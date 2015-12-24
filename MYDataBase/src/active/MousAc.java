/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package active;

import face.Table;
import mydatabase.MyTableMode;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Vadym
 */
public class MousAc extends MouseAdapter{
    

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getClickCount() == 1)
        {
            Table tab = (Table)me.getSource();
            String value = tab.getValueAt(tab.getSelectedRow(),0).toString();
            MyTableMode.id = value;
           
        }
    }   
}
