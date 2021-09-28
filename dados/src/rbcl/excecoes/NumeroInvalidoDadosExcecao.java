package rbcl.excecoes;

public class NumeroInvalidoDadosExcecao extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Número Inválido de Dados em partida";
	}
}
