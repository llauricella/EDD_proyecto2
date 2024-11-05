/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author Michelle García
 */
public class Person {
    
    private String fullname;
    private String knownAs;
    private String ofHisName;
    private String birthplace;
    private String father;
    private String mother;
    private String title;
    private String wedTo;
    private String eyes;
    private String hair;
    private String notes;
    private String fate;

    
    public Person(String fullname, String ofHisName, String father, String eyes, String hair) {
        this.fullname = fullname;
        this.ofHisName = ofHisName;
        this.father = father;
        this.eyes = eyes;
        this.hair = hair;
        this.knownAs = "";
        this.birthplace = "";
        this.mother = "";
        this.title = "";
        this.wedTo = "";
        this.notes = "";
        this.fate = "";
    }
    
    
    
    
}
