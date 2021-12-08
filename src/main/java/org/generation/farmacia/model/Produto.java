package org.generation.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 25)
	private String produto;
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 255)
	private String produtoCategoria;

	@NotNull
	private String produtoDescricao;

	@NotNull
	private float produtoPreco;

	@NotNull
	private String produtoMarca;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getProdutoCategoria() {
		return produtoCategoria;
	}

	public void setProdutoCategoria(String produtoCategoria) {
		this.produtoCategoria = produtoCategoria;
	}


	public float getProdutoPreco() {
		return produtoPreco;
	}

	public void setProdutoPreco(float produtoPreco) {
		this.produtoPreco = produtoPreco;
	}

	public String getProdutoMarca() {
		return produtoMarca;
	}

	public void setProdutoMarca(String produtoMarca) {
		this.produtoMarca = produtoMarca;
	}
}
