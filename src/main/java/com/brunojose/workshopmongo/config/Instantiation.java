package com.brunojose.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brunojose.workshopmongo.domain.User;
import com.brunojose.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        // Limpa a coleção antes de inserir (garante IDs consistentes)
        userRepository.deleteAll();
        
        // Cria usuários com IDs fixos (ou deixe null para o MongoDB gerar)
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        
        // Agora imprima os IDs gerados para você saber quais usar
        System.out.println("=== USUÁRIOS INSERIDOS ===");
        for (User u : userRepository.findAll()) {
            System.out.println("ID: " + u.getId() + " | Nome: " + u.getName());
        }
    }
}