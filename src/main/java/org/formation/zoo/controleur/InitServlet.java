package org.formation.zoo.controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.formation.zoo.service.CagePOJO;

/** 
 * Servlet implementation class InitServlet
 */
@WebServlet("/init")
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InitServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.getWriter().print("<h1>servlet atteinte</h1>");
		List<CagePOJO> zanimaux = null;
		zanimaux = Manager.getInstance().getAnimaux();
		req.setAttribute("listZanimaux", zanimaux);
		req.getServletContext().getRequestDispatcher("/principal.jsp").forward(req, resp);
	}

	
}
