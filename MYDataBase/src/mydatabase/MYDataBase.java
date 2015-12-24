/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mydatabase;

import active.Action;
import active.MousAc;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import face.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import static mydatabase.SQLConnectionSQLIte.conn;

/**
 *
 * @author Vadym
 */
public class MYDataBase {

    public static Form fr1;
    
    private Panel pn1;
    private Panel pn2;
    public static Panel pn3;
    
    private Edit ed1;
    private ComboBox cb1;
    private Table tb;
    private JScrollPane scr;
 
    private Button bt1;
    private Button bt2;
    private Button bt3;
    private Button bt4;
    private Button bt5;
    private Button bt6;
    private Button bt7;
    private Button bt8;
    private Button bt9;
    private Button bt10;
    private Button bt11;
    private Button bt12;
    private Button bt13;
    private Label lb1;
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        
        try {
	UIManager.setLookAndFeel(new AcrylLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
           e.printStackTrace();
	}
        
	JFrame.setDefaultLookAndFeelDecorated(true);      

        MYDataBase db = new MYDataBase();  
        
            db.creatCombo();
            db.creatTable();
            db.creatScrolPan();
            db.creatLabel();            
            db.creatEdit();
            db.creatButt();
            db.creatPan();
            db.creatForm();
        }

    private void action()
    {
        bt1.addActionListener(new Action(cb1,lb1,bt1,tb));
        bt2.addActionListener(new Action(ed1,cb1,lb1,bt2));
        bt3.addActionListener(new Action(cb1,lb1,bt3,tb));
        bt4.addActionListener(new Action(cb1, lb1, bt4,tb));
        bt5.addActionListener(new Action(cb1, lb1, bt5,tb));
        bt6.addActionListener(new Action(cb1, lb1, bt6,tb));    
        bt7.addActionListener(new Action(cb1, lb1, bt7,tb)); 
        bt8.addActionListener(new Action(cb1, lb1, bt8,tb)); 
        bt9.addActionListener(new Action(cb1, lb1, bt9,tb)); 
        bt10.addActionListener(new Action(cb1, lb1, bt10,tb));
        bt11.addActionListener(new Action(cb1,lb1,bt11,tb));
        bt12.addActionListener(new Action(cb1, lb1, bt12,tb));
        bt13.addActionListener(new Action(cb1, lb1, bt13,tb));
    }
    
    private void creatTable()
    {
        tb = new Table();  
        tb.addMouseListener(new MousAc());
    }
    
    private void creatScrolPan()
    {
        scr = new JScrollPane(tb); 
        scr.setPreferredSize(new Dimension(1300,300));
    }
    
    private void creatCombo()
    {
        cb1 = new ComboBox(350, 80, 200, 20);
    }
    
    private void creatLabel()
    {
        lb1 = new Label(900, 80, 200,25, null);
    }
    
    private void creatButt()
    {   
        bt1 = new Button("ADD2", 100, 20);
        bt2 = new Button("Connect", 100, 20,450,30);
        bt3 = new Button("Load Table", 100, 20, 200, 70);
        bt4 = new Button("ADD", 100, 20);
        bt5 = new Button("DELETE", 100, 20);
        bt6 = new Button("UPDATE", 100, 20);
        bt7 = new Button("SEARCH", 100, 20);        
        bt8 = new Button("COUNT ROWS", 120, 20);
        bt9 = new Button("SQL", 100, 20);
        bt10 = new Button("Replace fk_id", 100, 20);
        bt11 = new Button("Load Table_2", 100, 20, 200, 95);
        bt12 = new Button("SEARCH_2", 100, 20);
        bt13 = new Button("Replace fk_id search", 150, 20);
        action();
    }
   
    
    private void creatEdit()
    {
        ed1 = new Edit(200,30,240, 20);
    }
    
    private void creatPan()
    {
        pn1 = new Panel(1350, 150, "Choose and connect to DATABASE", null);
        pn1.add(ed1);
        pn1.add(bt2);
        pn1.add(bt3);
        pn1.add(cb1);
        pn1.add(lb1);
        pn1.add(bt11);
        pn2 = new Panel(1350, 70, "Function of DATABASE",new FlowLayout());
        pn2.add(bt1);
        pn2.add(bt4);
        pn2.add(bt5);
        pn2.add(bt6);
        pn2.add(bt7);        
        pn2.add(bt12);
        pn2.add(bt13); 
        pn2.add(bt8);
        pn2.add(bt9);
        pn2.add(bt10); 
        pn3 = new Panel(1350, 370, "TABLE",new FlowLayout()); 
        pn3.add(scr);
    }    
    
    private void creatForm()
    {
        
        fr1 = new Form("Database",ed1);    
        fr1.getContentPane().add(pn1);
        fr1.getContentPane().add(pn2);
        fr1.getContentPane().add(pn3); 
        
        fr1.addWindowStateListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent we) {
                if(conn!=null)
                {
                    try
                    {
                        conn.close();
                    }
                    catch(SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}

