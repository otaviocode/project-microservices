package logica;

import java.util.Scanner;

public class DiaTrintaeUm {

	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Seja bem vindo!\n Digite um número e iremos gerar uma tabuada do 1 ao 10!");
			int tabuada = scanner.nextInt();
			for (int x = 0; x <= 10; x++) {
				int mult = x * tabuada;
				System.out.println(tabuada + "x" + x + "=" + mult);
			}

			System.out.println(
					"Você deseja fazer a tabuada de outro número ou sair?\n 1 = Desejo Sair\n 2 = Fazer tabuada com outro número");
			int repetir = scanner.nextInt();
			if (repetir == 1) {
				System.out.println("Obrigado por ter usado o sisteminha <3 até mais!!");
				break;
			} else if (repetir == 2) {
				continue;
			}
			scanner.close();
		}

	}

}