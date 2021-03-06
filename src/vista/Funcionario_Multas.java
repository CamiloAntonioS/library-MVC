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

/**
 *
 * @author Renzo
 */
public class Funcionario_Multas extends javax.swing.JFrame {

    private Funcionario funcionario;

    /**
     * Creates new form Funcionario_Multas
     */
    public Funcionario_Multas() {
        initComponents();
    }

    public Funcionario_Multas(Funcionario funcionario) {
        initComponents();
         this.setLocationRelativeTo(null);
        this.setFuncionario(funcionario);
        this.listarMultados();
        this.obtenerRecaudado();
        this.obtenerLibroMultado();
        this.obtenerSedeMultada();
    }

    private void listarMultados() {
        try {
            this.llenarTabla(this.getFuncionario().listarMultados());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema inesperado!\nFavor contactese con el administrador de la plataforma.", "Error!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Funcionario_Multas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Funcionario_Multas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void obtenerRecaudado() {
        try {
            int totalMultas = this.getFuncionario().totalMultas();
            this.lbl_recaudado.setText(this.lbl_recaudado.getText() + " " + totalMultas);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema inesperado!\nFavor contactese con el administrador de la plataforma.", "Error!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Funcionario_Multas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Funcionario_Multas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void obtenerLibroMultado() {
        try {
            String libro = this.getFuncionario().libroMasMultado();
            this.lbl_multalibro.setText(this.lbl_multalibro.getText() + " " + libro);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema inesperado!\nFavor contactese con el administrador de la plataforma.", "Error!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Funcionario_Multas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Funcionario_Multas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void obtenerSedeMultada() {
        try {
            String sede = this.getFuncionario().sedeMasMultada();
            this.lbl_sede.setText(this.lbl_sede.getText() + " " + sede);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema inesperado!\nFavor contactese con el administrador de la plataforma.", "Error!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Funcionario_Multas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Funcionario_Multas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarTabla(ResultSet rs) throws SQLException {
        while (tbl_Usuarios_Multados.getRowCount() > 0) {
            ((DefaultTableModel) tbl_Usuarios_Multados.getModel()).removeRow(0);
        }
        int columns = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Object[] row = new Object[columns];
            for (int i = 1; i <= columns; i++) {
                row[i - 1] = rs.getObject(i);
            }
            ((DefaultTableModel) tbl_Usuarios_Multados.getModel()).insertRow(rs.getRow() - 1, row);
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

        label_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Usuarios_Multados = new javax.swing.JTable();
        label_titulo1 = new javax.swing.JLabel();
        lbl_recaudado = new javax.swing.JLabel();
        lbl_multalibro = new javax.swing.JLabel();
        lbl_sede = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        label_titulo.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        label_titulo.setText("Resumen de Multas");

        tbl_Usuarios_Multados.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        tbl_Usuarios_Multados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre", "Perfil", "Sede", "Multa Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_Usuarios_Multados);
        if (tbl_Usuarios_Multados.getColumnModel().getColumnCount() > 0) {
            tbl_Usuarios_Multados.getColumnModel().getColumn(4).setResizable(false);
        }

        label_titulo1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        label_titulo1.setText("Top 10 Usuarios con Multas");

        lbl_recaudado.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        lbl_recaudado.setText("Ingresos totales por multas:");

        lbl_multalibro.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        lbl_multalibro.setText("Libro con mayor cantidad de multas:");

        lbl_sede.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        lbl_sede.setText("Sede con mayor cantidad de multas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_titulo)
                            .addComponent(label_titulo1)
                            .addComponent(lbl_recaudado)
                            .addComponent(lbl_multalibro)
                            .addComponent(lbl_sede))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_recaudado, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_multalibro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_sede, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_titulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Funcionario_Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Funcionario_Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Funcionario_Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Funcionario_Multas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionario_Multas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_titulo1;
    private javax.swing.JLabel lbl_multalibro;
    private javax.swing.JLabel lbl_recaudado;
    private javax.swing.JLabel lbl_sede;
    private javax.swing.JTable tbl_Usuarios_Multados;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the funcionario
     */
    protected Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    protected void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
