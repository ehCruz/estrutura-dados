package duplamente;

import java.lang.StringBuilder;

public class Duplamente {

    private ListaDuplamenteEncadeada primeiroNo;
    private ListaDuplamenteEncadeada ultimoNo;
    private int tamanhoDaLista;

    public void adicionarElementoNoFim(int elemento) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
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

    public void adicionarElementoNoInicio(int elemento) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.setElemento(elemento);
        lista.setProximo(this.primeiroNo);
        this.primeiroNo.setAnterior(lista);
        this.primeiroNo = lista;
        this.tamanhoDaLista++;
    }

    public int pesquisarElemento(int elemento) {
        if (this.tamanhoDaLista > 0) {
            ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
            lista.setProximo(this.primeiroNo);
            for (int i = 0; i < this.tamanhoDaLista; i++) {
                if (lista.getElemento() == elemento) {
                    return i;
                }
                lista = lista.getProximo();
            }
        }
        return -1;
    }

    public int excluirElemento(int elemento) {
        if (this.pesquisarElemento(elemento) >= 0) {
            ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
            lista.setProximo(primeiroNo);
            for (int i = 0; i < tamanhoDaLista - 1; i++) {
                if (lista.getElemento() == elemento) {
                    lista.getProximo().setAnterior(lista.getAnterior());
                    this.tamanhoDaLista--;
                    return 1;
                }
                lista = lista.getProximo();
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        if (this.tamanhoDaLista == 0) {
            return "[]";
        } else {
            ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
            StringBuilder sb = new StringBuilder();
            lista.setProximo(primeiroNo);
            for (int i = 0; i < tamanhoDaLista; i++) {
                lista = lista.getProximo();
                if (lista.anterior != null) {
                    sb.append(lista.anterior.getElemento());
                } else {
                    sb.append(" ");
                }
                sb.append(" - ");
                sb.append(lista.getElemento());
                sb.append(" - ");
                if (lista.proximo != null) {
                    sb.append(lista.proximo.getElemento());
                } else {
                    sb.append(" ");
                }
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
