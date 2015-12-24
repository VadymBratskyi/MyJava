/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TexttPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.text.Document;
/**
 *
 * @author Вадим
 */
public class Text extends JTextField{

    public Text() {
    }

    
    
    public Text(String txt, int columns) {
        super.setColumns(columns);
        super.setText(txt); 
        Font fn = new Font("Times New Roman", Font.PLAIN, 28);
        super.setFont(fn);
        super.setBounds(new Rectangle(4, 4, 290, 40));
    }

  

   
    
    
    
    
    
}
