package rbcl.excecoes;

public class NumeroDeFacesInvalidoExcecao extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "N�mero de faces inv�lido";
	}

}
