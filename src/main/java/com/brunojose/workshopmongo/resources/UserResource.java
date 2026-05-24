package com.brunojose.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunojose.workshopmongo.domain.User;
import com.brunojose.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserService service;

    // GET /user — lista todos
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // GET /user/{id} — busca um usuário pelo ID  ← FALTAVA ISSO!
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}