package org.formation.zoo.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Servlet implementation class CreerServlet
 */
@WebServlet("/creer")
public class CreerServlet extends HttpServlet {

	public CreerServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "";
		if(req.getParameter("typeAnimal") != null && req.getParameter("nom") != null && req.getParameter("age") != null && req.getParameter("poids") != null 
				&& req.getParameter("corne") != null && req.getParameter("cageX") != null && req.getParameter("cageY") != null)
		{
			String codeAnimal = req.getParameter("typeAnimal");
			String nom = req.getParameter("nom");
			String age = req.getParameter("age");
			String poids = req.getParameter("poids");
			String lgCornes = req.getParameter("corne");
			String x = req.getParameter("cageX");
			String y = req.getParameter("cageY");
			
			msg = Manager.getInstance().ajouter(codeAnimal, nom, Integer.parseInt(age), Double.parseDouble(poids), Integer.parseInt(x),Integer.parseInt(y), Integer.parseInt(lgCornes));
		}
		req.getSession(false).setAttribute("etat", msg);
		resp.sendRedirect("/projetzoo2020");
	}

	
}
