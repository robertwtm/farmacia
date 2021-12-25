package org.generation.farmacia.service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.farmacia.model.UserLogin;
import org.generation.farmacia.model.Usuario;
import org.generation.farmacia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario CadastrarUsuario(Usuario usuario) {
		if(repository.findByUsuario(usuario.getUsuario()).isPresent()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuário em uso");
		}

		String senhaEncoder = encodePass(usuario.getSenha());
		String name = usuario.getNome();
		usuario.setSenha(senhaEncoder);
		usuario.setNome(name);

		return repository.save(usuario);
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
		if (usuario.isPresent()) {
			if (comparePass(user.get().getSenha(), usuario.get().getSenha())) {

				String authHeader = generateBasicToken(user.get().getUsuario() ,user.get().getSenha() );

				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());

				return user;

			}
		}
		return null;
	}

	private String encodePass(String passWord){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String passEncode = encoder.encode(passWord);
		return passEncode;
	}

	private String generateBasicToken(String email, String passWord){
		String structure = email + ":" + passWord;
		byte[] Base64structure = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
		return "Basic" + new String(Base64structure);
	}

	private boolean comparePass(String newPass, String savePass){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(newPass,savePass);
	}
}
