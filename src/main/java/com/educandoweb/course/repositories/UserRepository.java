package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;


// Spring Data JPA já tem o implements dessa interface, só precisa fazer isso
// Poderia colocar um @Repository mas como ela extende o JpaRepository, não precisa
public interface UserRepository extends JpaRepository<User, Long> {

}


