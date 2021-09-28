package rbcl.excecoes;

public class DadosTiposInvalidosExcecao extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Dados não são do mesmo tipo";
	}
}