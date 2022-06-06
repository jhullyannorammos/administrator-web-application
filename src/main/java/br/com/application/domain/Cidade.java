package br.com.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.application.infrastructure.DomainGeneric;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Table(name="cidades")
@Setter
@Getter
@Entity
public class Cidade extends DomainGeneric {
	
	@Column(length = 20, nullable = false, unique = true)
	private String cidade;
	
	@Column(length = 20)
	private String federacao;
	
	@Column(length = 2)
	private String sigla;
	
	@Column(length = 20)
	private boolean capital;
	
	public Cidade() {
		
	}

}
