package com.brunojose.workshopmongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class WorkshopmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopmongoApplication.class, args);
	}
	
	  @Bean
	    public CommandLineRunner printConfig(Environment env) {
	        return args -> {
	            String uri = env.getProperty("spring.data.mongodb.uri");
	            String db = env.getProperty("spring.data.mongodb.database");
	            System.out.println("🔧 [CONFIG] spring.data.mongodb.uri = " + uri);
	            System.out.println("🔧 [CONFIG] spring.data.mongodb.database = " + db);
	        };
	    }

}
