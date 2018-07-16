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
import negocio.Funcionario;
import negocio.Prestamo;

/**
 *
 * @author Renzo
 */
public class Funcionario_RenovacionesPendientes extends javax.swing.JFrame {

    private Funcionario funcionario;

    /**
     * Creates new form Funcionario_RevisarPrestamos
     */
    public Funcionario_RenovacionesPendientes() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     *
     * @param funcionario
     */
    public Funcionario_RenovacionesPendientes(Funcionario funcionario) {
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            this.funcionario = funcionario;
            this.listarPrestamosAceptacion();
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario_RenovacionesPendientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listarPrestamosAceptacion() throws SQLException {
        try {
            ResultSet rs = this.funcionario.listarPrestamosAceptacionBiblioteca();
            this.llenarTabla(rs);
        } catch (Exception ex) {
            Logger.getLogger(Funcionario_RenovacionesPendientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarTabla(ResultSet rs) throws SQLException {
        while (frenopend_tabla.getRowCount() > 0) {
            ((DefaultTableModel) frenopend_tabla.getModel()).removeRow(0);
        }
        int columns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++) {
                row[i - 1] = rs.getObject(i);
            }
            ((DefaultTableModel) frenopend_tabla.getModel()).insertRow(rs.getRow() - 1, row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        frenopend_tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        frenodev_filtro_nombre = new javax.swing.JTextField();
        frenodev_filtro_nombre1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fun_btn_realreno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Revision de textos pendientes de aceptación renovación");

        frenopend_tabla.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        frenopend_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Prestamo", "Nombre del Texto", "Rut del Solicitante", "Dia Solicitado", "Dia Entrega", "Días Atraso", "Renovaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        frenopend_tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(frenopend_tabla);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jLabel3.setText("Filtro de Nombre Texto");

        frenodev_filtro_nombre.setColumns(10);
        frenodev_filtro_nombre.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N

        frenodev_filtro_nombre1.setColumns(10);
        frenodev_filtro_nombre1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jLabel10.setText("Filtro por Rut Usuario");

        fun_btn_realreno.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        fun_btn_realreno.setText("Realizar Renovación");
        fun_btn_realreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fun_btn_realrenoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(frenodev_filtro_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(fun_btn_realreno, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(frenodev_filtro_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frenodev_filtro_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(frenodev_filtro_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(fun_btn_realreno)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fun_btn_realrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fun_btn_realrenoActionPerformed
        try {
            int selectedRow = this.frenopend_tabla.getSelectedRow();
            if (selectedRow >= 0) {
                int idPrestamo = (Integer) this.frenopend_tabla.getValueAt(selectedRow, 0);
                Prestamo prestamoBuscado = new Prestamo(idPrestamo);
                switch (prestamoBuscado.obtenerDatos()) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Se encuentra fuera de plazo de Entrega\nDebe devolver el libro y cancelar la multa.", "Inhabilitado para Renovacion!", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "No puede renovar este texto por tener Alta demanda y tener la cantidad maxima de renovaciones permitidas.", "Inhabilitado para Renovacion!", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "No puede renovar este texto por tener la cantidad maxima de renovaciones permitidas.", "Inhabilitado para Renovacion!", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 4:
                        int input = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea aceptar la renovación del texto:\n" + prestamoBuscado.getNombre_libro(), "Confirmar Renovación", JOptionPane.YES_NO_OPTION);
                        switch (input) {
                            case 0:
                                prestamoBuscado.registrarRenovacion();
                                JOptionPane.showMessageDialog(null, "Texto renovado exitosamente.", "Operacion Realizada", JOptionPane.INFORMATION_MESSAGE);
                                this.listarPrestamosAceptacion();
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(null, "Renovacion no realizada.", "Operación Cancelada", JOptionPane.INFORMATION_MESSAGE);
                                break;
                        }
                        break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error!\nFavor contactarse con el Administrador de la plataforma.", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex);
            Logger.getLogger(Funcionario_RevisarPrestamos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fun_btn_realrenoActionPerformed

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
            java.util.logging.Logger.getLogger(Funcionario_RenovacionesPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Funcionario_RenovacionesPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Funcionario_RenovacionesPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Funcionario_RenovacionesPendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionario_RenovacionesPendientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField frenodev_filtro_nombre;
    private javax.swing.JTextField frenodev_filtro_nombre1;
    private javax.swing.JTable frenopend_tabla;
    private javax.swing.JButton fun_btn_realreno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
