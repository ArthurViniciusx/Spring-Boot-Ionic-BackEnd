package com.arthurvinicius.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurvinicius.cursomc.domain.Filme;
import com.arthurvinicius.cursomc.repositories.FilmeRepositorys;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepositorys repo;

	public Filme find(Integer id) {
		Optional<Filme> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.arthurvinicius.cursomc.services.exceptions.ObjectNotFoundException(
				"Objeto não encontrado ! Id: " + id + ", Tipo: " + Filme.class.getName()));
	}

	public Filme insert(Filme obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
