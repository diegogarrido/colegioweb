/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.userInterface;

import com.archivos.Database;
import com.archivos.Serial;
import com.proyecto1.Curso;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;
import org.orm.PersistentException;

/**
 *
 * @author Diego
 */
public final class Anotaciones extends javax.swing.JFrame {

    private boolean gen;
    private int index;
    private Curso cur;
    private Database dat = new Database();

    /**
     * Creates new form Anotaciones
     */
    public Anotaciones() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * Constructor
     *
     * @param nombre nombre del alumno
     * @param curso curso del alumno
     * @param index índice del alumno en el arraylist de su curso
     * @throws FileNotFoundException
     */
    public Anotaciones(String nombre, Curso curso, int index,boolean gen){
        initComponents();
        String text = jLabel1.getText();
        this.gen=gen;
        jLabel1.setText(text + nombre);
        this.cur = curso;
        this.index = index;
        crearLista();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        negativa = new javax.swing.JButton();
        positiva = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        siguiente = new javax.swing.JButton();
        anterior = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);

        jLabel1.setText("Anotaciones del Alumno: ");

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        negativa.setText("Negativa");
        negativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativaActionPerformed(evt);
            }
        });

        positiva.setText("Positiva");
        positiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positivaActionPerformed(evt);
            }
        });

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        jLabel3.setText("Añadir Anotación");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Registro de Anotaciones");

        siguiente.setText("→");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        anterior.setText("←");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(positiva)
                .addGap(18, 18, 18)
                .addComponent(negativa)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(32, 32, 32)
                        .addComponent(siguiente))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(siguiente)
                    .addComponent(anterior))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volver)
                    .addComponent(negativa)
                    .addComponent(positiva)
                    .addComponent(editar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        volver();
    }//GEN-LAST:event_volverActionPerformed

    private void volver() {
        Cursos cur;
        cur = new Cursos(this.gen);
        cur.setVisible(true);
        this.dispose();
    }

    private void positivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positivaActionPerformed
        añadir("Positiva");
    }//GEN-LAST:event_positivaActionPerformed

    private void negativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativaActionPerformed
        añadir("Negativa");
    }//GEN-LAST:event_negativaActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        editar();
    }//GEN-LAST:event_editarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        Anotaciones anot = null;
        anot = new Anotaciones(cur.getAlumnos().get(index - 1).getNombre(), cur, index - 1,this.gen);
        this.dispose();
        anot.setVisible(true);
    }//GEN-LAST:event_anteriorActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        Serial ser = new Serial();
        Anotaciones anot = new Anotaciones(cur.getAlumnos().get(index + 1).getNombre(), cur, index + 1,this.gen);
        this.dispose();
        anot.setVisible(true);
    }//GEN-LAST:event_siguienteActionPerformed

    private void editar() {
        if (tabla.getSelectedRow() != -1) {
            String str = cur.getAlumnos().get(index).getAnotaciones().get(tabla.getSelectedRow()).split(",")[0];
            while (str.length() < 9) {
                str = str.replaceAll(",", "");
                str += "," + JOptionPane.showInputDialog(null, "Reingrese Detalle de la anotación", "Editar " + str, JOptionPane.QUESTION_MESSAGE);
            }
            if (!str.contains("null")) {
                cur.getAlumnos().get(index).getAnotaciones().set(tabla.getSelectedRow(), str);
                try {
                    dat.updateData(cur);
                } catch (PersistentException ex) {
                    Logger.getLogger(Anotaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
                crearLista();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una anotación", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void añadir(String tipo) {
        String str = "";
        while (str.length() < 1) {
            str = JOptionPane.showInputDialog(null, "Ingrese Detalle de la anotación", "Añadir " + tipo, JOptionPane.QUESTION_MESSAGE);
            if (str == null) {
                str = "-1";
            }
        }
        if (str != "-1") {
            tipo += "," + str;
            cur.getAlumnos().get(index).getAnotaciones().add(tipo);
            try {
                dat.updateData(cur);
            } catch (PersistentException ex) {
                Logger.getLogger(Anotaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            crearLista();
        }
    }

    /**
     * Crear Lista de anotaciones
     *
     * @throws FileNotFoundException
     */
    private void crearLista() {
        String col[] = new String[]{"Tipo", "Detalle"};
        String data[][] = new String[cur.getAlumnos().get(index).getAnotaciones().size()][3];
        for (int i = 0; i < cur.getAlumnos().get(index).getAnotaciones().size(); i++) {
            data[i][0] = cur.getAlumnos().get(index).getAnotaciones().get(i).split(",")[0];
            data[i][1] = cur.getAlumnos().get(index).getAnotaciones().get(i).split(",")[1];
        }
        DefaultTableModel def = new DefaultTableModel(data, col);
        tabla.setModel(def);
        if (index == 0) {
            anterior.setEnabled(false);
        } else {
            anterior.setEnabled(true);
        }
        if (index == cur.getAlumnos().size() - 1) {
            siguiente.setEnabled(false);
        } else {
            siguiente.setEnabled(true);
        }
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anotaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Anotaciones().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anterior;
    private javax.swing.JButton editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton negativa;
    private javax.swing.JButton positiva;
    private javax.swing.JButton siguiente;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
