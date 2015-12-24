/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package active;

import face.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Vadym
 */
public class OpenFile implements ActionListener {

    private Form form;
    private Panel pan;
    private Panel pan1;
    private Button bt;
    private Edit edit1;
    private RadioButton rbt1;
    private RadioButton rbt2;
    private RadioButton rbt3;
    private RadioButton rbt4;
    private Label lb1;
    private Label lb2;
    private Label lb3;
    private Edit ed1;
    private Edit ed2;
    private Edit ed3;
    private JFrame fr3;
    
    public OpenFile(Form form, Edit edit1) {
        this.form = form;
        this.edit1 = edit1;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        fr3 = new JFrame("Open Database");
        fr3.setSize(400, 200);
        form.setEnabled(false);        
        pan = new Panel(380, 130, "Select database", new FlowLayout());
        pan1 = new Panel(380, 130, "Add parameters for Oracle database", new FlowLayout());
        pan1.setLayout(null);
        pan1.setVisible(false);
        
        lb1 = new Label(20, 20, 100, 20, "URL: ");
        lb2 = new Label(50,50, 100, 20, "User Name: ");
        lb3 = new Label(60,80, 100, 20, "Password: ");
        
        ed1 = new Edit(70, 20, 250, 20);
        ed2 = new Edit(140, 50, 150, 20);
        ed3 = new Edit(140, 80, 150, 20);
        
        pan1.add(lb1);
        pan1.add(lb2);
        pan1.add(lb3);
        
        pan1.add(ed1);
        pan1.add(ed2);
        pan1.add(ed3);
        
        bt = new Button("Open database", 200, 25);
        
        rbt1 = new RadioButton("Microsoft Office Access");
        rbt2 = new RadioButton("MS SQL Server 2008/2010");
        rbt3 = new RadioButton("SQLite");
        rbt4 = new RadioButton("Oracle");
        
         //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(rbt1);
        group.add(rbt2);
        group.add(rbt3);
        group.add(rbt4);        
        
        
        pan.add(rbt1);
        pan.add(rbt2);
        pan.add(rbt3);
        pan.add(rbt4);
        
        bt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               if(rbt3.isSelected())
               {
                   SqliteFile();
               }else if(rbt4.isSelected())
               {
                   OrclFile();
               }
            }
        });
        
        
        fr3.setLocationRelativeTo(null);
        fr3.setLayout(new FlowLayout());
        fr3.getContentPane().add(pan);
        fr3.getContentPane().add(pan1);
        fr3.getContentPane().add(bt);

        rbt1.addActionListener(new select());
        rbt2.addActionListener(new select());
        rbt3.addActionListener(new select());
        rbt4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pan1.setVisible(true);
                fr3.setSize(400, 335); 
            }
        });
            
        
        
        fr3.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                form.setEnabled(true);
            }
        });

        fr3.setVisible(true);

    }

    private void SqliteFile() {
        Chooser ch = new Chooser(edit1);
        ch.Open();
        form.setEnabled(true);
        fr3.setVisible(false);
    }

 
    private void OrclFile()
    {
        edit1.setText(ed1.getText());
        Action.UsName=ed2.getText();
        Action.password=ed3.getText();
    }
    
    
 /*class CustomListener implements FocusListener{
   
     @Override
     public void focusLost(FocusEvent e) {
         System.out.println(e);       
         pan1.setVisible(false);
         fr3.setSize(400, 200);
          }        

        @Override
        public void focusGained(FocusEvent fe) {
                pan1.setVisible(true);
                fr3.setSize(400, 335);                
        }
     }*/
 
    public class select implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           pan1.setVisible(false);
           fr3.setSize(400, 200);
        }
    }
    
  
 }