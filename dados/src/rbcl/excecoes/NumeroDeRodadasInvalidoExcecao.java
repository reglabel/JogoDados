package rbcl.excecoes;

public class NumeroDeRodadasInvalidoExcecao extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "N�mero de rodadas inv�lidas";
	}

}