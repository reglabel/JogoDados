package rbcl.menu;

import rbcl.logica.RegraPartida;

public class MenuIMP extends Menu {
	
	@Override
	public void adicionarAlternativa(String texto, int numero) {
		alternativas.add(new AlternativaMenu(numero, texto));
	}

	@Override
	public String sobreOJogo() {
		return "\n\t-= SOBRE O JOGO -=\n\nUm escolhido n�mero de jogadores jogar� determinado n�mero de dados de certas faces para determinar o vencedor pela quantidade de pontos obtidos!\n"
				+ "Essa a��o � feita repetidamente em uma determina quantidade de rodadas, a definir dentro de um limite.\n"
				+ "Caso haja mais de um jogador com a maior pontua��o obtida, estes ir�o empatar e os demais ser�o derrotados.\n"
				+ "Caso haja mais de um dado obtido com valores iguais, o somat�rio total da rodada ser� multiplicado por essa quantidade.\n"
				+ "\n\nNota: caso selecione jogadores iguais ou acima do limite atual (" + RegraPartida.VALOR_JOGADORES_PADRAO+ "), "
				+ "iremos criar jogadores an�nimos para esta partida, automaticamente! :D"
				+ "\nIsso se aplica a demais regras atuais [limite de rodadas (de " + RegraPartida.VALOR_MINIMO_RODADAS_PADRAO + " a "+ RegraPartida.VALOR_MAXIMO_RODADAS_PADRAO+ "), "
						+ "intervalo de faces (maior ou igual a 6) e n�mero de dados(" + RegraPartida.VALOR_DADOS_PADRAO+ ")\n";
	}
}
