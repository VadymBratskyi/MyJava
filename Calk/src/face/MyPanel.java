package face;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class MyPanel extends JPanel{

	public MyPanel(int height, int width) {
		super.setPreferredSize(new Dimension(height,width));
		super.setBorder(BorderFactory.createEmptyBorder());
	//	super.setBackground(Color.red);
		super.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.PINK, Color.RED));
		super.setLayout(new FlowLayout(0,10,10));
	}
	
	
	
}
