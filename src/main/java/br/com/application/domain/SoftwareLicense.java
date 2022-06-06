package br.com.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.application.enumerator.SoftwareEnum;
import br.com.application.infrastructure.DomainGeneric;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@Entity
@Table(name = "licenses")
public class SoftwareLicense extends DomainGeneric {

	@OneToOne()
	@JoinColumn(name = "patrimonio_id", nullable = true, unique = true)
	private Patrimonio patrimonio;

	@Column(name = "number_key", unique = true, length = 30)
	private String key;

	@Enumerated(EnumType.STRING)
	private SoftwareEnum sistema;

	public SoftwareLicense() {

	}

}
