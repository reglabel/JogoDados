package rbcl.sessao;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import rbcl.entidades.Dado;
import rbcl.entidades.DadoIMP;
import rbcl.entidades.Jogador;
import rbcl.excecoes.*;
import rbcl.logica.RegraDado;
import rbcl.logica.RegraPartida;

public abstract class Partida {
	private int id;
	protected Jogador jogadores[];
	protected Dado dados[];
	protected int rodadas;
	private Random gerador = new Random();
	
	public Partida(Jogador[] jogadores, Dado[] dados, int rodadas) {
		this.setJogadores(jogadores);
		this.setDados(dados);
		this.setRodadas(rodadas);
		this.id = gerador.nextInt(100);
	}
	
	public abstract void executar();
	
	public Jogador[] getJogadores() {
		return jogadores;
	}

	protected void setJogadores(Jogador[] jogadores) {
		try {
			RegraPartida.validarComponenteJogadores(jogadores);
			this.jogadores = jogadores;
		} catch (JogadoresIguaisExcecao e) {
			Random gerador = new Random();
			for(int i = 0; i < jogadores.length; i++) {
				jogadores[i] = new Jogador("Player" + (i * gerador.nextInt(100)));
			}
						
			this.jogadores = jogadores;
		} catch (NumeroInvalidoJogadoresExcecao e) {
			Random gerador = new Random();
			Jogador[] jogadoresValidos = new Jogador[RegraPartida.VALOR_JOGADORES_PADRAO];
			for(int i = 0; i < RegraPartida.VALOR_JOGADORES_PADRAO; i++) {
				jogadoresValidos[i] = new Jogador("Player" + (i * gerador.nextInt(100)));
			}
						
			this.jogadores = jogadoresValidos;
		}
	}

	public Dado[] getDados() {
		return dados;
	}

	protected void setDados(Dado[] dados) {
		try {
			RegraPartida.validarComponenteDados(dados);
			this.dados = dados;
		} catch (DadosTiposInvalidosExcecao e) {
			for(int i = 0; i < dados.length; i++) {
				dados[i] = new DadoIMP(RegraDado.VALOR_FACES_PADRAO);
			}
						
			this.dados = dados;
		} catch (NumeroInvalidoDadosExcecao e) {
			Dado[] dadosValidos = new DadoIMP[RegraPartida.VALOR_DADOS_PADRAO];
			for(int i = 0; i < RegraPartida.VALOR_DADOS_PADRAO; i++) {
				dadosValidos[i] = new DadoIMP(RegraDado.VALOR_FACES_PADRAO);
			}
						
			this.dados = dadosValidos;
		}
	}

	public int getRodadas() {
		return rodadas;
	}

	protected void setRodadas(int rodadas) {
		try {
			RegraPartida.validarComponenteRodadas(rodadas);
			this.rodadas = rodadas;
		} catch (NumeroDeRodadasInvalidoExcecao e) {
			Random gerador = new Random();
			int novasRodadas = gerador.nextInt((RegraPartida.VALOR_MAXIMO_RODADAS_PADRAO-RegraPartida.VALOR_MINIMO_RODADAS_PADRAO) + 1) + RegraPartida.VALOR_MINIMO_RODADAS_PADRAO;
			this.rodadas = novasRodadas;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(jogadores);
		result = prime * result + Objects.hash(id, rodadas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return id == other.id && Arrays.equals(jogadores, other.jogadores) && rodadas == other.rodadas;
	}

	@Override
	public String toString() {
		return "-=- PARTIDA -=-\n\t-> Jogadores:" + Arrays.toString(jogadores) + "\n\t-> Rodadas: " + rodadas;
	}

}
