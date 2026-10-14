package com.lucascarvalho.cadastro_usuario.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascarvalho.cadastro_usuario.infrastructure.entities.User;

public interface EquipRepository extends JpaRepository<User, Long>{

	
}
