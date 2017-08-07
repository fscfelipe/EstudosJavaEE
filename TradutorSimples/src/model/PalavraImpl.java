package model;

public class PalavraImpl implements Palavra {
	
	String nome;
	String traducao;

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public String getTraducao() {
		return this.traducao;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void setTraducao(String traducao) {
		this.traducao = traducao;
	}

	@Override
	public String toString() {
		return "PalavraImpl [nome=" + nome + ", traducao=" + traducao + "]";
	}
	
	

}
