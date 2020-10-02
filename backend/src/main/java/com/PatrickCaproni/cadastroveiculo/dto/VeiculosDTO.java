package com.PatrickCaproni.cadastroveiculo.dto;

import java.io.Serializable;

import com.PatrickCaproni.cadastroveiculo.entities.Veiculos;

public class VeiculosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;

	public VeiculosDTO() {
	}

	public VeiculosDTO(Long id, String veiculo, String marca, Integer ano, String descricao, Boolean vendido) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
	}

	public VeiculosDTO(Veiculos entity) {
		super();
		this.id = entity.getId();
		this.veiculo = entity.getVeiculo();
		this.marca = entity.getMarca();
		this.ano = entity.getAno();
		this.descricao = entity.getDescricao();
		this.vendido = entity.getVendido();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}

}
