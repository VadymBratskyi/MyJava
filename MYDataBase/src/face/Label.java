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
public class Label extends JLabel{

    public Label(int x, int y, int width, int height, String title) {
    super.setText(title);
    super.setBounds(x, y, width, height);
    super.setForeground(Color.RED);
    super.setFont(new Font("Times New Roman", Font.BOLD, 15));
    }
    
}
