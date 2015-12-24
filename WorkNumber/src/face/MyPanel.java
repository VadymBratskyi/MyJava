package face;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;


import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class MyPanel extends JPanel {

	private TitledBorder title;

	public MyPanel(int width, int haight, String tit,  int tbr, LayoutManager ly) {
	
		super.setPreferredSize(new Dimension(width,haight ));
		title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), tit);
		title.setTitleJustification(tbr);
		super.setBorder(title);
		super.setLayout(ly);
		
	}
	
}
