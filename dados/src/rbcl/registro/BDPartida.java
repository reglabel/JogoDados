package rbcl.registro;

import java.util.HashSet;
import java.util.Set;

import rbcl.sessao.Partida;

public class BDPartida implements BD {

	public static Set<Partida> partidas = new HashSet<Partida>();

	@Override
	public void salvar(Object o) {
		if(o instanceof Partida) {
			partidas.add((Partida) o);
		}
	}

	@Override
	public void excluir(Object o) {
		if(o instanceof Partida) {
			partidas.remove((Partida) o);
		}
	}

	@Override
	public void listar() {
		for(Partida p : partidas) {
			System.out.println(p.toString());
		}
	}
}
