package rbcl.main;

import rbcl.menu.Menu;
import rbcl.menu.MenuIMP;
import rbcl.menu.Questionario;
import rbcl.registro.BD;
import rbcl.registro.BDJogador;
import rbcl.registro.BDPartida;
import rbcl.sessao.Partida;

public class Main {

	public static void main(String[] args) {
		Menu menu = new MenuIMP();
		BD bancoJogadores = new BDJogador();
		BD bancoPartidas = new BDPartida();
		int opcao;
		
		menu.adicionarAlternativa("Iniciar Novo Jogo", 1);
		menu.adicionarAlternativa("Listar Jogadores", 2);
		menu.adicionarAlternativa("Listar Partidas", 3);
		menu.adicionarAlternativa("Sobre o Jogo", 4);
		menu.adicionarAlternativa("Sair do Programa", 5);
		
		System.out.println("=-=- Bem-vindo(a) ao JOGO DE DADOS! -=-=\n");
		
		boolean continuar = true;
		while(continuar) {
			while(true) {
				System.out.println("\n\t\t=-=- MENU -=-=\n");
				menu.apresentar();
				System.out.println("\n");
				opcao = Menu.escolherOpcao();
				if(opcao < 1 || opcao > menu.getQtdAlternativas()) {
					System.out.println("Opção Inexistente! Tente novamente!");
				} else {
					break;
				}
			}
			
			switch(opcao) {
				case 1:
					System.out.println("\n");
					Partida partida = Questionario.criarPartida(bancoPartidas, bancoJogadores);
					partida.executar();
					break;
				
				case 2:
					System.out.println("\n");
					bancoJogadores.listar();
					break;
					
				case 3:
					System.out.println("\n");
					bancoPartidas.listar();
					break;
					
				case 4:
					System.out.println(menu.sobreOJogo());
					break;
					
				case 5:
					System.out.println("\n");
					System.out.println("Obrigada por Jogar! Até a próxima!");
					continuar = false;
					break;
			}
		}	
	}

}
