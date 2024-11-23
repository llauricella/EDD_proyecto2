/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * Esta clase define un objeto de tipo lista. Contiene un contador de su
 * cantidad de elementos, una lista donde se almacenan los objetos siguienres y
 * un elemento de tipo ElementoLista.
 *
 * @version 13/11/2024
 * @author Michelle García
 */
public class Lista {

    private int count = 0;
    private Lista next;
    private ElementoLista value;

    /**
     * Procedimiento para agregar un objeto en la lista
     *
     * @param j Elemento a agregar a la lista.
     */
    public void add(Object j) {
        if (j != null) {
            ElementoLista newValue = new ElementoLista();
            newValue.setValue(j);
            newValue.setIndex(count);

            if (this.getValue() == null) {
                this.value = newValue;
            } else {
                Lista actual = this;
                while (actual.next != null) {
                    actual = actual.next;
                }
                actual.next = new Lista();
                actual.next.value = newValue;
            }
            count++;
        }

    }

    /**
     * Función para obtener un elemento según su índice dentro de la lista
     *
     * @param index Índice del elemento a retornar
     * @return Elemento encontrado según su índice
     */
    public Object get(int index) {
        if (index == 0) {
            if (this.value != null) {
                return this.value.getValue();
            } else {
                return null;
            }
        } else {
            index--;
            return this.next.get(index);
        }
    }

    /**
     * Procedimiento para eliminar un elemento de la lista según su índice
     *
     * @param index Indice del elemento a eliminar
     */
    public void remove(int index) {
        if (index >= 0 && index < count) {
            if (index == 0) {

                if (this.next == null) {
                    this.value = null;
                } else {
                    this.value = this.next.getValue();
                    this.next = this.next.next;
                }
            } else {
                Lista actual = this;
                for (int i = 0; i < index - 1; i++) {
                    actual = actual.next;
                }

                actual.next = actual.next.next;
            }

            Lista temp = this;
            int indiceActual = 0;
            while (temp != null) {
                if (temp.getValue() != null) {
                    temp.getValue().setIndex(indiceActual);
                    indiceActual++;
                }
                temp = temp.next;
            }

            count--;
        }
    }

    /**
     * Función para contar los elementos dentro de la lista
     *
     * @return Cantidad de elementos de la lista
     */
    public int count() {
        if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.count();
        }
    }

    /**
     * Procedimiento para agregar los elementos de una lista externa a la lista
     * actual
     *
     * @param h Lista externa
     */
    public void addRange(Lista h) {

        if (h.count > 0) {
            Lista actual = h;
            while (actual.next != null && actual.getValue() != null) {

                if (!this.contains(actual.value.getValue())) {
                    this.add(actual.getValue().getValue());
                }
                actual = actual.next;
            }
        }
    }

    /**
     * Función para verificar si un objeto se encuentra dentro de la lista.
     *
     * @param value Objeto a encontrar
     * @return Si el objeto se encuentra adentro, true. En caso contrario,
     * false.
     */
    public boolean contains(Object value) {

        if (this.getValue() != null && this.getValue().getValue().equals(value)) {
            return true;
        } else if (this.next != null) {
            return this.next.contains(value);
        } else {
            return false;
        }
    }

    /**
     * Función para obtener el índice de un elemento dentro de la lista.
     *
     * @param value Objeto a encontrar.
     * @return Posición correspondiente al elemento en la lista.
     */
    public int indexOf(Object value) {
        String aux = ((Nodo) this.getValue().getValue()).getPerson().getKnownAs();

        if (this.getValue() != null && aux.equals(((Nodo) value).getPerson().getKnownAs())) {
            return this.getValue().getIndex();
        } else {
            if (this.next != null) {
                return this.next.indexOf(value);
            } else {
                return -1;
            }
        }
    }

    /**
     * Procedimiento para contener el nombre de los elementos una lista de
     * nodos.
     *
     * @return String con la información indicada.
     */
    public String printList() {
        String txt = "";

        for (int i = 0; i < count(); i++) {

            var Next = (Nodo) get(i);
            if (Next != null) {
                //txt = txt + Next.getPerson().leer()+ "\n";
                txt = txt + Next.getPerson().getNickname() + "\n";
            }
        }
        return txt;
    }
    
    public String printChild() {
        String txt = "";

        for (int i = 0; i < count(); i++) {

            var Next = (String) get(i);
            if (Next != null) {
                //txt = txt + Next.getPerson().leer()+ "\n";
                txt = txt + Next + "\n";
            }
        }
        return txt;
    }

    /**
     * Devuelve el valor del elemento de la lista
     * @return the value
     */
    public ElementoLista getValue() {
        return value;
    }

}
