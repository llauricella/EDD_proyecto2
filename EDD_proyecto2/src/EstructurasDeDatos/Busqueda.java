/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * En esta clase se almacenan todos lo métodos de busca a ejecutar.
 *
 * @version 13/11/2024
 * @author Michelle García
 */
public class Busqueda {

    /**
     * Función de búsqueda por profundidad utilizando un límite determinado.
     *
     * @param root Nodo donde se iniciará la búsqueda
     * @param heightLimit Altura máxima que podrá alcanzar la búsqueda.
     * @return Una lista que contenga a todos los nodos que se lograron visitar
     * dentro del rango de búsqueda.
     */
    public Lista DFS(Nodo root, int heightLimit) {
        return getAllNodesByHeight(visitAllNodesDFS(root), heightLimit);
    }

    /**
     * Función que visita todos los nodos dentro del grafo utilizando la
     * búsqueda por profundidad.
     *
     * @param root Nodo donde se iniciará el recorrido.
     * @return Una lista con todos los nodos visitados.
     */
    public Lista visitAllNodesDFS(Nodo root) {
        Lista visitedNodes = new Lista();
        Lista visited = new Lista();
        Pila stack = new Pila();

        stack.push(root);
        root.setHeight(0);

        while (stack.getCount() > 0) {
            Nodo currentNode = (Nodo) stack.pop();

            if (currentNode == null) {
                break;
            }

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                visitedNodes.add(currentNode);

                if (currentNode.getChildren() != null) {
                    for (int i = 0; i < currentNode.getChildren().count(); i++) {
                        Nodo child = (Nodo) currentNode.getChildren().get(i);
                        if (child != null && !visited.contains(child)) {
                            stack.push(child);
                            child.setHeight(currentNode.getHeight() + 1);
                        }
                    }
                }
            }
        }
        return visitedNodes;
    }

    /**
     * Función que filtra los nodos con base a una altura determinada.
     *
     * @param arbol Lista de nodos a filtrar.
     * @param heightLimit Límite de búsqueda.
     * @return Una lista de todos los nodos que se encuentren dentro del límite
     * específicado.
     */
    private Lista getAllNodesByHeight(Lista arbol, int heightLimit) {
        Lista result = new Lista();
        for (int n = 0; n < arbol.count(); n++) {
            Nodo nodo = (Nodo) arbol.get(n);
            if (nodo != null) {
                if (!result.contains(nodo)) {
                    if (nodo.getHeight() <= heightLimit) {
                        result.add(nodo);
                    }
                }
            }
        }
        return result;
    }
}
