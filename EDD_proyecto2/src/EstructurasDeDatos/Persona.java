/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 * @version 13/11/2024
 * @author Michelle García
 */
public class Persona {

    private String fullname;
    private String knownAs;
    private String ofHisName;
    private String father;
    private String mother;
    private String title;
    private String wedTo;
    private String eyes;
    private String hair;
    private String notes;
    private String fate;
    private String nickname;
    private Lista children;

    /**
     *
     * @param fullname
     * @param ofHisName
     * @param father
     * @param hair
     * @param eyes
     * @param children
     */

    //LecturaJson sola
    public Persona(String fullname) {
        this.fullname = fullname;
        this.ofHisName = "";
        this.father = "";
        this.eyes = "";
        this.hair = "";
        this.knownAs = "";
        this.mother = "";
        this.title = "";
        this.wedTo = "";
        this.notes = "";
        this.fate = "";
        this.children = null;
        this.nickname = fullname + ", " + ofHisName;
    }


    public Persona(String fullname, String father) {
        this.fullname = fullname;
        this.ofHisName = " ";
        this.father = father;
        this.eyes = "";
        this.hair = "";
        this.knownAs = "";
        this.mother = "";
        this.title = "";
        this.wedTo = "";
        this.notes = "";
        this.fate = "";
        this.children = null;
        this.nickname = fullname + ", " + ofHisName;
    }

    public Persona(String fullname, String ofHisName, String father, String eyes, String hair, Lista children) {
        this.fullname = fullname;
        this.ofHisName = ofHisName;
        this.father = father;
        this.eyes = eyes;
        this.hair = hair;
        this.knownAs = "";
        this.mother = "";
        this.title = "";
        this.wedTo = "";
        this.notes = "";
        this.fate = "";
        this.children = children;
        this.nickname = fullname + ", " + ofHisName;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the knownAs
     */
    public String getKnownAs() {
        return knownAs;
    }

    /**
     * @param knownAs the knownAs to set
     */
    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    /**
     * @return the ofHisName
     */
    public String getOfHisName() {
        return ofHisName;
    }

    /**
     * @param ofHisName the ofHisName to set
     */
    public void setOfHisName(String ofHisName) {
        this.ofHisName = ofHisName;
    }

    /**
     * @return the father
     */
    public String getFather() {
        return father;
    }

    /**
     * @param father the father to set
     */
    public void setFather(String father) {
        this.father = father;
    }

    /**
     * @return the mother
     */
    public String getMother() {
        return mother;
    }

    /**
     * @param mother the mother to set
     */
    public void setMother(String mother) {
        this.mother = mother;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the wedTo
     */
    public String getWedTo() {
        return wedTo;
    }

    /**
     * @param wedTo the wedTo to set
     */
    public void setWedTo(String wedTo) {
        this.wedTo = wedTo;
    }

    /**
     * @return the eyes
     */
    public String getEyes() {
        return eyes;
    }

    /**
     * @param eyes the eyes to set
     */
    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    /**
     * @return the hair
     */
    public String getHair() {
        return hair;
    }

    /**
     * @param hair the hair to set
     */
    public void setHair(String hair) {
        this.hair = hair;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the fate
     */
    public String getFate() {
        return fate;
    }

    /**
     * @param fate the fate to set
     */
    public void setFate(String fate) {
        this.fate = fate;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // String fullname, String ofHisName, String father, String eyes, String hair
    public String leer() {

        String txt = "";

        txt += "Nombre completo: " + getFullname() + " " + getOfHisName()
                + "\nPadre: " + getFather()
                + "\nOjos: " + getEyes()
                + "\nCabello: " + getHair()
                + "\nNickname: " + getNickname();

        if (!"".equals(getKnownAs())) {
            txt += "\nConocido como: " + getKnownAs();
        }
        if (!"".equals(getMother())) {
            txt += "\nMadre: " + getMother();
        }
        if (!"".equals(getTitle())) {
            txt += "\nTitulo: " + getTitle();
        }
        if (!"".equals(getWedTo())) {
            txt += "\nConyuge: " + getWedTo();
        }
        if (!"".equals(getNotes())) {
            txt += "\nNotas: " + getNotes();
        }
        if (!"".equals(getFate())) {
            txt += "\nDestino: " + getFate();
        }

        return txt;

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

}
