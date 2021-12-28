package org.generation.farmacia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbUsuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo Nome é Obrigatório!")
	private String nome;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caractéres")
	private String foto;
	
	@NotBlank(message = "O atributo Usuário é Obrigatório!")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	private String usuario;
	
	@NotBlank(message = "O atributo Senha é Obrigatório!")
	@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
	private String senha;


}
