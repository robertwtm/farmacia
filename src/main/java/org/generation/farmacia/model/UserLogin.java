package org.generation.farmacia.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {
	private Long id;

	private String nome;

	private String usuario;

	private String senha;

	private String token;

}
