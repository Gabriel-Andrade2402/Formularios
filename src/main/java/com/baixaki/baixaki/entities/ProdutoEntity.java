package com.baixaki.baixaki.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "tb_product")
public class ProdutoEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long id;
	private String name;
	private String barcode;
	@Lob 
	@Type(type="org.hibernate.type.ImageType")
	private byte[] baseImg;
	private Double price;
	private Integer quantity;
	@Nullable
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	  name = "tb_movimentacao_product", 
	  joinColumns = @JoinColumn(name = "product_id"), 
	  inverseJoinColumns = @JoinColumn(name = "movimentacao_id"))
	private Set<MovimentacaoEntity> SetMovimentacoes;
	@ManyToOne
	@JoinColumn(name = "provider", nullable = false)
	private FornecedorEntity provider;
	
	public ProdutoEntity() {
		
	}

	public ProdutoEntity(Long id,String barcode,byte[] baseImg,String name, Double price, Integer quantity, FornecedorEntity provider,Set<MovimentacaoEntity> SetMov) {
		this.id = id;
		this.barcode = barcode;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.provider = provider;
		this.SetMovimentacoes = SetMov;
		this.baseImg = baseImg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public FornecedorEntity getProvider() {
		return provider;
	}

	public void setProvider(FornecedorEntity provider) {
		this.provider = provider;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<MovimentacaoEntity> getSetMovimentacoes() {
		return SetMovimentacoes;
	}

	public void setSetMovimentacoes(Set<MovimentacaoEntity> SetMovimentacoes) {
		this.SetMovimentacoes = SetMovimentacoes;
	}
	
	
	
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public byte[] getBaseImg() {
		return baseImg;
	}

	public void setBaseImg(byte[] baseImg) {
		this.baseImg = baseImg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(SetMovimentacoes, barcode, baseImg, id, name, price, provider, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoEntity other = (ProdutoEntity) obj;
		return Objects.equals(SetMovimentacoes, other.SetMovimentacoes) && Objects.equals(barcode, other.barcode)
				&& Objects.equals(baseImg, other.baseImg) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price)
				&& Objects.equals(provider, other.provider) && Objects.equals(quantity, other.quantity);
	}

	@Override
	public String toString() {
		return "ProdutoEntity [id=" + id + ", name=" + name + ", barcode=" + barcode + ", baseImg=" + baseImg
				+ ", price=" + price + ", quantity=" + quantity + ", SetMovimentacoes=" + SetMovimentacoes
				+ ", provider=" + provider + "]";
	}

}
