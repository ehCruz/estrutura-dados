import java.util.Scanner;
import java.lang.NumberFormatException;
import java.util.IllegalFormatConversionException;

/**
 * @author Eduardo Henrique Cruz
 * 
 *         Disciplina de Estrutura de Dados - Atividade sobre vetores e matrizes
 */
public class Teatro {

	private static int[][] assentos;
	private static int[][][] balcoes = new int[2][][];
	private Scanner sc;

	public Teatro() {
		assentos = new int[10][12];
		balcoes[0] = new int[5][7];
		balcoes[1] = new int[3][4];
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new Teatro().processar();
	}

	private void processar() {
		System.out.print("\033\143");
		String op;
		while (true) {
			System.out.print(
					"---------Atividade sobre vetores e matrizes--------\n1- Reservar assento\n2- Listar assentos\n9- Sair\nSelecione uma opcao:");
			try {
				op = sc.next();
				Integer opcao = Integer.parseInt(op);
				switch (opcao) {
				case 1:
					reservarAssento();
					break;
				case 2:
					listarAssentos();
					break;
				case 3:
					simularEstadoDeOcupacao(1);
					break;
				case 4:
					simularEstadoDeOcupacao(0);
					break;
				case 9:
					System.out.print("\033\143");
					System.out.println(
							"----------------------------------------------------------\nAluno: Eduardo Cruz | Matricula: 258635\n----------------------------------------------------------");
					System.exit(0);
				default:
					System.out.printf("A opcao %d e invalida, tente novamente%n", op);
					break;
				}
			} catch (NumberFormatException | IllegalFormatConversionException e) {
				e.printStackTrace();
				System.out.println("Valor da entrada informado e invalido, use apenas numeros");
			}
		}
	}

	private void reservarAssento() {
		Integer opcao = 0;
		String opcaoAuxiliar;
		do {
			try {
				System.out.printf(
						"%s--------------Tipo do assento--------------%n%n1- Plateia %n2- Balcao%nSelecione uma opcao:",
						"\033\143");
				opcaoAuxiliar = sc.next();
				opcao = Integer.parseInt(opcaoAuxiliar);
			} catch (NumberFormatException | IllegalFormatConversionException e) {
				e.printStackTrace();
				System.out.println("Valor da entrada informado e invalido, use apenas numeros");
			}
		} while (opcao <= 0 && opcao > 2);
		switch (opcao) {
		case 1:
			if (!verificarOcupacao(0)) {
				System.out.printf("%s--Reservar assento na plateia:%n", "\033\143");
				Integer fila = 0;
				Integer cadeira = 0;
				boolean naoValido = true;
				do {
					try {
						System.out.printf("Informe a fila(0 - %d):", assentos.length - 1);
						opcaoAuxiliar = sc.next();
						fila = Integer.parseInt(opcaoAuxiliar);
						System.out.printf("Informe a cadeira(0 - %d):", assentos[fila].length - 1);
						opcaoAuxiliar = sc.next();
						cadeira = Integer.parseInt(opcaoAuxiliar);
						naoValido = false;
					} catch (NumberFormatException | IllegalFormatConversionException e) {
						e.printStackTrace();
						System.out.println("Valor da entrada informado e invalido, use apenas numeros");
					}
				} while (naoValido);
				if (assentos[fila][cadeira] == 0) {
					assentos[fila][cadeira] = 1;
					System.out.print("\033\143");
					System.out.printf("Assento N%d da fila N%d foi reservado com sucesso%n", cadeira, fila);

				} else {
					System.out.print("\033\143");
					System.out.printf("Assento N%d da fila N%d ja esta reservado, tente novamente outro lugar%n",
							cadeira, fila);
				}
			} else {
				System.out.println("Teatro esta cheio");
			}
			break;
		case 2:
			if (!(verificarOcupacao(1))) {
				System.out.printf("%s--Reservar assento no balcao:%n", "\033\143");
				Integer posicaoBalcao = 0;
				Integer fila = 0;
				Integer cadeira = 0;
				boolean naoValido = true;
				do {
					try {
						System.out.printf("Informe a posicao do balcao(0 - %d):", balcoes.length - 1);
						opcaoAuxiliar = sc.next();
						posicaoBalcao = Integer.parseInt(opcaoAuxiliar);
						System.out.printf("Informe a fila(0 - %d):", balcoes[posicaoBalcao].length - 1);
						opcaoAuxiliar = sc.next();
						fila = Integer.parseInt(opcaoAuxiliar);
						System.out.printf("Informe a cadeira(0 - %d):", balcoes[posicaoBalcao][fila].length - 1);
						opcaoAuxiliar = sc.next();
						cadeira = Integer.parseInt(opcaoAuxiliar);
						naoValido = false;
					} catch (NumberFormatException | IllegalFormatConversionException e) {
						e.printStackTrace();
						System.out.println("Valor da entrada informado e invalido, use apenas numeros");
					}
				} while (naoValido);
				if (balcoes[posicaoBalcao][fila][cadeira] == 0) {
					balcoes[posicaoBalcao][fila][cadeira] = 1;
					System.out.print("\033\143");
					System.out.printf("Balcao P%d: cadeira N%d da fila N%d foi reservado com sucesso%n", posicaoBalcao,
							cadeira, fila);
				} else {
					System.out.print("\033\143");
					System.out.printf(
							"Balcao P%d: cadeira N%d da fila N%d ja esta reservado, tente novamente outro lugar%n",
							posicaoBalcao, cadeira, fila);
				}
			}
			break;
		}
	}

