package operation;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import mas.ms;
import face.MyEddit;

public class Fooccuse implements FocusListener {

	private MyEddit edit1;
	
	public Fooccuse(MyEddit edit1) {
		this.edit1=edit1;

	}
	
	@Override
	public void focusGained(FocusEvent e) {
		if(edit1.getText().equals(ms.word))
		{
			edit1.setText("");
			edit1.setForeground(Color.black);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(edit1.getText().equals(""))
		{
			edit1.setText(ms.word);
			edit1.setForeground(Color.gray);
		}
	}

}
