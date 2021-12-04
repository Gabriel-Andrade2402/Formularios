package com.baixaki.baixaki.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baixaki.baixaki.entities.FornecedorEntity;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long> {
	@Query(value = "SELECT * FROM tb_fornecedor WHERE LOWER(corporate_name) = LOWER(:corporateName)", nativeQuery=true)
	FornecedorEntity findByCorporateName(@Param("corporateName") String clientId);
}
