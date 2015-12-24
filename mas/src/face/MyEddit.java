package face;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;

public class MyEddit  extends JTextField{

	public MyEddit(int x, int y, int width, int height, String tx) {
		super.setBounds(x,y,width,height);
		super.setText(tx);
		super.setForeground(Color.GRAY);
	}
}
