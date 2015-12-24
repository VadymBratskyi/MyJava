package operation;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import face.MyEddit;
import face.MyLable;
import mas.ms;

public class keyKlick extends KeyAdapter {

	private HashSet<Integer> arr;
	private MyLable labl;
	private MyEddit edit;
	
	public keyKlick(HashSet<Integer> arr, MyLable labl, MyEddit edit) {
		this.arr=arr;
		this.labl=labl;
		this.edit=edit;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {		
		
		if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar()==e.VK_BACK_SPACE) {
	        edit.setEditable(true);
	       
	    } else {
	        edit.setEditable(false);
	    }
		
		if(e.getKeyCode() == e.VK_ENTER)
		{
			if(!edit.getText().trim().equals(""))
			{
				arr.add(Integer.valueOf(edit.getText()));
				labl.setText(arr.toString());
				edit.setText("");
				ms.combo1.addMas(arr);				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Ви не записали число!","Ошибка!",JOptionPane.ERROR_MESSAGE);
			}
		}
}

	
	
}
