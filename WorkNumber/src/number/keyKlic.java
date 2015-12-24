package number;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import face.MyEdit;

public class keyKlic extends KeyAdapter {

	private MyEdit edit;
	
	public keyKlic(MyEdit edit) {
	   this.edit=edit;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() >= '0' && e.getKeyChar()<= '9' && edit.getText().length()<10 || e.getKeyChar()==KeyEvent.VK_BACK_SPACE)
		{
			edit.setEditable(true);
		}else
		{
			edit.setEditable(false);
		}
	}
}
