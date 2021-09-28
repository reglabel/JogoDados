package rbcl.sessao;

import java.util.Scanner;

import rbcl.entidades.Dado;
import rbcl.entidades.Jogador;
import rbcl.logica.RegraDado;
import rbcl.logica.RegraPartida;

public class PartidaIMP extends Partida {
	//logica do jogo
	
	public PartidaIMP(Jogador[] jogadores, Dado[] dados, int rodadas) {
		super(jogadores, dados, rodadas);
	}
	
	@Override
	public void executar() {
		Scanner scanner = new Scanner(System.in);
		
		for(int r = 0; r < rodadas; r++) {
			System.out.println("\n" + (r+1) + "º RODADA: ");
			for(int j = 0; j < jogadores.length; j++) {
				System.out.println("\n -> Jogador: " + jogadores[j].getNome());
				
				System.out.println("Lançamento de dados: ");
				for(int d = 0; d < dados.length; d++) {
					System.out.print((d+1) + "º lance: ");
					dados[d].jogar();
				}
				jogadores[j].setPontosPartida(jogadores[j].getPontosPartida() + RegraDado.somatorio(dados));
				
				System.out.println("PONTUAÇÃO ATUAl: " + jogadores[j].getPontosPartida());
			}
			
			System.out.println("Pressione ENTER para continuar...");
			scanner.nextLine();
			
		}
		
		RegraPartida.determinarResultado(jogadores);
		
		System.out.println("RESULTADOS DA PARTIDA: ");
		for(int j = 0; j < jogadores.length; j++) {
			System.out.println(jogadores[j].toString());
		}
		
		RegraPartida.reiniciarPontuacoes(jogadores);
	}
}
