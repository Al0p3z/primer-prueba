package com.tutorial.rest.webservices.restful_web_services.jpa.user;

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

import com.tutorial.rest.webservices.restful_web_services.jpa.post.Post;
import com.tutorial.rest.webservices.restful_web_services.jpa.post.PostRepository;
import com.tutorial.rest.webservices.restful_web_services.user.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	private UserJpaRepository repository;
	private PostRepository postRepository;
	
	public UserJpaResource(UserJpaRepository repository, PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}


	@GetMapping("/jpa/users")
	public List<UserJpa> retrieveAllUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Optional<UserJpa> retrieveUser(@PathVariable int id) {
		Optional<UserJpa> user = repository.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " +id);
		} 
		
		return user;
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {		
		repository.deleteById(id);
				
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<UserJpa> createUser(@Valid @RequestBody UserJpa user) {
		UserJpa savedUser = repository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<UserJpa> user = repository.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " +id);
		} 
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostsForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<UserJpa> user = repository.findById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " +id);
		} 
		
		post.setUser(user.get());
		
		Post savedPost = postRepository.save(post);
				
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

}
