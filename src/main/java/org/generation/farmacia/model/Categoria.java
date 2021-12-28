package org.generation.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 25)
	private String nome;
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 255)
	private String descricaoCategoria;

	@OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "categoria", nullable = false)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produtos;

}
