package com.brunojose.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunojose.workshopmongo.domain.Post;
import com.brunojose.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
//	public ResponseEntity<Post> findById(@PathVariable String id){
//		Post obj = service.findById(id);
//		return ResponseEntity.ok().body(obj);
//	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
	    System.out.println(">>> findById chamado com ID: " + id);
	    Post obj = service.findById(id);
	    return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
	    System.out.println(">>> TESTE FUNCIONOU!");
	    return ResponseEntity.ok("Controller funcionando!");
	}
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
	    System.out.println(">>> PING FUNCIONOU! Controller está respondendo!");
	    return ResponseEntity.ok("PONG - API está funcionando!");
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
	    return ResponseEntity.ok().body(service.findAll());
	}

}
