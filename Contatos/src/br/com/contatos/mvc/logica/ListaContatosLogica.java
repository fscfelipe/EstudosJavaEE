package br.com.contatos.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.contatos.jdbc.dao.ContatoDAO;
import br.com.contatos.jdbc.modelo.Contato;

public class ListaContatosLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
	      List<Contato> contatos = new ContatoDAO().getListaContatos();

	      req.setAttribute("contatos", contatos);
	  
	      return "lista-contatos.jsp";

	}

}
