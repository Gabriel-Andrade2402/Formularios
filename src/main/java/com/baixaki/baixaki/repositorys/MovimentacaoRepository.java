package com.baixaki.baixaki.repositorys;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baixaki.baixaki.entities.MovimentacaoEntity;

@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {
	@Query(value = "SELECT * FROM tb_movimentacao WHERE client = :client"
			+ " AND date_movimentation = :data",
			nativeQuery=true)
	MovimentacaoEntity find(@Param("client") Long clientId,
			@Param("data")Date data);
}
