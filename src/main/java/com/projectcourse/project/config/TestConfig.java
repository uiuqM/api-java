package com.projectcourse.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectcourse.project.entities.Category;
import com.projectcourse.project.entities.Order;
import com.projectcourse.project.entities.OrderItem;
import com.projectcourse.project.entities.Product;
import com.projectcourse.project.entities.User;
import com.projectcourse.project.entities.enums.OrderStatus;
import com.projectcourse.project.repositories.CategoryRepository;
import com.projectcourse.project.repositories.OrderItemRepository;
import com.projectcourse.project.repositories.OrderRepository;
import com.projectcourse.project.repositories.ProductRepository;
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
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Product p1 = new Product(null, "Laptop", "duis ut diam quam nulla porttitor massa id neque aliquam", 345.10, "");
		Product p2 = new Product(null, "Nintendo Switch", "varius quam quisque id diam vel quam elementum pulvinar etiam", 346.00, "");
		Product p3 = new Product(null, "Echo (4th Gen)", "faucibus turpis in eu mi bibendum neque egestas congue quisque", 75.00, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat1);
		
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		User u1 = new User("Nyelle Ferreira Mota", "nyelle@gmail.com", "999096645", "010203");
		User u2 = new User("Anna Julia", "bu@gmail.com", "998154321", "bubuzinha");
		
		Order o1 = new Order(null, Instant.parse("2023-01-05T10:40:03Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2023-01-04T11:46:52Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2023-01-02T19:50:33Z"), OrderStatus.WAITING_PAYMENT,u1);
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p2, 1, p2.getPrice());
		OrderItem oi2 = new OrderItem(o2, p1, 2, p1.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2));
	}
	
	
}
