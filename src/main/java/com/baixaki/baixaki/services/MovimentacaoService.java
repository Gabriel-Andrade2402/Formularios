package com.baixaki.baixaki.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baixaki.baixaki.entities.ClientEntity;
import com.baixaki.baixaki.entities.MovimentacaoEntity;
import com.baixaki.baixaki.entities.ProdutoEntity;
import com.baixaki.baixaki.repositorys.MovimentacaoRepository;
import com.baixaki.baixaki.repositorys.ProdutoRepository;

@Service
public class MovimentacaoService {
	@Autowired
	private MovimentacaoRepository repository;
	@Autowired
	private ClientService repositoryService;
	@Autowired
	private ProdutoRepository repositoryProduct;
	
	public void save(MovimentacaoEntity entity) {
		ClientEntity client = repositoryService.findByEmail(entity.getClient().getEmail());
		Set<ProdutoEntity> listProducts = new HashSet();
		for(ProdutoEntity product:entity.getProduct()) {
			ProdutoEntity findProduct=repositoryProduct.findByBarCode(product.getBarcode());
			if(findProduct!=null) {
				listProducts.add(findProduct);
			}
		}
		entity.setProduct(listProducts);
		entity.setClient(client);
		if(find(entity)==null && client !=null && listProducts.size()>0) {
			repository.save(entity);
		}
	}
	public void update(MovimentacaoEntity entity) {
		repository.save(entity);
	}
	public void delete(MovimentacaoEntity entity) {
		if(find(entity)!=null) {
			repository.delete(entity);
		}
	}
	public MovimentacaoEntity find(MovimentacaoEntity entity) {
		ClientEntity client = repositoryService.findByEmail(entity.getClient().getEmail());
		if(client!=null) {
			return repository.find(client.getId(),entity.getDateMovimentation());
		}else {
			return null;
		}
	}
	public List<MovimentacaoEntity> findAll(){
		return repository.findAll();
	}
}
