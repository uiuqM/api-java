package com.projectcourse.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectcourse.project.entities.Order;
import com.projectcourse.project.entities.User;
import com.projectcourse.project.repositories.OrderRepository;
import com.projectcourse.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("Nyelle Ferreira Mota", "nyelle@gmail.com", "999096645", "010203");
		User u2 = new User("Anna Julia", "bu@gmail.com", "998154321", "bubuzinha");
		
		Order o1 = new Order(null, Instant.parse("2023-01-05T10:40:03Z"), u1);
		Order o2 = new Order(null, Instant.parse("2023-01-04T11:46:52Z"), u2);
		Order o3 = new Order(null, Instant.parse("2023-01-02T19:50:33Z"), u1);
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}
