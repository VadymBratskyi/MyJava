package face;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyPaannel extends JPanel {

	public MyPaannel(int width, int height) {
		super.setPreferredSize(new Dimension(width, height));
		super.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.blue));
		super.setLayout(null);
	}
	
}
