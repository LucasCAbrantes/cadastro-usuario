package com.lucascarvalho.cadastro_usuario.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucascarvalho.cadastro_usuario.business.exception.ObjectNotFoundException;
import com.lucascarvalho.cadastro_usuario.infrastructure.entities.Equip;
import com.lucascarvalho.cadastro_usuario.infrastructure.repositories.EquipRepository;

@Service
public class EquipService {
	@Autowired
	private EquipRepository equipRepository;
	
	public List<Equip> findAll(){
		return equipRepository.findAll();
	}
	
	public Equip insert(Equip equip) {
		return equipRepository.saveAndFlush(equip);
	}
	
	public Equip findById(Long id) {
		return equipRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Equipe n encontrada"));
	}
	
	public void deleteById(Long id) {
		equipRepository.deleteById(id);
	}
	
	public Equip update(Long id, Equip equip) {
		Equip newE = findById(id);
		updateData(newE, equip);
		return equipRepository.saveAndFlush(newE);
	}

	private void updateData(Equip newE, Equip equip) {
		if(equip.getName()!= null) {
			newE.setName(equip.getName());
		}
		
		if(equip.isStatus()!= null) {
		newE.setStatus(equip.isStatus());
		}
	}
}
