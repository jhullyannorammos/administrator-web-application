package br.com.application.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.application.persistence.util.HibernateUtil;

@WebFilter(urlPatterns={"/faces/*"})
public class FacesAuthentication implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
         try {
			//HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest requisition = (HttpServletRequest) request;
		HttpSession session = requisition.getSession();
		Logado logado = (Logado) session.getAttribute("usuario");
		String url = requisition.getServletPath();
		
		if (!url.equalsIgnoreCase("index.jsf") && logado == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/autenticacao.xhtml");
			dispatcher.forward(request, response);
			return;
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}

}
