package com.projectcourse.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectcourse.project.entities.Category;
import com.projectcourse.project.entities.Order;
import com.projectcourse.project.entities.User;
import com.projectcourse.project.entities.enums.OrderStatus;
import com.projectcourse.project.repositories.CategoryRepository;
import com.projectcourse.project.repositories.OrderRepository;
import com.projectcourse.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
		User u1 = new User("Nyelle Ferreira Mota", "nyelle@gmail.com", "999096645", "010203");
		User u2 = new User("Anna Julia", "bu@gmail.com", "998154321", "bubuzinha");
		
		Order o1 = new Order(null, Instant.parse("2023-01-05T10:40:03Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-01-04T11:46:52Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2023-01-02T19:50:33Z"), OrderStatus.WAITING_PAYMENT,u1);
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}
