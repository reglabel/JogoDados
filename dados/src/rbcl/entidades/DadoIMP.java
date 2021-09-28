package rbcl.entidades;

public class DadoIMP extends Dado {

	public DadoIMP(int faces) {
		super(faces);
	}

	@Override
	public int jogar() {
		this.faceExposta = gerador.nextInt((faces-1) + 1) + 1;
		System.out.println(this.toString());
		return this.faceExposta;
	}
}
