package fila.exercicio01;

public class Exercicio01 {

    private final int[] vetorFila;
    private int tamanhoReal = 0;

    public Exercicio01() {
        this.vetorFila = new int[10];
    }

    public void adicionarElemento(int elemento) {
        if (this.tamanhoReal <= 10) {
            this.vetorFila[this.tamanhoReal] = elemento;
            this.tamanhoReal++;
        } else {
            System.out.println("Fila está cheia");
        }
    }

    public void adicionarElemento(int... elementos) {
        if (this.tamanhoReal <= 10) {
            for (int elemento : elementos) {
                if (this.tamanhoReal <= 10) {
                    this.vetorFila[this.tamanhoReal] = elemento;
                    this.tamanhoReal++;
                } else {
                    break;
                }
            }
        } else {
            System.out.println("Fila está cheia");
        }
    }

    public int consumirElemento() {
        if (this.tamanhoReal > 0) {
            int elemento = this.vetorFila[0];
            for (int i = 0; i < this.tamanhoReal; i++) {
                this.vetorFila[i] = this.vetorFila[i + 1];
            }
            this.tamanhoReal--;
            return elemento;
        } else {
            return -1;
        }
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
