/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package face;

import javax.swing.*;

/**
 *
 * @author Vadym
 */
public class ComboBox extends JComboBox<String>{

    public ComboBox(int x, int y, int width, int height) 
    {
        super.setBounds(x, y, width, height);
    }
}
