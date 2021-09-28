package rbcl.logica;

import java.util.HashSet;
import java.util.Set;

import rbcl.entidades.Dado;
import rbcl.excecoes.NumeroDeFacesInvalidoExcecao;

public abstract class RegraDado {
	public static final int VALOR_FACES_PADRAO = 6;
	
	public static void validarCriacao(int valor) throws NumeroDeFacesInvalidoExcecao {
		if(valor < VALOR_FACES_PADRAO) {
			throw new NumeroDeFacesInvalidoExcecao();
		}
	}
	
	public static int somatorio(Dado dados[]) {
		int qtdIgual = 0, somatorio = 0;
		Set<Dado> comparados = new HashSet<Dado>();
		
		for(int i = 0; i < dados.length; i++) {
			Dado dadoDaVez = dados[i];
			boolean verificado = false;
			
			boolean analise = comparados.add(dadoDaVez);
			if(analise) {
				if(i != (dados.length-1)) {
					Dado dadoAComparar;
					for(int j = i+1; j < dados.length; j++) {
						dadoAComparar = dados[j];
						
						if(dadoAComparar.equals(dadoDaVez)) {
							if(!verificado) {
								qtdIgual += 1;
								verificado = true;
							}
							qtdIgual += 1;
						}
					}	
				}
			}
			
			somatorio += dadoDaVez.getFaceExposta();
		}
		if(qtdIgual != 0) {
			somatorio *= qtdIgual;
		}
		return somatorio;
	}

	
}
