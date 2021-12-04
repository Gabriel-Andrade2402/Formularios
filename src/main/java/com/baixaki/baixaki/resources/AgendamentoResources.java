package com.baixaki.baixaki.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baixaki.baixaki.entities.AgendamentoEntity;
import com.baixaki.baixaki.services.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoResources {
	@Autowired
	private AgendamentoService service;
	
	@PostMapping(value = "/all")
	public ResponseEntity<List<AgendamentoEntity>> findAll() {
		List<AgendamentoEntity> lista= service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<String> cadastrar(@RequestBody AgendamentoEntity agendamento){
		service.Save(agendamento);
		return ResponseEntity.ok().body("ok");
	}
	@PostMapping(value = "/buscar")
	public ResponseEntity<AgendamentoEntity> buscar(@RequestBody AgendamentoEntity agendamento){
		return ResponseEntity.ok().body(service.find(agendamento));
	}
	@PostMapping(value = "/delete")
	public ResponseEntity<Void> deletar(@RequestBody AgendamentoEntity agendamento){
		service.delete(agendamento);
		return ResponseEntity.ok().build();
	}
}
