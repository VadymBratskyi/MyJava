package mas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

import operation.Fooccuse;
import operation.Fooccuse2;
import operation.act;
import operation.actArray;
import operation.keyKlicMas;
import operation.keyKlick;
import operation.keyKlick2;
import face.MyButtonnn;
import face.MyCombo;
import face.MyEddit;
import face.MyFormm;
import face.MyLable;
import face.MyPaannel;

public class ms {

	private MyFormm form;
	
	private MyPaannel pan1;
	private MyPaannel pan2;
	//-----МАССИВ---------------------------//
	private MyLable labl1;
	private MyLable labl2;
	private MyLable labl3;
	private MyLable labl4;
	private MyLable labl5;
	private MyLable labl6;
	private MyLable labl7;
	private MyLable labl8;
	private MyLable labl9;
	
	private MyEddit edit1;
	private MyEddit edit2;
	
	private MyButtonnn bt1;
	private MyButtonnn bt2;
	private MyButtonnn bt3;
	private MyButtonnn bt4;
	private MyButtonnn bt5;
	//--------------------------------------------------//
	private MyLable labl10;
	private MyLable labl11;
	private MyLable labl12;
	private MyEddit edit3;
	private MyLable labl13;
	private MyLable labl14;
	private MyLable labl15;
	private MyLable labl16;
	private MyEddit edit4;
	
	public static HashSet<Integer> arr;
	public static ArrayList<String> arrss;
	public static MyCombo combo1;
	public static MyCombo combo2;
	private MyButtonnn bt6;
	private MyButtonnn bt7;
	
	public static final String word = "Введите число";
	public static final String word2 = "Введите стр.";
	
	public static void main(String [] arg)
	{
		
		try {
			UIManager.setLookAndFeel(new McWinLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		
	    arr = new HashSet<Integer>();
		arrss= new ArrayList<String>();
	    
		ms mass =  new ms();
	
		mass.Combo();
		mass.Label();
		mass.Edit();
		mass.Buutton();
		mass.Pannel();
		mass.Foorm();
	}	
	
	
	public void focuss()
	{
		edit1.addFocusListener(new Fooccuse(edit1));
		edit2.addFocusListener(new Fooccuse(edit2));
		edit3.addFocusListener(new Fooccuse(edit3));
		edit4.addFocusListener(new Fooccuse2(edit4));
	}
	
	public void activ()
	{	
		bt1.addActionListener(new act(bt1,edit1,edit2,labl4));
		bt2.addActionListener(new act(bt2,edit1,edit2,labl5));
		bt3.addActionListener(new act(bt3,edit1,edit2,labl6));
		bt4.addActionListener(new act(bt4,edit1,edit2,labl7));
		bt5.addActionListener(new act(bt5,edit1,edit2,labl8,labl9));
		bt6.addActionListener(new actArray(combo1, labl12, arr,bt6));
		bt7.addActionListener(new actArray(combo2, labl15, arrss,bt7));
	}
	
	public void Combo()
	{
		combo1 = new MyCombo(30,105,90,20);
		combo2 = new MyCombo(30,215,90,20);
	}
	
	public void Buutton()
	{
		bt1 = new MyButtonnn("Созд. маccив",15,85, 115, 25);
		bt2 = new MyButtonnn("Сортировать",15,115, 115, 25);
		bt3 = new MyButtonnn("Сум/Средн",15,145, 115, 25);
		bt4 = new MyButtonnn("Макс/Мин",15,175, 115, 25);
		bt5 = new MyButtonnn("Чет/НеЧет",15,205, 115, 25);
		bt6 = new MyButtonnn("Удалить чис. с колекц.",125,105, 150, 20);
		bt7 = new MyButtonnn("Удалить стр. с колекц.",125,215, 150, 20);
		activ();
	}
	
	public void Edit()
	{
		edit1 = new MyEddit(30,55,90, 25, word);
		edit1.addKeyListener(new keyKlicMas(edit1));
		edit2 = new MyEddit(240,55, 90, 25, word);
		edit2.addKeyListener(new keyKlicMas(edit2));
		edit3 = new MyEddit(30,55, 90, 25, word);
		edit3.addKeyListener(new keyKlick(arr,labl12,edit3));	
		edit4 = new MyEddit(10,160,150, 25, word2);
		edit4.addKeyListener(new keyKlick2(arrss, labl15, edit4));
		focuss();
	}
		
	public void Label()
	{
		labl1 = new MyLable("Создание рандомного массива:",80,10,250,20);
		labl2 = new MyLable("Кол. элем.в массиве:",10,30,150,20);
		labl3 = new MyLable("Диапазон елем.:",230,30,150,20);
		labl4 = new MyLable("Наш массив",135,85,250,20);
		labl4.setForeground(Color.red);
		labl5 = new MyLable("Отсортирован массив",135,115,200,20);
		labl5.setForeground(Color.blue);
		labl6 = new MyLable("Сум/Средн",135,145,200,20);
		labl6.setForeground(Color.magenta);
		labl7 = new MyLable("Макс/Мин",135,175,200,20);
		labl7.setForeground(Color.green);
		labl8 = new MyLable("Чет/НеЧет",135,205,200,20);
		labl8.setForeground(Color.black);
		labl9 = new MyLable("",135,220,200,15);
		labl9.setForeground(Color.black);
		
		labl10 = new MyLable("Создание коллекции:",100,10,250,20);
		labl11 = new MyLable("Добавление чисел в колекцию:",10,30,230,20);
		labl12= new MyLable("Элементы коллекции",130,55,230,20);
		labl12.setForeground(Color.red);
		labl13 = new MyLable("Выберите число для удаления с коллекции:",10,80,330,20);	
		labl14 = new MyLable("Добавление строки в колекцию:",10,130,330,20);
		labl15= new MyLable("Элементы коллекции",170,160,230,20);
		labl15.setForeground(Color.blue);
		labl16 = new MyLable("Выберите символ для удаления с коллекции:",10,190,330,20);
	}
	
	public void Pannel()
	{
		pan1 = new MyPaannel(380,250);
		pan1.add(labl1);
		pan1.add(labl2);
		pan1.add(labl3);
		pan1.add(labl4);
		pan1.add(labl5);
		pan1.add(labl6);
		pan1.add(labl7);
		pan1.add(labl8);
		pan1.add(labl9);
		pan1.add(edit1);
		pan1.add(edit2);
		pan1.add(bt1);
		pan1.add(bt2);
		pan1.add(bt3);
		pan1.add(bt4);
		pan1.add(bt5);
		pan2 = new MyPaannel(380,250);
		pan2.add(labl10);
		pan2.add(labl11);
		pan2.add(labl12);
		pan2.add(edit3);
		pan2.add(labl13);
		pan2.add(combo1);
		pan2.add(bt6);
		pan2.add(edit4);
		pan2.add(labl14);
		pan2.add(labl15);
		pan2.add(labl16);
		pan2.add(combo2);
		pan2.add(bt7);
	}
	

	public void Foorm()
	{
		form = new MyFormm("Massive");
		form.getContentPane().add(pan1);
		form.getContentPane().add(pan2);
	}
	
}
