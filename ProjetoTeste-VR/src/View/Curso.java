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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ClassCurso;
import model.ClassProfessor;
import model.CursoDAO;
import model.ProfessorDAO;

/**
 *
 * @author Otavio
 */
public class Curso extends javax.swing.JFrame {

    /**
     * Creates new form FrmPesqCursos
     * @throws java.sql.SQLException
     */
    public Curso() throws SQLException {
        initComponents();
        iniciar();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabCurso = new javax.swing.JTable();
        jlbl_Desc = new javax.swing.JLabel();
        edt_Desc = new javax.swing.JTextField();
        jlbl_Desc1 = new javax.swing.JLabel();
        edt_Dur = new javax.swing.JTextField();
        edt_QtdAluno = new javax.swing.JTextField();
        jlbl_Desc2 = new javax.swing.JLabel();
        edt_CargaHr = new javax.swing.JTextField();
        jlbl_Desc3 = new javax.swing.JLabel();
        cb_Periodo = new javax.swing.JComboBox<>();
        jlbl_Desc4 = new javax.swing.JLabel();
        cb_Instrutor = new javax.swing.JComboBox<>();
        jlbl_Desc5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        TabCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRICAO", "DURACAO", "QTD_ALUNO", "CARGA_HR", "PERIODO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabCursoMouseClicked(evt);
            }
        });
        TabCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabCursoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TabCurso);

        jlbl_Desc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlbl_Desc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_Desc.setText("Descrição");

        edt_Desc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jlbl_Desc1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlbl_Desc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_Desc1.setText("Duração");

        edt_Dur.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        edt_QtdAluno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jlbl_Desc2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlbl_Desc2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_Desc2.setText("Qtd. Aluno");

        edt_CargaHr.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jlbl_Desc3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlbl_Desc3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_Desc3.setText("Carga Hr.");

        cb_Periodo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cb_Periodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "Matutino", "Vespertino", "Noturno", "Integral" }));

        jlbl_Desc4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlbl_Desc4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_Desc4.setText("Periodo");

        cb_Instrutor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cb_Instrutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        jlbl_Desc5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlbl_Desc5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbl_Desc5.setText("Prof. Responsável");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/viewImagem/excluir.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbl_Desc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbl_Desc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbl_Desc4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edt_Desc)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edt_Dur, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbl_Desc2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edt_QtdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbl_Desc3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edt_CargaHr, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlbl_Desc5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_Instrutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Desc)
                    .addComponent(edt_Desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edt_QtdAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_Desc2)
                    .addComponent(edt_CargaHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_Desc3)
                    .addComponent(jlbl_Desc1)
                    .addComponent(edt_Dur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_Desc4)
                    .addComponent(cb_Periodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_Instrutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_Desc5))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void readTable() throws SQLException{
    
        DefaultTableModel modelo = (DefaultTableModel) TabCurso.getModel();
        CursoDAO cursodao = new CursoDAO();
        modelo.setRowCount(0);
        
        for (ClassCurso c : cursodao.read()) {
            
             modelo.addRow(new Object[]{
                c.getCodigo(),
                c.getDescricao(),
                c.getDuracao(),
                c.getQtd_aluno(),
                c.getCarga_hr(),
                c.getPeriodo()
             }
             );   
        }
    }
    
    public void refreshCombo() throws SQLException{
        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cb_Instrutor.getModel();
        ProfessorDAO profdao = new ProfessorDAO();
        
        for (model.ClassProfessor clsprof : profdao.readMestre()){ 
            comboBoxModel.addElement(clsprof);    
        }
    }
    
    private void clean(){
        edt_CargaHr.setText(null);
        edt_Desc.setText(null);
        edt_Dur.setText(null);
        edt_QtdAluno.setText(null);
        cb_Periodo.setSelectedIndex(0);
    }
    
    private void charge(){
        String indexCB;
        
        if (TabCurso.getSelectedRow() != -1){
            
            edt_Desc.setText(TabCurso.getValueAt(TabCurso.getSelectedRow(), 1).toString());
            edt_Dur.setText(TabCurso.getValueAt(TabCurso.getSelectedRow(), 2).toString());
            edt_QtdAluno.setText(TabCurso.getValueAt(TabCurso.getSelectedRow(), 3).toString());
            edt_CargaHr.setText(TabCurso.getValueAt(TabCurso.getSelectedRow(), 4).toString());
            indexCB = TabCurso.getValueAt(TabCurso.getSelectedRow(),5).toString();
            cb_Periodo.setSelectedIndex(((DefaultComboBoxModel)cb_Periodo.getModel()).getIndexOf(indexCB));
        }
    }
    
    private void iniciar() throws SQLException{
        readTable();
        refreshCombo();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        verificaEdts();
        Integer periodo;
        Double cargaHoraria;
        
        cargaHoraria = Double.parseDouble(edt_CargaHr.getText());
        
        if (cargaHoraria < 20 || cargaHoraria > 40) {
            JOptionPane.showMessageDialog(null, "Carga horaria mínima de 20hrs e máxima de 40hrs!");
            return;
        }
        
        ClassCurso clscurso = new ClassCurso();
        CursoDAO dao = new CursoDAO();
        clscurso.setDescricao(edt_Desc.getText());
        clscurso.setDuracao(Double.parseDouble(edt_Dur.getText()));
        clscurso.setQtd_aluno(Integer.parseInt(edt_QtdAluno.getText()));
        clscurso.setCarga_hr(Double.parseDouble(edt_CargaHr.getText()));
        
        clscurso.setPeriodo(cb_Periodo.getSelectedItem()+"");
        
        ClassProfessor professor = (ClassProfessor) cb_Instrutor.getSelectedItem();
        
        int idProf = professor.getCodigo();
        
        clscurso.setProfessor(idProf);
         
        try {
            dao.create(clscurso);
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
        verificaEdts();
        if (TabCurso.getSelectedRow() != -1){
            
        ClassCurso clscurso = new ClassCurso();
        CursoDAO dao = new CursoDAO();
        clscurso.setDescricao(edt_Desc.getText());
        clscurso.setDuracao(Double.parseDouble(edt_Dur.getText()));
        clscurso.setQtd_aluno(Integer.parseInt(edt_QtdAluno.getText()));
        clscurso.setCarga_hr(Double.parseDouble(edt_CargaHr.getText()));
        clscurso.setPeriodo(cb_Periodo.getSelectedItem()+"");
        
        ClassProfessor professor = (ClassProfessor) cb_Instrutor.getSelectedItem();
        
        int id = professor.getCodigo();
        clscurso.setProfessor(id);
        
        clscurso.setCodigo((int) TabCurso.getValueAt(TabCurso.getSelectedRow(), 0));
        try {
            dao.update(clscurso);
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
        if (TabCurso.getSelectedRow() != -1){
            
        ClassCurso c = new ClassCurso();
        CursoDAO dao = new CursoDAO();
        c.setCodigo((int) TabCurso.getValueAt(TabCurso.getSelectedRow(), 0));
            try {
                dao.delete(c);
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

    private void TabCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabCursoMouseClicked
         // TODO add your handling code here:
         charge();
    }//GEN-LAST:event_TabCursoMouseClicked

    private void TabCursoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabCursoKeyReleased
        // TODO add your handling code here:
        charge();
    }//GEN-LAST:event_TabCursoKeyReleased

    public JTable getTabCurso() {
        return TabCurso;
    }

    public void setTabCurso(JTable TabCurso) {
        this.TabCurso = TabCurso;
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
            java.util.logging.Logger.getLogger(Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Curso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Curso().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabCurso;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_Instrutor;
    private javax.swing.JComboBox<String> cb_Periodo;
    private javax.swing.JTextField edt_CargaHr;
    private javax.swing.JTextField edt_Desc;
    private javax.swing.JTextField edt_Dur;
    private javax.swing.JTextField edt_QtdAluno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbl_Desc;
    private javax.swing.JLabel jlbl_Desc1;
    private javax.swing.JLabel jlbl_Desc2;
    private javax.swing.JLabel jlbl_Desc3;
    private javax.swing.JLabel jlbl_Desc4;
    private javax.swing.JLabel jlbl_Desc5;
    // End of variables declaration//GEN-END:variables

    private void verificaEdts() {
        
        if (edt_Desc.getText()==null){
            JOptionPane.showMessageDialog(null, "Favor informar a descrição");
            return;
        }else if(edt_Dur.getText()==null){
            JOptionPane.showMessageDialog(null, "Favor informar a duração");
            return;
        }else if(edt_CargaHr.getText()==null){
            JOptionPane.showMessageDialog(null, "Favor informar a carga horária");
            return;
        }else if(edt_QtdAluno.getText()==null){
            JOptionPane.showMessageDialog(null, "Favor informar a quantidade de alunos");
            return;
        }
        
        if ("--".equals(cb_Periodo.getSelectedItem()+"")){
          JOptionPane.showMessageDialog(null, "Favor informar o periodo da disciplina");
          return;
        }
        
        if ("--".equals(cb_Instrutor.getSelectedItem()+"")){
          JOptionPane.showMessageDialog(null, "Favor informar professor responsável");
          return;
        }
    }
}
