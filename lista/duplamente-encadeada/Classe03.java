import java.lang.StringBuilder;

public class Classe03 {

    private ListaDuplamenteEncadeada primeiroNo;
    private ListaDuplamenteEncadeada ultimoNo;
    private int tamanhoDaLista;

    public void adicionarElemento(int elemento) {
        ListaDuplamenteEncadeada lista = this.new ListaDuplamenteEncadeada();
        lista.setElemento(elemento);
        if (this.tamanhoDaLista == 0) {
            lista.setAnterior(null);
            lista.setProximo(null);
            this.primeiroNo = lista;
            this.ultimoNo = this.primeiroNo;
        } else {
            lista.setAnterior(this.ultimoNo);
            this.ultimoNo.setProximo(lista);
            this.ultimoNo = lista;
        }
        this.tamanhoDaLista++;
    }

    public int excluirUltimoNo() {
        if (this.tamanhoDaLista == 0) {
            return 0;
        } else {
            ListaDuplamenteEncadeada lista = this.new ListaDuplamenteEncadeada();
            lista.setProximo(primeiroNo);
            for (int i = 0; i < tamanhoDaLista - 1; i++) {
                lista = lista.getProximo();
            }
            this.ultimoNo.setProximo(null);
            this.ultimoNo = lista;
            this.tamanhoDaLista--;
            return 1;
        }
    }

    public String exibirUltimoNo() {
        if (this.tamanhoDaLista == 0) {
            return "Lista vazia";
        } else {
            StringBuilder sb = new StringBuilder();
            ListaDuplamenteEncadeada lista = this.new ListaDuplamenteEncadeada();
            lista.setProximo(ultimoNo);
            lista = lista.getProximo();
            sb.append("Ultimo item adicionado: ").append(lista.getElemento());
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        if (this.tamanhoDaLista == 0) {
            return "[]";
        } else {
            ListaDuplamenteEncadeada lista = this.new ListaDuplamenteEncadeada();
            StringBuilder sb = new StringBuilder();
            lista.setProximo(primeiroNo);
            for (int i = 0; i < tamanhoDaLista; i++) {
                lista = lista.getProximo();
                sb.append(lista.getElemento());
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    private class ListaDuplamenteEncadeada {
        private int elemento;
        private ListaDuplamenteEncadeada proximo;
        private ListaDuplamenteEncadeada anterior;

        /**
         * @return the elemento
         */
        public int getElemento() {
            return elemento;
        }

        /**
         * @param elemento the elemento to set
         */
        public void setElemento(int elemento) {
            this.elemento = elemento;
        }

        /**
         * @return the proximo
         */
        public ListaDuplamenteEncadeada getProximo() {
            return proximo;
        }

        /**
         * @param proximo the proximo to set
         */
        public void setProximo(ListaDuplamenteEncadeada proximo) {
            this.proximo = proximo;
        }

        /**
         * @param anterior the anterior to set
         */
        public void setAnterior(ListaDuplamenteEncadeada anterior) {
            this.anterior = anterior;
        }

        /**
         * @return the anterior
         */
        public ListaDuplamenteEncadeada getAnterior() {
            return anterior;
        }
    }
}