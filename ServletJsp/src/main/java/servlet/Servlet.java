package servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet
 */
public class Servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		String idioma = req.getParameter("Idioma");
		String idioma2 = req.getParameter("Idioma2");
		
		//System.out.println(user);
		req.setAttribute("nom",nombre);
		req.setAttribute("i", idioma);
		req.setAttribute("i2",idioma2);

		Servicios.crearTabla();
		Servicios.insertarTabla(nombre,idioma, idioma2);
		

		req.getRequestDispatcher("fin.jsp").forward(req, resp);
		//redirect(resp);
		super.doPost(req, resp);
	}


	private void redirect(HttpServletResponse resp) throws IOException {
		resp.sendRedirect("fin.jsp");
	}
}
