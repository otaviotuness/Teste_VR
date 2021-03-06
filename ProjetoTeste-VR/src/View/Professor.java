/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.AlunoDAO;
import model.ClassCurso;
import model.ClassProfessor;
import model.CursoDAO;
import model.ProfessorDAO;

/**
 *
 * @author Otavio
 */
public class Professor extends javax.swing.JFrame {

    /**
     * Creates new form Professor
     */
    public Professor() throws SQLException {
        initComponents();
        readTable();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabProfessor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cb_Titulo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        edt_Nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edt_Rg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edt_Cpf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOME", "RG", "CPF", "TITULO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabProfessorMouseClicked(evt);
            }
        });
        TabProfessor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabProfessorKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TabProfessor);

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImagem/confirmar.png"))); // NOI18N
        jButton1.setText("Incluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImagem/alterar.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImagem/excluir.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jButton1)
                .addGap(39, 39, 39)
                .addComponent(jButton2)
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)))
        );

        cb_Titulo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Mestre", "Doutor" }));

        jLabel1.setText("Nome");

        jLabel2.setText("RG");
        jLabel2.setToolTipText("");

        jLabel3.setText("CPF");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edt_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(edt_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cb_Titulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(edt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(edt_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(edt_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clean(){
        edt_Nome.setText(null);
        edt_Nome.setText(null);
        edt_Rg.setText(null);
        edt_Cpf.setText(null);
        cb_Titulo.setSelectedIndex(0);
    }
    
    private void charge(){
        
        String indexCB;
        
        if (TabProfessor.getSelectedRow() != -1){
            
            edt_Nome.setText(TabProfessor.getValueAt(TabProfessor.getSelectedRow(), 1).toString());
            edt_Rg.setText(TabProfessor.getValueAt(TabProfessor.getSelectedRow(), 2).toString());
            edt_Cpf.setText(TabProfessor.getValueAt(TabProfessor.getSelectedRow(), 3).toString());
            cb_Titulo.setSelectedIndex(Integer.parseInt(TabProfessor.getValueAt(TabProfessor.getSelectedRow(), 5).toString()));
            
            indexCB = TabProfessor.getValueAt(TabProfessor.getSelectedRow(), 6).toString();
            ((DefaultComboBoxModel)cb_Titulo.getModel()).getIndexOf(indexCB);
        }
    }
    
    public void readTable() throws SQLException{
    
        DefaultTableModel modelo = (DefaultTableModel) TabProfessor.getModel();
        ProfessorDAO professordao = new ProfessorDAO();
        modelo.setRowCount(0);
        
        for (ClassProfessor prof : professordao.read()) {
            
             modelo.addRow(new Object[]{
                prof.getCodigo(),
                prof.getNome(),
                prof.getRg(),
                prof.getCpf(),
                prof.getTitulo()
             }
             );   
        }
    }
     
    private void TabProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabProfessorMouseClicked
        // TODO add your handling code here:
        charge();
    }//GEN-LAST:event_TabProfessorMouseClicked

    private void TabProfessorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabProfessorKeyReleased
        // TODO add your handling code here:
        charge();
    }//GEN-LAST:event_TabProfessorKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ClassProfessor clsprofessor = new ClassProfessor();
        ProfessorDAO dao = new ProfessorDAO();
   
        clsprofessor.setNome(edt_Nome.getText());
        clsprofessor.setCpf(edt_Cpf.getText());
        clsprofessor.setRg(edt_Rg.getText());
        clsprofessor.setTitulo(cb_Titulo.getSelectedItem()+"");

        try {
            dao.create(clsprofessor);
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            readTable();
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }

        clean();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (TabProfessor.getSelectedRow() != -1){
            String titulo;
            
            ClassProfessor clsprofesor = new ClassProfessor();
            ProfessorDAO profdao = new ProfessorDAO();
           
            clsprofesor.setNome(edt_Nome.getText());
            clsprofesor.setRg(edt_Rg.getText());
            clsprofesor.setCpf(edt_Cpf.getText());
            
            titulo = cb_Titulo.getSelectedItem()+"";
            clsprofesor.setTitulo(titulo);
            

            clsprofesor.setCodigo((int) TabProfessor.getValueAt(TabProfessor.getSelectedRow(), 0));
            try {
                profdao.update(clsprofesor);
            } catch (SQLException ex) {
                Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                readTable();
            } catch (SQLException ex) {
                Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            }
            clean();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (TabProfessor.getSelectedRow() != -1){

            ClassProfessor clsprofessor = new ClassProfessor();
            ProfessorDAO profdao = new ProfessorDAO();
            clsprofessor.setCodigo((int) TabProfessor.getValueAt(TabProfessor.getSelectedRow(), 0));
            try {
                profdao.delete(clsprofessor);
            } catch (SQLException ex) {
                Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                readTable();
            } catch (SQLException ex) {
                Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            }
            clean();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Professor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Professor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Professor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Professor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Professor().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabProfessor;
    private javax.swing.JComboBox<String> cb_Titulo;
    private javax.swing.JTextField edt_Cpf;
    private javax.swing.JTextField edt_Nome;
    private javax.swing.JTextField edt_Rg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
