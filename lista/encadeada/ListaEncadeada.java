public class ListaEncadeada {

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