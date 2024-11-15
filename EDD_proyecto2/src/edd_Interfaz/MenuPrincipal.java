/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edd_Interfaz;

import EstructurasDeDatos.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Luigi Lauricella
 */
public class MenuPrincipal extends javax.swing.JFrame {
    private GraphStream graphstream;
    private Informacion info;
    private Arbol tree;
    
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
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
        PersonaField = new javax.swing.JTextField();
        PersonaButton = new javax.swing.JButton();
        PersonaLabel = new javax.swing.JLabel();
        AntepasadoButton = new javax.swing.JButton();
        AntepasadoField = new javax.swing.JTextField();
        AntepasadoLabel = new javax.swing.JLabel();
        TituloButton = new javax.swing.JButton();
        TituloLabel = new javax.swing.JLabel();
        GeneracionButton = new javax.swing.JButton();
        GeneraciónLabel = new javax.swing.JLabel();
        TituloField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TituloPrincipalLabel.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        TituloPrincipalLabel.setText("Menu de Control");

        JSONButton.setText("Cargar Json");
        JSONButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JSONButtonActionPerformed(evt);
            }
        });

        ArbolButton.setText("Mostrar árbol");
        ArbolButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArbolButtonActionPerformed(evt);
            }
        });

        PersonaButton.setText("Buscar");
        PersonaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonaButtonActionPerformed(evt);
            }
        });

        PersonaLabel.setText("Buscar persona por nombre");

        AntepasadoButton.setText("Mostrar");

        AntepasadoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AntepasadoFieldActionPerformed(evt);
            }
        });

        AntepasadoLabel.setText("Mostrar antepasados por nombre");

        TituloButton.setText("Buscar");
        TituloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloButtonActionPerformed(evt);
            }
        });

        TituloLabel.setText("Buscar por titulo");

        GeneracionButton.setText("Enseñar");

        GeneraciónLabel.setText("Enseñar la lista de integrantes de una generación");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PersonaField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(PersonaButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(TituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(TituloField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TituloButton)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(GeneracionButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(GeneraciónLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(AntepasadoField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(AntepasadoButton))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(PersonaLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addComponent(JSONButton)))
                                .addGap(148, 148, 148)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ArbolButton)
                                    .addComponent(AntepasadoLabel)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(TituloPrincipalLabel)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TituloPrincipalLabel)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JSONButton)
                    .addComponent(ArbolButton))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PersonaLabel)
                    .addComponent(AntepasadoLabel))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PersonaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PersonaButton)
                    .addComponent(AntepasadoButton)
                    .addComponent(AntepasadoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloLabel)
                    .addComponent(GeneraciónLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloButton)
                    .addComponent(GeneracionButton)
                    .addComponent(TituloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JSONButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JSONButtonActionPerformed
        /***
         * Botón para subir un archivo JSON a la interfaz
         * para su debido procesamiento.
         */
        if (graphstream != null) {
            graphstream.setVisible(false);
            graphstream = null;
        }
        // tree =
        LecturaJson lecturajson = new LecturaJson();
        
        graphstream = new GraphStream(tree);
    }//GEN-LAST:event_JSONButtonActionPerformed

    private void ArbolButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArbolButtonActionPerformed
        /***
         * Botón para abrir la interfaz visual del árbol
         * de la librería de GraphStream.
         */
        
        // if (tree != null) {} else {JOptionPane.showMessageDialog(null, "ERROR, cargue un documento JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);}
        if (graphstream != null) {
            if (!graphstream.isVisible()) {
            graphstream.populateGraph();
            graphstream.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_ArbolButtonActionPerformed

    private void PersonaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonaButtonActionPerformed
        
        // if (tree != null) {} else {JOptionPane.showMessageDialog(null, "ERROR, cargue un documento JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);}
        String person = PersonaField.getText();
        if (person != null) {
            if (graphstream != null) {
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no colocaste un nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PersonaButtonActionPerformed

    private void AntepasadoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AntepasadoFieldActionPerformed
        
        // if (tree != null) {} else {JOptionPane.showMessageDialog(null, "ERROR, cargue un documento JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);}
        String antepasado = AntepasadoField.getText();
        if (antepasado != null) {
            if (graphstream != null) {
                String[] nickname = antepasado.split(", ");
                Nodo aux = tree.getHashtable().getNode(nickname[0], nickname[1]);
                Lista resultados = tree.ancestros(aux);
                info = new Informacion(tree, resultados);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no colocaste un nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
        AntepasadoField.setText("");
    }//GEN-LAST:event_AntepasadoFieldActionPerformed

    private void TituloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloButtonActionPerformed
        
        String titulo = TituloField.getText();
        if (titulo != null) {
            if (graphstream != null) {
                
                //info = new Informacion();
                info.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, no cargaste un JSON antes.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR, no colocaste un nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TituloButtonActionPerformed

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
    private javax.swing.JButton AntepasadoButton;
    private javax.swing.JTextField AntepasadoField;
    private javax.swing.JLabel AntepasadoLabel;
    private javax.swing.JButton ArbolButton;
    private javax.swing.JButton GeneracionButton;
    private javax.swing.JLabel GeneraciónLabel;
    private javax.swing.JButton JSONButton;
    private javax.swing.JButton PersonaButton;
    private javax.swing.JTextField PersonaField;
    private javax.swing.JLabel PersonaLabel;
    private javax.swing.JButton TituloButton;
    private javax.swing.JTextField TituloField;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JLabel TituloPrincipalLabel;
    // End of variables declaration//GEN-END:variables
}
