package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController                     // Notação pra informar que é um CONTROLADOR
@RequestMapping(value = "/users")   // Nome do recurso pra acessar depois
public class UserResource {
	// Essa é a RESOURCE LAYER onde teremos os controladores REST
	
	//=====================================================================//
	//                     APPLICATION
	//               RESOURCE LAYER (REST CONTROLLERS)
	//             SERVICE LAYER                          || ENTITIES ||
	//             DATA ACCESS LAYER (DATA REPOSITORIES)  ||          ||
	//=====================================================================//
	
	@GetMapping   // Pra responder a requisição GET do HTTP
	public ResponseEntity<User> findAll() {   // ResponseEntity é um método especifico do Java pra atender uma requisição WEB
		User u = new User(1L, "Maria", "maria@gmail.com", "99999-9999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
}
