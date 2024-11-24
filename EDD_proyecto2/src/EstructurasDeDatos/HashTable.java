/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 13/11/2024
 * @author Michelle García
 */
public class HashTable {

    private int capacity;
    private Lista nodes;
    private Lista[] table;

    /**
     * Constructor del hashtable
     *
     *
     * @param capacity
     */
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.nodes = new Lista();
        this.table = new Lista[capacity];
    }

    /**
     * Función para generar un hash
     *
     *
     * @param nickname
     * @return
     */
    public int hash(String nickname) {
        int hash = 0;

        for (int i = 0; i < nickname.length(); i++) {
            hash += nickname.charAt(i);
        }

        hash = hash / 7;

        return hash;
    }

    /**
     * Función para obtener un nodo
     *
     *
     * @param fullname
     * @param mote
     * @return
     */
    public Nodo getNode(String fullname, String mote) {
        String nickname = fullname + ", " + mote;
        int code = hash(nickname);
        Nodo found = null;

        if (code > getCapacity()) {
            code = code / 7;
        }

        if (getTable()[code] != null) {
            if (getTable()[code].getValue() != null) {
                found = (Nodo) getTable()[code].getValue().getValue();
            }
            if (getTable()[code].count() > 1) {
                Lista aux = getTable()[code];
                for (int i = 0; i < getTable()[code].count(); i++) {
                    Nodo act = (Nodo) aux.get(i);
                    if (act.getPerson().getNickname().equals(nickname)) {
                        found = act;
                        break;
                    }
                }
            }
        }

        return found;
    }

    /**
     * Función para agregar un nodo al hashtable
     *
     *
     * @param newNode
     * @param code
     */
    public void addNode(Nodo newNode) {
        String toHash = newNode.getPerson().getNickname();
        int code = hash(toHash);
        Lista aux = new Lista();

        if (code > getCapacity()) {
            code = code / 7;
        }

        if (getTable()[code] == null) {
            aux.add(newNode);
            getTable()[code] = aux;
        } else {
            getTable()[code].add(newNode);
        }

        getNodes().add(newNode);
    }

    /**
     * Función para agregar un nodo al hashtable
     *
     *
     * @return
     */
    public Lista getNodes() {
        return nodes;
    }

    /**
     * Función para agregar un nodo al hashtable
     *
     *
     * @param nodes
     */
    public void setNodes(Lista nodes) {
        this.nodes = nodes;
    }

    /**
     * @return the table
     */
    public Lista[] getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(Lista[] table) {
        this.table = table;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
