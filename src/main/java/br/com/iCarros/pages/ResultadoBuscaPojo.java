package br.com.iCarros.pages;

import com.google.gson.annotations.SerializedName;

public class ResultadoBuscaPojo {

	
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@SerializedName("ano")
	private Integer ano;
	@SerializedName("km")
	private String km;
		
	@SerializedName("cor")
	private String cor;
	
	@SerializedName("cambio")
	private String cambio;
	
	@SerializedName("preco")
	private String preco;
	
	@SerializedName("nome")
	private String nome;
	

}
