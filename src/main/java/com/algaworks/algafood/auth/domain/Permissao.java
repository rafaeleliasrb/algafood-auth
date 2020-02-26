package com.algaworks.algafood.auth.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permissao {

	@Id
	private Long id;
	
	private String nome;
	//private String descricao;
	
	public String getNome() {
		return nome;
	}
}
