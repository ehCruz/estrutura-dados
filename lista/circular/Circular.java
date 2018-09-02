package circular;

public class Circular {

    private ListaCircular primeiroNo;
    private ListaCircular ultimoNo;
    private int tamanhoLista = 0;

    public void adicionarElemento(int elemento) {
        ListaCircular listaCircular = new ListaCircular();
        listaCircular.setElemento(elemento);
        if (this.tamanhoLista == 0) {
            listaCircular.setObjAnterior(null);
            listaCircular.setObjProximo(null);
            this.primeiroNo = listaCircular;
            this.ultimoNo = this.primeiroNo;
        } else {
            listaCircular.setObjAnterior(this.ultimoNo);
            this.ultimoNo.setObjProximo(listaCircular);
            this.ultimoNo = listaCircular;
            this.primeiroNo.setObjAnterior(listaCircular);
            this.ultimoNo.setObjProximo(this.primeiroNo);
        }
        this.tamanhoLista++;
    }

    @Override
    public String toString() {
        if (this.tamanhoLista == 0) {
            return "[]";
        } else {
            ListaCircular listaCircular = this.new ListaCircular();
            StringBuilder sb = new StringBuilder();
            listaCircular.setObjProximo(this.primeiroNo);
            for (int i = 0; i < this.tamanhoLista; i++) {
                listaCircular = listaCircular.getObjProximo();
                if (listaCircular.objAnterior != null) {
                    sb.append(listaCircular.objAnterior.getElemento());
                } else {
                    sb.append(" ");
                }
                sb.append(" - ");
                sb.append(listaCircular.getElemento());
                sb.append(" - ");
                if (listaCircular.objProximo != null) {
                    sb.append(listaCircular.objProximo.getElemento());
                } else {
                    sb.append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    private class ListaCircular {

        private int elemento;
        private ListaCircular objProximo;
        private ListaCircular objAnterior;

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
         * @param objProximo the objProximo to set
         */
        public void setObjProximo(ListaCircular objProximo) {
            this.objProximo = objProximo;
        }

        /**
         * @return the objProximo
         */
        public ListaCircular getObjProximo() {
            return objProximo;
        }

        /**
         * @param objAnterior the objAnterior to set
         */
        public void setObjAnterior(ListaCircular objAnterior) {
            this.objAnterior = objAnterior;
        }

        /**
         * @return the objAnterior
         */
        public ListaCircular getObjAnterior() {
            return objAnterior;
        }
    }
}