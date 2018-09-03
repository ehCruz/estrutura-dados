package fila.exercicio01;

public class Exercicio01 {

    private final int[] vetorFila;
    private int tamanhoReal = 0;

    public Exercicio01() {
        this.vetorFila = new int[10];
    }

    public void adicionarElemento(int elemento) {
        if (this.tamanhoReal < 10) {
            this.vetorFila[this.tamanhoReal] = elemento;
            this.tamanhoReal++;
        } else {
            System.out.println("Fila está cheia");
        }
    }

    public void consumirElemento(){

    }

    @Override
    public String toString() {
        if (this.tamanhoReal > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Itens da lista:\n");
            for (int i = 0; i < this.tamanhoReal; i++) {
                sb.append("[").append(this.vetorFila[i]).append("]");
            }
            return sb.toString();
        } else {
            return "Fila está vazia";
        }
    }
}
