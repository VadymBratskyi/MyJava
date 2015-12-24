package operation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

import mas.ms;
import face.MyButtonnn;
import face.MyCombo;
import face.MyLable;

public class actArray implements ActionListener {

	private MyLable labl;
	private MyCombo combo;
	private HashSet<Integer> arr;
	private ArrayList<String> arrss;
	private MyButtonnn bt;
	
	public actArray(MyCombo combo, MyLable labl, HashSet<Integer> arr, MyButtonnn bt) {
		this.arr=arr;
		this.combo=combo;
		this.labl=labl;
		this.bt=bt;
	}

	public actArray(MyCombo combo, MyLable labl, ArrayList<String> arrss, MyButtonnn bt) {
		this.arrss=arrss;
		this.combo=combo;
		this.labl=labl;
		this.bt=bt;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(bt.getText().trim().equals("”далить чис. с колекц."))
		{
			workHashSet();
		}
		else if(bt.getText().trim().equals("”далить стр. с колекц."))
		{
			workArrList();
		}
	}
	
	public void workHashSet()
	{
		if(combo.getItemCount()>0)
		{
			arr.remove(combo.getSelectedItem());	
			combo.removeAllItems();
			for(int i: arr)
			{
				combo.addItem(i);
			}			
			labl.setText(arr.toString());
		}
		else
		{
			labl.setText("Ёлементы коллекции");
		}
			
		
	}
	
	public void workArrList()
	{
		if(combo.getItemCount()>0)
		{
			arrss.remove(combo.getSelectedItem());	
			combo.removeAllItems();
			for(String i: arrss)
			{
				combo.addItem(i);
			}			
			labl.setText(arrss.toString());
		}
		else
		{
			labl.setText("Ёлементы коллекции");
		}	
	}
	

}
