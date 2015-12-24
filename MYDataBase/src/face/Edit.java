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
public class Edit extends JTextField{

    public Edit(int width, int height) 
    {
        super.setPreferredSize(new Dimension(width, height));
    }
    
    public Edit(int x, int y, int width, int height) 
    {
        super.setBounds(x, y, width, height);
    }
    
}
