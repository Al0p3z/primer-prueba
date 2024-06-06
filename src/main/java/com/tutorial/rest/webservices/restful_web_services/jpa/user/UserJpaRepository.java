package com.tutorial.rest.webservices.restful_web_services.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.rest.webservices.restful_web_services.user.User;

public interface UserJpaRepository extends JpaRepository<UserJpa, Integer>{

}
