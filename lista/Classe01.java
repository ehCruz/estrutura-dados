public class Classe01 {

    private int[] elementos;
    private static final int TAMANHO_LISTA = 10;
    private int tamanhoReal;

    public Classe01() {
        elementos = new int[TAMANHO_LISTA];
        tamanhoReal = 0;
    }

    public void adicionarElemento(int elemento) {
        if (this.tamanhoReal == TAMANHO_LISTA - 1) {
            System.out.println("Lista cheia");
        } else {
            this.elementos[this.tamanhoReal] = elemento;
            int temp;
            for (int i = 0; i < this.tamanhoReal; i++) {
                if (this.elementos[i] > this.elementos[i + 1]) {
                    temp = this.elementos[i + 1];
                    this.elementos[i + 1] = this.elementos[i];
                    this.elementos[i] = temp;
                }
            }
            tamanhoReal++;
        }
    }

    public void removeElemento(int posicao) {
        if (this.tamanhoReal <= 0) {
            System.out.println("Lista vazia");
        } else if (posicao >= this.tamanhoReal) {
            throw new IllegalArgumentException("Posicao informada e invalida");
        } else {
            int temp;
            for (int i = posicao; i < this.tamanhoReal; i++) {
                temp = this.elementos[i + 1];
                this.elementos[i + 1] = this.elementos[i];
                this.elementos[i] = temp;
            }
            tamanhoReal--;
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