package work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import main.Calk;
import face.MyTextFild;

public class ButtonClick implements ActionListener {

	private MyTextFild chis1;
	private MyTextFild chis2;
	private MyTextFild rez;
	private double vidp;
	
	
	
	public ButtonClick(MyTextFild chis1,MyTextFild chis2, MyTextFild rez) {
		this.chis1=chis1;
		this.chis2=chis2;
		this.rez=rez;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if (e.getSource() instanceof JButton) {
			JButton bt = (JButton) e.getSource();
			if(bt.getText().trim().equals("+") || bt.getText().trim().equals("-") || bt.getText().trim().equals("*") || bt.getText().trim().equals("/") || bt.getText().trim().equals("="))
			{
				if(!chis1.getText().equals(Calk.VvedChis) && !chis2.getText().equals(Calk.VvedChis))
				{
										
						double cuf1 = Double.parseDouble(chis1.getText());
						double cuf2 = Double.parseDouble(chis2.getText());
						
						if(bt.getActionCommand().trim().equals("+"))
						{
							vidp=operation.add(cuf1, cuf2);
						}
						if(bt.getActionCommand().trim().equals("-"))
						{
							vidp=operation.subtract(cuf1, cuf2);
						}
						if(bt.getActionCommand().trim().equals("*"))
						{
							vidp=operation.multiply(cuf1, cuf2);
						}
						if(bt.getActionCommand().trim().equals("/"))
						{
							vidp=operation.divide(cuf1, cuf2);
						}
						if(bt.getActionCommand().trim().equals("="))
						{
							rez.setText(String.valueOf(vidp));
						}
				
				}else
				{
					rez.setText("");
					JOptionPane.showMessageDialog(null, "Ви не заповнили усі поля!!", "Помилка", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				
			}
			
		}else	
		{
			return;
		}	

	}
	
	
	
	
}
