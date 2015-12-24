package face;

import java.awt.Dimension;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton {

	public MyButton(int width, int height, String text) {
		super.setText(text);
		super.setPreferredSize(new Dimension(width,height));
	}
}
