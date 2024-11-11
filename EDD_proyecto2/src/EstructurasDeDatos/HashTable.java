/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author Michelle García
 */
public class HashTable {

    private int capacity;
    private List nodes;
    private List[] table;

    // Utiliza el método 
    public int hash(String name) {
        final int FNV_PRIME = 0x811C9DC5;
        final int OFFSET_BASIS = 0x1000193;

        int hash = OFFSET_BASIS;
        for (int i = 0; i < name.length(); i++) {
            hash ^= name.charAt(i);
            hash *= FNV_PRIME;
        }
        return hash;
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.nodes = nodes;
        this.table = new List[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = new List();
        }
    }

    // Eliminar dentro del hashtable
    public void delete(Nodo father) {

    }
}
