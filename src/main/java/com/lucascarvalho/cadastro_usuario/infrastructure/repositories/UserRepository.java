package com.lucascarvalho.cadastro_usuario.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascarvalho.cadastro_usuario.infrastructure.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
