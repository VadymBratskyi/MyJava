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
public class Form extends JFrame{

    public Form(String name,Edit edit) {
        
        MyMennu men = new MyMennu(this,edit);
        men.creatMenu();
        super.setTitle(name);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(700, 500);
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon("D:\\Програми\\ICON\\png\\dbb.png").getImage());
        super.setLayout(new FlowLayout(0,5,10));
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setBackground(Color.GRAY);
        super.setJMenuBar(men);
        //super.setResizable(false);
        super.setVisible(true);
        
    }        
}
