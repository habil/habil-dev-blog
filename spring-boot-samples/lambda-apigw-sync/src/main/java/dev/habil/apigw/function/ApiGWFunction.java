package dev.habil.apigw.function;


import dev.habil.apigw.data.ApiGWReimportRequest;
import dev.habil.apigw.service.ApiGWService;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class ApiGWFunction implements Function<ApiGWReimportRequest, String> {

    private final ApiGWService apiGWService;

    @Override
    public String apply(ApiGWReimportRequest request) {
        apiGWService.syncSwaggerToApiGW(request);
        return "ok";
    }
}
