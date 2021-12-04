package com.baixaki.baixaki.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baixaki.baixaki.entities.ClientEntity;
import com.baixaki.baixaki.repositorys.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public void save(ClientEntity client) {
		if(repository.findByEmail(client.getEmail())==null) {
			repository.save(client);
		}
	}
	public void update(ClientEntity client) {
		repository.save(client);
	}
	public void delete(ClientEntity client) {
		if(repository.findByEmail(client.getEmail())!=null) {
			repository.delete(repository.findByEmail(client.getEmail()));
		}
	}
	public ClientEntity findByEmail(String email) {
		return repository.findByEmail(email);
	}
	public List<ClientEntity> findAll(){
		return repository.findAll();
	}
}
