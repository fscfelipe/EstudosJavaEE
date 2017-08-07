package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tradutor")
public class TradutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TradutorController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String palavra = request.getParameter("palavra");
		palavra = palavra.toLowerCase();
		

		InputStream is = getClass().getClassLoader().getResourceAsStream("model/listaPalavras.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line;
		boolean flag = false;
		
		//Percorre o arquivo, e armazena no request, caso a tradução exista
		while ((line = br.readLine()) != null) {
			
			line = line.toLowerCase();
			String[] parts = line.split(",");
			
			if (parts[0].equals(palavra)) {
				flag = true;
				request.setAttribute("palavra", parts[1]);
				break;
			}
			
		}
		
		//Se a tradução não existe, armazena a palavra enviada sem tradução
		if(!flag) {
			request.setAttribute("palavra", palavra);
		}
		
		request.setAttribute("flag", flag);
		br.close();
		
		RequestDispatcher rd = request.getRequestDispatcher("/traducao.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
