package operation;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import mas.ms;
import face.MyEddit;

public class Fooccuse2 implements FocusListener {

	private MyEddit edit1;
	
	public Fooccuse2(MyEddit edit1) {
		this.edit1=edit1;

	}
	
	@Override
	public void focusGained(FocusEvent e) {
		if(edit1.getText().equals(ms.word2))
		{
			edit1.setText("");
			edit1.setForeground(Color.black);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(edit1.getText().equals(""))
		{
			edit1.setText(ms.word2);
			edit1.setForeground(Color.gray);
		}
	}

}
