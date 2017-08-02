package br.com.contatos.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.contatos.jdbc.dao.ContatoDAO;
import br.com.contatos.jdbc.modelo.Contato;

public class AdicionarContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request
                .getParameter("dataNascimento");
        Calendar dataNascimento = null;
        
        try {
            Date date = 
                    new SimpleDateFormat("dd/MM/yyyy")
                    .parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            System.out.println("Erro de conversão da data");
            return null; 
        }
        
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);
        
        ContatoDAO dao = new ContatoDAO();
        dao.adiciona(contato);
        
        
        return "mvc?logica=ListaContatosLogica";
	}

}
