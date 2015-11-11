/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static Controller.ControllerPayment.deletePaymentCtr;
import static Controller.ControllerPayment.insertPaymentCtr;
import static Controller.ControllerPayment.paymentReturnWithCodeObjectCtr;
import static Controller.ControllerPayment.returnAllPaymentCtr;
import static Controller.ControllerPayment.searchPaymentWithCodeMonthCtr;
import static Controller.ControllerPayment.searchPaymentWithCodePaymentCtr;
import static Controller.ControllerPayment.searchPaymentWithCodeSalariedCtr;
import static Controller.ControllerPayment.updatePaymentCtr;
import static Controller.ControllerSalaried.salariedReturnObjectWithCodeCtr;
import static Controller.ControllerSalaried.searchSalariedCodeCtr;
import static Utils.Generic.verifyObject;
import static database.SalariedSQL.cosultSalariedCode;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Parking;
import model.Payment;
import model.Salaried;
import utilitarios.LtpUtil;
import utilitarios.LtpUtilException;
import static view.ParkingRegister.returnObject;

/**
 *
 * @author rodrigo.martins
 */
public class SalariedPayment extends javax.swing.JFrame {

    Salaried sal;
    Payment payment;
    Parking park = returnObject();

    /**
     * Creates new form SalariedPayment
     */
    public SalariedPayment() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        showAllPayments();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        URL url = this.getClass().getResource("/images/Parking-32.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JtextCodeSalaried = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMonth = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldYear = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValue = new javax.swing.JTextField();
        jBtnClearFields = new javax.swing.JButton();
        jBtnEditPayment = new javax.swing.JButton();
        jBtnRegister = new javax.swing.JButton();
        jBtnSearchPayment = new javax.swing.JButton();
        jBtnRemovePayment = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sign = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextCodePayment = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Codigo Mensalista:");

        jLabel2.setText("Mês:");

        jLabel3.setText("Ano:");

        jLabel4.setText("Data do Pagamento:");

        jLabel5.setText("Valor:");

        jTextFieldValue.setEditable(false);

        jBtnClearFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eraser-24.png"))); // NOI18N
        jBtnClearFields.setText("Limpar e Refazer");
        jBtnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearFieldsActionPerformed(evt);
            }
        });

        jBtnEditPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Process-24.png"))); // NOI18N
        jBtnEditPayment.setText("Atualizar Registros");
        jBtnEditPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditPaymentActionPerformed(evt);
            }
        });

        jBtnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Plus-24.png"))); // NOI18N
        jBtnRegister.setText("Registrar Pagamento");
        jBtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegisterActionPerformed(evt);
            }
        });

        jBtnSearchPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search-24.png"))); // NOI18N
        jBtnSearchPayment.setText("Pesquisar");
        jBtnSearchPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchPaymentActionPerformed(evt);
            }
        });

        jBtnRemovePayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete-24.png"))); // NOI18N
        jBtnRemovePayment.setText("Remover");
        jBtnRemovePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemovePaymentActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Contact Card-25.png"))); // NOI18N
        jLabel6.setText("Mensalista:");

        jLabel7.setText("Nome:");

        jLabel9.setText("Telefone:");

        jLabel11.setText("Placa:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(sign, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sign, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(phone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, jLabel6, jLabel7, jLabel9, name, phone, sign});

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search-24.png"))); // NOI18N
        jLabel8.setText("Codigo:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1447229279_dollar.png"))); // NOI18N
        jLabel10.setText("Pagamento de Mensalidades");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info-24.png"))); // NOI18N
        jLabel12.setText("Utilize o campo \"Codigo\" apenas para pesquisas!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnClearFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnEditPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSearchPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRemovePayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextCodePayment, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JtextCodeSalaried, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldValue, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextCodePayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(JtextCodeSalaried, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnClearFields)
                    .addComponent(jBtnEditPayment)
                    .addComponent(jBtnRegister)
                    .addComponent(jBtnSearchPayment)
                    .addComponent(jBtnRemovePayment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegisterActionPerformed

        try {

            int code = (Integer) Integer.parseInt(JtextCodeSalaried.getText());
            int month = (Integer) Integer.parseInt(jTextFieldMonth.getText());

            if (!searchPaymentWithCodeMonthCtr(code, month)) {

                if (cosultSalariedCode(code)) {

                    int year = (Integer) Integer.parseInt(jTextFieldYear.getText());

                    SimpleDateFormat formatDate = new SimpleDateFormat("dd/mm/yyyy");
                    java.util.Date invoiceDate = formatDate.parse(jTextFieldDate.getText());
                    Date sqlDate = new java.sql.Date(invoiceDate.getTime());

                    double price = park.getTarifa_por_mes();

                    payment = new Payment(0, code, month, year, sqlDate, price);

                    insertPaymentCtr(payment);
                    showAllPayments();
                    JOptionPane.showMessageDialog(this, "Pagamento efetuado!");
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum mensalista encontrado com este codigo!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "pagamento ja cadastrado para este mensalista!");
            }

        } catch (ParseException | SQLException ex) {
            Logger.getLogger(SalariedPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnRegisterActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.getSelectedRow();
        int codeSalaried = (Integer) Integer.parseInt((String) jTable1.getValueAt(row, 1));
        int codePayment = (Integer) Integer.parseInt((String) jTable1.getValueAt(row, 0));

        payment = paymentReturnWithCodeObjectCtr(codePayment);

        jTextCodePayment.setText(String.valueOf(payment.getNoPagto()));
        JtextCodeSalaried.setText(String.valueOf(payment.getCodigo()));
        jTextFieldMonth.setText(String.valueOf(payment.getMes_referencia()));
        jTextFieldYear.setText(String.valueOf(payment.getAno_referencia()));
        jTextFieldValue.setText(String.valueOf(payment.getValor()));
        jTextFieldDate.setText(String.valueOf(payment.getData_pagto()));

        sal = salariedReturnObjectWithCodeCtr(codeSalaried);

        name.setText(sal.getNome());
        phone.setText(sal.getTelefone());
        sign.setText(sal.getPlaca());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBtnEditPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditPaymentActionPerformed

        payment.setMes_referencia(Integer.parseInt(jTextFieldMonth.getText()));
        payment.setAno_referencia(Integer.parseInt(jTextFieldYear.getText()));

        updatePaymentCtr(payment);
        showAllPayments();
        JOptionPane.showMessageDialog(this, "Pagamento atualizado!");

    }//GEN-LAST:event_jBtnEditPaymentActionPerformed

    private void jBtnRemovePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemovePaymentActionPerformed

        int reply = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o pagamento?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            if (verifyObject(payment)) {

                int row = jTable1.getSelectedRow();
                int code = (Integer) Integer.parseInt((String) jTable1.getValueAt(row, 0));
                deletePaymentCtr(code);
                showAllPayments();
                JOptionPane.showMessageDialog(this, "Pagamento removido!");
            }
        }

    }//GEN-LAST:event_jBtnRemovePaymentActionPerformed

    private void jBtnSearchPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchPaymentActionPerformed

        if (!JtextCodeSalaried.getText().isEmpty() || !jTextCodePayment.getText().isEmpty()) {
            if (JtextCodeSalaried.getText().isEmpty() && !jTextCodePayment.getText().isEmpty()) {
            
                int code = (Integer) Integer.parseInt(jTextCodePayment.getText());

                    try {
                        ResultSet resp = (ResultSet) searchPaymentWithCodePaymentCtr(code);
                        LtpUtil.loadFormatJTable(jScrollPane1, resp);
                    } catch (SQLException | LtpUtilException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                
            } else {
                if(!JtextCodeSalaried.getText().isEmpty() && jTextCodePayment.getText().isEmpty()) {
                
                    int code = (Integer) Integer.parseInt(JtextCodeSalaried.getText());

                    try {
                        ResultSet resp = (ResultSet) searchPaymentWithCodeSalariedCtr(code);
                        LtpUtil.loadFormatJTable(jScrollPane1, resp);
                    } catch (SQLException | LtpUtilException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Informe apenas um campo!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inform o codigo do mensalista ou do pagamento!");
        }
    }//GEN-LAST:event_jBtnSearchPaymentActionPerformed

    private void jBtnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearFieldsActionPerformed
        clearFields();
    }//GEN-LAST:event_jBtnClearFieldsActionPerformed

    private void clearFields() {

        jTextCodePayment.setText("");
        JtextCodeSalaried.setText("");
        jTextFieldMonth.setText("");
        jTextFieldYear.setText("");
        jTextFieldValue.setText("");
        jTextFieldDate.setText("");
        showAllPayments();
        payment = null;
    }

    private void showAllPayments() {
        try {
            ResultSet resp = (ResultSet) returnAllPaymentCtr();
            LtpUtil.loadFormatJTable(jScrollPane1, resp);
        } catch (SQLException | LtpUtilException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
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
            java.util.logging.Logger.getLogger(SalariedPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalariedPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalariedPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalariedPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalariedPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtextCodeSalaried;
    private javax.swing.JButton jBtnClearFields;
    private javax.swing.JButton jBtnEditPayment;
    private javax.swing.JButton jBtnRegister;
    private javax.swing.JButton jBtnRemovePayment;
    private javax.swing.JButton jBtnSearchPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextCodePayment;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldMonth;
    private javax.swing.JTextField jTextFieldValue;
    private javax.swing.JTextField jTextFieldYear;
    private javax.swing.JLabel name;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel sign;
    // End of variables declaration//GEN-END:variables
}
