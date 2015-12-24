package number;

import java.awt.Color;
import java.awt.FlowLayout;


import javax.swing.border.TitledBorder;

import active.actChis;
import face.MyButton;
import face.MyEdit;
import face.MyForm;
import face.MyLabel;
import face.MyPanel;


public class worknumber {

	private MyForm form;
	
	private MyPanel panel1;
	private MyPanel panel2;
	private MyPanel panel3;
	
	private MyEdit edit1;
	
	private MyButton bt1;
	private MyButton bt2;
	private MyButton bt3;
	private MyButton bt4;
	private MyButton bt5;
	private MyButton bt6;
	private MyButton bt7;
	private MyButton bt8;
	private MyButton bt9;
	private MyButton bt10;
	private MyButton bt11;
	private MyButton bt12;
	
	private MyLabel labl1;
	private MyLabel labl2;
	private MyLabel labl3;
	private MyLabel labl4;
	private MyLabel labl5;
	private MyLabel labl6;
	private MyLabel labl7;
	private MyLabel labl8;
	private MyLabel labl9;
	private MyLabel labl10;
	private MyLabel labl11;
	private MyLabel labl12;
	private MyLabel labl13;	
	
	public static void main(String[] args) {
		
		worknumber wk = new worknumber();
		
		wk.label();
		wk.edit();
		wk.button();
		wk.panels();
		wk.form();
	
	}
	
	public void button()
	{
		bt1 = new MyButton(85,20,"Окр.Чис.");
		bt2 = new MyButton(89,20,"Сум.Циф.");
		bt3 = new MyButton(85,20,"Кіл.Циф.");
		bt4 = new MyButton(85,20,"Обр.Поз.");
		bt5 = new MyButton(85,20,"Видал.");	
		bt6 = new MyButton(89,20,"Пар.НеП.");
		bt7 = new MyButton(85,20,"Кіл.Пов.");
		bt8 = new MyButton(85,20,"Mx.Mn.");
		bt9 = new MyButton(85,20,"Сортув.");
		bt10 = new MyButton(89,20,"Сер.Ар.");
		bt11 = new MyButton(85,20,"Сер.Кв.");
		bt12 = new MyButton(85,20,"Сер.Гео.");
		active();
	}
	
	
	public void active()
	{
		bt1.addActionListener(new actChis(edit1,bt1,labl1));
		bt2.addActionListener(new actChis(edit1,bt2,labl2));
		bt3.addActionListener(new actChis(edit1,bt3,labl3));
		bt4.addActionListener(new actChis(edit1,bt4,labl4));
		bt5.addActionListener(new actChis(edit1,bt5,labl5));		
		bt6.addActionListener(new actChis(edit1,bt6,labl6));
		bt7.addActionListener(new actChis(edit1,bt7,labl7));
		bt8.addActionListener(new actChis(edit1,bt8,labl8));
		bt9.addActionListener(new actChis(edit1,bt9,labl9,labl10));
		bt10.addActionListener(new actChis(edit1,bt10,labl11));
		bt11.addActionListener(new actChis(edit1,bt11,labl12));
		bt12.addActionListener(new actChis(edit1,bt12,labl13));
		
	}
		
	public void edit()
	{
		edit1 = new MyEdit(250, 35);
		edit1.addKeyListener(new keyKlic(edit1));
	}
	
	
	public void label()
	{
		labl1 =new MyLabel("Цифри числа");
		labl1.setForeground(Color.red);
		labl2 =new MyLabel("Сума цифр");
		labl2.setForeground(Color.blue);
		labl3 =new MyLabel("Кількість цифр");
		labl3.setForeground(Color.green);
		labl4 =new MyLabel("Цифра за вказ. позицією");
		labl4.setForeground(Color.red);
		labl5 =new MyLabel("Видалення");
		labl5.setForeground(Color.black);
		labl6 =new MyLabel("Парні/Непарні");
		labl6.setForeground(Color.blue);
		labl7 =new MyLabel("Кіл. вказаної цифри");
		labl7.setForeground(Color.green);
		labl8 =new MyLabel("Макс/Мін.");
		labl8.setForeground(Color.red);
		labl9 =new MyLabel("Сортування бульбашкой");
		labl9.setForeground(Color.black);
		labl10 =new MyLabel("Сортування вибіркой");
		labl10.setForeground(Color.blue);
		labl11 =new MyLabel("Середнє арефметичне");
		labl11.setForeground(Color.red);
		labl12 =new MyLabel("Середнє квадратичне");
		labl12.setForeground(Color.green);
		labl13 =new MyLabel("Середнє геометричне");
		labl13.setForeground(Color.black);
	}
	
	public void panels()
	{
		panel1 = new MyPanel(380,70,"Введіть число для обробки",TitledBorder.CENTER,new FlowLayout());
		panel1.add(edit1);
		panel2 = new MyPanel(380,100,"Виберіть подію",TitledBorder.LEFT, new FlowLayout(1,5,5));
		panel2.add(bt1);
		panel2.add(bt2);
		panel2.add(bt3);
		panel2.add(bt4);
		panel2.add(bt5);
		panel2.add(bt6);
		panel2.add(bt7);
		panel2.add(bt8);
		panel2.add(bt9);
		panel2.add(bt10);
		panel2.add(bt11);
		panel2.add(bt12);
		panel3 = new MyPanel(380,350,"Результат",TitledBorder.ABOVE_BOTTOM,  new FlowLayout(1,1000,8));
		panel3.add(labl1);
		panel3.add(labl2);
		panel3.add(labl3);
		panel3.add(labl4);
		panel3.add(labl5);
		panel3.add(labl6);
		panel3.add(labl7);
		panel3.add(labl8);
		panel3.add(labl9);
		panel3.add(labl10);
		panel3.add(labl11);
		panel3.add(labl12);
		panel3.add(labl13);
	}

	public void form()
	{		
		form = new MyForm("Обробка чисел");
		form.getContentPane().add(panel1);
		form.getContentPane().add(panel2);
		form.add(panel3);
	}
	
	
}
