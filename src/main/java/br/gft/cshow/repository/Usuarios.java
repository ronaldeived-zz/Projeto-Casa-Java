package br.gft.cshow.repository;

import org.springframework.data.repository.CrudRepository;

import br.gft.cshow.model.Usuario;

public interface Usuarios extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
	
}
