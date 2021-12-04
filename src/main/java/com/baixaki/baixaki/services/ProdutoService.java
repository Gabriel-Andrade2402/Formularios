package com.baixaki.baixaki.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baixaki.baixaki.entities.FornecedorEntity;
import com.baixaki.baixaki.entities.ProdutoEntity;
import com.baixaki.baixaki.repositorys.FornecedorRepository;
import com.baixaki.baixaki.repositorys.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private FornecedorRepository repositoryProvider;
	
	public void save(ProdutoEntity entity) {
		FornecedorEntity fornecedor = repositoryProvider.findByCorporateName(entity.getProvider().getCorporateName());
		entity.setProvider(fornecedor);
		if(fornecedor!=null && findByBarCode(entity.getBarcode())==null) {
			repository.save(entity);
		}
	}
	public void update(ProdutoEntity entity) {
		repository.save(entity);
	}
	public void delete(ProdutoEntity entity) {
		if(findByBarCode(entity.getBarcode())!=null) {
			repository.delete(entity);
		}
	}
	public ProdutoEntity findByBarCode(String barcode) {
		return repository.findByBarCode(barcode);
	}
	public List<ProdutoEntity> findAll(){
		return repository.findAll();
	}
}
