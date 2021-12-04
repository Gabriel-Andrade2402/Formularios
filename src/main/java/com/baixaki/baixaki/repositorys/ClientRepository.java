package com.baixaki.baixaki.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baixaki.baixaki.entities.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
	@Query(value = "SELECT * FROM tb_client WHERE LOWER(email) = LOWER(:email) ", nativeQuery=true)
	ClientEntity findByEmail(@Param("email") String email);
}
