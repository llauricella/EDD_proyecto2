/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author Michelle García
 */
public class Arbol {

    private Nodo root;
    private HashTable hashtable;

    public Arbol(Nodo root, HashTable hashtable) {
        this.root = root;
        this.hashtable = hashtable;
    }

    /**
     * @return the root
     */
    public Nodo getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Nodo root) {
        this.root = root;
    }

    /**
     * @return the hashtable
     */
    public HashTable getHashtable() {
        return hashtable;
    }

    /**
     * @param hashtable the hashtable to set
     */
    public void setHashtable(HashTable hashtable) {
        this.hashtable = hashtable;
    }

    public boolean isEmpty() {
        boolean empty = false;
        if (getRoot().getChildren().count() < 1) {
            empty = true;
        }
        return empty;
    }

    // 
    public void addChildren(String fatherNickname, String childNickname) {
        String[] father = fatherNickname.split(",");
        String[] child = childNickname.split(",");
        String fatherName = father[0];
        String fatherMote = father[1];
        String childName = child[0];
        String childMote = child[1];
        
        Nodo parent = getHashtable().getNode(fatherName, fatherMote);
        Nodo children = getHashtable().getNode(childName, childMote);
        parent.getChildren().add(children);
    }

    // Eliminar dentro del hashtable
    public void delete(int code) {

    }

    public Lista descendientesPorGeneracion(int height) {
        Busqueda buscar = new Busqueda();
        Lista encontrados = buscar.DFS(getRoot(), height);
        return encontrados;
    }
    
    public Lista descendientes(Nodo root) {
        Busqueda buscar = new Busqueda();
        Lista encontrados = buscar.DFS(root, getHashtable().getCapacity());
        return encontrados;
    }
    
    public Lista ancestros (Nodo descendant) {
        int height = descendant.getHeight()-1;
        Busqueda buscar = new Busqueda();
        Lista encontrados = buscar.DFS(getRoot(), height);
        return encontrados;
    }

    public Lista encontrados(String search) {

        Lista found = new Lista();
        Lista get;

        for (int i = 0; i < getHashtable().getCapacity(); i++) {
            if (getHashtable().getTable()[i].count() == 1) {
                Nodo aux = (Nodo) getHashtable().getTable()[i].get(0);
                if (keyIsEqual(search, aux)) {
                    found.add(aux);
                }
            } else if (getHashtable().getTable()[i].count() > 1) {
                get = getHashtable().getTable()[i];
                for (int j = 0; j < get.count(); j++) {
                    Nodo aux = (Nodo) get.get(j);
                    if (keyIsEqual(search, aux)) {
                        found.add(aux);
                    }
                }
            }
        }

        return found;
    }

    public boolean keyIsEqual(String key, Nodo value) {
        String name = value.getPerson().getFullname();
        String mote = value.getPerson().getKnownAs();
        return name.contains(key) || mote.contains(key);
    }

}
