package rbcl.excecoes;

public class NumeroInvalidoJogadoresExcecao extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "N�mero inv�lido de jogadores";
	}

}
