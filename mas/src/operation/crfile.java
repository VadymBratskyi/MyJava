package operation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import mas.ms;

public class crfile {

	private  String adres;
	
	public crfile(String adres) {
		this.adres=adres;				
	}
	
	public void creatFile()
	{
		
		JOptionPane.showMessageDialog(null, "���� ��������!!", "����������", JOptionPane.INFORMATION_MESSAGE);
		try
		{
			File fl = new File(adres);
			FileWriter fw = new FileWriter(fl);
			BufferedWriter bfw = new BufferedWriter(fw);
			bfw.write("����� ������: "+act.mss+"\n");
			bfw.write("������������: "+act.sortMas+"\n");
			bfw.write(act.smsr+"\n");
			bfw.write(act.mnmx+"\n");
			bfw.write(act.countChNch+"\n");
			bfw.write(act.writeCh+" / "+act.writeNCh+"\n");
			bfw.write("��������<HashSet> �����: "+"\n");
			bfw.write(ms.arr.toString());
			bfw.write("\n��������<ArrayList> �����: "+"\n");
			bfw.write(ms.arrss.toString());
			bfw.flush();
			bfw.close();
			
		}catch(IOException ex)
		{
			Logger.getLogger(crfile.class.getName()).log(Level.SEVERE, null, ex);
		}
	} 
	
}
