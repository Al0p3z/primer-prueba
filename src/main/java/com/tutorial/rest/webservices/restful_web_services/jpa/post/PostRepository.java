package com.tutorial.rest.webservices.restful_web_services.jpa.post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.rest.webservices.restful_web_services.user.User;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
