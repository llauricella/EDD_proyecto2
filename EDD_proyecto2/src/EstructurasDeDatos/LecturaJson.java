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

    public class IndexAux {

        String Name;
    }

    private HashTable hashtable = new HashTable(500);
    private Lista listaPersonas = new Lista();
    private Nodo root = null;
    private Arbol arbol = null;

    public void LecturaPadres(File file) {

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

                                if (caracteristicasElement.isJsonArray()) {
                                    JsonArray caracteristicas = caracteristicasElement.getAsJsonArray();

                                    Persona padre = new Persona(nombreMiembro);
                                    Lista hijos = new Lista();

                                    for (JsonElement caracteresElement : caracteristicas) {
                                        if (caracteresElement.isJsonObject()) {
                                            JsonObject caracteristica = caracteresElement.getAsJsonObject();

                                            for (String key : caracteristica.keySet()) {
                                                JsonElement value = caracteristica.get(key);
                                                String valor = value.isJsonArray() ? value.getAsJsonArray().toString() : value.getAsString();
                                                switch (key) {
                                                    case "Of his name" ->
                                                        padre.setOfHisName(valor);
                                                    case "Born to" -> {
                                                        if ("".equals(padre.getFather())) {
                                                            padre.setFather(valor);
                                                        } else {
                                                            padre.setMother(valor);
                                                        }
                                                    }
                                                    case "Of eyes" ->
                                                        padre.setEyes(valor);
                                                    case "Of hair" ->
                                                        padre.setHair(valor);
                                                    case "Known throughout as" ->
                                                        padre.setKnownAs(valor);
                                                    case "Held title" ->
                                                        padre.setTitle(valor);
                                                    case "Wed to" ->
                                                        padre.setWedTo(valor);
                                                    case "Notes" ->
                                                        padre.setNotes(valor);
                                                    case "Fate" ->
                                                        padre.setFate(valor);
                                                }
                                                if (key.equals("Father to") && value.isJsonArray()) {
                                                    JsonArray hijosArray = value.getAsJsonArray();
                                                    for (JsonElement hijo : hijosArray) {
                                                        hijos.add(hijo.getAsString());
                                                    }
                                                }

                                                String nickname = padre.getFullname() + ", " + padre.getOfHisName();
                                                padre.setNickname(nickname);
                                            }

                                        }
                                    }
                                    listaPersonas.add(padre);
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

                System.out.println("Padres");
                System.out.println(listaPersonas.count());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Lista LecturaHijos(File file) {
        Lista Result = new Lista();
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
                                String ofHisName = "";

                                if (caracteristicasElement.isJsonArray()) {
                                    JsonArray caracteristicas = caracteristicasElement.getAsJsonArray();

                                    for (JsonElement caracteresElement : caracteristicas) {
                                        if (caracteresElement.isJsonObject()) {
                                            JsonObject caracteristica = caracteresElement.getAsJsonObject();

                                            for (String key : caracteristica.keySet()) {
                                                JsonElement value = caracteristica.get(key);
                                                String valor = value.isJsonArray() ? value.getAsJsonArray().toString() : value.getAsString();

                                                if (key.equals("Of his name")) {
                                                    ofHisName = valor;
                                                }

                                                if (key.equals("Father to") && value.isJsonArray()) {
                                                    JsonArray hijosArray = value.getAsJsonArray();
                                                    for (JsonElement hijo : hijosArray) {
                                                        if (!Result.contains(hijo.getAsString())) {
                                                            String nickname = nombreMiembro + ", " + ofHisName;
                                                            Persona P = new Persona(hijo.getAsString(), nickname);
                                                            Result.add(P);
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

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Result;
    }

    public void RevisarHijosPadres(Lista hijos) {

        for (int i = 0; i < listaPersonas.count(); i++) {
            Persona Padre = (Persona) listaPersonas.get(i);
            String namePadre = Padre.getFullname().split(" ")[0];
            String fatherNamePadre = Padre.getNickname();
            //System.out.println("Padre:" + namePadre);
            for (int j = 0; j < hijos.count(); j++) {
                Persona hijo = (Persona) hijos.get(j);
                if (!listaPersonas.contains(hijo)) {
                    String nameHijo = hijo.getFullname().split(" ")[0];
                    String fatherNameHijo = hijo.getFather();
                    //System.out.println(namePadre + " == " + nameHijo);

                    if (!namePadre.equals(nameHijo) && !personaExistByName(listaPersonas, nameHijo)) {
                        listaPersonas.add(hijo);
                    } else {
                        if (!fatherNamePadre.equals(fatherNameHijo)) {
                            listaPersonas.add(hijo);
                        }
                    }
                }

            }
        }
    }

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

    public Boolean personaExistByNickName(Lista personas, String name) {
        for (int x = 0; x < personas.count(); x++) {
            var p = (Persona) personas.get(x);
            var n = p.getFullname().split(" ")[0];
            if (n.equals(name)) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * @return @throws java.io.IOException
     * @throws java.io.IOException
     */
    public Arbol LecturaJson() throws IOException {
        var chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        var file = chooser.getSelectedFile();

        try {
            LecturaPadres(file);
            var hijos = LecturaHijos(file);
            RevisarHijosPadres(hijos);

            System.out.println("Hijos: " + hijos.count());

            /**/
            for (int i = 0; i < listaPersonas.count(); i++) {
                Persona aux = (Persona) listaPersonas.get(i);
                System.out.println(aux.leer());
                System.out.println("");
            }

            
            for (int i = 0; i < listaPersonas.count(); i++) {
                Persona Padre = (Persona) listaPersonas.get(i);
                Nodo nuevoNodo = new Nodo(Padre);
                hashtable.addNode(nuevoNodo);
                if (root == null) {
                    if ("[Unknown]".equals(nuevoNodo.getPerson().getFather())) {
                        root = nuevoNodo;
                    }
                }
            }

            arbol = new Arbol(root, hashtable);

            for (int i = 0; i < hashtable.getNodes().count(); i++) {
                Nodo Padre = (Nodo) hashtable.getNodes().get(i);
                for (int j = 0; j < hashtable.getNodes().count(); j++) {
                    Nodo aux2 = (Nodo) hashtable.getNodes().get(j);
                    if (Padre.getPerson().getChildren() != null) {
                        if (Padre.getPerson().getFullname().equals(aux2.getPerson().getFather())) {
                            arbol.addChildren(Padre.getPerson().getNickname(), aux2.getPerson().getNickname());
                        } else if (Padre.getPerson().getKnownAs().equals(aux2.getPerson().getFather())) {
                            arbol.addChildren(Padre.getPerson().getNickname(), aux2.getPerson().getNickname());
                        } else {
                            String nickname = Padre.getPerson().getFullname() + ", " + Padre.getPerson().getOfHisName() + " of his name";
                            if (nickname.equals(aux2.getPerson().getFather())) {
                                arbol.addChildren(Padre.getPerson().getNickname(), aux2.getPerson().getNickname());
                            }
                        }
                    } else {
                        //System.out.println("La persona no tiene hijos");
                    }
                    //System.out.println(Padre.getChildren().printList());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, No es un tipo de dato válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("Personas " + listaPersonas.count());
        return arbol;
    }
}
