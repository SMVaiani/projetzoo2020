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
		String msg = "";
		String mangeur = "";
		String mange = "";
		if(req.getParameter("mangeur") != null && req.getParameter("mange") != null)
		{
			mangeur = req.getParameter("mangeur");
			mange = req.getParameter("mange");
			msg = Manager.getInstance().devorer(Integer.parseInt(mangeur), Integer.parseInt(mange));
		}
		//resp.getWriter().print("<h1>mangeur:"+mangeur+"   mange:"+mange+"</h1>");
		req.getSession(false).setAttribute("etat", msg);
		resp.sendRedirect("/projetzoo2020");
	}

	
}
