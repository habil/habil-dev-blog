package dev.habil.transcoder.config;

import static dev.habil.transcoder.util.ApplicationConstants.AWS_ACCESS_KEY;
import static dev.habil.transcoder.util.ApplicationConstants.AWS_SECRET_KEY;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.elastictranscoder.AmazonElasticTranscoder;
import com.amazonaws.services.elastictranscoder.AmazonElasticTranscoderClientBuilder;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
public class AwsConfig {

    private final Environment environment;

    @Bean
    public AmazonElasticTranscoder transcoderClient() {
        return AmazonElasticTranscoderClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                Objects.requireNonNull(environment.getProperty(AWS_ACCESS_KEY)),
                Objects.requireNonNull(environment.getProperty(AWS_SECRET_KEY))
            )))
            .withRegion(Regions.EU_WEST_1)
            .build();
    }
}
