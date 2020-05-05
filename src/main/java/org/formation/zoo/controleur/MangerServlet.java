package org.formation.zoo.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** 
 * Servlet implementation class InitServlet
 */
@WebServlet("/manger")
public class MangerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MangerServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.getWriter().print("<h1>servlet atteinte</h1>");
		Manager.getInstance().nourrir();
		//req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		resp.sendRedirect("index.jsp");
	}
	
}
