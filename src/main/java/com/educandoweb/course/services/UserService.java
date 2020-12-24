package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

// Camada de SERVIÇO, usada pra acessar camada REPOSITORIES pra acesso a DADOS, aqui ficariam as regras de negócio, sempre é importante ter essa camada entre CONTROLLER e REPOSITORIES
// Temos @Component registra a classe como componente do Spring permitindo ser injetado via Autowired, temos tambem o @Repository, @Service, 
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); // O Optional, desde o Java 8, serve pra retornar o objeto tipo User, no caso, no findById do Id, se fosse outro objeto, caçava por outro Database.
		return obj.get(); // Retorna objeto User presente no optional
	}
	
	public User insert(User obj) { // Salvar objeto do tipo User
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
//		User entity = repository.getOne(id); //Deixar um objeto monitorado pelo JPA pra pode manipulá-lo posteriormente
//		                                     // Melhor que o findbyid que acessa o Banco de Dados
		
		User entity = findById(id);
		
		updateData(entity, obj);
		
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		// Atualizar os dados do entity com o que tem no obj
		
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
