import circular.Circular;
import duplamente.Duplamente;
import encadeada.Simples;

import java.util.Scanner;

public class Princal {

    private static Scanner in = new Scanner(System.in);
    private Simples listaSimples = new Simples();
    private Duplamente listaDuplamente = new Duplamente();
    private Circular listaCircular = new Circular();
    private Integer elemento;

    public static void main(String[] args) {
        new Princal().processar();
    }

    private void processar() {
        int op;
        while (true) {
            System.out.println("---Demostração de listas---\nExercicios da disciplina de Estrutura de Dados\n");
            System.out.println("Tipo de listas:\n1- Lista simples\n2- Lista duplamente encadeada\n3- Lista circular\n9- Sair");
            System.out.print("Selecione o tipo de lista para trabalhar:");
            op = in.nextInt();
            switch (op) {
                case 1:
                    this.listaSimples();
                    break;
                case 2:
                    this.listaDuplamente();
                    break;
                case 3:

                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção" + op + " é inválida");
                    break;
            }
        }
    }

    private void listaSimples() {
        int op;
        String el;
        while (true) {
            System.out.println("---Demostração de listas---\nExercicio 02 - Lista Simples\n");
            System.out.println("Selecione uma ação:\n1- Incluir elemento\n2- Excluir elemento\n3- Imprimir lista\n9- Menu principal");
            System.out.print("Selecione a operação que deseja realizar:");
            op = in.nextInt();
            switch (op) {
                case 1:
                    do {
                        System.out.print("Informe um valor inteiro a ser adicionado a lista:");
                        el = in.next();
                    } while (!validarEntradaDeElemento(el));
                    this.listaSimples.adicionarElemento(this.elemento);
                    break;
                case 2:
                    int confirmaExclusao = this.listaSimples.excluirUltimoNo();
                    if (confirmaExclusao == 1)
                        System.out.println("Último elemento removido com sucesso");
                    else
                        System.out.println("Lista está vazia");
                    break;
                case 3:
                    System.out.println("Todos os elementos da lista:\n" + this.listaSimples);
                    break;
                case 9:
                    this.processar();
                    break;
                default:
                    System.out.println("Opção" + op + " é inválida");
                    break;
            }
        }
    }

    private void listaDuplamente() {
        int op;
        String el;
        while (true) {
            System.out.println("---Demostração de listas---\nExercicio 03 - Lista Duplamente Encadeada\n");
            System.out.println("Selecione uma ação:\n1- Incluir elemento no final\n2- Incluir elemento no começo\n" +
                    "3- Excluir elemento\n4- Imprimir lista\n5- Pesquisar elemento\n9- Menu principal");
            System.out.print("Selecione a operação que deseja re2alizar:");
            op = in.nextInt();
            switch (op) {
                case 1:
                    do {
                        System.out.print("Informe um valor inteiro a ser adicionado no final da lista:");
                        el = in.next();
                    } while (!validarEntradaDeElemento(el));
                    this.listaDuplamente.adicionarElementoNoFim(this.elemento);
                    break;
                case 2:
                    do {
                        System.out.print("Informe um valor inteiro a ser adicionado no inicio da lista:");
                        el = in.next();
                    } while (!validarEntradaDeElemento(el));
                    this.listaDuplamente.adicionarElementoNoInicio(this.elemento);
                    break;
                case 3:
                    do {
                        System.out.print("Informe o elemento a ser excluido: ");
                        el = in.next();
                    } while (!validarEntradaDeElemento(el));
                    if (this.listaDuplamente.excluirElemento(elemento) > 0) {
                        System.out.println("Elemento [" + elemento + "] removido com sucesso");
                    } else {
                        System.out.println("Elemento [" + elemento + "] não foi encontrado na lista, tente novamente.");
                    }
                    break;
                case 4:
                    System.out.println("Todos os elementos da lista:\n" + this.listaDuplamente);
                    break;
                case 5:
                    do {
                        System.out.print("Informe o elemento a ser pesquisado: ");
                        el = in.next();
                    } while (!validarEntradaDeElemento(el));
                    int posicao = this.listaDuplamente.pesquisarElemento(elemento);
                    if (posicao >= 0) {
                        System.out.println("Elemento [" + elemento + "] encontrado no indice [" + posicao + "] da lista.");
                    } else {
                        System.out.println("Elemento [" + elemento + "] não encontrado na lista");
                    }
                    break;
                case 9:
                    this.processar();
                    break;
                default:
                    System.out.println("Opção" + op + " é inválida");
                    break;
            }
        }
    }

    private boolean validarEntradaDeElemento(String elemento) {
        try {
            this.elemento = Integer.parseInt(elemento);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
