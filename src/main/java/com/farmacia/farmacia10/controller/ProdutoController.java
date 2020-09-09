package com.farmacia.farmacia10.controller;

import java.util.List;

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

import com.farmacia.farmacia10.model.Produto;
import com.farmacia.farmacia10.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAllProduto(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto(@RequestBody Produto nome){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
}