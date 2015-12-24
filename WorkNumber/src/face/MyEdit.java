package face;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyEdit extends JTextField {

	public MyEdit(int width, int height) {
		super.setPreferredSize(new Dimension(width, height));
		super.setFont(new Font("Times New Roman",Font.BOLD, 27));
	}
}
