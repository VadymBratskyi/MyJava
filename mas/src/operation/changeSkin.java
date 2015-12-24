package operation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import face.MyFormm;

public class changeSkin implements ActionListener {

	private MyFormm form;
	private LookAndFeel feel;
	
	public changeSkin(LookAndFeel feel, MyFormm form){
		this.feel=feel;
		this.form=form;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		try {
			UIManager.setLookAndFeel(feel);
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SwingUtilities.updateComponentTreeUI(form);
		
	}
	
	
	
	
}
