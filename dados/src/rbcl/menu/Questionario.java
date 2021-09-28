package rbcl.menu;

import java.util.Scanner;

import rbcl.entidades.Dado;
import rbcl.entidades.DadoIMP;
import rbcl.entidades.Jogador;
import rbcl.logica.RegraPartida;
import rbcl.registro.BD;
import rbcl.registro.BDJogador;
import rbcl.sessao.Partida;
import rbcl.sessao.PartidaIMP;

public abstract class Questionario {
	private static Scanner scanner = new Scanner(System.in);
	
	private static Jogador criarJogador(BD banco) {
		System.out.println("\nDeseja criar jogador NOVO [Digite 1] ou usar um EXISTENTE [Digite 2]?");
		int opcao = 0;
		
		while(true) {
			opcao = Menu.escolherOpcao();
			if (opcao == 1 || opcao == 2) {
				break;
			} else {
				System.out.println("\nOpção inexistente! Tente novamente!");
			}
		}
		
		Jogador jogador = null;
		
		switch(opcao) {
		
			case 1:
				System.out.println("\nDigite o nome do Jogador: ");
				String nome = scanner.nextLine().toUpperCase();
				jogador = BDJogador.procurar(nome);
				if(jogador == null) {
					jogador = new Jogador(nome);
					banco.salvar(jogador);
					System.out.println("\nJogador " + jogador.getNome() + " registrado!");
				} else {
					System.out.println("\nJogador já existente! Acessando esse registro...");
				}
				break;
				
			case 2:
				boolean continuar = true;
				while(continuar) {
					System.out.println("\n Veja a LISTA de JOGADORES: ");
					banco.listar();
					System.out.println("\nDigite o nome do Jogador que deseja selecionar: ");
					String nomeAProcurar = scanner.nextLine().toUpperCase();
					Jogador jogadorAExistir = BDJogador.procurar(nomeAProcurar);
					if(BDJogador.estaVazio()) {
						System.out.println("\nNão há jogadores registrados! Crie um novo!");
						continuar = false;
					} else {
						if(jogadorAExistir == null) {
							System.out.println("\nJogador Inexistente! Tente um nome válido!");
						} else {
							jogador = jogadorAExistir;
							System.out.println("\nJogador " + jogador.getNome() + " selecionado!");
							continuar = false;
						}
					}
				}
					
		}		
		return jogador;
	}
	
	private static Dado criarDado(int faces) {
		Dado dado = new DadoIMP(faces);
		return dado;
	}
	
	public static Partida criarPartida(BD bancoPartida, BD bancoJogadores) {		
		System.out.println("Iniciando NOVA PARTIDA! Quantos jogadores participarão?");

		int qtdJogadores = Menu.escolherOpcao();
		Jogador[] jogadores = new Jogador[qtdJogadores];
		for(int i = 0; i < qtdJogadores; i++) {
			System.out.println("\nCriando Jogador nº" + (i+1) + "...");
			Jogador jogadorNovo = criarJogador(bancoJogadores);
			
			while(jogadorNovo == null) {
				jogadorNovo = criarJogador(bancoJogadores);
			}
			
			jogadores[i] = jogadorNovo;
		}
		
		System.out.println("\nQuantas são as faces de cada dado?");
		int qtdFaces = Menu.escolherOpcao();
		
		System.out.println("\nQuantos dados serão utilizados para cada jogador?");
		int qtdDados = Menu.escolherOpcao();
		Dado[] dados = new Dado[qtdDados];
		for(int i = 0; i < qtdDados; i++) {
			dados[i] = criarDado(qtdFaces);
		}

		System.out.println("\nQuantas rodadas serão realizadas?");
		int qtdRodadas = Menu.escolherOpcao();
		
		Partida partida = new PartidaIMP(jogadores, dados, qtdRodadas);
		bancoPartida.salvar(partida);
		
		return partida;
	}
}
