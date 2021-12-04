package com.baixaki.baixaki.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baixaki.baixaki.entities.FornecedorEntity;
import com.baixaki.baixaki.repositorys.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository repository;
	
	public void save(FornecedorEntity entity) {
		if(findByCorporateName(entity.getCorporateName())==null) {
			repository.save(entity);
		}
	}
	public void update(FornecedorEntity entity) {
		repository.save(entity);
	}
	public void delete(FornecedorEntity entity) {
		if(findByCorporateName(entity.getCorporateName())!=null) {
			repository.delete(findByCorporateName(entity.getCorporateName()));
		}
	}
	public FornecedorEntity findByCorporateName(String corporateName) {
		return repository.findByCorporateName(corporateName);
	}
	public List<FornecedorEntity> findAll(){
		return repository.findAll();
	}
}
