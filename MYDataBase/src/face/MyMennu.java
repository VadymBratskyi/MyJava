/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package face;

import active.ChangeSkin;
import active.OpenFile;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

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
public class MyMennu extends JMenuBar{

    private Form form;
    private Panel pan;
    private Button bt;
    private Edit edit1;
    private RadioButton rbt1;
    private RadioButton rbt2;
    private RadioButton rbt3;
    private RadioButton rbt4;
	
    public MyMennu(Form form, Edit edit1) {
       this.form=form;
       this.edit1=edit1;
    }
        
    public void creatMenu()
	{
		JMenu men = new JMenu("Files");		
		JMenuItem newDB = new JMenuItem("New Database");
                JMenuItem opDB = new JMenuItem("Open Database");
                JMenuItem ex = new JMenuItem("Exit");
		men.add(newDB);
		men.add(opDB);
                men.addSeparator();
		men.add(ex);
                super.add(men);
                
		JMenu ed = new JMenu("Edit");
                JMenu st = new JMenu("Change Style");		
                JMenuItem sty1 = new JMenuItem("Style 1");
                JMenuItem sty2 = new JMenuItem("Style 2");
                JMenuItem sty3 = new JMenuItem("Style 3");
                JMenuItem sty4 = new JMenuItem("Style 4");
                JMenuItem sty5 = new JMenuItem("Style 5");
                JMenuItem sty6 = new JMenuItem("Default");
                st.add(sty1);
                st.add(sty2);
                st.add(sty3);
                st.add(sty4);
                st.add(sty5);
                st.addSeparator();
                st.add(sty6);
                ed.add(st);                		
		super.add(ed);	
		
		JMenu hl= new JMenu("Help");
                JMenuItem inf = new JMenuItem("About programs");
                JMenuItem pro = new JMenuItem("Propertis");
                hl.add(inf);
		hl.add(pro);
		super.add(hl);			
		
		
		sty1.addActionListener(new ChangeSkin(new McWinLookAndFeel(), form));
		sty2.addActionListener(new ChangeSkin(new LunaLookAndFeel(), form));
		sty3.addActionListener(new ChangeSkin(new TextureLookAndFeel(), form));
		sty4.addActionListener(new ChangeSkin(new AluminiumLookAndFeel(), form));
                sty5.addActionListener(new ChangeSkin(new MintLookAndFeel(), form));
                sty6.addActionListener(new ChangeSkin(new AcrylLookAndFeel(), form));                
                opDB.addActionListener(new OpenFile(form,edit1));
                
                ex.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.exit(0);
                    }
                });
                
                newDB.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        pan = new Panel(380, 130, "Select database", new FlowLayout());
                        bt = new Button("Create a selected database", 200, 25);
                        rbt1 = new RadioButton("Microsoft Office Access");
                        rbt2 = new RadioButton("MS SQL Server 2008/2010");
                        rbt3 = new RadioButton("SQLite");
                        rbt4 = new RadioButton("Oracle");                        
                        JFrame fr3 = new JFrame("NEW Database");
                        fr3.setSize(400, 200);
                        form.setEnabled(false);
                        ButtonGroup gr = new ButtonGroup();
                        gr.add(rbt1);
                        gr.add(rbt2);
                        gr.add(rbt3);
                        gr.add(rbt4);
                        pan.add(rbt1);
                        pan.add(rbt2);
                        pan.add(rbt3);
                        pan.add(rbt4);
                        fr3.setLocationRelativeTo(null);
                        fr3.setLayout(new FlowLayout());
                        fr3.getContentPane().add(pan);
                        fr3.getContentPane().add(bt);
                        fr3.setVisible(true);
                        fr3.addWindowListener(new WindowAdapter() {

                            @Override
                            public void windowClosing(WindowEvent we) {
                               form.setEnabled(true);
                            }                            
                        });
                    }
                });
	}
    
}
