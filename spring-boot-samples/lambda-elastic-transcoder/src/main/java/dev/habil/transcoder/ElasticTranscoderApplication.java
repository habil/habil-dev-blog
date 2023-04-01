package dev.habil.transcoder;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;

@SpringBootApplication
public class ElasticTranscoderApplication {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(ElasticTranscoderApplication.class, args);
    }

}
