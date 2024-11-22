package EstructurasDeDatos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Santiago Castro
 */
import com.google.gson.*;
import java.io.*;
import javax.swing.*;

public class LecturaJson {

    /**
     *
     * @return @throws java.io.IOException
     * @throws java.io.IOException
     */
    public Arbol LecturaJson() throws IOException {
        HashTable hashtable = new HashTable(500);
        Lista listaPersonas = new Lista();
        Nodo root = null;
        Arbol arbol = null;
        var chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        var file = chooser.getSelectedFile();

        try {
            if (file != null) {
                FileReader lector = new FileReader(file);
                JsonParser parser = new JsonParser();
                JsonElement raiz = parser.parse(lector);

                if (raiz.isJsonObject()) {
                    JsonObject redObject = raiz.getAsJsonObject();
                    var redEntrySet = redObject.entrySet();

                    if (redEntrySet.size() != 1) {
                        JOptionPane.showMessageDialog(null, "ERROR, No es un dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    var redEntry = redEntrySet.iterator().next();
                    JsonElement miembrosElementos = redEntry.getValue();

                    if (miembrosElementos.isJsonArray()) {
                        JsonArray miembros = miembrosElementos.getAsJsonArray();

                        for (JsonElement miembrosElemento : miembros) {
                            if (miembrosElemento.isJsonObject()) {
                                var miembrosObjeto = miembrosElemento.getAsJsonObject();
                                var miembrosEntrySet = miembrosObjeto.entrySet();

                                if (miembrosEntrySet.size() != 1) {
                                    JOptionPane.showMessageDialog(null, "ERROR, No es un dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                                var miembroEntry = miembrosEntrySet.iterator().next();
                                String nombreMiembro = miembroEntry.getKey();
                                JsonElement caracteristicasElement = miembroEntry.getValue();
                                Lista children = new Lista();

                                String ofHisName = "";
                                String father = "";
                                String eyes = "";
                                String hair = "";

                                if (caracteristicasElement.isJsonArray()) {
                                    JsonArray caracteristicas = caracteristicasElement.getAsJsonArray();

                                    for (JsonElement caracteresElement : caracteristicas) {
                                        if (caracteresElement.isJsonObject()) {
                                            JsonObject caracteristica = caracteresElement.getAsJsonObject();

                                            for (String key : caracteristica.keySet()) {
                                                JsonElement value = caracteristica.get(key);
                                                String valor = value.isJsonArray() ? value.getAsJsonArray().toString() : value.getAsString();
                                                switch (key) {
                                                    case "Of his name" ->
                                                        ofHisName = valor;
                                                    case "Born to" -> {
                                                        if (father.isEmpty()) {
                                                            father = valor;
                                                        }
                                                    }
                                                    case "Of eyes" ->
                                                        eyes = valor;
                                                    case "Of hair" ->
                                                        hair = valor;
                                                }
                                                
                                                if (key.equals("Father to") && value.isJsonArray()) {
                                                    JsonArray hijosArray = value.getAsJsonArray();
                                                    for (JsonElement hijo : hijosArray) {
                                                        children.add(hijo.getAsString());
                                                        Persona persona = new Persona(hijo.getAsString(), nombreMiembro);
                                                        listaPersonas.add(persona);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    Persona persona;
                                    if ("[Unknown]".equals(father)) {
                                        persona = new Persona(nombreMiembro, ofHisName, "[Unknown]", eyes, hair, children);
                                        listaPersonas.add(persona);
                                    } else {
                                        persona = new Persona(nombreMiembro, ofHisName, father, eyes, hair, children);
                                    }
                                    for (int i = 0; i < listaPersonas.count(); i++) {
                                        Persona aux = (Persona) listaPersonas.get(i);
                                        String[] persona1 = nombreMiembro.split(" ");
                                        String personaName = persona1[0];
                                        if (aux.getFullname().equals(personaName)) {
                                            aux.setFullname(persona.getFullname());
                                            aux.setOfHisName(persona.getOfHisName());
                                            aux.setFather(persona.getFather());
                                            aux.setEyes(persona.getEyes());
                                            aux.setHair(persona.getHair());
                                            aux.setChildren(persona.getChildren());
                                            aux.setNickname(aux.getFullname() + ", " + aux.getOfHisName());
                                            for (JsonElement caracteresElement : caracteristicasElement.getAsJsonArray()) {
                                                JsonObject caracteristica = caracteresElement.getAsJsonObject();

                                                for (String key : caracteristica.keySet()) {
                                                    JsonElement value = caracteristica.get(key);
                                                    String valor = value.isJsonArray() ? value.getAsJsonArray().toString() : value.getAsString();

                                                    switch (key) {
                                                        case "Known throughout as" ->
                                                            aux.setKnownAs(valor);
                                                        case "Held title" ->
                                                            aux.setTitle(valor);
                                                        case "Wed to" ->
                                                            aux.setWedTo(valor);
                                                        case "Notes" ->
                                                            aux.setNotes(valor);
                                                        case "Fate" ->
                                                            aux.setFate(valor);
                                                        case "Born to" -> {
                                                            if (!father.equals(valor)) {
                                                                aux.setMother(valor);

                                                            }
                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "Error, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);

                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Error, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                }

                for (int i = 0; i < listaPersonas.count(); i++) {
                    Persona aux = (Persona) listaPersonas.get(i);
                    Nodo nuevoNodo = new Nodo(aux);
                    hashtable.addNode(nuevoNodo);
                    if (root == null) {
                        if ("[Unknown]".equals(nuevoNodo.getPerson().getFather())) {
                            root = nuevoNodo;
                        }
                    }
                }

                arbol = new Arbol(root, hashtable);

                for (int i = 0; i < hashtable.getNodes().count(); i++) {
                    Nodo aux = (Nodo) hashtable.getNodes().get(i);
                    // Axel -> no tiene hijos. es hijo de Orys.
                    // Serac -> Reginald, William, Steffon, Paradraic, Flynn. es hijo de Orys.
                    for (int j = 0; j < hashtable.getNodes().count(); j++) {
                        Nodo aux2 = (Nodo) hashtable.getNodes().get(j);
                        if (aux.getPerson().getChildren().count() > 1) {
                            if (aux.getPerson().getFullname().equals(aux2.getPerson().getFather())) {
                                arbol.addChildren(aux.getPerson().getNickname(), aux2.getPerson().getNickname());
                            } else if (aux.getPerson().getKnownAs().equals(aux2.getPerson().getFather())) {
                                arbol.addChildren(aux.getPerson().getNickname(), aux2.getPerson().getNickname());
                            } else {
                                String nickname = aux.getPerson().getFullname() + ", " + aux.getPerson().getOfHisName() + " of his name";
                                if (nickname.equals(aux2.getPerson().getFather())) {
                                    arbol.addChildren(aux.getPerson().getNickname(), aux2.getPerson().getNickname());
                                }
                            }
                        } else {
                            System.out.println("La persona no tiene hijos");
                        }
                        //System.out.println(aux.getChildren().printList());
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        /*System.out.println(listaPersonas.printPersona());*/
        return arbol;
    }
}
