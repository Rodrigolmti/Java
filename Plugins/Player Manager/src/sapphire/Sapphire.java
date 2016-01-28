/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sapphire;

import dataBase.connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.home;

/**
 *
 * @author macbookpro
 */
public class Sapphire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
  
            new home().setVisible(true);
            connection connect = new connection();
            connect.createConnection();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException | SQLException e) {
            
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(1);
        }

        
    }
    
}
