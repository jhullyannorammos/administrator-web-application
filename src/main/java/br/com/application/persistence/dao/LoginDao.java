package br.com.application.persistence.dao;

import br.com.application.domain.Usuario;

public interface LoginDao {
	
	void recoveryPassword(String logon, String password);
	void resetPassword(String logon, String password);
	Usuario getUsuario(String logon, String password);
	Boolean getUsuario(String logon);
	
}
