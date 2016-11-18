package util;

import javax.swing.JOptionPane;
import model.MessagingError;

/**
 *
 * @author Amanda Nunes / Rodrigo Lopes
 */
public class Alert {

    /**
     * Show Alert simple method to show a alert to warning the user 
     * @param message
     */
    public static void showAlert(String message) {

        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Show Error Alert show a alert with error messages to user
     * @param error
     */
    public static void showErrorAlert(MessagingError error) {

        JOptionPane.showMessageDialog(null, "Error message: " + error.getMessage() + "\n "
                + "Error location: " + error.getLocalizedError() + "\n"
                + "Contact the administrator for more informations!");
    }
}
