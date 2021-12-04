package com.baixaki.baixaki.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_agendamento")
public class AgendamentoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date data;
	@ManyToOne
	@JoinColumn(name = "client", nullable = false)
	private ClientEntity client;
	private String observation;
	
	public AgendamentoEntity() {
		
	}

	public AgendamentoEntity(Long id, Date data, ClientEntity client,String observation) {
		this.id = id;
		this.data = data;
		this.client = client;
		this.observation= observation;
	}
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, data, id, observation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendamentoEntity other = (AgendamentoEntity) obj;
		return Objects.equals(client, other.client) && Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(observation, other.observation);
	}

	@Override
	public String toString() {
		return "AgendamentoEntity [id=" + id + ", data=" + data + ", client=" + client + ", observation=" + observation
				+ "]";
	}	
	
}
