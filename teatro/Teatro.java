import java.util.Scanner;

public class Teatro {
	
	private int[][] assentos;
	private Scanner sc;

	public Teatro(){
		assentos = new int[10][12];
		sc = new Scanner(System.in);
	}

	public static void main(String[] args){
		new Teatro().processar();	
	}

	private void processar(){
		int op;
		while(true){
			System.out.println("Selecione uma opcao:\n1- Reservar assento\n2 - Listar assentos\n9 - Sair");
			op = sc.nextInt();
			switch(op){
				case 1:
					reservarAssento();
					break;
				case 2:
					listaAssentos();
					break;
				case 9:
					System.out.println("Finalizando....");
					System.exit(0);
				default:
					System.out.printf("A opcao %d e invalida, tente novamente!%n", op);
					break;	
			}
		}	
	}

	private void reservarAssento(){
		if(!estaCheio()){			
			int fila;
			int cadeira;
			boolean naoValido = true;
			do{	
				System.out.println("Informe a fila(0 - 9):");
				fila = sc.nextInt();
				if(fila >= 0 && fila <= 9)
					naoValido = false;				
			}while(naoValido);
			naoValido = true;
			do{	
				System.out.println("Informe a cadeira(0 - 9):");
				cadeira = sc.nextInt();
				if(cadeira >= 0 && cadeira <= 9)
					naoValido = false;				
			}while(naoValido);
			if(assentos[fila][cadeira] == 0){
				assentos[fila][cadeira] = 1;
				System.out.printf("Assento N%d da fila N%d foi reservado com sucesso%n", cadeira, fila);
			
			}else{
				System.out.printf("Assento N%d da fila N%d ja esta reservado%n", cadeira, fila);
			}
		}else{
			System.out.println("Teatro esta cheio");
		}
	}

	private void listaAssentos(){
		for(int fila = 0; fila < assentos.length; fila++){
			System.out.printf("Fila %d%n", fila + 1);
			for(int cadeira = 0; cadeira < assentos[fila].length; cadeira++){
				if(assentos[fila][cadeira] == 0)
					System.out.print("Vazio ");
				else
					System.out.print("Reservado ");
			}
			System.out.println();
		}
	}

	private boolean estaCheio(){
		for(int fila = 0; fila < assentos.length; fila++){
			for(int cadeira = 0; cadeira < assentos[fila].length; cadeira++){
				if(assentos[fila][cadeira] == 0)
					return false;
				else
					return true;
			}
		}
		return false;
	}
}	
