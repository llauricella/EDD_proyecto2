/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author Michelle García
 */
public class Node {
    
    private Node[] children;
    private Node father;
    private Person person;

    public Node(Node[] children, Node father, Person person) {
        this.children = children;
        this.father = father;
        this.person = person;
    }
    
    
    
}
