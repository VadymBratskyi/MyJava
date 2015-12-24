/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calkulate;

import Button.But;
import Lister.ListersActiv;
import Panels.Panel;
import Rosch.Schet;
import TexttPanel.Text;
import com.jtattoo.plaf.AbstractLookAndFeel;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 *
 * @author Вадим
 */
public class Calkulate {

    private double a = 0.0;
    private double b = 0.0;
    private String ch;
    private Text txt;
    private Panel panel1;
    private Panel panel2;
    private Panel panel3;
    private But button0;
    private But button1;
    private But button2;
    private But button3;
    private But button4;
    private But button5;
    private But button6;
    private But button7;
    private But button8;
    private But button9;
    private But butpl;
    private But butmi;
    private But butmn;
    private But butdil;
    private But buttoch;
    private But butproc;
    private But butcor;
    private But butstep;
    private But butrez;
    private But butC;
    private But butC2;
    private But skin;
    private JFrame frame;
    private LookAndFeel fil;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
              
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calkulate.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFrame.setDefaultLookAndFeelDecorated(true);
        
        Calkulate calk = new Calkulate();
    
        calk.creatText();
        calk.creatButton();
        calk.procBut();
        calk.creatPanel();
        calk.creatFrame();
        

    }

    //<editor-fold defaultstate="collapsed" desc="Components">
       public void procBut() {
        button0.addActionListener(new Listern());
        button1.addActionListener(new Listern());
        button2.addActionListener(new Listern());
        button3.addActionListener(new Listern());
        button4.addActionListener(new Listern());
        button5.addActionListener(new Listern());
        button6.addActionListener(new Listern());
        button7.addActionListener(new Listern());
        button8.addActionListener(new Listern());
        button9.addActionListener(new Listern());
        buttoch.addActionListener(new Listern());
       
        
        butpl.addActionListener(new Rozrah());
        butmi.addActionListener(new Rozrah());
        butmn.addActionListener(new Rozrah());
        butdil.addActionListener(new Rozrah());
        butproc.addActionListener(new ObrahKV());
        butcor.addActionListener(new ObrahKV());
        butstep.addActionListener(new Rozrah());
        
        butrez.addActionListener(new Vidpov());
   }
       
    private void creatButton() {

        button0 = new But("0", 65, 200, 55, 60);
        button1 = new But("1", 5, 5, 55, 60);
        button2 = new But("2", 65, 5, 55, 60);
        button3 = new But("3", 125, 5, 55, 60);

        button4 = new But("4", 5, 70, 55, 60);
        button5 = new But("5", 65, 70, 55, 60);
        button6 = new But("6", 125, 70, 55, 60);

        button7 = new But("7", 5, 135, 55, 60);
        button8 = new But("8", 65, 135, 55, 60);
        button9 = new But("9", 125, 135, 55, 60);

        butC2 = new But("←", 190, 5, 50, 60, Color.RED);
        //<editor-fold defaultstate="collapsed" desc="Действие Кнопка С2">
        butC2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txt.getText().trim().equals("")) {
                    txt.setText("");
                    return;
                } else {
                    String tmp = txt.getText();
                    txt.setText(tmp.substring(0, tmp.length()-1));
                }
                
            }
        });
        //</editor-fold>
        butC = new But("C", 245, 5, 50, 60, Color.RED);
        //<editor-fold defaultstate="collapsed" desc="Действие копки С">
        butC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt.setText("");
                return;
            }
        });
        //</editor-fold>
        butpl = new But("+", 190, 135, 50, 60, Color.RED);
        butmi = new But("-", 245, 135, 50, 60, Color.RED);
        butmn = new But("*", 190, 200, 50, 60, Color.RED);
        butdil = new But("/", 245, 200, 50, 60, Color.RED);
        buttoch = new But(".", 5, 200, 55, 60);
        butproc = new But("%", 125, 200, 55, 60, Color.RED);
        butcor = new But("√", 190, 70, 50, 60, Color.RED);
        butstep = new But("^", 245, 70, 50, 60, Color.RED);
        butrez = new But("=", 5, 5, 175, 30, Color.RED);
        skin = new But("skin", 190, 5, 108, 30, Color.RED);
      
        skin.addActionListener(new ActionListener() {

            
            @Override
            public void actionPerformed(ActionEvent e) {

          if(skin.getText().trim().equals("skin")){
             skin.setText("skin2");
                try {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calkulate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.updateComponentTreeUI(frame);
                
            } else 
              if(skin.getText().trim().equals("skin2")){
                    skin.setText("skin3");
                try {
            UIManager.setLookAndFeel(new HiFiLookAndFeel() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calkulate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.updateComponentTreeUI(frame);
            
            } else 
                if(skin.getText().trim().equals("skin3")){
            skin.setText("skin");
                try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calkulate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.updateComponentTreeUI(frame); 
   
            }
            }
            
        });

            
            
            
        
            }       

    private void creatText() {
        txt = new Text(null, 10);

        txt.setEditable(false);
        txt.setFocusable(false);
    }

    private void creatPanel() {
        panel1 = new Panel("panel1", 4, 4, 300, 50);
        panel1.setLayout(null);
        panel1.add(txt);

        panel2 = new Panel("panel2", 4, 60, 300, 270);
        panel2.setLayout(null);

        panel3 = new Panel(4, 332, 300, 35);
        panel3.setLayout(null);

        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(butcor);
        panel2.add(butstep);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(butpl);
        panel2.add(butmi);
        panel2.add(button7);
        panel2.add(button8);
        panel2.add(button9);
        panel2.add(buttoch);
        panel2.add(button0);
        panel2.add(butproc);
        panel2.add(butdil);
        panel2.add(butmn);
        panel2.add(butC2);
        panel2.add(butC);
        panel3.add(butrez);
        panel3.add(skin);

    }

    private void creatFrame() {

        frame = new JFrame("Калькулятор");
        frame.setIconImage(new ImageIcon("image\\calculator.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 150, 317, 400);
        frame.setVisible(true);
        frame.setLayout(null);

        frame.getContentPane().add(panel1);
        frame.getContentPane().add(panel2);
        frame.getContentPane().add(panel3);

        frame.setResizable(false);
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Listener">
    class Listern implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!(e.getSource() instanceof JButton)) {
                return;
            }

            JButton btn = (JButton) e.getSource();
             txt.setText(txt.getText() + btn.getText());
            
        }
    }

    class Rozrah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!(e.getSource() instanceof JButton)) {
                return;
            }

            JButton bt = (JButton) e.getSource();

            if (!(txt.getText().trim().equals(""))) {
                a = Double.parseDouble(txt.getText());
                txt.setText("");
                ch = bt.getText();
            } else {
                txt.setText("");
                return;
            }

        }
    }

    class Vidpov implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!(e.getSource() instanceof JButton)) {
                return;
            }

            if(a!=0.0 && !txt.getText().trim().equals("")){
            
            b = Double.parseDouble(txt.getText());
            
            if (ch.trim().equals("+")) {
                txt.setText(String.valueOf(Schet.sum(a, b)));
            } else if (ch.trim().equals("-")) {
                txt.setText(String.valueOf(Schet.substract(a, b)));
            } else if (ch.trim().equals("*")) {
                txt.setText(String.valueOf(Schet.multiply(a, b)));
            } else if (ch.trim().equals("/")) {
                txt.setText(String.valueOf(Schet.divade(a, b)));
            } else if (ch.trim().equals("^")) {
                txt.setText(String.valueOf(Schet.step(a, b)));
            }else{
                
                txt.setText("");
                 return;  
            }  
            
        }
    }
    }

    class ObrahKV implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!(e.getSource() instanceof JButton)) {
                return;
            }

            JButton bt = (JButton) e.getSource();
           
            if(!(txt.getText().trim().equals(""))){  
            a = Double.parseDouble(txt.getText());
            ch = bt.getText();
            
                      
             if (ch.trim().equals("√")) {
                txt.setText(String.valueOf(Schet.kor(a)));            
            }else if (ch.trim().equals("%")) {
                txt.setText(String.valueOf(Schet.proc(a)));
            } 
            }else{
                txt.setText("");
                return;
            }

        }
    }
    }


     
        
    
    
//</editor-fold>

