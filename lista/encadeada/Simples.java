package encadeada;

import java.lang.StringBuilder;

public class Simples {

    private ListaEncadeada primeiroNo;
    private ListaEncadeada ultimoNo;
    private int tamanhoDaLista;

    public void adicionarElemento(int elemento) {
        if (this.tamanhoDaLista <= 14) {
            if (verificarElementoRepetido(elemento)){
                ListaEncadeada lista = new ListaEncadeada();
                lista.setElemento(elemento);
                if (this.tamanhoDaLista == 0) {
                    lista.setProximo(null);
                    this.primeiroNo = lista;
                    this.ultimoNo = this.primeiroNo;
                } else {
                    if (this.primeiroNo.getElemento() > elemento) {
                        lista.setProximo(this.primeiroNo);
                        this.primeiroNo = lista;
                    } else if (this.ultimoNo.getElemento() > elemento) {
                        lista.setProximo(primeiroNo);
                        for (int i = 0; i < this.tamanhoDaLista; i++) {
                            if (lista.getProximo().getElemento() < elemento) {
                                lista = lista.getProximo();
                            } else {
                                ListaEncadeada objTemp = new ListaEncadeada();
                                objTemp.setElemento(elemento);
                                objTemp.setProximo(lista.getProximo());
                                lista.setProximo(objTemp);
                                break;
                            }
                        }
                    } else {
                        this.ultimoNo.setProximo(lista);
                        this.ultimoNo = lista;
                    }
                }
                this.tamanhoDaLista++;
            } else {
                System.out.println("Elemento já presente na lista");
            }
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

    private boolean verificarElementoRepetido(int elemento){
        ListaEncadeada lista = new ListaEncadeada();
        lista.setProximo(primeiroNo);
        for (int i = 0; i < tamanhoDaLista; i++) {
            lista = lista.getProximo();
            if(lista.getElemento() == elemento)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.tamanhoDaLista == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            ListaEncadeada lista = new ListaEncadeada();
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