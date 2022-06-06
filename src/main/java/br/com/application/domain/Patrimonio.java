package br.com.application.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.application.infrastructure.DomainGeneric;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
@Entity
@Table(name = "patrimonios")
public class Patrimonio extends DomainGeneric {

	@Column(name = "patrimonio", unique = true)
	private String patrimonio;
	
	@OneToOne()
	@JoinColumn(name = "mercadoria_id", unique = true)
    private Mercadoria mercadoria;
	
	@OneToOne()
	@JoinColumn(name = "sl_id", unique = true)
    private SoftwareLicense softwareLicense;
	
	@Column()
    private boolean sucateado = false;
	
	public Patrimonio() {
		
	}
}
