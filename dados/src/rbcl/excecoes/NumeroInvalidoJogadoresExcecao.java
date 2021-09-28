package rbcl.excecoes;

public class NumeroInvalidoJogadoresExcecao extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Número inválido de jogadores";
	}

}
