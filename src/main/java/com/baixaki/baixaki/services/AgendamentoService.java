package com.baixaki.baixaki.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baixaki.baixaki.entities.AgendamentoEntity;
import com.baixaki.baixaki.entities.ClientEntity;
import com.baixaki.baixaki.repositorys.AgendamentoRepository;

@Service
public class AgendamentoService {
	@Autowired
	private AgendamentoRepository repository;
	@Autowired
	private ClientService repositoryService;
	
	public void Save(AgendamentoEntity entity) {
		ClientEntity client = repositoryService.findByEmail(entity.getClient().getEmail());
		if(client!=null && find(entity) == null) {
			entity.setClient(client);
			repository.save(entity);
		}
	}
	public void Delete(AgendamentoEntity entity) {
		repository.delete(entity);
	}
	public void update(AgendamentoEntity entity) {
		repository.save(entity);
	}
	public AgendamentoEntity find(AgendamentoEntity entity) {
		ClientEntity client = repositoryService.findByEmail(entity.getClient().getEmail());
		if(client!=null) {
			return repository.find(client.getId(),entity.getData());
		}else {
			return null;
		}
	}
	public List<AgendamentoEntity> findAll(){
		return repository.findAll();
	}
	public void delete(AgendamentoEntity agendamento) {
		if(find(agendamento)!=null) {
			repository.delete(agendamento);
		}
	}
}
