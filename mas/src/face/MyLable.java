package face;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;

public class MyLable extends JLabel{

	public MyLable(String txt, int x, int y, int width, int height) {
	
		super.setText(txt);
		super.setFont(new Font("Times New Roman", Font.BOLD, 15));
		super.setBounds(x,y,width,height);
		
	}
}
