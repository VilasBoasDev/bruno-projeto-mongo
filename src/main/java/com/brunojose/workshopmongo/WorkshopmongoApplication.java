package com.brunojose.workshopmongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
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

    @Bean
    public CommandLineRunner listBeans(ApplicationContext ctx) {
        return args -> {
            System.out.println("\n=== BEANS DO SPRING ===");
            String[] beanNames = ctx.getBeanDefinitionNames();
            boolean found = false;
            for (String beanName : beanNames) {
                String lower = beanName.toLowerCase();
                if (lower.contains("post") || lower.contains("user") || lower.contains("resource")) {
                    System.out.println("✅ " + beanName + " -> " + ctx.getBean(beanName).getClass().getName());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("❌ NENHUM controller encontrado!");
            }
            System.out.println("=======================\n");
        };
    }
}