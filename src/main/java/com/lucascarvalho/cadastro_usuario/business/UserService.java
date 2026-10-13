package com.lucascarvalho.cadastro_usuario.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucascarvalho.cadastro_usuario.business.exception.ObjectNotFoundException;
import com.lucascarvalho.cadastro_usuario.infrastructure.entities.User;
import com.lucascarvalho.cadastro_usuario.infrastructure.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User insert(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario n encontrado"));
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(User user) {
		User newU = findById(user.getId());
		updateUser(newU, user);
		return userRepository.saveAndFlush(newU);
	}

	private void updateUser(User newU, User user) {
		newU.setName(user.getName());
		newU.setEmail(user.getEmail());
		
	}
}
