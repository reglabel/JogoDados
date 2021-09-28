package rbcl.menu;

public class AlternativaMenu {
	private int numero;
	private String texto;
	
	public AlternativaMenu(int numero, String texto) {
		super();
		this.numero = numero;
		this.texto = texto;
	}

	protected int getNumero() {
		return numero;
	}
	
	protected void setNumero(int numero) {
		this.numero = numero;
	}
	
	protected String getTexto() {
		return texto;
	}
	
	protected void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "\t" + numero + ") " + texto;
	}
	
	
}
