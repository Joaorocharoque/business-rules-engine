package com.company.businessrulesengine.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;
	private String marca;
	private int quantidade;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataDeValidade;

	private Double precoDeVenda;
	private Double precoDeCompra;

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(LocalDate dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	public Double getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(Double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public Double getPrecoDeCompra() {
		return precoDeCompra;
	}

	public void setPrecoDeCompra(Double precoDeCompra) {
		this.precoDeCompra = precoDeCompra;
	}

	public static final class Builder {
		private Long id;
		private String nome;
		private String descricao;
		private String marca;
		private int quantidade;
		private LocalDate dataDeValidade;
		private Double precoDeVenda;
		private Double precoDeCompra;

		private Builder() {
		}

		public static Builder aProduct() {
			return new Builder();
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public Builder descricao(String descricao) {
			this.descricao = descricao;
			return this;
		}

		public Builder marca(String marca) {
			this.marca = marca;
			return this;
		}

		public Builder quantidade(int quantidade) {
			this.quantidade = quantidade;
			return this;
		}

		public Builder dataDeValidade(LocalDate dataDeValidade) {
			this.dataDeValidade = dataDeValidade;
			return this;
		}

		public Builder precoDeVenda(Double precoDeVenda) {
			this.precoDeVenda = precoDeVenda;
			return this;
		}

		public Builder precoDeCompra(Double precoDeCompra) {
			this.precoDeCompra = precoDeCompra;
			return this;
		}

		public Product build() {
			Product product = new Product();
			product.setId(id);
			product.setNome(nome);
			product.setDescricao(descricao);
			product.setMarca(marca);
			product.setQuantidade(quantidade);
			product.setDataDeValidade(dataDeValidade);
			product.setPrecoDeVenda(precoDeVenda);
			product.setPrecoDeCompra(precoDeCompra);
			return product;
		}
	}
}