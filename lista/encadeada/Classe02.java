import java.lang.StringBuilder;

public class Classe02 {

    private ListaEncadeada primeiroNodo;
    private ListaEncadeada ultimoNodo;
    private int tamanhoDaLista;

    public void adicionarElemento(int elemento) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.setElemento(elemento);
        this.primeiroNodo = lista;
        if (this.tamanhoDaLista == 0) {
            this.ultimoNodo = this.primeiroNodo;
        } else {
            lista.setProximo(primeiroNodo);
            this.primeiroNodo = lista;
        }
        this.tamanhoDaLista++;
    }

    public void adicionarElementoNoFinal(int elemento) {
        if (this.tamanhoDaLista > 0) {
            ListaEncadeada lista = new ListaEncadeada();
            lista.setElemento(elemento);
            lista.setProximo(ultimoNodo);
            this.ultimoNodo = lista;
            this.tamanhoDaLista++;
        }
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
}