package com.lucascarvalho.cadastro_usuario.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucascarvalho.cadastro_usuario.infrastructure.entities.Equip;
import com.lucascarvalho.cadastro_usuario.infrastructure.entities.User;
import com.lucascarvalho.cadastro_usuario.infrastructure.repositories.EquipRepository;
import com.lucascarvalho.cadastro_usuario.infrastructure.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EquipRepository equipRepository;
	
	@Override
	public void run(String... args) throws Exception {
		equipRepository.deleteAll();
		userRepository.deleteAll();
		
		User maria = new User(null,"Maria Silva" ,"maria@gmail.com");
		User pedro = new User(null,"Pedro Costa" ,"pedro@gmail.com");
		User jose = new User(null,"Jose Bezzera" ,"jose@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,pedro,jose));
		
		Equip equip1 = new Equip(null, "Pastoral Familiar" , true);
		Equip equip2 = new Equip(null, "Pastoral da Acolhida" , true);
		
		equip1.getUsers().addAll(Arrays.asList(maria, jose));
		equip2.getUsers().addAll(Arrays.asList(pedro));
		
		equipRepository.saveAll(Arrays.asList(equip1,equip2));
		
	}

	

}
