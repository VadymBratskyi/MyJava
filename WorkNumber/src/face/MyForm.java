package face;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
@SuppressWarnings("serial")
public class MyForm extends JFrame {
	
	public MyForm(String title) {
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(400, 600);
		super.getContentPane().setLayout(new FlowLayout(1,1,5));
		super.setVisible(true);
	//	super.setIconImage(new ImageIcon("D:\\Програми\\ICON\\png\\document-preferences-2-icon.png").getImage());
		super.setLocationRelativeTo(null);
	}
	
}
