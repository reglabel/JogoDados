package rbcl.registro;

import java.util.HashSet;
import java.util.Set;

import rbcl.entidades.Jogador;

public class BDJogador implements BD {
	public static Set<Jogador> jogadores = new HashSet<Jogador>();

	@Override
	public void salvar(Object o) {
		if(o instanceof Jogador) {
			jogadores.add((Jogador) o);
		}
	}

	@Override
	public void excluir(Object o) {
		if(o instanceof Jogador) {
			jogadores.remove((Jogador) o);
		}
	}

	@Override
	public void listar() {
		for(Jogador j : jogadores) {
			System.out.println(j.toString());
		}
	}
	
	public static Jogador procurar(String nome) {
		Jogador jogador = null;
		for(Jogador j: jogadores) {
			if(j.getNome().equals(nome)) {
				jogador = j;
			}
		}
		return jogador;
	}
	
	public static boolean estaVazio() {
		if(jogadores.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
