package com.lucascarvalho.cadastro_usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucascarvalho.cadastro_usuario.business.EquipService;
import com.lucascarvalho.cadastro_usuario.infrastructure.entities.Equip;

@RestController
@RequestMapping("/equips")
public class EquipController {
	@Autowired
	private EquipService equipService;
	
	@GetMapping
	public ResponseEntity<List<Equip>> findAll(){
		List<Equip> list = equipService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Equip>  findById(@PathVariable Long id){
		Equip obj = equipService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Equip>  insert(@RequestBody Equip obj){
		obj = equipService.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Equip> delete(@PathVariable Long id){
		equipService.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Equip> update(@PathVariable Long id, @RequestBody Equip obj) {
	    Equip updated = equipService.update(id, obj);
	    return ResponseEntity.ok().body(updated);
	}
}
