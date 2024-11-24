/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * Esta es la clase nodo, encargada de almacenar a las personas y sus descendientes.
 * 
 * @version 24/11/2024
 * @author Michelle García
 */
public class Nodo {

    private Lista decendientes;
    private Persona person;
    private int height;

    /***
     * Constructor de la clase Nodo para personas con hijos.
     * 
     * @param person Objeto de tipo persona
     * @param children Lista de nodos hijos de la persona
     */ 
    public Nodo(Persona person, Lista children) {
        this.person = person;
        this.decendientes = children;
    }
    
    /***
     * Constructor de la clase Nodo para personas sin hijos
     * 
     * @param person Objeto de tipo persona
     */
    public Nodo(Persona person) {
        this.person = person;
        this.decendientes = new Lista();
    }

    /**
     * @return the person
     */
    public Persona getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Persona person) {
        this.person = person;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the children
     */
    public Lista getChildren() {
        return decendientes;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Lista children) {
        this.decendientes = children;
    }

}
