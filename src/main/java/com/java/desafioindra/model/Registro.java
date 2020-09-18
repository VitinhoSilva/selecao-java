package com.java.desafioindra.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRO")
public class Registro implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String regiaosigla;
	private String estadosigla;
	private String municipio;
	private String revenda;
	private String cnpjrevenda;
	private String produto;
	private String datacoleta;
	private Double valorvenda;
	private Double valorcompra;
	private String unidademedida;
	private String bandeira;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegiaosigla() {
		return regiaosigla;
	}
	public void setRegiaosigla(String regiaosigla) {
		this.regiaosigla = regiaosigla;
	}
	public String getEstadosigla() {
		return estadosigla;
	}
	public void setEstadosigla(String estadosigla) {
		this.estadosigla = estadosigla;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getRevenda() {
		return revenda;
	}
	public void setRevenda(String revenda) {
		this.revenda = revenda;
	}
	public String getCnpjrevenda() {
		return cnpjrevenda;
	}
	public void setCnpjrevenda(String cnpjrevenda) {
		this.cnpjrevenda = cnpjrevenda;
	}

	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getDatacoleta() {
		return datacoleta;
	}
	public void setDatacoleta(String datacoleta) {
		this.datacoleta = datacoleta;
	}
	public Double getValorvenda() {
		return valorvenda;
	}
	public void setValorvenda(Double valorvenda) {
		this.valorvenda = valorvenda;
	}
	public Double getValorcompra() {
		return valorcompra;
	}
	public void setValorcompra(Double valorcompra) {
		this.valorcompra = valorcompra;
	}
	public String getUnidademedida() {
		return unidademedida;
	}
	public void setUnidademedida(String unidademedida) {
		this.unidademedida = unidademedida;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public Registro() {
		
	}
	
	
	public Registro(Long id, String regiaosigla, String estadosigla, String municipio, String revenda,
			String cnpjrevenda, String produto, String datacoleta, Double valorvenda, Double valorcompra,
			String unidademedida, String bandeira) {
		super();
		this.id = id;
		this.regiaosigla = regiaosigla;
		this.estadosigla = estadosigla;
		this.municipio = municipio;
		this.revenda = revenda;
		this.cnpjrevenda = cnpjrevenda;
		this.produto = produto;
		this.datacoleta = datacoleta;
		this.valorvenda = valorvenda;
		this.valorcompra = valorcompra;
		this.unidademedida = unidademedida;
		this.bandeira = bandeira;
	}


	@Override
	public String toString() {
		return "Registro [id=" + id + ", regiaosigla=" + regiaosigla + ", estadosigla=" + estadosigla + ", municipio="
				+ municipio + ", revenda=" + revenda + ", cnpjrevenda=" + cnpjrevenda + ", produto=" + produto
				+ ", datacoleta=" + datacoleta + ", valorvenda=" + valorvenda + ", valorcompra=" + valorcompra
				+ ", unidademedida=" + unidademedida + ", bandeira=" + bandeira + "]";
	}
	
	
	
}