package com.algaworks.algafood.auth.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.auth.domain.Usuario;
import com.algaworks.algafood.auth.domain.UsuarioRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public JpaUserDetailsService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado com username: " + username));
		
		return new AuthUser(usuario);
	}

}
