package rbcl.excecoes;

public class JogadoresIguaisExcecao extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Jogadores iguais para mesma partida";
	}

}
