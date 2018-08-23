public class Classe01 {

    private int[] elementos;
    private static final int TAMANHO_LISTA = 10;
    private int tamanhoReal;

    public Classe01() {
        elementos = new int[TAMANHO_LISTA];
        tamanhoReal = 0;
    }

    public void adicionarElemento(int elemento) {
        if (this.tamanhoReal == TAMANHO_LISTA) {
            System.out.println("Lista cheia");
        } else {
            this.elementos[this.tamanhoReal] = elemento;
            tamanhoReal++;
            ordenarLista();
        }
    }

    private void ordenarLista() {
        if (this.tamanhoReal > 0) {
            int temp;
            for (int i = 1; i < this.tamanhoReal; i++) {
                for (int j = i; j > 0; j--) {
                    if (this.elementos[j] < this.elementos[j - 1]) {
                        temp = this.elementos[j];
                        this.elementos[j] = this.elementos[j - 1];
                        this.elementos[j - 1] = temp;
                    }
                }
            }
        }
    }

    public void removeElemento(int posicao) {
        if (this.tamanhoReal <= 0) {
            System.out.println("Lista vazia");
        } else if (posicao > this.tamanhoReal || posicao < 0) {
            throw new IllegalArgumentException("Posicao informada e invalida");
        } else {
            this.elementos[posicao] = this.tamanhoReal + 1;
            tamanhoReal--;
            ordenarLista();
        }
    }

    public void exibirElementosDaLista() {
        if (this.tamanhoReal == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < tamanhoReal; i++) {
                System.out.println(this.elementos[i]);
            }
        }
    }

    public int tamanhoLista() {
        return this.tamanhoReal;
    }

}