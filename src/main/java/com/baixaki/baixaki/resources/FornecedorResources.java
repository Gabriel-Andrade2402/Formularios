package com.baixaki.baixaki.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baixaki.baixaki.entities.FornecedorEntity;
import com.baixaki.baixaki.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorResources {
	@Autowired
	private FornecedorService service;
	
	@PostMapping(value="/cadastrar")
	public ResponseEntity<String> cadastrar(@RequestBody FornecedorEntity fornecedor){
		service.save(fornecedor);
		return ResponseEntity.ok().body("ok");
	}
	
	@PostMapping(value="/buscar")
	public ResponseEntity<FornecedorEntity> buscar(@RequestBody FornecedorEntity fornecedor){
		return ResponseEntity.ok().body(service.findByCorporateName(fornecedor.getCorporateName()));
	}
	
	@PostMapping(value="/all")
	public ResponseEntity<List<FornecedorEntity>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	@PostMapping(value = "/delete")
	public ResponseEntity<Void> deletar(@RequestBody FornecedorEntity fornecedor){
		service.delete(fornecedor);
		return ResponseEntity.ok().build();
	}
}
