package com.brunojose.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunojose.workshopmongo.domain.Post;
import com.brunojose.workshopmongo.repository.PostRepository;
import com.brunojose.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    // NOVO: Listar todos os posts
    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }
    
    public List<Post> findByTitle(String text){
    	return repo.searchTitle(text);
    }
}