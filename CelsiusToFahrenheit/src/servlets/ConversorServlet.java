package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/converter")
public class ConversorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConversorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double temp = Double.parseDouble(request.getParameter("temperatura"));
		String tempOpt = request.getParameter("tempOpt");
		double valor = 0.0;
		
		if(tempOpt.equals("celsiusOpt")) {
			
			 valor = ((temp - 32.0) * 5.0) / 9.0;
			
		}else {
			 valor = ((temp * 9.0) / 5.0) + 32.0;
		}
		
		PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Resultado da conversão</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Valor convertido: " + valor + "</h1>");
			out.println("</body>");
			out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
