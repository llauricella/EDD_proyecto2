/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edd_Interfaz;

import EstructurasDeDatos.*;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luigi Lauricella
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private GraphStream graphstream;
    private Arbol tree;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        AntepasadoBox.removeAllItems();
        PersonaBox.removeAllItems();
        TituloBox.removeAllItems();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloPrincipalLabel = new javax.swing.JLabel();
        JSONButton = new javax.swing.JButton();
        ArbolButton = new javax.swing.JButton();
        PersonaButton = new javax.swing.JButton();
        PersonaLabel = new javax.swing.JLabel();
        AntepasadoButton = new javax.swing.JButton();
        AntepasadoLabel = new javax.swing.JLabel();
        TituloButton = new javax.swing.JButton();
        TituloLabel = new javax.swing.JLabel();
        GeneracionButton = new javax.swing.JButton();
        GeneraciónLabel = new javax.swing.JLabel();
        TituloField = new javax.swing.JTextField();
        AntepasadoBox = new javax.swing.JComboBox<>();
        PersonaField = new javax.swing.JTextField();
        PersonaBox = new javax.swing.JComboBox<>();
        TituloBox = new javax.swing.JComboBox<>();
        GeneracionField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TituloPrincipalLabel.setFont(new java.awt.Font("Swis721 BT", 3, 24)); // NOI18N
        TituloPrincipalLabel.setForeground(new java.awt.Color(0, 0, 255));
        TituloPrincipalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloPrincipalLabel.setText("   Menú de Control   ");
        TituloPrincipalLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 3));

        JSONButton.setBackground(new java.awt.Color(0, 0, 255));
        JSONButton.setFont(new java.awt.Font("Swis721 Blk BT", 0, 14)); // NOI18N
        JSONButton.setForeground(new java.awt.Color(255, 255, 255));
        JSONButton.setText("Cargar Json");
        JSONButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSONButtonActionPerformed(evt);
            }
        });

        ArbolButton.setBackground(new java.awt.Color(0, 0, 255));
        ArbolButton.setFont(new java.awt.Font("Swis721 Blk BT", 0, 14)); // NOI18N
        ArbolButton.setForeground(new java.awt.Color(255, 255, 255));
        ArbolButton.setText("Mostrar árbol");
        ArbolButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArbolButtonActionPerformed(evt);
            }
        });

        PersonaButton.setBackground(new java.awt.Color(0, 0, 255));
        PersonaButton.setFont(new java.awt.Font("Swis721 Blk BT", 0, 14)); // NOI18N
        PersonaButton.setForeground(new java.awt.Color(255, 255, 255));
        PersonaButton.setText("Buscar");
        PersonaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonaButtonActionPerformed(evt);
            }
        });

        PersonaLabel.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        PersonaLabel.setText("Buscar persona por nombre");

        AntepasadoButton.setBackground(new java.awt.Color(0, 0, 255));
        AntepasadoButton.setFont(new java.awt.Font("Swis721 Blk BT", 0, 14)); // NOI18N
        AntepasadoButton.setForeground(new java.awt.Color(255, 255, 255));
        AntepasadoButton.setText("Mostrar");
        AntepasadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AntepasadoButtonActionPerformed(evt);
            }
        });

        AntepasadoLabel.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        AntepasadoLabel.setText("Mostrar antepasados por nombre");

        TituloButton.setBackground(new java.awt.Color(0, 0, 255));
        TituloButton.setFont(new java.awt.Font("Swis721 Blk BT", 0, 14)); // NOI18N
        TituloButton.setForeground(new java.awt.Color(255, 255, 255));
        TituloButton.setText("Buscar");
        TituloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloButtonActionPerformed(evt);
            }
        });

        TituloLabel.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        TituloLabel.setText("Buscar por titulo");

        GeneracionButton.setBackground(new java.awt.Color(0, 0, 255));
        GeneracionButton.setFont(new java.awt.Font("Swis721 Blk BT", 0, 14)); // NOI18N
        GeneracionButton.setForeground(new java.awt.Color(255, 255, 255));
        GeneracionButton.setText("Enseñar");
        GeneracionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneracionButtonActionPerformed(evt);
            }
        });

        GeneraciónLabel.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        GeneraciónLabel.setText("Enseñar la lista de integrantes de una generación");

        TituloField.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N

        AntepasadoBox.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        AntepasadoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AntepasadoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AntepasadoBoxActionPerformed(evt);
            }
        });

        PersonaField.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        PersonaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonaFieldActionPerformed(evt);
            }
        });

        PersonaBox.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        PersonaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        TituloBox.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N
        TituloBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        GeneracionField.setFont(new java.awt.Font("Segoe UI Semilight", 2, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(JSONButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ArbolButton)
                .addGap(182, 182, 182))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(TituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PersonaField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PersonaButton)
                .addGap(132, 132, 132))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(GeneracionField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GeneracionButton))
                        .addComponent(TituloBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(TituloField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TituloButton)))
                    .addComponent(GeneraciónLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PersonaBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PersonaLabel)
                                .addGap(44, 44, 44)))
                        .addGap(132, 132, 132))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AntepasadoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AntepasadoButton)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AntepasadoLabel)
                        .addGap(161, 161, 161))))
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(TituloPrincipalLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(TituloPrincipalLabel)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JSONButton)
                    .addComponent(ArbolButton))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GeneraciónLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GeneracionButton)
                            .addComponent(GeneracionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AntepasadoLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AntepasadoButton)
                            .addComponent(AntepasadoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloLabel)
                            .addComponent(PersonaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PersonaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TituloButton)
                            .addComponent(TituloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PersonaButton)
                            .addComponent(PersonaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JSONButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSONButtonActionPerformed
        /**
         * *
         * Botón para subir un archivo JSON a la interfaz para su debido
         * procesamiento.
         */
        if (graphstream != null) {
            graphstream.setVisible(false);
            graphstream = null;
        }
        try {
            tree = new LecturaJson().LecturaJson();
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
        AntepasadoBox.removeAllItems();
        PersonaBox.removeAllItems();
        TituloBox.removeAllItems();
        
        Lista nodos = tree.getHashtable().getNodes();
        for (int i = 0; i < tree.getHashtable().getNodes().count(); i++) {
            Nodo aux = (Nodo) nodos.get(i);
            AntepasadoBox.addItem(aux.getPerson().getNickname());
        }
        
        System.out.println(tree.getRoot().getPerson().getFullname());

    }//GEN-LAST:event_JSONButtonActionPerformed

    private void ArbolButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArbolButtonActionPerformed
        /**
         * *
         * Botón para abrir la interfaz visual del árbol de la librería de
         * GraphStream.
         */

        if (tree != null) {
            if (graphstream != null) {
                if (!graphstream.isVisible()) {
                    graphstream.dispose();
                    graphstream = new GraphStream(tree);
                    //Nodo root = tree.getRoot();
                    //graphstream.populateGraphbyRoot(root);
                    graphstream.populateGraphbyHashTable(tree);
                    graphstream.setVisible(true);
                }
            } else {
                graphstream = new GraphStream(tree);
                Nodo root = tree.getRoot();
                //graphstream.populateGraphbyRoot(root);
                //graphstream.populateGraphbyHashTable(tree);
                graphstream.populateGraphFromRootWithBFS(root);
                graphstream.setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ArbolButtonActionPerformed

    private void PersonaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonaButtonActionPerformed
        if (tree != null) {
            PersonaBox.removeAllItems();
            String selectedItem = (String) PersonaField.getText();
            if (selectedItem != null) {
                Lista encontrados = tree.encontradosNombre(selectedItem);
                if (encontrados != null) {
                    for (int i = 0; i < encontrados.count(); i++){
                        Nodo encontrado = (Nodo) encontrados.get(i);
                        PersonaBox.addItem(encontrado.getPerson().getNickname());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR, no se encontro un nombre", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, no elegiste un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, cargue un documento JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        PersonaField.setText("");
    }//GEN-LAST:event_PersonaButtonActionPerformed

    private void TituloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloButtonActionPerformed

        String titulo = TituloField.getText();
        if (titulo != null) {
            TituloBox.removeAllItems();
            String selectedItem = (String) TituloField.getText();
            if (selectedItem != null) {
                Lista encontrados = tree.encontradosTitulo(selectedItem);
                if (encontrados != null) {
                    for (int i = 0; i < encontrados.count(); i++){
                        Nodo encontrado = (Nodo) encontrados.get(i);
                        TituloBox.addItem(encontrado.getPerson().getNickname());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR, no se encontro un nombre", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, no elegiste un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no colocaste un nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
        TituloField.setText("");
    }//GEN-LAST:event_TituloButtonActionPerformed

    private void AntepasadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AntepasadoButtonActionPerformed
        if (tree != null) {
            String antepasado = (String) AntepasadoBox.getSelectedItem();
            if (antepasado != null) {
                if (graphstream != null) { graphstream.dispose(); }
                graphstream = new GraphStream(tree);
                String[] nickname = antepasado.split(", ");
                Nodo aux = tree.getHashtable().getNode(nickname[0], nickname[1]);
                Lista ancestros = tree.ancestros(aux);
                System.out.println(ancestros.printList());
                graphstream.populateGraphbyAncestros(ancestros);
                graphstream.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, no colocaste un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, cargue un documento JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_AntepasadoButtonActionPerformed

    private void PersonaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PersonaFieldActionPerformed

    private void GeneracionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneracionButtonActionPerformed
        if (tree != null) {
             try {
                int height = Integer.parseInt(GeneracionField.getText());
                
                Lista resultados = tree.descendientesPorGeneracion(height);
                if (resultados != null) {
                    JOptionPane.showMessageDialog(null, resultados.printList(), "Resultados para la generación " + height, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR, no hay generación " + height, "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR, coloca un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, cargue un documento JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_GeneracionButtonActionPerformed

    private void AntepasadoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AntepasadoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AntepasadoBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AntepasadoBox;
    private javax.swing.JButton AntepasadoButton;
    private javax.swing.JLabel AntepasadoLabel;
    private javax.swing.JButton ArbolButton;
    private javax.swing.JButton GeneracionButton;
    private javax.swing.JTextField GeneracionField;
    private javax.swing.JLabel GeneraciónLabel;
    private javax.swing.JButton JSONButton;
    private javax.swing.JComboBox<String> PersonaBox;
    private javax.swing.JButton PersonaButton;
    private javax.swing.JTextField PersonaField;
    private javax.swing.JLabel PersonaLabel;
    private javax.swing.JComboBox<String> TituloBox;
    private javax.swing.JButton TituloButton;
    private javax.swing.JTextField TituloField;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JLabel TituloPrincipalLabel;
    // End of variables declaration//GEN-END:variables
}
