/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Castro, Michelle García
 * Esta clase contiene las funciones
 * responsables de cargar el archivo 
 * json para construir el arbol y su 
 * hashtable.
 */

public class LecturaJson {

    /**
     *Esta funcion se encarga de procesar los datos
     * del archivo Json para la creacion del arbol.
     * Ademas crea las adyacencias del mismo entre 
     * padres e hijos.
     * @return Retorna una variable de tipo arbol 
     * con la que se va a construir el arbol 
     * genealogico.
     * @throws java.io.IOException
     */
    public Arbol LecturaJson() throws IOException {
        HashTable hashtable = new HashTable(500);
        Nodo root = null;
        Arbol arbol = null;
        Lista listaPersonas = new Lista();

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
                                                if (key.equals("Father to") && value.isJsonArray()) {
                                                    JsonArray hijosArray = value.getAsJsonArray();
                                                    for (JsonElement hijo : hijosArray) {
                                                        children.add(hijo.getAsString());
                                                    }
                                                }
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
                                            }
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                                    continue;
                                }

                                Persona persona = new Persona(nombreMiembro, ofHisName, father, eyes, hair, children);

                                for (JsonElement caracteresElement : caracteristicasElement.getAsJsonArray()) {
                                    JsonObject caracteristica = caracteresElement.getAsJsonObject();

                                    for (String key : caracteristica.keySet()) {
                                        JsonElement value = caracteristica.get(key);
                                        String valor = value.isJsonArray() ? value.getAsJsonArray().toString() : value.getAsString();

                                        switch (key) {
                                            case "Known throughout as" ->
                                                persona.setKnownAs(valor);
                                            case "Held title" ->
                                                persona.setTitle(valor);
                                            case "Wed to" ->
                                                persona.setWedTo(valor);
                                            case "Notes" ->
                                                persona.setNotes(valor);
                                            case "Fate" ->
                                                persona.setFate(valor);
                                            case "Born to" -> {
                                                if (!father.equals(valor)) {
                                                    persona.setMother(valor);

                                                }
                                            }
                                        }
                                    }
                                }

                                listaPersonas.add(persona);
                                Nodo nuevoNodo = new Nodo(persona);
                                hashtable.addNode(nuevoNodo);
                                if (root == null) {
                                    root = nuevoNodo;
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            arbol = new Arbol(root, hashtable);
            for (int i = 0; i < hashtable.getNodes().count(); i++) {
                Nodo aux = (Nodo) hashtable.getNodes().get(i);
                if (aux.getChildren() != null) {
                    if (aux.getPerson().getChildren().count() > 0) {
                        for (int j = 0; j < hashtable.getNodes().count(); j++) {
                            Nodo aux2 = (Nodo) hashtable.getNodes().get(j);
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
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
        }

        arbol = conexionHijos(arbol, listaPersonas);
        return arbol;
    }
    
    /**
     *
     * Funcion encragada de conectar los hijos 
     * sin descripcion en el archivo Json con 
     * sus padres respectivos.
     * @param arbol con la informacion de 
     * las personas descritas en el archivo
     * @param listaPersonas contiene  todas
     * las personas descritas en el archivo
     * @return Retorna una variable de tipo arbol 
     * que contiene todos los miembros de la familia
     * ya conectados.
     */ 

    public Arbol conexionHijos(Arbol arbol, Lista listaPersonas) {

        if (arbol.getHashtable() != null) {
            for (int i = 0; i < arbol.getHashtable().getNodes().count(); i++) {
                Nodo aux = (Nodo) arbol.getHashtable().getNodes().get(i);
                Persona personaAux = aux.getPerson();
                if (personaAux.getChildren() != null) {
                    for (int x = 0; x < personaAux.getChildren().count(); x++) {
                        String hijoName = (String) personaAux.getChildren().get(x);
                        if (!personaExistByName(listaPersonas, hijoName) && hijoName != null) {
                            Persona persona = new Persona(hijoName, personaAux.getFullname());
                            Nodo nodo = new Nodo(persona);
                            arbol.getHashtable().addNode(nodo);
                            arbol.addChildren(aux.getPerson().getNickname(), persona.getNickname());
                        }
                    }
                }
            }
        }
        
        return arbol;
    }
      
    /* 
     * 
     *
     * Funcion encragada de determinar si una persona
     * ya pertenece a la lista de personas, la cual
     * contiene a todas las personas con descripcion presentes en el 
     * archivo.
     * @param Lista Contiene a todas las personas
     * con descripcion en el archivo
     * @param String Nombre de la persona que se 
     * desea buscar en la lista de personas
     * @return Boleano Retorna un booleano True or False
     * indicando si la persona existe en la lista o no.
    */ 
    public Boolean personaExistByName(Lista personas, String name) {
        for (int x = 0; x < personas.count(); x++) {
            var p = (Persona) personas.get(x);
            var n = p.getFullname().split(" ")[0];
            if (n.equals(name)) {
                return true;
            }
        }

        return false;
    }
}
