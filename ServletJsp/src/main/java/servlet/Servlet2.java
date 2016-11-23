package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		//System.out.println(user);
		req.setAttribute("nom",nombre);
		
		
		Servicios.BorrarTabla(nombre);
		
		redirect(resp);
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		//System.out.println(user);
		req.setAttribute("nom",nombre);
		
		//JavaConexion.crearTabla();
		Servicios.BorrarTabla(nombre);
		
		redirect(resp);
		super.doPost(req, resp);
	}

	private void redirect(HttpServletResponse resp) throws IOException {
		resp.sendRedirect("aviso.jsp");
	}
}
