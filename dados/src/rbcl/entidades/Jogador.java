package rbcl.entidades;

import java.util.Objects;
import java.util.Random;

public class Jogador {
	private int id;
	private String nome;
	private int pontosPartida;
	private int vitorias;
	private int derrotas;
	private int empates;
	private Random gerador = new Random();
	
	public Jogador(String nome) {
		this.nome = nome.toUpperCase();
		this.id = gerador.nextInt(100);
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPontosPartida() {
		return pontosPartida;
	}
	
	public void setPontosPartida(int pontosPartida) {
		this.pontosPartida = pontosPartida;
	}
	
	public int getVitorias() {
		return vitorias;
	}
	
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	
	public int getDerrotas() {
		return derrotas;
	}
	
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	
	public int getEmpates() {
		return empates;
	}
	
	public void setEmpates(int empates) {
		this.empates = empates;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return " - Jogador -\nNome: " + nome + "\nPontos Partida: " + pontosPartida + "\nVitorias: " + vitorias + "\nDerrotas: "
				+ derrotas + "\nEmpates: " + empates;
	}
	
	public String toStringRodada() {
		return " - Jogador -\nNome: " + nome + "\nPontos Partida: " + pontosPartida;
	}

}
