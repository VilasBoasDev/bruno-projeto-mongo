package com.brunojose.workshopmongo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brunojose.workshopmongo.domain.User;
import com.brunojose.workshopmongo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User insert(User user) {
        return repo.insert(user);
    }
}