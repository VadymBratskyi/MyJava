package operation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import face.MyEddit;


public class keyKlicMas extends KeyAdapter {

	private MyEddit edit;
	
	public keyKlicMas(MyEddit edit) {

		this.edit=edit;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {		
		
		if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar()==e.VK_BACK_SPACE) {
	        edit.setEditable(true);
	       
	    } else {
	        edit.setEditable(false);
	    }
		
	}
}
