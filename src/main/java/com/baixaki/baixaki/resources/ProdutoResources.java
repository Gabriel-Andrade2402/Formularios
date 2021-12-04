package com.baixaki.baixaki.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baixaki.baixaki.entities.ProdutoEntity;
import com.baixaki.baixaki.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResources {
	@Autowired
	private ProdutoService service;
	
	@PostMapping(value="/cadastrar")
	public ResponseEntity<String> cadastrar(@RequestBody ProdutoEntity produto){
		service.save(produto);
		return ResponseEntity.ok().body("ok");
	}
	
	@PostMapping(value="/buscar")
	public ResponseEntity<ProdutoEntity> buscar(@RequestBody ProdutoEntity produto){
		return ResponseEntity.ok().body(service.findByBarCode(produto.getBarcode()));
	}
	
	@PostMapping(value="/all")
	public ResponseEntity<List<ProdutoEntity>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	@PostMapping(value = "/delete")
	public ResponseEntity<Void> deletar(@RequestBody ProdutoEntity produto){
		service.delete(produto);
		return ResponseEntity.ok(null);
	}
}
