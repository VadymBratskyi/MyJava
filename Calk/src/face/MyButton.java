package face;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;;

public class MyButton extends JButton {
	
	public MyButton(String text, int width, int height) {
		super.setText(text);
		super.setPreferredSize(new Dimension(width,height));
		super.setFont(new Font("Times New Roma", Font.BOLD,15));
	}
}
