/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.Usuario;

/**
 *
 * @author Renzo
 */
public class Docente extends javax.swing.JFrame {

    Usuario docente;

    /**
     * Creates new form Alumno
     */
    public Docente() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public Docente(Usuario docente) {
        initComponents();
        this.docente = docente;
        this.listarPrestamos();
        this.setTitle("Prestamos vigentes [" + this.docente.getUsername() + "]");
        this.label_titulo.setText("Prestamos Vigentes alumno " + this.docente.getNombre());
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

        label_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        docente_tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        docente_filtro_nombre = new javax.swing.JTextField();
        docente_btn_renovar = new javax.swing.JButton();
        btn_libreria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_titulo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        label_titulo.setText("Prestamos vigentes");

        docente_tabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Libreria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 11))); // NOI18N
        docente_tabla.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        docente_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Prestamo", "ID Texto", "Nombre Texto", "Categoria", "Dia Solicitado", "Dia Entrega", "Días Atraso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(docente_tabla);
        docente_tabla.getAccessibleContext().setAccessibleName("");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jLabel3.setText("Filtro de Nombre");

        docente_filtro_nombre.setColumns(10);
        docente_filtro_nombre.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N

        docente_btn_renovar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        docente_btn_renovar.setText("Renovar préstamo seleccionado");
        docente_btn_renovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docente_btn_renovarActionPerformed(evt);
            }
        });

        btn_libreria.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        btn_libreria.setText("Ver Libreria");
        btn_libreria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_libreriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_titulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(docente_filtro_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(docente_btn_renovar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_libreria)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(docente_filtro_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(docente_btn_renovar)
                    .addComponent(btn_libreria))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void docente_btn_renovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docente_btn_renovarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docente_btn_renovarActionPerformed

    private void btn_libreriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_libreriaActionPerformed
        Libreria libreria;
        try {
            libreria = new Libreria();
            libreria.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema inesperado!\nFavor reintente en unos momentos", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_libreriaActionPerformed

    private void listarPrestamos() {
        try {
            ResultSet rs = this.docente.listarPrestamos();
            this.llenarTabla(rs);
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarTabla(ResultSet rs) throws SQLException {
        while (docente_tabla.getRowCount() > 0) {
            ((DefaultTableModel) docente_tabla.getModel()).removeRow(0);
        }
        int columns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++) {
                row[i - 1] = rs.getObject(i);
            }
            ((DefaultTableModel) docente_tabla.getModel()).insertRow(rs.getRow() - 1, row);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Docente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Docente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_libreria;
    private javax.swing.JButton docente_btn_renovar;
    private javax.swing.JTextField docente_filtro_nombre;
    private javax.swing.JTable docente_tabla;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_titulo;
    // End of variables declaration//GEN-END:variables
}
