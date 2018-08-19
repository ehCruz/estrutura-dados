import java.util.Scanner;

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
		int op;
		while (true) {
			System.out.print(
					"Controle de ocupacao de teatro\n1- Reservar assento\n2- Listar assentos\n9- Sair\nSelecione uma opcao:");
			op = sc.nextInt();
			switch (op) {
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
				System.exit(0);
			default:
				System.out.printf("A opcao %d e invalida, tente novamente!%n", op);
				break;
			}
		}
	}

	private void reservarAssento() {
		int opcao = 0;
		do {
			System.out.printf("%sTipo do assento:%n1- Plateia %n2- Balcao%nSelecione uma opcao:", "\033\143");
			opcao = sc.nextInt();
		} while (opcao <= 0 && opcao > 2);
		switch (opcao) {
		case 1:
			if (!verificarOcupacao(0)) {
				System.out.printf("%s--Reservar assento na plateia:%n", "\033\143");
				int fila;
				int cadeira;
				do {
					System.out.printf("Informe a fila(0 - %d):", assentos.length - 1);
					fila = sc.nextInt();
				} while (!(fila >= 0 && fila < assentos.length));

				do {
					System.out.printf("Informe a cadeira(0 - %d):", assentos[fila].length - 1);
					cadeira = sc.nextInt();
				} while (!(cadeira >= 0 && cadeira < assentos[fila].length));

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
				int posicaoBalcao;
				int fila;
				int cadeira;
				do {
					System.out.printf("Informe a posicao do balcao(0 - %d):", balcoes.length - 1);
					posicaoBalcao = sc.nextInt();
				} while (!(posicaoBalcao >= 0 && posicaoBalcao < balcoes.length));

				do {
					System.out.printf("Informe a fila(0 - %d):", balcoes[posicaoBalcao].length - 1);
					fila = sc.nextInt();
				} while (!(fila >= 0 && fila < balcoes[posicaoBalcao].length));

				do {
					System.out.printf("Informe a cadeira(0 - %d):", balcoes[posicaoBalcao][fila].length - 1);
					cadeira = sc.nextInt();
				} while (!(cadeira >= 0 && cadeira < balcoes[posicaoBalcao][fila].length));

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
		int opcao = 0;
		do {
			System.out.printf(
					"%sListar Assentos%nTipo de assento que deseja listar%n1- Plateia%n2- Balcao%n3- Plateia e Balcao%nSelecione uma opcao:",
					"\033\143");
			opcao = sc.nextInt();
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