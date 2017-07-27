package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SomaParcelas
 */
@WebServlet("/somar")
public class somaParcelas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int p1 = Integer.parseInt(request.getParameter("p1"));
		int p2 = Integer.parseInt(request.getParameter("p2"));
		
		int total = p1 + p2;
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Resultado da soma</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>O resultado foi " + total + "</h1>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
