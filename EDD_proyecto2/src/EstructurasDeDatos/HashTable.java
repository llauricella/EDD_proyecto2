/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author Michelle García
 */
public class HashTable {

    private int capacity;
    private Lista nodes;
    private Lista[] table;

    public int hash(String nickname) {
        int hash = 0;

        for (int i = 0; i < nickname.length(); i++) {
            hash += nickname.charAt(i);
        }

        hash = hash / 50;
        return hash;
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.nodes = new Lista();
        this.table = new Lista[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = new Lista();
        }
    }

    public Nodo getNode(String fullname, String mote) {
        String nickname = fullname +","+ mote;
        int code = hash(nickname);
        Nodo found = null;

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

        return found;
    }

    public void addNode(Nodo newNode) {
        String toHash = newNode.getPerson().getNickname();
        int code = hash(toHash);

        if (code < getCapacity()) {
            getTable()[code].add(newNode);
        } else {
            code = code / 2;
            getTable()[code].add(newNode);
        }
        
        getNodes().add(newNode);
    }

    /*
    public void recorrer(){
        // Recorre el hashtable correctamente
        for (int i = 0; i < getCapacity(); i++) {
            Lista found = (Lista) getTable()[i];

            if (found.count() == 1) {
                if (found.get(0) != null) {
                    Nodo act = (Nodo) found.get(0);
                    System.out.println(act.getPerson().leer() + "\n");
                }
            } else {
                for (int j = 0; j < found.count(); j++) {
                    if (found.get(j) != null) {
                        Nodo act = (Nodo) found.get(j);
                        System.out.println(act.getPerson().leer() + "\n");
                    }
                }
            }
        }
    }
    
    */
    public Lista getNodes() {
        return nodes;
    }
    
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
