package com.baixaki.baixaki.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baixaki.baixaki.entities.MovimentacaoEntity;
import com.baixaki.baixaki.services.MovimentacaoService;

@RestController
@RequestMapping(value = "/movimentacoes")
public class MovimentacaoResources {
	@Autowired
	private MovimentacaoService service;
	
	@PostMapping(value="/cadastrar")
	public ResponseEntity<String> cadastrar(@RequestBody MovimentacaoEntity movimentacao){
		service.save(movimentacao);
		return ResponseEntity.ok().body("ok");
	}
	
	@PostMapping(value="/buscar")
	public ResponseEntity<MovimentacaoEntity> buscar(@RequestBody MovimentacaoEntity movimentacao){
		return ResponseEntity.ok().body(service.find(movimentacao));
	}
	
	@PostMapping(value="/all")
	public ResponseEntity<List<MovimentacaoEntity>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	@PostMapping(value = "/delete")
	public ResponseEntity<Void> deletar(@RequestBody MovimentacaoEntity movimentacao){
		service.delete(movimentacao);
		return ResponseEntity.ok(null);
	}
}
