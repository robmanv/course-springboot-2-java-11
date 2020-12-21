package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;


// Para avisar ao Spring que é uma classe de configuração
@Configuration
//Para avisar ao Spring que é exclusiva do perfil de testes
@Profile("test")
//Servirá pra popular o banco de dados com nossos objetos   | O CommandLineRunner serve pra executar um conjunto de instruções quando a aplicação for iniciada
public class TestConfig implements CommandLineRunner {
// Deve existir uma injeção de dependência, desacoplada (fraca) com minha repositories (framework tem mecanismo de injeção de dependencia implicito)
	// Spring vai resolver a dependência e adicionar a instância de UserRepository aqui dentro
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888-8888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777-7777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // Salvando no banco de dados uma lista de objetos
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);   // Z significa que está no padrão UTC, horário de Grewnwich
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1); 
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Category c1 = new Category(null, "Electronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
	}
	
	
}
