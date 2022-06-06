package br.com.application.domain;

import br.com.application.domain.embeddable.Configuracao;
import br.com.application.infrastructure.DomainGeneric;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Setter
@Getter
@Table(name = "mercadorias")
public class Mercadoria extends DomainGeneric {
    
    @Column(name = "serialnumber", unique = true, nullable = false)
    private String serial;
    
    @Column(name = "estocada")
    private boolean estocada;
    
    @ManyToOne(/*fetch=FetchType.LAZY*/)
    @JoinColumn(name = "estoque_id", nullable = true)
    private Estoque estoque;

    @OneToOne()
    @JoinColumn(name = "produto_id", unique = false)
    private Produto produto;
    
    @OneToOne()
    @JoinColumn(name = "patrimonio_id", unique = false)
    private Patrimonio patrimonio;

    @Embedded
    private Configuracao configuracao;
    
    public Mercadoria(String serial, boolean estocada, Estoque estoque, Produto produto, Patrimonio patrimonio, Configuracao configuracao) {
    	this.patrimonio = patrimonio;
    	this.estocada = estocada;
    	this.produto = produto;
    	this.estoque = estoque;
    	this.serial = serial;
    }   

    public Mercadoria() {
        
    }   

}
