import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;



import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;



public class oclfile extends JFrame {

	private JFrame frame;
	private JMenu menu;
	private JMenu menu1;
	private JMenuItem it0;
	private JMenuItem it1;
	private JMenuItem it2;
	private JMenuItem it3;
	private JMenuItem it4;
	private JMenuItem it5;
	private JMenuItem it6;
	private JMenuItem it7;
	private JMenuItem itm1;
	private JMenuBar mb;
	private JTextArea tar;
	
	
	public static void main(String [] args)
	{
		oclfile oc = new oclfile();
		
		oc.textArie();
		oc.crMenu();
		oc.crForm();
		
	}
	
	
	public void textArie()
	{
		tar = new JTextArea();
		tar.setBounds(30, 50, 280, 200);
		tar.setBorder(BorderFactory.createEtchedBorder());
	}
	
	public void crForm()
	{
		frame = new JFrame("OpenCloseFile");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350,400);
		frame.setVisible(true);
		frame.setJMenuBar(mb);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.add(tar);
	}
	
	public void crMenu()
	{
		try {
			UIManager.setLookAndFeel(new AcrylLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		mb = new JMenuBar();
		menu = new JMenu("File");		
		mb.add(menu);
		it0 = new JMenuItem("New File");
		it0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tar.setText("");
				
			}
		});
		menu.add(it0);
		it1 = new JMenuItem("Open File");
		it1.addActionListener(new act());
		menu.add(it1);
		it2 = new JMenuItem("Save File");
		it2.addActionListener(new saveFil());
		menu.add(it2);
		menu.addSeparator();
		it3 = new JMenuItem("Close");
		menu.add(it3);
		
		menu1 = new JMenu("Propertis");
		mb.add(menu1);
		itm1 = new JMenu("Style");
		
		it4 = new JMenuItem("st1");
		it4.addActionListener(new style(new AeroLookAndFeel()));
		it5 = new JMenuItem("st2");
		it5.addActionListener(new style(new AluminiumLookAndFeel()));
		it6 = new JMenuItem("st3");
		it6.addActionListener(new style(new AcrylLookAndFeel()));
		it7 = new JMenuItem("st4");
		it7.addActionListener(new style(new NoireLookAndFeel()));
		
		
		
		itm1.add(it4);
		itm1.add(it5);
		itm1.add(it6);
		itm1.add(it7);
		menu1.add(itm1);
	}
	
	
	class style implements ActionListener
	{

		private LookAndFeel feel;
		
		public style(LookAndFeel feel) {
			this.feel = feel;

		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				UIManager.setLookAndFeel(feel);
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			SwingUtilities.updateComponentTreeUI(frame);
		}
		
	}	
		
		
	class oppFile
	{
		JFileChooser fch = new JFileChooser();
		StringBuilder bld = new StringBuilder();
	
		public void Oppp() 
		{
			if(fch.showOpenDialog(null)== JFileChooser.APPROVE_OPTION)
			{
		
				File fil = fch.getSelectedFile();
				
				try {
					
					Scanner input = new Scanner(fil);
					while(input.hasNext())
					{
						bld.append(input.nextLine());
						bld.append("\n");
					}
					input.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else
			{
				bld.append("Not found file!");
			}
		}
		
	}
	
	class activbtex implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);			
		}
	}
	
	class saveFil implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			File fl = new File("D:\\");			 
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Сохранение файла");   
			fileChooser.setCurrentDirectory(fl); 
				
			fileChooser.addChoosableFileFilter(new FileFilter()//adds new filter into list  
		     {  
		       String description = "Text Files(*.txt)";//the filter you see  
		       String extension = "txt";//the filter passed to program  
		       
			   public String getDescription()  
		       {
		         return description;  
		       }  
		       public boolean accept(File f)  
		       {  
		         if(f == null) return false;  
		         if(f.isDirectory()) return true;  
		         return f.getName().toLowerCase().endsWith(extension);  
		       }  
		     });  
		///////////////////////////////////////////////////////////////////////////	
			int userSelection = fileChooser.showSaveDialog(null);
			 
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
			    try {
					FileWriter fwr = new FileWriter(fileToSave.getAbsolutePath());
					BufferedWriter bfwr = new BufferedWriter(fwr);
					bfwr.write(tar.getText());
					    bfwr.flush();
					    bfwr.close();
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			}
		
		}
		
	}
	
	
	class act implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
 
			oppFile op = new oppFile();
			op.Oppp();
			
		tar.setText(op.bld.toString());
		}
		
	}
}
