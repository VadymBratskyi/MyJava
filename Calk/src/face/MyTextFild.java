package face;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

public class MyTextFild extends JTextField {

	public MyTextFild(int width, int height) {
	//	super.setColumns(size);
		super.setPreferredSize(new Dimension(width,height));
	}
	
	public MyTextFild(int width, int height, String txt) {
		this(width,height);
		super.setText(txt);
		super.setForeground(Color.gray);
		}
}
