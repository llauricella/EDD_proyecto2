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
    
    private Node leftSon;
    private Node brother;
    private Node father;
    private Person person;
    private int code;
   

    public Node(Node leftSon, Node brother, Node father, Person person) {
        this.leftSon = leftSon;
        this.brother = brother;
        this.father = father;
        this.person = person;
    }

    /**
     * @return the leftSon
     */
    public Node getLeftSon() {
        return leftSon;
    }

    /**
     * @param leftSon the leftSon to set
     */
    public void setLeftSon(Node leftSon) {
        this.leftSon = leftSon;
    }

    /**
     * @return the brother
     */
    public Node getBrother() {
        return brother;
    }

    /**
     * @param brother the brother to set
     */
    public void setBrother(Node brother) {
        this.brother = brother;
    }

    /**
     * @return the father
     */
    public Node getFather() {
        return father;
    }

    /**
     * @param father the father to set
     */
    public void setFather(Node father) {
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
