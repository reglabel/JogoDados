package rbcl.excecoes;

public class NumeroDeRodadasInvalidoExcecao extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Número de rodadas inválidas";
	}

}