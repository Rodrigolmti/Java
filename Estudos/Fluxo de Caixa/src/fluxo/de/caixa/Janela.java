/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluxo.de.caixa;

import utilitarios.LtpUtil;

/**
 *
 * @author Rodrigo lopes martins (lmti)
 * Esta classe e responsavel por receber os valores dos TextField e validar
 * caso forem validos, seram passados para a classe Grafico
 */
public class Janela extends javax.swing.JFrame {

    /**
     * Creates new form Janela
     */
    public Janela() {
        initComponents();
        lbl_mgmErroData.setVisible(false);
        lbl_mgsErroValor.setVisible(false);
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
        lbl_data1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_data2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbl_valor2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbl_valor1 = new javax.swing.JTextField();
        btn_gerar = new javax.swing.JButton();
        lbl_mgsErroValor = new javax.swing.JLabel();
        lbl_mgmErroData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_data1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_data1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Informe a data1");

        jLabel2.setText("Informe a data2");

        jLabel4.setText("Informe o valor 2");

        jLabel3.setText("Informe o valor 1");

        lbl_valor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_valor1ActionPerformed(evt);
            }
        });

        btn_gerar.setText("Gerar");
        btn_gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerarActionPerformed(evt);
            }
        });

        lbl_mgsErroValor.setText("Verifique o valor");

        lbl_mgmErroData.setBackground(new java.awt.Color(178, 34, 34));
        lbl_mgmErroData.setText("Verifique a data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_data1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_data2, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_valor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_valor1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btn_gerar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_mgmErroData)
                        .addGap(96, 96, 96)
                        .addComponent(lbl_mgsErroValor)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_data1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_valor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_data2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_valor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_mgmErroData)
                    .addComponent(lbl_mgsErroValor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btn_gerar)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_gerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerarActionPerformed

        boolean valid = false;

        if(lbl_data1.getText().isEmpty() || lbl_data2.getText().isEmpty()){
            lbl_mgmErroData.setVisible(true);
        } else {
            valid = true;
            lbl_mgmErroData.setVisible(false);
        }

        if(lbl_valor1.getText().isEmpty() || lbl_valor2.getText().isEmpty()) {
            lbl_mgsErroValor.setVisible(true);
        } else {
            valid = true;
            lbl_mgsErroValor.setVisible(false);
        }

        if(valid == true) {
            //Conversoes para validacoes de + e -
            String data1 = String.valueOf(lbl_data1.getText());
            String dia1 = data1.substring(0,2);
            int diaAux1 = Integer.parseInt(dia1);
            String mes1 = data1.substring(3,5);
            int mesAux1 = Integer.parseInt(mes1);
            String ano1 = data1.substring(6,10);
            int anoAux1 = Integer.parseInt(ano1);
            
            String data2 = String.valueOf(lbl_data2.getText());
            String dia2 = data2.substring(0,2);
            int diaAux2 = Integer.parseInt(dia2);
            String mes2 = data2.substring(3,5);
            int mesAux2 = Integer.parseInt(mes2);
            String ano2 = data2.substring(6,10);
            int anoAux2 = Integer.parseInt(ano2);
            
            String valor1 = String.valueOf(lbl_valor1.getText());
            String valor2 = String.valueOf(lbl_valor2.getText());
            
            String a,b;
            boolean valida = false;
            a = valor1.substring(0,1);
            b = valor2.substring(0,1);
            
            double auxValor1 = Double.parseDouble(valor1);
            double auxValor2 = Double.parseDouble(valor2);
            
            if(a.equals("-") && b.equals("-")) {//Acerta os valores caso a e b serem negativos
                auxValor2 = auxValor2 + auxValor1;
                valida = true;
            }
            
            if(valida == false) {//Restringe caso ja tenha passado no a e b
                if(b.equals("-")) {
                   auxValor2 = auxValor2 + auxValor1;
                }
                if(a.equals("-")) {
                   auxValor2 = auxValor1 + auxValor2;
                }
            }

            Grafico grafico = new Grafico(diaAux1,mesAux1,anoAux1,
                    diaAux2,mesAux2,anoAux2, auxValor1,auxValor2);
        }
    }//GEN-LAST:event_btn_gerarActionPerformed

    private void lbl_valor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_valor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_valor1ActionPerformed

    private void lbl_data1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_data1ActionPerformed

    }//GEN-LAST:event_lbl_data1ActionPerformed

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
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_gerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lbl_data1;
    private javax.swing.JTextField lbl_data2;
    private javax.swing.JLabel lbl_mgmErroData;
    private javax.swing.JLabel lbl_mgsErroValor;
    private javax.swing.JTextField lbl_valor1;
    private javax.swing.JTextField lbl_valor2;
    // End of variables declaration//GEN-END:variables
}
