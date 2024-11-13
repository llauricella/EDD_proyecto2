/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author Michelle García
 */
public class Nodo {
    
    private Lista children;
    private Persona person;
    private int height;
    private Nodo mother;
   

    public Nodo(Persona person, Lista children, Nodo mother) {
        this.person = person;
        this.children = children;
        this.mother = mother;
    }

    public Nodo(Persona person) {
        this.person = person;
        this.children = new Lista();
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
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Lista children) {
        this.children = children;
    }

    /**
     * @return the mother
     */
    public Nodo getMother() {
        return mother;
    }

    /**
     * @param mother the mother to set
     */
    public void setMother(Nodo mother) {
        this.mother = mother;
    }

    
    
    
}
