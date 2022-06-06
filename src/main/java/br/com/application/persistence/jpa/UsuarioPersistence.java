package br.com.application.persistence.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.application.domain.Usuario;
import br.com.application.infrastructure.PersistenceGeneric;
import br.com.application.persistence.util.JDBConnectionUtil;
import br.com.application.persistence.util.HibernateUtil;

public class UsuarioPersistence extends PersistenceGeneric<Usuario> {
	
	public Usuario getUsuario(String logon) throws Exception {

		Usuario usuario = null;
		return usuario;
	}
	
	public Usuario getUsuario(String logon, String password) throws Exception {
		Usuario usuario = null;
		return usuario;
	}
    /*
	public Usuario getUsuario(String logon) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario;
		try {
			return usuario = (Usuario) session.createQuery("from Usuario where logon = :name")
					.setParameter("logon", logon);
		} catch (Exception e) {
			return null;
		}
	}

	public Usuario getUsuario(String logon, String password) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Usuario usuario = (Usuario) session.createQuery("from Usuario where logon = :name and password = :passwd")
					.setParameter("logon", logon).setParameter("passwd", password);
			return usuario;
		} catch (Exception e) {
			return null;
		}
	}
    */
}
