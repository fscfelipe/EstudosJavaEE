package br.com.contatos.testes;

import java.util.List;

import br.com.contatos.jdbc.dao.ContatoDAO;
import br.com.contatos.jdbc.modelo.Contato;

public class TestaListarContatos {

	public static void main(String[] args) {

		ContatoDAO dao = new ContatoDAO();
		List<Contato> contatos = dao.getListaContatos();

		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Data de Nascimento: " + 
								contato.getDataNascimento().getTime() + "\n");
		}

	}

}
