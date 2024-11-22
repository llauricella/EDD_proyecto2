/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 13/11/2024
 * @author Michelle García
 */

public class Arbol {

    private Nodo root;
    private HashTable hashtable;
    private Busqueda buscar;

    public Arbol(Nodo root, HashTable hashtable) {
        this.root = root;
        this.hashtable = hashtable;
        this.buscar = new Busqueda();
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

    /**
     * @return the buscar
     */
    public Busqueda getBuscar() {
        return buscar;
    }

    public boolean isEmpty() {
        boolean empty = false;
        if (getRoot().getChildren().count() < 1) {
            empty = true;
        }
        return empty;
    }

    public void addChildren(String fatherNickname, String childNickname) {
       
        String[] father = fatherNickname.split(", ");
        String[] child = fatherNickname.split(", ");      

        Nodo parent = getHashtable().getNode(father[0], father[1]);
        Nodo children = getHashtable().getNode(child[0], child[1]);
        parent.getChildren().add(children);
        /*
        if (fatherNickname == null || childNickname == null || fatherNickname.isEmpty() || childNickname.isEmpty()) {
            System.out.println("Error: Nicknames no pueden ser nulos o vacíos.");
            return;
        }

        // Dividir los apodos en nombre y mote
        String[] fatherParts = fatherNickname.split(", ");
        String[] childParts = childNickname.split(", ");
        if (fatherParts.length < 2 || childParts.length < 1) {
            System.out.println("Error: Formato de nickname inválido.");
            return;
        }

        String fatherName = fatherParts[0];
        String fatherMote = fatherParts.length > 1 ? fatherParts[1] : "";
        String childName = childParts[0];
        String childMote = childParts.length > 1 ? childParts[1] : "";

        // Buscar nodos en el hashtable
        Nodo parent = getHashtable().getNode(fatherName, fatherMote);
        Nodo children = getHashtable().getNode(childName, childMote);

        if (parent == null) {
            System.out.println("Error: Nodo padre no encontrado para " + fatherNickname);
            return;
        }
        if (children == null) {
            System.out.println("Error: Nodo hijo no encontrado para " + childNickname);
            return;
        }

        // Agregar el hijo al nodo padre
        if (parent.getChildren() == null) {
            parent.setChildren(new Lista()); // Inicializar lista de hijos si es nula
        }
        parent.getChildren().add(children);

        System.out.println("Relación padre-hijo añadida: " + fatherNickname + " -> " + childNickname);*/
    }

    public Lista descendientesPorGeneracion(int height) {
        descendientes(getRoot());
        Lista encontrados = new Lista();

        for (int i = 0; i < getHashtable().getNodes().count(); i++) {
            Nodo aux = (Nodo) getHashtable().getNodes().get(i);
            if (aux.getHeight() == (height - 1)) {
                encontrados.add(aux);
            }
        }
        return encontrados;
    }

    public Lista descendientes(Nodo root) {
        Lista encontrados = getBuscar().DFS(root, getHashtable().getCapacity());
        return encontrados;
    }

    public Lista ancestros(Nodo descendant) {
        descendientes(getRoot());
        int height = descendant.getHeight() - 1;
        Lista encontrados = getBuscar().DFS(getRoot(), height);
        return encontrados;
    }

    public Lista encontradosNombre(String search) {
        Lista found = new Lista();

        for (int i = 0; i < getHashtable().getNodes().count(); i++) {
            Nodo aux = (Nodo) getHashtable().getNodes().get(i);
            if (keyIsEqualName(search, aux)) {
                found.add(aux);
            }
        }
        return found;
    }

    public Lista encontradosTitulo(String search) {
        Lista found = new Lista();

        for (int i = 0; i < getHashtable().getNodes().count(); i++) {
            Nodo aux = (Nodo) getHashtable().getNodes().get(i);
            if (keyIsEqualTitle(search, aux)) {
                found.add(aux);
            }
        }
        return found;
    }

    public boolean keyIsEqualName(String search, Nodo value) {
        String key = search.toLowerCase();
        String name = value.getPerson().getFullname().toLowerCase();
        String mote = value.getPerson().getKnownAs().toLowerCase();
        return name.contains(key) || mote.contains(key);
    }

    public boolean keyIsEqualTitle(String search, Nodo value) {
        String key = search.toLowerCase();
        String title = value.getPerson().getTitle().toLowerCase();
        return title.contains(key);
    }

}
