package logica;

import java.util.Scanner;

public class AnotherLogic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int x = 1; x < 11;) {

			System.out.println("Número da verificação: " + x);
			System.out.println("Olá, bem vindo ao sistema de notas, digite a sua nota:");
			int nota = sc.nextInt();

			if (nota > 4) {
				if (nota >= 7) {
					System.out.println("Aluno(a) Aprovado!");
				} else if (nota > 4 && nota <= 7) {
					System.out.println("Aluno(a) em Recuperação");
				}
			} else {
				System.out.println("Aluno(a) Reprovado!");
			}

			System.out.println("Deseja encerrar o programa ou verificar outra nota?\n");
			System.out.println("1 = SIM Verificar Outra Nota");
			System.out.println("0 = NÃO Encerrar Sistema");
			int rodarDenovo = sc.nextInt();

			if (rodarDenovo == 1) {
				x++;
			} else if (rodarDenovo == 0) {
				System.out.println("Obrigado por ultilizar, tchauuu <3");
				break;
			}

		}

		sc.close();

	}

}
