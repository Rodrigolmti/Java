package Controller;

import static database.ConnectionFactory.createConnection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.ParkingRegister;

public class Main {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            //new Splash().setVisible(true);
            createConnection();
            new ParkingRegister().setVisible(true);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException | SQLException e) {
            
            java.util.logging.Logger.getLogger(ParkingRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(1);
        }
    }

}
