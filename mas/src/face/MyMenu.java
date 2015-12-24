package face;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;

import operation.act;
import operation.changeSkin;
import operation.crfile;

public class MyMenu extends JMenuBar {

	public MyFormm form;
	
	public MyMenu(MyFormm form) {
		this.form=form;	
	}
	
	public void creatMenu()
	{
		JMenu file = new JMenu("Files");
		super.add(file);
		JMenuItem op = new JMenuItem("Save file");
		file.add(op);
		file.addSeparator();
		op.addActionListener(new activeFil());

		JMenuItem ex = new JMenuItem("Exit");
		file.add(ex);		
		ex.addActionListener(new activbtex());		
		
		JMenu style = new JMenu("Style");
		super.add(style);
		JMenuItem style1 = new JMenuItem("Стиль 1");
		JMenuItem style2 = new JMenuItem("Стиль 2");
		JMenuItem style3 = new JMenuItem("Стиль 3");
		JMenuItem style4 = new JMenuItem("Стиль 4");
		style.add(style1);
		style.add(style2);
		style.add(style3);
		style.add(style4);
		
		style1.addActionListener(new changeSkin(new MetalLookAndFeel(), form));
		style2.addActionListener(new changeSkin(new LunaLookAndFeel(), form));
		style3.addActionListener(new changeSkin(new TextureLookAndFeel(), form));
		style4.addActionListener(new changeSkin(new AluminiumLookAndFeel(), form));
		
		JMenu help = new JMenu("Help");
		super.add(help);
		JMenuItem ab = new JMenuItem("About programs");
		help.add(ab);
		
	}
	
	class activbtex implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);			
		}
	}
	
	class activeFil implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			File fl = new File("D:\\");			 
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Сохранение файла");   
			fileChooser.setCurrentDirectory(fl); 
		
		//////////////////////////////////////////////////////////////////////////////////////////
			fileChooser.addChoosableFileFilter(new FileFilter() {
				
				 String description = "EXE Files(*.exe)";//the filter you see  
			     String extension = "exe";//the filter passed to program  
				
				@Override
				public String getDescription() {
					// TODO Auto-generated method stub
					return description;
				}
				
				@Override
				public boolean accept(File f) {
					if(f== null) return false;
					if(f.isDirectory()) return true;
					return f.getName().toLowerCase().endsWith(extension);
				}
			});//adds new filter into list  
			
			
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
			    crfile crf = new crfile(fileToSave.getAbsolutePath());
			    crf.creatFile();
			}
			
		}
		
	}
	
}
