/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * Esta es la clase encargada de describir a los objetos de tipo árbol
 *
 * @version 13/11/2024
 * @author Michelle García
 */
public class Arbol {
    
    private Nodo root;
    private HashTable hashtable;
    private Busqueda buscar;

    /**
     * Constructor de la clase Arbol.
     *
     * @param root Nodo padre.
     * @param hashtable Hashtable donde se almacenan todos los nodos.
     */
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

    /**
     * Procedimiento para añadir un hijo dentro del árbol.
     *
     * @param fatherNickname Apodo identificador del padre.
     * @param childNickname Apodo identificador del hijo.
     */
    public void addChildren(String fatherNickname, String childNickname) {

        String[] father = fatherNickname.split(", ");
        String[] child = childNickname.split(", ");

        Nodo parent = getHashtable().getNode(father[0], father[1]);
        Nodo children = getHashtable().getNode(child[0], child[1]);
        parent.getChildren().add(children);

    }

    /**
     * Función para obtener una generación del árbol.
     *
     * @param height Número de la generación a encontrar.
     * @return Lista con los nodos que pertenecen a la generación buscada.
     */
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

    /**
     * Función para obtener a todos los descendientes desde un padre.
     *
     * @param root Nodo padre.
     * @return Lista con los nodos que descienden del nodo padre.
     */
    public Lista descendientes(Nodo root) {
        Lista encontrados = getBuscar().DFS(root, getHashtable().getCapacity());
        return encontrados;
    }

    /**
     * Función para obtener a los ancestros de un descendiente del árbol.
     * 
     * @param descendant Nodo que es descendiente.
     * @return Lista con los nodos que anteceden al descendiente buscado.
     */
    public Lista ancestros(Nodo descendant) {
        descendientes(getRoot());
        int height = descendant.getHeight() - 1;
        Lista encontrados = getBuscar().DFS(getRoot(), height);
        return encontrados;
    }

    
    /**
     * Función para encontrar nodos por un nombre o mote.
     * 
     * @param search Nombre a buscar.
     * @return Lista con los nodos que coinciden con la búsqueda.
     */
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

    /**
     * Función para encontrar nodos por un titulo.
     * 
     * @param search Titulo a buscar.
     * @return Lista con los nodos que coinciden con la búsqueda.
     */
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
    
    /**
     * Función para verificar si un nombre o mote coincide con el nombre o mote guardado dentro de un nodo.
     * 
     * @param search Nombre a buscar
     * @param value Nodo a revisar.
     * @return Lista con los nodos que pertenecen a la generación buscada.
     */
    public boolean keyIsEqualName(String search, Nodo value) {
        String key = search.toLowerCase();
        String name = value.getPerson().getFullname().toLowerCase();
        String mote = value.getPerson().getKnownAs().toLowerCase();
        return name.contains(key) || mote.contains(key);
    }

    
    /**
     * Función para verificar si un titulo coincide con el titulo guardada dentro de un nodo.
     * 
     * @param search Titulo a buscar
     * @param value Nodo a revisar.
     * @return Lista con los nodos que pertenecen a la generación buscada.
     */
    public boolean keyIsEqualTitle(String search, Nodo value) {
        String key = search.toLowerCase();
        String title = value.getPerson().getTitle().toLowerCase();
        return title.contains(key);
    }

}
