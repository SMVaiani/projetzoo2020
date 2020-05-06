package org.formation.zoo.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/supprimer")
public class SupprimerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SupprimerServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = "";
		if(req.getParameter("nomAnimal") != null)
		{
			String nomAnimal = req.getParameter("nomAnimal");
			msg = Manager.getInstance().supprimer(nomAnimal);
		}
		req.getSession(false).setAttribute("etat", msg);
		resp.sendRedirect("/projetzoo2020");
	}

	
}
