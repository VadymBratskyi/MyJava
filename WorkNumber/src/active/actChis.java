package active;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import face.MyButton;
import face.MyEdit;
import face.MyLabel;

public class actChis implements ActionListener {

	private MyEdit edit;	
	private MyButton bt;
	private MyLabel label1;
	private MyLabel label2;
	
	public String st="dgsfdg";
	
	public actChis(MyEdit edit, MyButton bt, MyLabel label) {
		this.edit=edit;
		this.bt=bt;
		this.label1=label;
	}
	
	public actChis(MyEdit edit, MyButton bt, MyLabel label1, MyLabel label2) {
		this.edit=edit;
		this.bt=bt;
		this.label1=label1;
		this.label2=label2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(!edit.getText().trim().equals(""))
		{			
				
			if(bt.getText().trim().equals("Окр.Чис."))
			{
				chisla(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Сум.Циф."))
			{
				sumChis(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Кіл.Циф."))
			{
				countChis(Integer.valueOf(edit.getText()));
				//JOptionPane.showMessageDialog(null, edit.getText().length());
			}else if(bt.getText().trim().equals("Обр.Поз."))
			{
				selectPoint(Integer.valueOf(edit.getText()));
			}
			else if(bt.getText().trim().equals("Сер.Ар."))
			{
				serChis(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Пар.НеП."))
			{
				chotNechot(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Кіл.Пов."))
			{
				kilZadCufr(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Mx.Mn."))
			{
				maxMin(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Сортув."))
			{
				sortBuble(Integer.valueOf(edit.getText()));
				sortSelect(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Видал."))
			{
				remuveValue(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Сер.Кв."))
			{
				serKvadChis(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Сер.Гео."))
			{
				serGeoChis(Integer.valueOf(edit.getText()));
			}
		}else
		{
			JOptionPane.showMessageDialog(null, "Ви не заповнили поле", "Помилка", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void chisla(int chis)// виведеня чисел по елементно
	{	int ch=chis;//перезапис числа
		int ch2=chis;//перезапис числа
    	//int m=1;  
		int g;
    	int cou=0;//кіл елемент
    	int dob=1;//збільш у 10 раз для ділення.
    	String allNum="";
    
		while(chis>0)
		{
			chis/=10;
			cou++;			
		}
		
		for(int i=1; i<cou; i++)
		{
			dob*=10;	
		}
		
		System.out.print("Усі цифри, введенного числа: ");
		while(ch>0)
		{
			ch/=10;
			g=ch2/dob%10;
			//m*=10;
			dob/=10;
			System.out.print(g+" ");
			allNum+=g+" ";
		}	
		System.out.println();
		label1.setText(allNum);
	}
	
	public void sumChis(int chis)//знаходження суми чисел 
	{
		int sum=0;//суму цифр
		int ch=chis;//перезапис числа
		int g; //окремі числа числа
 		int m=1;
 		
		while(chis>0)
		{
			chis/=10;
			g=ch/m%10;
			m*=10;
			sum+=g;
		}
		
		System.out.println("Сумма цифр: "+sum);
		label1.setText("Сумма цифр: "+sum);
	}
	
	public void countChis(int chis)//виведеня кількості чисел
	{
		int count=0;
		int g;
		
		while(chis>0)
		{
			chis/=10;
			count++;		
		}
		
		g=count%10;
		
		if(g==1)
		{
			label1.setText(String.valueOf(count)+" цифра");
		}else if(g==0 || g>=5 && g<=9)
		{
			label1.setText(String.valueOf(count)+" цифр");
		}if(g>=2 && g<=4)
		{
			label1.setText(String.valueOf(count)+" цифри");
		}
		System.out.println("Кількість цифр: "+count);
	}
	
	public void serChis(int chis)//знаходження сер. арефм 
	{
		int ch=chis;
		int count=0;
		int g;
		int m=1;
		double sum=0;		
		
		while(chis>0)
		{
			chis/=10;
			g=ch/m%10;
			m*=10;
			count++;
			sum+=g;
		}
		System.out.println("Сер. арефм.: "+sum/count);
		label1.setText("Сер. арефм.= "+String.valueOf(sum/count));
	}
	
	public void selectPoint(int chis)//вибір елемента по позиції
	{
		String poz = JOptionPane.showInputDialog("Введіть позицію цифри");
		int point = Integer.valueOf(poz);
	
		int count=0;			
		int l=1;
		int ch=chis; 
		int g,el;
		
		while(chis>0)
		{
			chis/=10;			
			count++;			
		}
		if(point<=count)
		{
			for(int i=0; i<count-point; i++){
	             l*=10;
			}           
			g=ch/l;//ділим на соті до нашого елем
			el=g%10;//знаходження остачі
			System.out.println("Вибрана позиція: ("+poz+") "+" Цифра на позиції: "+el);
			label1.setText("Вибр. позиц. ("+poz+")"+" Цифра на позиції: "+el);
		}else
		{
			JOptionPane.showMessageDialog(null, "В перевищили ліміт чисел", "Помилка", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void chotNechot(int chis)//перевірка на праність
	{
		int g;
		//int m=1;
		int couCh=0;
		int couNCh=0;
		String chel="";
		String nchel="";
		int ch=chis;//перезапис числа
		int ch2=chis;//перезапис числа
    	//int m=1;   
    	int cou=0;//кіл елемент
    	int dob=1;//збільш у 10 раз для ділення.
    	
		while(chis>0)
		{
			chis/=10;
			cou++;			
		}
		
		for(int i=1; i<cou; i++)
		{
			dob*=10;	
		}
		
		while(ch>0)
		{
			ch/=10;
			g=ch2/dob%10;
			//m*=10;
			dob/=10;
			 if(g%2==0)
			 {
				 couCh++;
				 chel+=String.valueOf(g);			
			 }else
			 {
				 couNCh++;
				 nchel+=String.valueOf(g);			
			 }	
		}
		
		
		 System.out.println("Кіл. парних: "+couCh+" / Кіл. Не парних: "+couNCh);
		 System.out.println("("+chel+") / ("+nchel+")");
		 label1.setText("Кіл. парних: "+couCh+"-("+chel+")"+" / Кіл. Не парних: "+couNCh+"-("+nchel+")"); 		 
	}

	public void kilZadCufr(int chis)//підрахунок кількості цифри
	{
		int zad = Integer.valueOf(JOptionPane.showInputDialog("Підрахунок кількості введенної цифри"));
		int ch=chis;
		int countZad=0;
		int g;
		int m=1;
				
		while(chis>0)
		{
			chis/=10;
			g=ch/m%10;
			m*=10;
			if(g==zad)
			{
				countZad++;
			}
		}		
		System.out.println("Була задана цифра ("+zad+")  Її кількість в числі: "+countZad);
		label1.setText("Була задана цифра ("+zad+")  Її кількість в числі: "+countZad);
	}

	public void maxMin(int chis)//знаходження мінімальногоі максимального
	{
		int g;
		int m=1;
		int first;
		int ch=chis;
		int ch1=chis;
		int count=0;
		int dob=1;
		
		while(chis>0)
		{
			chis/=10;
			count++;			
		}
		
		for(int i=1; i<count; i++)
		{
			dob*=10;
		}		
		first=ch1/dob%10;
		int max=first;
		int min=first;
		
		while(ch>0)
		{
			ch/=10;
			g=ch1/m%10;
			m*=10;
			
			if(max<g)
			{
				max=g;
			}else if(min>g)
			{
				min=g;
			}		
		}
		
		System.out.println("Макс. цифра: "+max);
		System.out.println("Мін. цифра: "+min);
		label1.setText("Макс. цифра: "+max+" / Мін. цифра: "+min);
	}

	public void sortBuble(int chis)//сортування цифер бульбашкой
	{
		int [] mas;
		int ch=chis;
		int ch1=chis;
		int g;
		int m=1;
		int count=0;
		String sortMas1="";
		
		while(chis>0)
		{
			chis/=10;			
			count++;		
		}
		
		mas = new int[count];
		
		while(ch>0)
		{			
			for(int i=0; i<mas.length; i++)
			{
				ch/=10;
				g=ch1/m%10;
				m*=10;
				mas[i]=g;
			}
		}
		
		for(int i=1; i<mas.length; i++)
		{
			for(int j=mas.length-1; j>=i; j--)
			{
				if(mas[j-1]>mas[j])
				{
					int tmp=mas[j-1];
					mas[j-1]=mas[j];
					mas[j]=tmp;
				}
			}
		}
		
		System.out.print("Відсортовані цифри числа методом бульбашки: ");
		
		for(int i=0; i<mas.length; i++)
		{
			System.out.print(mas[i]+" ");
			sortMas1+=mas[i]+" ";
		}
		System.out.println();
		label1.setText(sortMas1+"-метод бульбашки");
	}

	public void sortSelect(int chis)//сортування цифер вибором
	{	
		int [] mas;
		int ch=chis;
		int ch1=chis;
		int g;
		int m=1;
		int count=0;		
		String sortMas2="";
		
		while(chis>0)
		{
			chis/=10;			
			count++;		
		}
		
		mas = new int[count];
		
		while(ch>0)
		{			
			for(int i=0; i<mas.length; i++)
			{
				ch/=10;
				g=ch1/m%10;
				m*=10;
				mas[i]=g;
			}
		}
		
		int min=0;
		
		for(int i=0; i<mas.length-1; i++)
		{
			min=i;
			
			for(int j=i+1; j<mas.length; j++)
			{
				if(mas[j]<mas[min])
				{
					min=j;
				}
			}
			
			int tmp =mas[i];
			mas[i]=mas[min];
			mas[min]=tmp;		
		}
		
		System.out.print("Відсортовані цифри числа методом вибору: ");
		
		for(int i=0; i<mas.length; i++)
		{
			System.out.print(mas[i]+" ");
			sortMas2+=mas[i]+" ";
		}
		System.out.println();
		label2.setText(sortMas2+"-метод вибору");
	}

	public void remuveValue(int chis)//видал цифер
	{
		int value = Integer.valueOf(JOptionPane.showInputDialog("Введіть число для видалення"));
		int ch=chis;
		int ch1=chis;
		int count=0;
		int g;
		int l=1;
		String str="";
		String str1="";
		
		while(chis>0)
		{
			chis/=10;
			count++;
		}		
	
		for(int i=1; i<count; i++)
		{
			l*=10;
		}
		System.out.print("Вказане число ("+value+")"+" Видаленне вказана цифра: ");
		while(ch>0)
		{
			ch/=10;
			g=ch1/l%10;
			l/=10;
			if(g!=value)
			{
				System.out.print(g+" ");
				str+=g+" ";
				str1+=g;
			}
			label1.setText("Вказане число ("+value+")"+" Видаленне вказана цифра: "+str);
		edit.setText(str1);
		}
		
	}

	public void serGeoChis(int chis)//знаходження сер. геометр. 
	{
		int ch=chis;
		int count=0;
		int g;
		int m=1;
		int dobAll=1;		
		
		while(chis>0)
		{
			chis/=10;
			g=ch/m%10;
			m*=10;
			count++;
			dobAll*=g;
		}
		double serGeometr=Math.pow(dobAll,(double)1/count);
		
		System.out.println("Сер. геометричне.: "+serGeometr);
		label1.setText("Сер. геометричне.: "+serGeometr);
	}

	public void serKvadChis(int chis)//знаходження сер. квадрат..
	{
		int ch=chis;
		int count=0;
		int g;
		int m=1;
		int sumKv=0;
		
		
		while(chis>0)
		{
			chis/=10;
			g=ch/m%10;
			m*=10;
			count++;
			sumKv+=Math.pow(g, 2);
		}
		double serKvadr=(double)Math.sqrt(sumKv/count);
		System.out.println("Сер. квадаратичне.: "+serKvadr);
		label1.setText("Сер. квадаратичне.: "+serKvadr);
	}
}
