package com.algaworks.algafood.auth.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Grupo {

	@Id
	private Long id;
	
	//private String nome;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "grupo_permissao", 
			joinColumns = @JoinColumn(name = "grupo_id"),
			inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private Set<Permissao> permissoes = new HashSet<>();
	
	public Set<Permissao> getPermissoes() {
		return permissoes;
	}
}
