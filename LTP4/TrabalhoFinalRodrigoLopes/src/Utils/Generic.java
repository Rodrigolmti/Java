/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */
public class Generic {
    
    //Methods generic
    
    public static Object returnObject(Object obj) {
        return obj;
    }
    
    public static boolean verifyObject(Object obj) {

        if (obj != null) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Objeto não instanciado / selecione um veiculo!");
        return false;
    }
}
