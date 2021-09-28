package rbcl.entidades;

import java.util.Objects;
import java.util.Random;

import rbcl.excecoes.NumeroDeFacesInvalidoExcecao;
import rbcl.logica.RegraDado;

public abstract class Dado {
	protected int faces;
	protected int faceExposta = 1;
	protected Random gerador;
	
	public Dado(int faces) {
		this.setFaces(faces);
		this.gerador = new Random();
	}
	
	public int getFaces() {
		return faces;
	}
	
	public int getFaceExposta() {
		return faceExposta;
	}
	
	public abstract int jogar();

	protected void setFaces(int faces) {
		try {
			RegraDado.validarCriacao(faces);
			this.faces = faces;
		} catch (NumeroDeFacesInvalidoExcecao e) {
			this.faces = RegraDado.VALOR_FACES_PADRAO;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(faceExposta, faces);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dado other = (Dado) obj;
		return faceExposta == other.faceExposta && faces == other.faces;
	}

	@Override
	public String toString() {
		return "Dado [faces=" + faces + ", faceExposta=" + faceExposta + "]";
	}
}
