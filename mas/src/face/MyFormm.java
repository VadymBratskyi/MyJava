package face;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MyFormm extends JFrame {

	public MyFormm(String title) {
		
		MyMenu menu = new MyMenu(this);
		super.setTitle(title);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setSize(400, 565);		
		super.setMinimumSize(new Dimension(400,565));
		//super.setResizable(false);
		super.setLayout(new FlowLayout());
		super.setLocationRelativeTo(null);
		super.setJMenuBar(menu);
		menu.creatMenu();
		super.setVisible(true);
	}
	
}
