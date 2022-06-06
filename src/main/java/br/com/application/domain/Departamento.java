package br.com.application.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.application.infrastructure.DomainGeneric;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@Entity
@Table(name = "departamentos")
public class Departamento extends DomainGeneric {

	@Column(name = "departamento")
	private String departamento;

	@Column(name = "sigla", unique = true)
	private String sigla;

	@Column(name = "hierarquia")
	private String hierarquia;
	
	@Column(name = "localidade")
	private String localidade;

	@OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
	private List<Colaborador> colaboradores;

	public Departamento() {

	}

	public String getUO() throws Exception {
		return this.sigla + "-" + this.hierarquia + "-" + this.departamento;
	}

}
