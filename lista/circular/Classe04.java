public class Classe04 {

    

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