package face;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel{

	 public MyLabel(String text) {
		 super.setText(text);
		 super.setFont(new Font("Times New Roman", Font.BOLD, 16));
	}
	 
	 
	 public MyLabel(String text, Color cl) {
		 super.setText(text);
		 super.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		 super.setForeground(cl);
	}
}
