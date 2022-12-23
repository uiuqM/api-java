package com.projectcourse.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectcourse.project.entities.User;
import com.projectcourse.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("Nyelle Ferreira Mota", "nyelle@gmail.com", "999096645", "010203");
		User u2 = new User("Anna Julia", "bu@gmail.com", "998154321", "bubuzinha");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
}
