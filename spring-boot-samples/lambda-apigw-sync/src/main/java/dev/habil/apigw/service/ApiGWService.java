package dev.habil.apigw.service;

import com.amazonaws.services.apigatewayv2.AmazonApiGatewayV2;
import com.amazonaws.services.apigatewayv2.model.AuthorizerType;
import com.amazonaws.services.apigatewayv2.model.Cors;
import com.amazonaws.services.apigatewayv2.model.CreateAuthorizerRequest;
import com.amazonaws.services.apigatewayv2.model.CreateAuthorizerResult;
import com.amazonaws.services.apigatewayv2.model.CreateIntegrationRequest;
import com.amazonaws.services.apigatewayv2.model.CreateIntegrationResult;
import com.amazonaws.services.apigatewayv2.model.GetRoutesRequest;
import com.amazonaws.services.apigatewayv2.model.GetRoutesResult;
import com.amazonaws.services.apigatewayv2.model.JWTConfiguration;
import com.amazonaws.services.apigatewayv2.model.ReimportApiRequest;
import com.amazonaws.services.apigatewayv2.model.UpdateApiRequest;
import com.amazonaws.services.apigatewayv2.model.UpdateRouteRequest;
import dev.habil.apigw.data.ApiGWReimportRequest;
import java.util.Collections;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiGWService {
    private final AmazonApiGatewayV2 amazonApiGatewayV2;

    public void syncSwaggerToApiGW(ApiGWReimportRequest request) {
        //This method will consume your api-docs url and re-import it to aws api-gw.
        reImport(request);
        //This method will create JWT Authorizer.
        String authorizerId = createAuthorizer(request).getAuthorizerId();
        //This method will create Integration (VPC Link).
        String integrationId = createIntegration(request).getIntegrationId();
        //This method will update your API routes given authorizerId & integrationId.
        updateRoutes(request, authorizerId, integrationId);
        //This method will create Basic CORS configuration for your API. (Don't use it ANY production API!)
        updateCors(request);
    }

    private void updateCors(ApiGWReimportRequest request) {
        UpdateApiRequest updateApiRequest = new UpdateApiRequest();
        Cors cors = new Cors();
        cors.setAllowOrigins(Collections.singleton("*"));
        cors.setAllowHeaders(Collections.singleton("*"));
        cors.setAllowMethods(Collections.singleton("*"));
        cors.setExposeHeaders(Collections.singleton("*"));
        updateApiRequest.setCorsConfiguration(cors);
        updateApiRequest.setApiId(request.getApiId());
        amazonApiGatewayV2.updateApi(updateApiRequest);
    }

    private void updateRoutes(ApiGWReimportRequest request, String authorizerId,
                              String integrationId) {
        GetRoutesResult routes =
            amazonApiGatewayV2.getRoutes(new GetRoutesRequest().withApiId(request.getApiId()));

        routes.getItems().forEach(route -> {
            UpdateRouteRequest updateRouteRequest = new UpdateRouteRequest();
            updateRouteRequest.setApiId(request.getApiId());
            updateRouteRequest.setAuthorizerId(authorizerId);
            updateRouteRequest.setAuthorizationType("JWT");
            updateRouteRequest.setRouteId(route.getRouteId());
            updateRouteRequest.setOperationName(route.getOperationName());
            updateRouteRequest.setTarget("integrations/" + integrationId);
            amazonApiGatewayV2.updateRoute(updateRouteRequest);
        });
    }

    private CreateIntegrationResult createIntegration(ApiGWReimportRequest request) {
        CreateIntegrationRequest createIntegrationRequest = new CreateIntegrationRequest();
        createIntegrationRequest.setApiId(request.getApiId());
        createIntegrationRequest.setPayloadFormatVersion("1.0");
        createIntegrationRequest.setConnectionId("ConnectionId");
        createIntegrationRequest.setIntegrationType("HTTP_PROXY");
        createIntegrationRequest.setIntegrationMethod("ANY");
        createIntegrationRequest.setIntegrationUri("arn:aws:elasticloadbalancing");
        createIntegrationRequest.setConnectionType("VPC_LINK");
        return amazonApiGatewayV2.createIntegration(createIntegrationRequest);
    }

    private CreateAuthorizerResult createAuthorizer(ApiGWReimportRequest request) {
        CreateAuthorizerRequest createAuthorizerRequest = new CreateAuthorizerRequest();
        createAuthorizerRequest.setApiId(request.getApiId());
        createAuthorizerRequest.setName(request.getApiId() + "-Authorizer");
        createAuthorizerRequest.setAuthorizerType("oauth2");
        JWTConfiguration jwtConfiguration = new JWTConfiguration();
        jwtConfiguration.setAudience(Collections.singleton(request.getAudience()));
        jwtConfiguration.setIssuer(request.getIssuerUrl());
        createAuthorizerRequest.setJwtConfiguration(jwtConfiguration);
        createAuthorizerRequest.setIdentitySource(
            Collections.singleton("$request.header.Authorization"));
        createAuthorizerRequest.setAuthorizerType(AuthorizerType.JWT.name());
        return amazonApiGatewayV2.createAuthorizer(createAuthorizerRequest);
    }

    private void reImport(ApiGWReimportRequest request) {
        HttpResponse<String> response = Unirest.get(request.getInternalUrl()).asString();
        ReimportApiRequest importApiRequest = new ReimportApiRequest();
        importApiRequest.setBody(response.getBody());
        importApiRequest.setBasepath("prepend");
        importApiRequest.setApiId(request.getApiId());
        amazonApiGatewayV2.reimportApi(importApiRequest);
    }
}
