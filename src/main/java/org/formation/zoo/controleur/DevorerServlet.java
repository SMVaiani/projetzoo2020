package org.formation.zoo.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Servlet implementation class DevorerServlet
 */
@WebServlet("/devorer")
public class DevorerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DevorerServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mangeur = Integer.parseInt(req.getParameter("mangeur"));
		int mange = Integer.parseInt(req.getParameter("mange"));
		Manager.getInstance().devorer(mangeur, mange);
		//resp.getWriter().print("<h1>mangeur:"+mangeur+"   mange:"+mange+"</h1>");
		resp.sendRedirect("/projetzoo2020");
	}

	
}
