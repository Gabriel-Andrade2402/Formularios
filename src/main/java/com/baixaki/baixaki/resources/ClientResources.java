package com.baixaki.baixaki.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baixaki.baixaki.entities.ClientEntity;
import com.baixaki.baixaki.services.ClientService;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping(value = "/client")
public class ClientResources {
	@Autowired
	private ClientService service;
	
	@PostMapping(value="/cadastrar")
	public ResponseEntity<String> cadastrar(@JsonFormat @RequestBody ClientEntity client ){
		System.out.println(client.toString());
		service.save(client);
		return ResponseEntity.ok().body("ok");
	}
	@PostMapping(value = "/buscar")
	public ResponseEntity<ClientEntity> buscar(@RequestBody ClientEntity client){
		return ResponseEntity.ok().body(service.findByEmail(client.getEmail()));
	}
	@PostMapping(value = "/delete")
	public ResponseEntity<Void> deletar(@RequestBody ClientEntity client){
		service.delete(client);
		return ResponseEntity.ok().build();
	}
	@GetMapping(value = "/all")
	public ResponseEntity<List<ClientEntity>> buscarTodos(){
		return ResponseEntity.ok().body(service.findAll());
	}
}
