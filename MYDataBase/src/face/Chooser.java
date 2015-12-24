/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package face;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


/**
 *
 * @author Vadym
 */
public class Chooser{
  
    private Edit ed1;

    public Chooser(Edit ed1) {
        this.ed1=ed1;
    } 
       
    public void  Open()
        {
        File fl = new File("D:\\");
        JFileChooser ch = new JFileChooser();
        ch.setCurrentDirectory(fl); 
        FileNameExtensionFilter fr = new FileNameExtensionFilter("*.db","db");
        ch.setFileFilter(fr);
        
        /*ch.addChoosableFileFilter(new FileFilter() {

            String typesee = "(*.db)";
            String notsee = "db";
            
            @Override
            public boolean accept(File file) {
                if(file == null) return false;
                if(file.isDirectory()) return true;
                return file.getName().toLowerCase().endsWith(notsee);
            }

            @Override
            public String getDescription() {
               return typesee;
            }
        });*/
        
        if(ch.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {      
            fl = ch.getSelectedFile();
            ed1.setText(fl.getAbsoluteFile().toString());       
        }
    }
    
}
