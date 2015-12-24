/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JButton;

/**
 *
 * @author Вадим
 */
public class But extends JButton {

    

    public But(String txt, int x, int y, int width, int height) {
        super.setText(txt);
        super.setBounds(new Rectangle(x, y, width, height));
    }

    public But(String txt, int x, int y, int width, int height, Color col) {
        super.setText(txt);
        super.setBounds(new Rectangle(x, y, width, height));
        Font fon = new Font("Times New Roman", Font.BOLD, 15);
        super.setFont(fon);
        super.setForeground(col);
    }
}
