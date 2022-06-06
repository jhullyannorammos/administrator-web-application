package br.com.application.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.application.enumerator.MovimentacaoEnum;
import br.com.application.infrastructure.DomainGeneric;

import lombok.Getter;
import lombok.Setter;

@Table(name = "movimentacao")
@SuppressWarnings("serial")
@Entity
@Setter
@Getter
public class Movimentacao extends DomainGeneric {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="movimentacao_mercadorias",
        joinColumns = @JoinColumn(name="movimentacao_id"),
        inverseJoinColumns = @JoinColumn(name="mercadoria_id"))
    private List<Mercadoria> mercadorias;
    
    @Enumerated(EnumType.STRING)
    private MovimentacaoEnum movimentacao;
    
    @Column(name="dataMovimentacao")
    private Date periodo;
    
    @Column()
    private boolean concluida = Boolean.FALSE;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="colaborador_id")
    private Colaborador colaborador;
    
    public Movimentacao(boolean concluida, Date periodo, Colaborador colaborador, List<Mercadoria> mercadorias, MovimentacaoEnum movimentacao) {
        this.movimentacao = movimentacao;
        this.mercadorias = mercadorias;
        this.colaborador = colaborador;
        this.concluida = concluida;
        this.periodo = periodo;
    }
    
	
	public Movimentacao() {
        super();
    }
    
}
