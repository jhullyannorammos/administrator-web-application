package br.com.application.domain;

import br.com.application.infrastructure.DomainGeneric;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@SuppressWarnings("serial")
@Setter
@Getter
@Table(name="produtos")
@Entity
public class Produto extends DomainGeneric{
	
	@OneToOne()
    @JoinColumn(name = "modelo_id", unique=true)
    private Modelo modelo;
	
	@Column(name="valor", nullable = false)
    private double valor;
    
    @Column(name="produto")
    private String produto;

    public Produto() {
		
	}
    
    public Produto(String produto, Modelo modelo, double valor) {
		this.produto = produto;
    	this.modelo = modelo;
    	this.valor = valor;
	}
    
}
