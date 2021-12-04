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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_client")
public class ClientEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private Date dataCadastro;
	private PersonType personType;
	private String fantasyName;
	private String corporateName;
	private String cep;
	private String address;
	private String complement;
	private String telephone;
	private String celphone;
	private String contact;
	private String email;
	private String city;
	private String district;
	private String observation;
	private Date nasc;
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<MovimentacaoEntity> listMov = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<AgendamentoEntity> listAge = new ArrayList<>();
	
	public ClientEntity() {
		
	}

	public ClientEntity(Long id, String code, Date dataCadastro, PersonType personType, String fantasyName,
			String corporateName, String cep, String address, String complement, String telephone, String celphone,
			String contact, String email, String city, String district, String observation, Date nasc,
			List<MovimentacaoEntity> listMov, List<AgendamentoEntity> listAge) {
		this.id = id;
		this.code = code;
		this.dataCadastro = dataCadastro;
		this.personType = personType;
		this.fantasyName = fantasyName;
		this.corporateName = corporateName;
		this.cep = cep;
		this.address = address;
		this.complement = complement;
		this.telephone = telephone;
		this.celphone = celphone;
		this.contact = contact;
		this.email = email;
		this.city = city;
		this.district = district;
		this.observation = observation;
		this.nasc = nasc;
		this.listMov = listMov;
		this.listAge = listAge;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getfantasyName() {
		return fantasyName;
	}

	public void setfantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public List<MovimentacaoEntity> getListMov() {
		return listMov;
	}

	public void setListMov(List<MovimentacaoEntity> listMov) {
		this.listMov = listMov;
	}

	public List<AgendamentoEntity> getListAge() {
		return listAge;
	}

	public void setListAge(List<AgendamentoEntity> listAge) {
		this.listAge = listAge;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fantasyName, address, celphone, cep, city, code, complement, contact, corporateName,
				dataCadastro, district, email, id, listAge, listMov, nasc, observation, personType, telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientEntity other = (ClientEntity) obj;
		return Objects.equals(fantasyName, other.fantasyName) && Objects.equals(address, other.address)
				&& Objects.equals(celphone, other.celphone) && Objects.equals(cep, other.cep)
				&& Objects.equals(city, other.city) && Objects.equals(code, other.code)
				&& Objects.equals(complement, other.complement) && Objects.equals(contact, other.contact)
				&& Objects.equals(corporateName, other.corporateName)
				&& Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(district, other.district)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(listAge, other.listAge) && Objects.equals(listMov, other.listMov)
				&& Objects.equals(nasc, other.nasc) && Objects.equals(observation, other.observation)
				&& personType == other.personType && Objects.equals(telephone, other.telephone);
	}

	@Override
	public String toString() {
		return "ClientEntity [id=" + id + ", code=" + code + ", dataCadastro=" + dataCadastro + ", personType="
				+ personType + ", fantasyName=" + fantasyName + ", corporateName=" + corporateName + ", cep=" + cep
				+ ", address=" + address + ", complement=" + complement + ", telephone=" + telephone + ", celphone="
				+ celphone + ", contact=" + contact + ", email=" + email + ", city=" + city + ", district=" + district
				+ ", observation=" + observation + ", nasc=" + nasc + ", listMov=" + listMov + ", listAge=" + listAge
				+ "]";
	}
	
	
}
