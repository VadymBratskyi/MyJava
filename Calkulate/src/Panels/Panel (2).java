/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
/**
 *
 * @author Вадим
 */
public class Panel extends JPanel{

    public Panel() {
    }

    
    
    
    public Panel(String name,int x,int y, int width, int height) {
        super.setBounds(new Rectangle(x, y, width, height));
        super.setBorder(BorderFactory.createEtchedBorder()); 
        super.setName(name);
        super.setLayout(null);
    }

    public Panel(int x,int y, int width, int height) {
        super.setBounds(new Rectangle(x, y, width, height));
        super.setLayout(null);
    }
    
    
    
}
