package br.gft.cshow.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.gft.cshow.model.Usuario;
import br.gft.cshow.repository.Usuarios;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private Usuarios usuarios;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarios.findByLogin(login);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		return usuario;
	}

}
