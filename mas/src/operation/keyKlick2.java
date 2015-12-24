package operation;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import face.MyEddit;
import face.MyLable;
import mas.ms;

public class keyKlick2 extends KeyAdapter {

	private ArrayList<String> arrss;
	private MyLable labl;
	private MyEddit edit;
	
	public keyKlick2(ArrayList<String> arrss, MyLable labl, MyEddit edit) {
		this.arrss=arrss;
		this.labl=labl;
		this.edit=edit;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {		
		
		if(e.getKeyCode() == e.VK_ENTER)
		{
			if(!edit.getText().trim().equals(""))
			{
				arrss.add(edit.getText());
				labl.setText(arrss.toString());
				edit.setText("");
				ms.combo2.addMas2(arrss);				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Ви не записали число!","Ошибка!",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	
	
}
