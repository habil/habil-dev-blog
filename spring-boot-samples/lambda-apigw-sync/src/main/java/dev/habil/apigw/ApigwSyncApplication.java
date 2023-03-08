package dev.habil.apigw;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;

@SpringBootApplication
public class ApigwSyncApplication {

	public static void main(String[] args) {
		FunctionalSpringApplication.run(ApigwSyncApplication.class, args);
	}

}
