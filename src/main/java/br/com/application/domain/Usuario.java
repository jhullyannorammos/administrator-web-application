package br.com.application.domain;

import br.com.application.enumerator.UsuarioEnum;
import br.com.application.enumerator.UsuarioStatus;
import br.com.application.infrastructure.DomainGeneric;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;
@SuppressWarnings("serial")
@Setter
@Getter
@Entity
@Table(name="usuarios")
public class Usuario extends DomainGeneric{
       
    @Column(name="username")
    private String username;
   
    @Email
    @Column(name = "logon", 
            length = 30, 
            unique = true, 
            nullable = false)
    private String email;
    
    @Column(name="password")
    private String password;
    
    
    @Enumerated(EnumType.STRING) 
    private UsuarioEnum perfil;
    
    @Enumerated(EnumType.STRING) 
    private UsuarioStatus status;


    public Usuario() {
        super(); 
    }

 
}
