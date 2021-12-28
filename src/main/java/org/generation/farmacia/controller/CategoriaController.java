package org.generation.farmacia.controller;

import java.util.List;

import org.generation.farmacia.model.Categoria;
import org.generation.farmacia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	/*
		Class controller da categoria
		@author GiovanaBorges
	 */
	
	@Autowired
	private CategoriaRepository repository; 
	
	@GetMapping 
	public ResponseEntity<List<Categoria>> findAllCategoria() {
		return ResponseEntity.ok(repository.findAll ());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findByIdCategoria(@PathVariable Long id) {
		return repository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> findByDescricaoCategoria(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoCategoriaContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
