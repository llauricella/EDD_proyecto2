/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edd_Interfaz;

import EstructurasDeDatos.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swing_viewer.*;
import org.graphstream.ui.view.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Luigi Lauricella
 */
public class GraphStream extends javax.swing.JFrame implements ViewerListener {

    private Arbol tree;
    private Graph graph;
    private final ViewerPipe fromviewer;

    /**
     * Creates new form GraphStream
     *
     * @param tree
     */
    public GraphStream(Arbol tree) {
        this.tree = tree;
        initComponents();
        this.setLocationRelativeTo(null);
        graph = new SingleGraph("Example");
        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);

        View view = viewer.addDefaultView(false);
        GraphStreamPanel.setLayout(new BorderLayout());
        GraphStreamPanel.add((Component) view, BorderLayout.CENTER);

        fromviewer = viewer.newViewerPipe();
        fromviewer.addViewerListener(this);
        fromviewer.addSink(graph);

        PumpViewer();
    }

    public void populateGraphbyAncestors(Lista descendientes, String targetNickname) {
        if (descendientes == null || descendientes.count() == 0 || targetNickname == null) {
            return;
        }

        int[] currentXPosition = new int[100];
        Nodo root = tree.getRoot();

        String rootNickname = root.getPerson().getNickname();
        graph.addNode(rootNickname).setAttribute("ui.label", rootNickname);
        assignNodePosition(root, 0, currentXPosition);

        for (int i = 0; i < descendientes.count(); i++) {
            Nodo currentNode = (Nodo) descendientes.get(i);

            if (currentNode == null || currentNode.getPerson() == null) {
                continue;
            }

            String currentNickname = currentNode.getPerson().getNickname();
            
            if (currentNickname.equals(targetNickname)) {
                break;
            }

            Lista children = currentNode.getChildren();
            if (children != null) {
                for (int j = 0; j < children.count(); j++) {
                    Nodo child = (Nodo) children.get(j);

                    if (child == null || child.getPerson() == null) {
                        continue;
                    }

                    String childNickname = child.getPerson().getNickname();
                    String[] splitChild = childNickname.split(", ");

                    if (graph.getNode(childNickname) == null) {
                        if (" ".contains(splitChild[1])) {
                            graph.addNode(childNickname).setAttribute("ui.label", splitChild[0]);
                        } else {
                            graph.addNode(childNickname).setAttribute("ui.label", childNickname);
                        }
                        
                        assignNodePosition(child, i + 1, currentXPosition);
                    }

                    String edgeId = generateEdgeId(currentNickname, childNickname);
                    if (graph.getEdge(edgeId) == null) {
                        graph.addEdge(edgeId, currentNickname, childNickname);
                    }
                }
            }
        }

        graph.setAttribute("ui.stylesheet", "node { fill-color: lightblue; }");
    }

    private void assignNodePosition(Nodo node, int level, int[] currentXPosition) {
        if (node == null || node.getPerson() == null) {
            return;
        }

        String nodeNickname = node.getPerson().getNickname();

        int xPosition = currentXPosition[level] += 3;
        graph.getNode(nodeNickname).setAttribute("xyz", xPosition, -level, 0);
    }

    public void populateGraphbyRoot(Nodo root) {

        if (root == null) {
            return;
        }

        Busqueda busqueda = new Busqueda();
        Lista reachableNodes = busqueda.visitAllNodesDFS(root);

        int[] currentXPosition = new int[100];
        assignNodePositions(root, 0, currentXPosition);

        for (int i = 0; i < reachableNodes.count(); i++) {
            Nodo node = (Nodo) reachableNodes.get(i);

            if (node == null || node.getPerson() == null) {
                continue;
            }

            String nodeNickname = node.getPerson().getNickname();

            Lista children = node.getChildren();

            if (children != null) {
                for (int j = 0; j < children.count(); j++) {
                    Nodo child = (Nodo) children.get(j);

                    if (child == null || child.getPerson() == null) {
                        continue;
                    }
                    String childNickname = child.getPerson().getNickname();

                    if (nodeNickname.equals(childNickname)) {
                        continue;
                    }

                    String edgeId = generateEdgeId(nodeNickname, childNickname);

                    if (graph.getEdge(edgeId) == null) {
                        graph.addEdge(edgeId, nodeNickname, childNickname);
                    }
                }
            }
        }
        graph.setAttribute("ui.stylesheet", "node { fill-color: lightblue; }");
    }

    private void assignNodePositions(Nodo node, int level, int[] currentXPosition) {
        if (node == null || node.getPerson() == null) {
            return;
        }

        String nodeNickname = node.getPerson().getNickname();

        if (graph.getNode(nodeNickname) == null) {
            String[] split = nodeNickname.split(", ");
            if (" ".contains(split[1])) {
                graph.addNode(nodeNickname).setAttribute("ui.label", split[0]);
            } else {
                graph.addNode(nodeNickname).setAttribute("ui.label", nodeNickname);
            }

        }

        int xPosition = currentXPosition[level] += 3;
        graph.getNode(nodeNickname).setAttribute("xyz", xPosition, -level, 0);

        Lista children = node.getChildren();
        if (children != null) {
            for (int i = 0; i < children.count(); i++) {
                Nodo child = (Nodo) children.get(i);
                assignNodePositions(child, level + 3, currentXPosition);
            }
        }
    }

    private String generateEdgeId(String nodeId1, String nodeId2) {
        if (nodeId1.compareTo(nodeId2) < 0) {
            return nodeId1 + "-" + nodeId2;
        } else {
            return nodeId2 + "-" + nodeId1;
        }
    }

    private void PumpViewer() {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                while (!isCancelled()) {
                    fromviewer.pump();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                return null;
            }
        };
        worker.execute();
    }

    @Override
    public void viewClosed(String id) {
    }

    @Override
    public void buttonPushed(String id) {
        Node node = graph.getNode(id);
        if (node != null) {
            String[] fullname = id.split(", ");
            if ("".equals(tree.getHashtable().getNode(fullname[0], fullname[1]).getPerson().getEyes())) {
                Persona persona = tree.getHashtable().getNode(fullname[0], fullname[1]).getPerson();
                JOptionPane.showMessageDialog(null, "Fullname: " + persona.getFullname(), id, JOptionPane.INFORMATION_MESSAGE);
            } else {
                String resultados = tree.getHashtable().getNode(fullname[0], fullname[1]).getPerson().leer();
                JOptionPane.showMessageDialog(null, resultados, id, JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    @Override
    public void buttonReleased(String id) {
    }

    @Override
    public void mouseOver(String id) {
    }

    @Override
    public void mouseLeft(String id) {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GraphStreamPanel = new javax.swing.JPanel();

        setTitle("GraphStream");

        javax.swing.GroupLayout GraphStreamPanelLayout = new javax.swing.GroupLayout(GraphStreamPanel);
        GraphStreamPanel.setLayout(GraphStreamPanelLayout);
        GraphStreamPanelLayout.setHorizontalGroup(
            GraphStreamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        GraphStreamPanelLayout.setVerticalGroup(
            GraphStreamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GraphStreamPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GraphStreamPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(GraphStream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphStream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphStream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphStream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphStream(tree).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GraphStreamPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the graph
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * @param graph the graph to set
     */
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    /**
     * @return the tree
     */
    public Arbol getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(Arbol tree) {
        this.tree = tree;
    }
}
