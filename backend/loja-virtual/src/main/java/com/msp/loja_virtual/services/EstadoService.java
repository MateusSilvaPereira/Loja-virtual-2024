package com.msp.loja_virtual.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msp.loja_virtual.entity.Estado;
import com.msp.loja_virtual.repository.EstadoRepository;

@Service
public class EstadoService {

	private EstadoRepository estadoRepository;

	public EstadoService(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	public List<Estado> buscarTodos() {
		return estadoRepository.findAll();
	}

	public Estado inserir(Estado estado) {
		estado.setDataCriacao(new Date());
		return estadoRepository.save(estado);
	}

	public Estado alterar(Estado estado) {
		estado.setDataAtualizacao(new Date());
		return estadoRepository.save(estado);
	}

	public void deletar(Long id) {
		estadoRepository.deleteById(id);
	}

}
