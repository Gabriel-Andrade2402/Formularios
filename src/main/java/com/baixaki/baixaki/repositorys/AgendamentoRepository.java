package com.baixaki.baixaki.repositorys;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baixaki.baixaki.entities.AgendamentoEntity;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity,Long>{
	@Query(value = "SELECT * FROM tb_agendamento WHERE data = :data AND clientId = :clientId", nativeQuery=true)
	AgendamentoEntity find(@Param("clientId") Long clientId,@Param("data") Date data);
}
