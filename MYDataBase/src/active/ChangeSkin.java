/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package active;

import face.Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Vadym
 */
public class ChangeSkin implements ActionListener{

    private LookAndFeel look;
    private Form form;

    public ChangeSkin(LookAndFeel look, Form form) {
        this.look = look;
        this.form = form;
    } 

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
			UIManager.setLookAndFeel(look);
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SwingUtilities.updateComponentTreeUI(form);              
    }
    
}
