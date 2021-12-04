package com.baixaki.baixaki.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baixaki.baixaki.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
	@Query(value = "SELECT * FROM tb_product WHERE LOWER(barcode) = LOWER(:barcode)", nativeQuery=true)
	ProdutoEntity findByBarCode(@Param("barcode") String name);
	
}
