package com.baixaki.baixaki.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.baixaki.baixaki.enumeration.Payment;

@Entity
@Table(name = "tb_movimentacao")
public class MovimentacaoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movimentacao_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "client", nullable = false)
	private ClientEntity client;
	@ManyToMany(mappedBy = "SetMovimentacoes")
	private Set<ProdutoEntity> product;
	private Date dateMovimentation;
	private Payment payment;
	private Double price;
	
	public MovimentacaoEntity() {
		
	}

	public MovimentacaoEntity(Long id,ClientEntity client, Set<ProdutoEntity> product, Date dateMovimentation,Payment payment,Double price) {
		this.id= id;
		this.client = client;
		this.product = product;
		this.dateMovimentation = dateMovimentation;
		this.payment = payment;
		this.price = price;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public Set<ProdutoEntity> getProduct() {
		return product;
	}

	public void setProduct(Set<ProdutoEntity> product) {
		this.product = product;
	}

	public Date getDateMovimentation() {
		return dateMovimentation;
	}

	public void setDateMovimentation(Date dateMovimentation) {
		this.dateMovimentation = dateMovimentation;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, dateMovimentation, id, payment, price, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentacaoEntity other = (MovimentacaoEntity) obj;
		return Objects.equals(client, other.client) && Objects.equals(dateMovimentation, other.dateMovimentation)
				&& Objects.equals(id, other.id) && payment == other.payment && Objects.equals(price, other.price)
				&& Objects.equals(product, other.product);
	}

	@Override
	public String toString() {
		return "MovimentacaoEntity [id=" + id + ", client=" + client + ", product=" + product + ", dateMovimentation="
				+ dateMovimentation + ", payment=" + payment + ", price=" + price + "]";
	}

	
	
}
