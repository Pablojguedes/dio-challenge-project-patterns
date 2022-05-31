package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	private String cep;
	private String publicArea;
	private String complement;
	private String district;
	private String city;
	private String uf;
	private String ibge;
	private String gia;
	private String ddd;
	private String siafi;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return publicArea;
	}

	public void setLogradouro(String publicArea) {
		this.publicArea = publicArea;
	}

	public String getComplemento() {
		return complement;
	}

	public void setComplemento(String complement) {
		this.complement = complement;
	}

	public String getBairro() {
		return district;
	}

	public void setBairro(String district) {
		this.district = district;
	}

	public String getLocalidade() {
		return city;
	}

	public void setLocalidade(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

}