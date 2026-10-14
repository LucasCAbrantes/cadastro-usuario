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
	
	public User update(Long id, User user) {
		User newU = findById(id);
		updateData(newU, user);
		return userRepository.saveAndFlush(newU);
	}

	private void updateData(User newU, User user) {
		if(user.getName()!= null) {
			newU.setName(user.getName());
		}
		
		if(user.getEmail()!= null) {
		newU.setEmail(user.getEmail());
		}
	}
}
