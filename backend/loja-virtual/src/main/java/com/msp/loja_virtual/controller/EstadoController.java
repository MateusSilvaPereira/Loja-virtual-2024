package com.msp.loja_virtual.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msp.loja_virtual.entity.Estado;
import com.msp.loja_virtual.services.EstadoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/api/estado")
public class EstadoController {

	private EstadoService service;

	public EstadoController(EstadoService service) {
		this.service = service;
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Estado>> buscarTodos() {
		return ResponseEntity.ok(service.buscarTodos());
	}

	@PostMapping(value = "/")
	public ResponseEntity<Estado> inserir(@RequestBody Estado estado) {
		return ResponseEntity.ok(service.inserir(estado));
	}

	@PutMapping(value = "/")
	public ResponseEntity<Estado> alterar(@RequestBody Estado estado) {
		return ResponseEntity.ok().body(service.alterar(estado));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		service.deletar(id);
		return ResponseEntity.ok().build();
	}

}
