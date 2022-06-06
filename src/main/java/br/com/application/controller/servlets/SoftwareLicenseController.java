package br.com.application.controller.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.application.domain.Patrimonio;
import br.com.application.persistence.jpa.PatrimonioPersistence;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/SoftwareLicense" })
public class SoftwareLicenseController extends HttpServlet{

	private PatrimonioPersistence SLicensePersistence;
	private List<Patrimonio> SLicenses;
	private Patrimonio SLicense;

	private JSONArray SLicensesJSON;
	private JSONObject SLicenseJSON;
	
	private HashMap<String, Object> js = new HashMap<String, Object>();
	private Gson gson = null;
	
	public SoftwareLicenseController() {
		super();
	}
	
	private void persist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(SLicense.getPatrimonio()));
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(gson.toJson(SLicense.getPatrimonio()));
		}
	}
	
	private void findBy(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(SLicenseJSON);
		}
	}
	
	private void findAll(HttpServletResponse response) throws Exception {
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(500);
			response.getWriter().print(gson.toJson(e.getMessage()));
		}finally {
			response.setStatus(200);
			response.getWriter().print(SLicensesJSON);
		}
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException, Exception {
		gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");
		int op = Integer.parseInt(request.getParameter("actionServlet"));
		switch (op) {
		case 100:
			persist(request, response);
			break;
		case 200:
			delete(request, response);
			break;
		case 300:
			findBy(request, response);
			break;
		case 400:
			findAll(response);
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception ex) {
			Logger.getLogger(ProdutosController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception ex) {
			Logger.getLogger(ProdutosController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}

