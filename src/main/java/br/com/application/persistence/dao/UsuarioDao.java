package br.com.application.persistence.dao;

import java.util.List;

import br.com.application.domain.Usuario;

public interface UsuarioDao {

	Usuario findById(Usuario usuario);
	void update(Usuario usuario);
	void delete(Usuario usuario);
	void save(Usuario usuario);
	List<Usuario> findAll();
	
}
