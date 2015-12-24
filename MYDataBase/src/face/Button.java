/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package face;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Vadym
 */
public class Button extends JButton{

    public Button(String name, int width, int height) {
        super.setText(name);
        super.setPreferredSize(new Dimension(width, height));
    }  

    public Button(String name, int width, int height, int x, int y) {
        super.setText(name);
        super.setBounds(x, y, width, height);
    }
    
    
}
