package work;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;

import main.Calk;
import face.MyTextFild;

public class FocusText extends FocusAdapter {

	private MyTextFild txt;
		
	public FocusText() {
		// TODO Auto-generated constructor stub
	}
	
	public FocusText(MyTextFild tx) {
		this.txt=tx;
		
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		if(txt.getText().equals(Calk.VvedChis))
		{
			txt.setText("");
			txt.setForeground(Color.black);
		}
	}
	
	@Override
	public void focusLost(FocusEvent e) {
		if(txt.getText().equals(""))
		{
			txt.setText(Calk.VvedChis);
			txt.setForeground(Color.gray);
		}
	}
	
	
	
}
