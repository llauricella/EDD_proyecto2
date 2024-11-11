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
    
    private Nodo leftSon;
    private Nodo brother;
    private Nodo father;
    private Person person;
    private int code;
   

    public Nodo(Nodo leftSon, Nodo brother, Nodo father, Person person) {
        this.leftSon = leftSon;
        this.brother = brother;
        this.father = father;
        this.person = person;
    }

    /**
     * @return the leftSon
     */
    public Nodo getLeftSon() {
        return leftSon;
    }

    /**
     * @param leftSon the leftSon to set
     */
    public void setLeftSon(Nodo leftSon) {
        this.leftSon = leftSon;
    }

    /**
     * @return the brother
     */
    public Nodo getBrother() {
        return brother;
    }

    /**
     * @param brother the brother to set
     */
    public void setBrother(Nodo brother) {
        this.brother = brother;
    }

    /**
     * @return the father
     */
    public Nodo getFather() {
        return father;
    }

    /**
     * @param father the father to set
     */
    public void setFather(Nodo father) {
        this.father = father;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
    
    
    
}
