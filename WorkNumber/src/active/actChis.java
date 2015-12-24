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
				
			if(bt.getText().trim().equals("���.���."))
			{
				chisla(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("���.���."))
			{
				sumChis(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("ʳ�.���."))
			{
				countChis(Integer.valueOf(edit.getText()));
				//JOptionPane.showMessageDialog(null, edit.getText().length());
			}else if(bt.getText().trim().equals("���.���."))
			{
				selectPoint(Integer.valueOf(edit.getText()));
			}
			else if(bt.getText().trim().equals("���.��."))
			{
				serChis(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("���.���."))
			{
				chotNechot(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("ʳ�.���."))
			{
				kilZadCufr(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("Mx.Mn."))
			{
				maxMin(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("������."))
			{
				sortBuble(Integer.valueOf(edit.getText()));
				sortSelect(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("�����."))
			{
				remuveValue(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("���.��."))
			{
				serKvadChis(Integer.valueOf(edit.getText()));
			}else if(bt.getText().trim().equals("���.���."))
			{
				serGeoChis(Integer.valueOf(edit.getText()));
			}
		}else
		{
			JOptionPane.showMessageDialog(null, "�� �� ��������� ����", "�������", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void chisla(int chis)// �������� ����� �� ���������
	{	int ch=chis;//��������� �����
		int ch2=chis;//��������� �����
    	//int m=1;  
		int g;
    	int cou=0;//�� �������
    	int dob=1;//����� � 10 ��� ��� ������.
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
		
		System.out.print("�� �����, ���������� �����: ");
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
	
	public void sumChis(int chis)//����������� ���� ����� 
	{
		int sum=0;//���� ����
		int ch=chis;//��������� �����
		int g; //����� ����� �����
 		int m=1;
 		
		while(chis>0)
		{
			chis/=10;
			g=ch/m%10;
			m*=10;
			sum+=g;
		}
		
		System.out.println("����� ����: "+sum);
		label1.setText("����� ����: "+sum);
	}
	
	public void countChis(int chis)//�������� ������� �����
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
			label1.setText(String.valueOf(count)+" �����");
		}else if(g==0 || g>=5 && g<=9)
		{
			label1.setText(String.valueOf(count)+" ����");
		}if(g>=2 && g<=4)
		{
			label1.setText(String.valueOf(count)+" �����");
		}
		System.out.println("ʳ������ ����: "+count);
	}
	
	public void serChis(int chis)//����������� ���. ����� 
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
		System.out.println("���. �����.: "+sum/count);
		label1.setText("���. �����.= "+String.valueOf(sum/count));
	}
	
	public void selectPoint(int chis)//���� �������� �� �������
	{
		String poz = JOptionPane.showInputDialog("������ ������� �����");
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
			g=ch/l;//���� �� ��� �� ������ ����
			el=g%10;//����������� ������
			System.out.println("������� �������: ("+poz+") "+" ����� �� �������: "+el);
			label1.setText("����. �����. ("+poz+")"+" ����� �� �������: "+el);
		}else
		{
			JOptionPane.showMessageDialog(null, "� ���������� ��� �����", "�������", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void chotNechot(int chis)//�������� �� �������
	{
		int g;
		//int m=1;
		int couCh=0;
		int couNCh=0;
		String chel="";
		String nchel="";
		int ch=chis;//��������� �����
		int ch2=chis;//��������� �����
    	//int m=1;   
    	int cou=0;//�� �������
    	int dob=1;//����� � 10 ��� ��� ������.
    	
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
		
		
		 System.out.println("ʳ�. ������: "+couCh+" / ʳ�. �� ������: "+couNCh);
		 System.out.println("("+chel+") / ("+nchel+")");
		 label1.setText("ʳ�. ������: "+couCh+"-("+chel+")"+" / ʳ�. �� ������: "+couNCh+"-("+nchel+")"); 		 
	}

	public void kilZadCufr(int chis)//��������� ������� �����
	{
		int zad = Integer.valueOf(JOptionPane.showInputDialog("ϳ�������� ������� �������� �����"));
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
		System.out.println("���� ������ ����� ("+zad+")  �� ������� � ����: "+countZad);
		label1.setText("���� ������ ����� ("+zad+")  �� ������� � ����: "+countZad);
	}

	public void maxMin(int chis)//����������� ���������� �������������
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
		
		System.out.println("����. �����: "+max);
		System.out.println("̳�. �����: "+min);
		label1.setText("����. �����: "+max+" / ̳�. �����: "+min);
	}

	public void sortBuble(int chis)//���������� ����� ����������
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
		
		System.out.print("³��������� ����� ����� ������� ���������: ");
		
		for(int i=0; i<mas.length; i++)
		{
			System.out.print(mas[i]+" ");
			sortMas1+=mas[i]+" ";
		}
		System.out.println();
		label1.setText(sortMas1+"-����� ���������");
	}

	public void sortSelect(int chis)//���������� ����� �������
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
		
		System.out.print("³��������� ����� ����� ������� ������: ");
		
		for(int i=0; i<mas.length; i++)
		{
			System.out.print(mas[i]+" ");
			sortMas2+=mas[i]+" ";
		}
		System.out.println();
		label2.setText(sortMas2+"-����� ������");
	}

	public void remuveValue(int chis)//����� �����
	{
		int value = Integer.valueOf(JOptionPane.showInputDialog("������ ����� ��� ���������"));
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
		System.out.print("������� ����� ("+value+")"+" ��������� ������� �����: ");
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
			label1.setText("������� ����� ("+value+")"+" ��������� ������� �����: "+str);
		edit.setText(str1);
		}
		
	}

	public void serGeoChis(int chis)//����������� ���. �������. 
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
		
		System.out.println("���. �����������.: "+serGeometr);
		label1.setText("���. �����������.: "+serGeometr);
	}

	public void serKvadChis(int chis)//����������� ���. �������..
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
		System.out.println("���. ������������.: "+serKvadr);
		label1.setText("���. ������������.: "+serKvadr);
	}
}
