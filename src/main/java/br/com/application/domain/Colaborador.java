package br.com.application.domain;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.br.CPF;

import br.com.application.domain.embeddable.Telefone;
import br.com.application.domain.embeddable.Endereco;
import br.com.application.infrastructure.DomainGeneric;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Table(name="colaboradores")
@Setter
@Getter
@Entity
public class Colaborador extends DomainGeneric {

    @Column(name = "email", 
            length = 30, 
            unique = true, 
            nullable = false)
    private String email;
	
    @Column(name="nomecompleto", nullable = false)
	private String NomeCompleto;
	
	@CPF
    @Column(name = "cpf", 
            length = 14, 
            unique = true, 
            nullable = false)
    private String cpf;
    
    @Column(name = "cnh", 
            length = 11, 
            unique = true, 
            nullable = true)
    private String cnh;
    
    @Column(name = "rg", 
            length = 14, 
            unique = true, 
            nullable = true)
    private String rg;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dataNascimento;
	
	@Column(name = "matricula", 
			unique = true, 
			nullable = true)
	private String matricula;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "remuneracao")
	private double remuneracao;
	
	@Embedded
	private Endereco endereco;
	
	@Embedded
	private Telefone telefone;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "departamento_id", nullable = true)
	private Departamento departamento;
	
	@OneToOne()
	private Usuario usuario;
	
	public Colaborador() {
		
	}
}
