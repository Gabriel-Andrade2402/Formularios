package com.baixaki.baixaki.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.baixaki.baixaki.enumeration.PersonType;

@Entity
@Table(name = "tb_fornecedor")
public class FornecedorEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private Date dataCadastro;
	private PersonType personType;
	private String fantasyName;
	private String corporateName;
	private String address;
	private String complement;
	private String cep;
	private String telephone;
	private String fax;
	private String celphone;
	private String contact;
	private String emailContact;
	private String email;
	private String city;
	private String district;
	private String filial;
	private String observation;
	private Date nasc;
	@OneToMany(mappedBy="provider")
	private List<ProdutoEntity> products = new ArrayList<>();
	
	public FornecedorEntity() {
		
	}

	public FornecedorEntity(Long id,String code, Date dataCadastro, PersonType personType, String fantasyName,
			String corporateName, String address, String complement, String cep, String telephone, String fax,
			String celphone, String contact, String emailContact, String email, String city, String district,
			String filial, String observation, Date nasc, List<ProdutoEntity> products) {
		this.id= id;
		this.code = code;
		this.dataCadastro = dataCadastro;
		this.personType = personType;
		this.fantasyName = fantasyName;
		this.corporateName = corporateName;
		this.address = address;
		this.complement = complement;
		this.cep = cep;
		this.telephone = telephone;
		this.fax = fax;
		this.celphone = celphone;
		this.contact = contact;
		this.emailContact = emailContact;
		this.email = email;
		this.city = city;
		this.district = district;
		this.filial = filial;
		this.observation = observation;
		this.nasc = nasc;
		this.products = products;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	public String getFantasyName() {
		return fantasyName;
	}

	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCelphone() {
		return celphone;
	}

	public void setCelphone(String celphone) {
		this.celphone = celphone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getfilial() {
		return filial;
	}

	public void setfilial(String filial) {
		this.filial = filial;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

	public List<ProdutoEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProdutoEntity> products) {
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, celphone, cep, city, code, complement, contact, corporateName, dataCadastro,
				district, email, emailContact, fantasyName, fax, filial, id, nasc, observation, personType, products,
				telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FornecedorEntity other = (FornecedorEntity) obj;
		return Objects.equals(address, other.address) && Objects.equals(celphone, other.celphone)
				&& Objects.equals(cep, other.cep) && Objects.equals(city, other.city)
				&& Objects.equals(code, other.code) && Objects.equals(complement, other.complement)
				&& Objects.equals(contact, other.contact) && Objects.equals(corporateName, other.corporateName)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(district, other.district)
				&& Objects.equals(email, other.email) && Objects.equals(emailContact, other.emailContact)
				&& Objects.equals(fantasyName, other.fantasyName) && Objects.equals(fax, other.fax)
				&& Objects.equals(filial, other.filial) && Objects.equals(id, other.id)
				&& Objects.equals(nasc, other.nasc) && Objects.equals(observation, other.observation)
				&& personType == other.personType && Objects.equals(products, other.products)
				&& Objects.equals(telephone, other.telephone);
	}

	@Override
	public String toString() {
		return "FornecedorEntity [id=" + id + ", code=" + code + ", dataCadastro=" + dataCadastro + ", personType="
				+ personType + ", fantasyName=" + fantasyName + ", corporateName=" + corporateName + ", address="
				+ address + ", complement=" + complement + ", cep=" + cep + ", telephone=" + telephone + ", fax=" + fax
				+ ", celphone=" + celphone + ", contact=" + contact + ", emailContact=" + emailContact + ", email="
				+ email + ", city=" + city + ", district=" + district + ", filial=" + filial + ", observation="
				+ observation + ", nasc=" + nasc + ", products=" + products + "]";
	}

	
	
}
