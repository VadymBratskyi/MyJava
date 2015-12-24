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
public class Panel extends JPanel{

    public Panel(int width, int height, String name, LayoutManager men) {
        super.setPreferredSize(new Dimension(width,height));
        super.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black),name));
        super.setLayout(men);
    }    
}
