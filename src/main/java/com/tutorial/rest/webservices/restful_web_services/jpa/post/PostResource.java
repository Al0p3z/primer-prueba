package com.tutorial.rest.webservices.restful_web_services.jpa.post;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tutorial.rest.webservices.restful_web_services.user.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class PostResource {
	
	private PostRepository repository;
	
	public PostResource(PostRepository repository) {
		this.repository = repository;
	}


	@GetMapping("/jpa/posts")
	public List<Post> retrieveAllPosts() {
		return repository.findAll();
	}
	
	@GetMapping("/jpa/posts/{id}")
	public Optional<Post> retrievePost(@PathVariable int id) {
		Optional<Post> post = repository.findById(id);
		
		if (post.isEmpty()) {
			throw new UserNotFoundException("id: " +id);
		} 
		
		return post;
	}
	
	@DeleteMapping("/jpa/posts/{id}")
	public void deletePost(@PathVariable int id) {		
		repository.deleteById(id);
				
	}
	
	@PostMapping("/jpa/posts")
	public ResponseEntity<Post> createUser(@Valid @RequestBody Post post) {
		Post savedUser = repository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

}
