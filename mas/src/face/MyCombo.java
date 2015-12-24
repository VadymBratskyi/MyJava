package face;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JComboBox;

import operation.act;

public class MyCombo extends JComboBox {

	public MyCombo(int x, int y, int width, int height) {
		super.setBounds(x,y,width,height);
	}
	
	
	public void addMas(HashSet<Integer> arr) {
		super.removeAllItems();		
		for(int i: arr)
		{
			super.addItem(i);
		}	
	}
	
	public void addMas2(ArrayList<String> arrss) {
		super.removeAllItems();
		for(String i: arrss)
		{
			super.addItem(i);
		}		
		
		
	}
	
}
