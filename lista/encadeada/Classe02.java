import java.lang.StringBuilder;

public class Classe02 {

    private ListaEncadeada primeiroNodo;
    private ListaEncadeada ultimoNodo;
    private int tamanhoDaLista;

    public void adicionarElemento(int elemento) {
        ListaEncadeada lista = this.new ListaEncadeada();
        lista.setElemento(elemento);
        if (this.tamanhoDaLista == 0) {
            lista.setProximo(null);
            this.primeiroNodo = lista;
            this.ultimoNodo = this.primeiroNodo;
        } else {
            this.ultimoNodo.setProximo(lista);
            this.ultimoNodo = lista;
        }
        this.tamanhoDaLista++;
    }

    public String exibirUltimoNodo() {
        if (this.tamanhoDaLista == 0) {
            return "Lista vazia";
        } else {
            StringBuilder sb = new StringBuilder();
            ListaEncadeada lista = new ListaEncadeada();
            lista.setProximo(ultimoNodo);
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
            lista.setProximo(primeiroNodo);
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