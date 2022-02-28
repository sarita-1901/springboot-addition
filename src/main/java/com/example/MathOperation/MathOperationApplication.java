package com.example.MathOperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

//@SpringBootApplication(scanBasePackages = {"com.example.MathOperation"})
public class MathOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathOperationApplication.class, args);
	}

	@Scheduled(cron = "*/10 * * * * *")
	void someJob() {
		System.out.println("Now is " + new Date());
	}

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration {


}