import java.lang.StringBuilder;

public class Classe02 {

    private ListaEncadeada primeiroNo;
    private ListaEncadeada ultimoNo;
    private int tamanhoDaLista;

    public void adicionarElemento(int elemento) {
        if (this.tamanhoDaLista <= 9) {
            ListaEncadeada lista = this.new ListaEncadeada();
            lista.setElemento(elemento);
            if (this.tamanhoDaLista == 0) {
                lista.setProximo(null);
                this.primeiroNo = lista;
                this.ultimoNo = this.primeiroNo;
            } else {
                this.ultimoNo.setProximo(lista);
                this.ultimoNo = lista;
            }
            this.tamanhoDaLista++;
        }
    }

    public int excluirUltimoNo() {
        if (this.tamanhoDaLista == 0) {
            return 0;
        } else {
            ListaEncadeada lista = new ListaEncadeada();
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
            ListaEncadeada lista = new ListaEncadeada();
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
            ListaEncadeada lista = new ListaEncadeada();
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

    private class ListaEncadeada {
        private int elemento;
        private ListaEncadeada proximo;

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
        public ListaEncadeada getProximo() {
            return proximo;
        }

        /**
         * @param proximo the proximo to set
         */
        public void setProximo(ListaEncadeada proximo) {
            this.proximo = proximo;
        }
    }
}