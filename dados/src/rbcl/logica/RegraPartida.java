package rbcl.logica;

import java.util.HashSet;
import java.util.Set;

import rbcl.entidades.Dado;
import rbcl.entidades.Jogador;
import rbcl.excecoes.*;

public abstract class RegraPartida {
	public static int VALOR_JOGADORES_PADRAO = 2;
	public static int VALOR_MINIMO_RODADAS_PADRAO = 3;
	public static int VALOR_MAXIMO_RODADAS_PADRAO = 5;
	public static int VALOR_DADOS_PADRAO = 3;
	
	public static void validarComponenteJogadores(Jogador jogadores[]) throws JogadoresIguaisExcecao, NumeroInvalidoJogadoresExcecao {
		if (jogadores.length != VALOR_JOGADORES_PADRAO || jogadores.length <= 1) {
			throw new NumeroInvalidoJogadoresExcecao();
		}
		
		for(int i = 0; i < jogadores.length; i++) {
			Jogador jogadorDaVez = jogadores[i];
			
			if(i < (jogadores.length - 1)) {
				for(int j = i + 1; j < jogadores.length; j++) {
					Jogador jogadorAComparar = jogadores[j];
					if(jogadorDaVez.equals(jogadorAComparar)) {
						throw new JogadoresIguaisExcecao();
					}
				}
			}
		}
	}
	
	public static void validarComponenteDados(Dado dados[]) throws NumeroInvalidoDadosExcecao, DadosTiposInvalidosExcecao {
		
		if (dados.length != VALOR_DADOS_PADRAO || dados.length <= 0) {
			throw new NumeroInvalidoDadosExcecao();
		}
		
		for(int i = 0; i < dados.length; i++) {
			Dado dadoDaVez = dados[i];
			
			if(i < (dados.length - 1)) {
				for(int j = i + 1; j < dados.length; j++) {
					Dado dadoAComparar = dados[j];
					if(!(dadoDaVez.equals(dadoAComparar))) {
						throw new DadosTiposInvalidosExcecao();
					}
				}
			}
		}
	}
	
	public static void validarComponenteRodadas(int rodadas) throws NumeroDeRodadasInvalidoExcecao {
		if (rodadas < VALOR_MINIMO_RODADAS_PADRAO  || rodadas > VALOR_MAXIMO_RODADAS_PADRAO) {
			throw new NumeroDeRodadasInvalidoExcecao();
		}
	}
	
	public static void determinarResultado(Jogador jogadores[]) {
		Jogador jogadorMaiorScore = jogadores[0];
		Jogador jogadorMenorScore = jogadores[0];
		Set<Jogador> empatados = new HashSet<Jogador>();
		
		for(int i = 0; i < jogadores.length; i++) {
			Jogador jogadorDaVez = jogadores[i];
			
			if(i == 0) {
				jogadorMaiorScore = jogadorDaVez;
				jogadorMenorScore = jogadorDaVez;
			} else {
				if(jogadorDaVez.getPontosPartida() > jogadorMaiorScore.getPontosPartida()) {
					jogadorMaiorScore = jogadorDaVez;
				}
				
				if(jogadorDaVez.getPontosPartida() < jogadorMenorScore.getPontosPartida()) {
					jogadorMenorScore = jogadorDaVez;
				}
				
			}
		}
		
		if(jogadorMaiorScore.getPontosPartida() == jogadorMenorScore.getPontosPartida()) {
			for(int i = 0; i < jogadores.length; i++) {
				Jogador jogadorDaVez = jogadores[i];
				
				jogadorDaVez.setEmpates(jogadorDaVez.getEmpates() + 1);
			}
		} else {
			boolean temEmpates = false;
			
			for(int i = 0; i < jogadores.length; i++) {
				Jogador jogadorDaVez = jogadores[i];
				
				if(jogadorDaVez.getPontosPartida() == jogadorMaiorScore.getPontosPartida() && !(jogadorDaVez.equals(jogadorMaiorScore))) {
					empatados.add(jogadorDaVez);
					temEmpates = true;
				}
				
				if(jogadorDaVez.getPontosPartida() < jogadorMaiorScore.getPontosPartida()) {
					jogadorDaVez.setDerrotas(jogadorDaVez.getDerrotas() + 1);
				}
			}
			
			if(temEmpates) {
				for(Jogador j : empatados) {
					j.setEmpates(j.getEmpates() + 1);
				}
				
				jogadorMaiorScore.setEmpates(jogadorMaiorScore.getEmpates() + 1);
			} 
			
			if(!temEmpates){
				jogadorMaiorScore.setVitorias(jogadorMaiorScore.getVitorias() + 1);
			}
		}
	}
	
	public static void reiniciarPontuacoes(Jogador jogadores[]) {
		for(int i = 0; i < jogadores.length; i++) {
			Jogador jogadorDaVez = jogadores[i];
			jogadorDaVez.setPontosPartida(0);
		}
	}
}
