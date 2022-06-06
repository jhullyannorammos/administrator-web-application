package br.com.application.infrastructure;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("serial")
@MappedSuperclass
@Setter()
@Getter()
public class DomainGeneric implements Serializable {
    
    @EqualsAndHashCode.Include
    @Id @Column(name="codigo", nullable=false, insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
    
}
