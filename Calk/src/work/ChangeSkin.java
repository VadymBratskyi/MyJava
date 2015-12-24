package work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;

import face.MyForms;

public class ChangeSkin implements ActionListener {

	private LookAndFeel look;
	private MyForms fram;
	
	
	public ChangeSkin(LookAndFeel look, MyForms fram) {
		this.look=look;
		this.fram=fram;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		try {
			UIManager.setLookAndFeel(look);
		} catch (UnsupportedLookAndFeelException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(ChangeSkin.class.getName()).log(Level.SEVERE, null, ex);
		}
		SwingUtilities.updateComponentTreeUI(fram);
	}

}
