package face;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyForms extends JFrame {

	public MyForms(String name) {
		super.setIconImage(new ImageIcon("D:\\Програми\\ICON\\png\\06_calculator.png").getImage());
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setTitle(name);
		super.setSize(400, 325);
		super.setVisible(true);
		super.setLocationRelativeTo(null);
		super.setLayout(new FlowLayout(0,5,5));
		super.setResizable(false);
	}
	
}
