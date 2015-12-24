package operation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import mas.ms;
import face.MyButtonnn;
import face.MyCombo;
import face.MyEddit;
import face.MyLable;

public class act implements ActionListener {

	private int size;
	private int value;
	private static int [] mas;
	private MyEddit edit1;
	private MyEddit edit2;
	private MyLable labl;
	private MyLable labl1;
	private MyButtonnn bt;
	public static String mss="";
	private int min;
	private int max;
	private double sum=0;
	private double ser=0;
	public static String mnmx;
	public static String smsr;
	private int countCh;
	private int countNECh;
	
	public static String ch="";
	public static String nch="";
	public static String countChNch="";
	public static String writeCh;
	public static String writeNCh;
	public static String sortMas;
	
	public act(MyButtonnn bt, MyEddit edit1, MyEddit edit2, MyLable labl) {
		this.bt=bt;
		this.labl =labl;
		this.edit1=edit1;
		this.edit2=edit2;		
	}
		
	public act(MyButtonnn bt, MyEddit edit1, MyEddit edit2, MyLable labl1, MyLable labl2) {
		this.bt=bt;
		this.labl =labl1;				
		this.labl1 =labl2;
		this.edit1=edit1;
		this.edit2=edit2;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

	if(!edit1.getText().trim().equals(ms.word) && !edit2.getText().trim().equals(ms.word))	
	{
		if(bt.getText().trim().equals("Созд. маccив"))
		{
			creatMas();
			
		}else if(bt.getText().trim().equals("Макс/Мин"))
		{
			 max_min();
			 
		}else if(bt.getText().trim().equals("Сум/Средн"))
		{
			sum_ser();
			
		}else if(bt.getText().trim().equals("Чет/НеЧет"))
		{
			chot();
		}
		else if(bt.getText().trim().equals("Сортировать"))
		{
			sort();
		}
	}else
	{
			JOptionPane.showMessageDialog(null, "Ви не заполнили все поля!!", "Ошибка", JOptionPane.ERROR_MESSAGE);
	}
		
	}
	
		public void creatMas()
		{
			size=Integer.valueOf(edit1.getText());
			value=Integer.valueOf(edit2.getText());
			
			mas = new int[size];
			System.out.println("Created mass");
			for(int i=0; i<mas.length; i++)
			{
				mas[i]=(int)Math.round(Math.random()*value);
				System.out.print(mas[i]+" ");
			}
			System.out.println();
			
			
			mss=String.valueOf(mas[0]);
			
			for(int i=1; i<mas.length; i++)
			{
				mss+=" "+mas[i];				
			}
				labl.setText(mss);			
		}
		
		public void max_min()
		{
			min=mas[0];
			max=mas[0];
			
			 for(int i=0; i<mas.length; i++)
				{
				if(max<mas[i])
				{
					max=mas[i];
				
				}else if(min>mas[i])	

					min=mas[i];
					
				}
			 	mnmx="Макс.= "+max+" / Мин.= "+min;
			 	System.out.println("mx= "+max+" mn= "+min);
			    labl.setText(mnmx);
		}
		
		public void sum_ser()
		{		sum=0;			
			 for(int i=0; i<mas.length; i++)
			{
				sum+=mas[i];
			}
			 ser=sum/mas.length;	
			 System.out.println("Sum.= "+sum+" / Ser.= "+String.format("%2.2f", ser));
			 smsr="Сум.= "+sum+" / Сред.= "+String.format("%2.2f", ser);
			 labl.setText(smsr);
			 
		}

		public void chot()
		{
			countCh=0;
			countNECh=0;
			ch="";
			nch="";
			
			for (int i=0; i<mas.length; i++)
			{
				if(mas[i]%2==0)
				{
					countCh++;		
					ch+=String.valueOf(mas[i])+" ";
				}else
				{
					countNECh++;
					nch+=String.valueOf(mas[i])+" ";
				}
			}
			countChNch="К.Чет.= "+countCh+" / К.Не чет.= "+countNECh;
						
			System.out.println("CountCh= "+countCh+" / CountNCh= "+countNECh);
			System.out.println("Chot.= ("+ch+") / NChot.= ("+nch+")");
			writeCh="("+ch+")";
			writeNCh="("+nch+")";
			labl.setText(countChNch);
			labl1.setText(writeCh+" / "+writeNCh);
			
		}

		public void sort()
		{
			sortMas="";
			Arrays.sort(mas);

			sortMas=String.valueOf(mas[0]);
			System.out.println("Sorted mass");
			for(int i=0; i<mas.length; i++)
			{
				System.out.print(mas[i]+" ");
			}
			System.out.println();
			
			for(int i=1; i<mas.length; i++)
			{
				sortMas+=" "+mas[i];
			}
			
			labl.setText(sortMas);
		}
}

