package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

import work.ButtonClick;
import work.FocusText;
import work.ChangeSkin;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

import face.MyButton;
import face.MyForms;
import face.MyLabel;
import face.MyPanel;
import face.MyTextFild;

public class Calk{

	public static final String VvedChis = "¬ведите число";
	
	private MyForms fr;
	
	private MyPanel panel1;
	private MyPanel panel2;
	private MyPanel panel3;
	
	private MyLabel lab1;
	private MyLabel lab2;
	private MyLabel lab3;
	
	
	private MyTextFild txt1;
	private MyTextFild txt2;
	private MyTextFild txt3;
	
	private MyButton bt1;
	private MyButton bt2;
	private MyButton bt3;
	private MyButton bt4;
	private MyButton bt5;
	private MyButton btSkin1;
	private MyButton btSkin2;
	private MyButton btSkin3;
	private MyButton btSkin4;
	private MyButton btSkin5;
	
	private MyButton bt00;
	private MyButton bt01;
	private MyButton bt02;
	private MyButton bt03;
	private MyButton bt04;
	private MyButton bt05;
	private MyButton bt06;
	private MyButton bt07;
	private MyButton bt08;
	private MyButton bt09;
	private MyButton bt10;
	private MyButton btT;
	
	public boolean ch=true;

	
	public static void main(String[] args) {
	
		try {
			UIManager.setLookAndFeel(new McWinLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		Calk calk = new Calk();	
		
		
		
		calk.creatTExt();
		calk.creatLabel();
		calk.creatButon();
		calk.creatPanel();
		calk.addCompPan();
		calk.forAndComponents();
		
	}
	
	public void creatButon()
	{

		bt1 = new MyButton(" + ", 80, 30);
		bt2 = new MyButton(" - ", 80, 30);
		bt3 = new MyButton(" * ", 80, 30);
		bt4 = new MyButton(" / ", 80, 30);
		bt5 = new MyButton(" = ", 150, 30);
		
		bt00 = new MyButton(" 0 ", 50,30);
		bt01 = new MyButton(" 1 ", 50,30);
		bt02 = new MyButton(" 2 ", 50,30);
		bt03 = new MyButton(" 3 ", 50,30);
		bt04 = new MyButton(" 4 ", 50,30);
		bt05 = new MyButton(" 5 ", 50,30);
		bt06 = new MyButton(" 6 ", 50,30);
		bt07 = new MyButton(" 7 ", 50,30);
		bt08 = new MyButton(" 8 ", 50,30);
		bt09 = new MyButton(" 9 ", 50,30);
		bt10 = new MyButton(" 10 ", 50,30);
		btT = new MyButton(" . ", 50,30);
		btSkin1 = new MyButton("Cк≥н 1", 70,20);
		btSkin2 = new MyButton("Cк≥н 2", 70,20);
		btSkin3 = new MyButton("Cк≥н 3", 70,20);
		btSkin4 = new MyButton("Cк≥н 4", 70,20);
		btSkin5 = new MyButton("Cк≥н 5", 70,20);
		buttonClick();
	}
	
	public void focus()
	{
		txt1.addFocusListener(new FocusText(txt1));
		txt2.addFocusListener(new FocusText(txt2));
	}
	
	public void buttonClick()
	{
		ButtonClick btCL = new ButtonClick(txt1,txt2,txt3);
	
		bt1.addActionListener(btCL);
		bt2.addActionListener(btCL);
		bt3.addActionListener(btCL);
		bt4.addActionListener(btCL);
		bt5.addActionListener(btCL);
		
		bt00.addActionListener(btCL);
		bt01.addActionListener(btCL);
		bt02.addActionListener(btCL);
		bt03.addActionListener(btCL);
		bt04.addActionListener(btCL);
		bt05.addActionListener(btCL);
		bt06.addActionListener(btCL);
		bt07.addActionListener(btCL);
		bt08.addActionListener(btCL);
		bt09.addActionListener(btCL);
		bt10.addActionListener(btCL);
		btT.addActionListener(btCL);
	}
	
	public void creatLabel()
	{
		lab1 = new MyLabel("„исло 1 ");
		lab2 = new MyLabel("„исло 2 ");
		lab3 = new MyLabel("–езультат: ");		
	}
	
	public void creatTExt()
	{
		txt1 = new MyTextFild(100,30,VvedChis);
		txt1.setName("Edit1");
		txt2 = new MyTextFild(100,30,VvedChis);
		txt2.setName("Edit2");
		txt3 = new MyTextFild(100,30);
		txt3.setEditable(false);
		txt3.setFocusable(false);
		
		focus();
	}
	
	public void creatPanel()
	{
		panel1 = new MyPanel(383, 100);
		panel2 = new MyPanel(383, 100);
		panel3 = new MyPanel(383, 55);
	}
	
	public void addCompPan()
	{
		panel1.add(lab1);
		panel1.add(txt1);
		panel1.add(lab2);
		panel1.add(txt2);
		panel1.add(bt1);
		panel1.add(bt2);
		panel1.add(bt3);
		panel1.add(bt4);		
		
		panel2.add(bt00);
		panel2.add(bt01);
		panel2.add(bt02);
		panel2.add(bt03);
		panel2.add(bt04);
		panel2.add(bt05);
		panel2.add(bt06);
		panel2.add(bt07);
		panel2.add(bt08);
		panel2.add(bt09);
		panel2.add(bt10);
		panel2.add(btT);
		
		panel3.add(lab3);
		panel3.add(txt3);
		panel3.add(bt5);
	}
	
	
	public void forAndComponents()
	{
	 fr = new MyForms("Calkulator");
	 fr.getContentPane().add(panel1);
	 fr.getContentPane().add(panel2);
	 fr.getContentPane().add(panel3);
	 fr.getContentPane().add(btSkin1);
	 fr.getContentPane().add(btSkin2);
	 fr.getContentPane().add(btSkin3);
	 fr.getContentPane().add(btSkin4);
	 fr.getContentPane().add(btSkin5);
	 skin();
	}
	
	
	public void skin()
	{
		btSkin1.addActionListener(new ChangeSkin(new SmartLookAndFeel(),fr));
		btSkin2.addActionListener(new ChangeSkin(new McWinLookAndFeel(),fr));
		btSkin3.addActionListener(new ChangeSkin(new BernsteinLookAndFeel(),fr));
		btSkin4.addActionListener(new ChangeSkin(new HiFiLookAndFeel(),fr));
		btSkin5.addActionListener(new ChangeSkin(new NoireLookAndFeel(),fr));
	}

}
