package rbcl.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
	public static List<AlternativaMenu> alternativas = new ArrayList<AlternativaMenu>();
	private int qtdAlternativas;
	
	public abstract void adicionarAlternativa(String texto, int numero);
	public abstract String sobreOJogo();
	
	public void apresentar() {
		for(int i = 0; i < alternativas.size(); i++) {
			System.out.println(alternativas.get(i).toString());
		}
	}
	
	public static int escolherOpcao() {
		int opcao = 0;
		boolean continuar = true;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite a opção escolhida: ");
		String texto = scanner.nextLine();
		
		while(continuar) {
			try {
				opcao = Integer.parseInt(texto);
				continuar = false;
			} catch(NumberFormatException e) {
				System.out.println("Valor inválido! Tente novamente: ");
				texto = scanner.nextLine();
			}
		}
		
		return opcao;
		
	}

	public int getQtdAlternativas() {
		qtdAlternativas = alternativas.size();
		return qtdAlternativas;
	}
	
	
}
