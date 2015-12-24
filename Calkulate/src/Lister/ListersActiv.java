/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lister;

import Panels.Panel;
import TexttPanel.Text;
import calkulate.Calkulate;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Вадим
 */
public class ListersActiv implements ActionListener {
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) {
            return;
        }
        
        JButton btn = (JButton) e.getSource();
        Text tx = new Text();
        tx.setText(btn.getText());
        
        
    }
    
    
}
