package br.com.crudfarmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_produto")

public class Produto {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "É necessário informar o nome do Produto!")
	@Size(min = 2, max = 30, message = "Informe um nome com no mínimo 2 e no máximo 30 caracteres!")
	@Column (length = 20)
	private String nome;
	
	@Size(min = 5, max = 500, message = "Informe uma descrição que contenha no mínimo 5v e no máximo 500 caracteres!")
	@Column (length = 500)
	private String descricao;
	
	@NotNull (message = "É necessário informar a quantidade do Produto!")
	@Positive (message = "Apenas números positivos são aceitos!")
	private int quantidade;
	
	@NotNull (message = "É necessário informar um preço para o Produto!")
	@Positive (message = "O valor do preço deve positivo!")
    private float preco;
	
	@ManyToOne
	@JsonIgnoreProperties("Produto")
	private Categoria categoria;

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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}