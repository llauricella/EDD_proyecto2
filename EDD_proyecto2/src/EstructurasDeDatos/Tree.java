/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;
 
/**
 *
 * @author Michelle García
 */
public class Tree {

    private Nodo root;
    private HashTable hashtable;

    public Tree(Nodo root, HashTable hashtable) {
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
    
    
    public boolean isBrother(Nodo node) {
        boolean exists = false;
        if (node.getBrother() != null) {
            exists = true;
        }
        return exists;
    }
    
    public boolean isLeaf(Nodo node) {
        boolean leaf = false;
        if (node.getLeftSon() == null) {
            leaf = true;
        }
        return leaf;
    }
    
    public boolean isEmpty(){
        boolean empty = false;
        if (getRoot().getLeftSon() == null){
            empty = true;
        }
        return empty;
    }
    
    public void insert(Nodo sibling, Nodo father){
        Nodo child = father.getLeftSon();
        while (child.getBrother() != null){
            child = child.getBrother();
        }
        child.setBrother(sibling);
    }

    // Eliminar dentro del hashtable
    public void delete(int code){
        
    }
    
    public void findNode (int code){
    
    
    }
    
    
    
}