	private void listarAssentos() {
		Integer opcao = -1;
		String opcaoAuxiliar;
		do {
			try {
				System.out.printf(
						"%s--------------Listar Assentos--------------%n%nTipo de assento que deseja listar%n1- Plateia%n2- Balcao%n3- Plateia e Balcao%nSelecione uma opcao:",
						"\033\143");
				opcaoAuxiliar = sc.next();
				opcao = Integer.parseInt(opcaoAuxiliar);
			} catch (NumberFormatException | IllegalFormatConversionException e) {
				e.printStackTrace();
				System.out.println("Valor da entrada informado e invalido, use apenas numeros");
			}
		} while (opcao <= 0 && opcao > 3);
		switch (opcao) {
		case 1:
			System.out.print("--Plateia\n\n");
			for (int fila = 0; fila < assentos.length; fila++) {
				System.out.print("   ");
				for (int cadeira = 0; cadeira < assentos[fila].length; cadeira++) {
					if (assentos[fila][cadeira] == 0)
						System.out.print("Vazio ");
					else
						System.out.print("Reservado ");
				}
				System.out.print("\n");
			}
			System.out.print("\n\n");
			break;
		case 2:
			System.out.print("--Balcao\n\n");
			for (int total = 0; total < balcoes.length; total++) {
				for (int fila = 0; fila < balcoes[total].length; fila++) {
					System.out.print("   ");
					for (int cadeira = 0; cadeira < balcoes[total][fila].length; cadeira++) {
						if (balcoes[total][fila][cadeira] == 0)
							System.out.print("Vazio ");
						else
							System.out.print("Reservado ");
					}
					System.out.print("\n");
				}
				System.out.print("\n");
			}
			System.out.print("\n\n");
			break;
		case 3:
			System.out.print("\033\143");
			System.out.print("--Plateia\n\n");
			for (int fila = 0; fila < assentos.length; fila++) {
				System.out.print("   ");
				for (int cadeira = 0; cadeira < assentos[fila].length; cadeira++) {
					if (assentos[fila][cadeira] == 0)
						System.out.print("Vazio ");
					else
						System.out.print("Reservado ");
				}
				System.out.print("\n");
			}
			System.out.print("\n\n");
			System.out.print("--Balcao\n\n");
			for (int total = 0; total < balcoes.length; total++) {
				for (int fila = 0; fila < balcoes[total].length; fila++) {
					System.out.print("   ");
					for (int cadeira = 0; cadeira < balcoes[total][fila].length; cadeira++) {
						if (balcoes[total][fila][cadeira] == 0)
							System.out.print("Vazio ");
						else
							System.out.print("Reservado ");
					}
					System.out.print("\n");
				}
				System.out.print("\n");
			}
			System.out.print("\n\n");
			break;
		}
	}

	private void simularEstadoDeOcupacao(int opcao) {
		for (int fila = 0; fila < assentos.length; fila++) {
			for (int cadeira = 0; cadeira < assentos[fila].length; cadeira++) {
				assentos[fila][cadeira] = opcao;
			}
		}
		listarAssentos();
	}

	private boolean verificarOcupacao(int tipoAssento) {
		if (tipoAssento == 0) {
			for (int fila = 0; fila < assentos.length; fila++) {
				for (int cadeira = 0; cadeira < assentos[fila].length; cadeira++) {
					if (assentos[fila][cadeira] == 0)
						return false;
				}
			}
			return true;
		} else {
			for (int total = 0; total < balcoes.length; total++) {
				for (int fila = 0; fila < balcoes[total].length; fila++) {
					for (int cadeira = 0; cadeira < balcoes[total][fila].length; cadeira++) {
						if (balcoes[total][fila][cadeira] == 0)
							return false;
					}
				}
			}
			return true;
		}
	}
}