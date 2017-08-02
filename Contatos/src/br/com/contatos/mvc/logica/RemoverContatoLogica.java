package br.com.contatos.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.contatos.jdbc.dao.ContatoDAO;
import br.com.contatos.jdbc.modelo.Contato;

public class RemoverContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		long id = Long.parseLong(req.getParameter("id"));

	    Contato contato = new Contato();
	    contato.setId(id);

	    ContatoDAO dao = new ContatoDAO();
	    dao.remove(contato);

	    System.out.println("Excluindo contato... ");

	    return "lista-contatos.jsp";
	}

}
