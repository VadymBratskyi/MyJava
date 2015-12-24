/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package active;

import face.*;
import mydatabase.MyTableMode;
import mydatabase.OracleConnect;
import mydatabase.SQLConnectionSQLIte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static mydatabase.MYDataBase.fr1;


/**
 *
 * @author Vadym
 */
public class Action implements ActionListener{

 
    private ComboBox comb1; 
    private ComboBox boxSearch;
    private static String nameSel;
    private static MyTableMode mod;
    private Label lb1;
    private Table tb;
    public  JScrollPane scr1;
    private Button bt1;
    private Edit ed1;
    private Edit ed;
    private String [] masCollNam;
    private int count;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JButton bt;
    private JButton bt2;
    private JFrame addFr;
    private JFrame addFr2;
    private JFrame serFr3;
    private JLabel lb;
    private Label lab;
    private JTextField tf; 
    private JComboBox cb; 
    public String [] valFk;
    public String [] colFk;
    public String SearchBoxVal;
    
    public String namColPK = null;
    public String selColFK = null;
    public String namTab = null;
    public String first;//(Sel, Del, Ins, Upd)
    
    public static Connection conn;
    
     public static String UsName=null;
     public static String password=null;
      
    public Action(ComboBox comb1, Label lb1,Button bt1,Table tb) {
        this.comb1 = comb1;
        this.lb1 = lb1;
        this.bt1 = bt1;
        this.tb = tb;
    }  
    
    public Action(Edit ed1, ComboBox comb1, Label lb1,Button bt1) {
        this.ed1 = ed1;
        this.comb1 = comb1;
        this.lb1 = lb1;
        this.bt1 = bt1;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
     
            if(bt1.getText().trim().equals("Connect"))
            {  if(UsName==null && password==null)
               {ConnectSQLite();
               }else{ConnectORCL();}                
            }else if(bt1.getText().trim().equals("Load Table"))
            {  LoadTable();
            }else if(bt1.getText().trim().equals("Load Table_2"))
            {  LoadTable2();
            }else if(bt1.getText().trim().equals("UPDATE"))
            {  UpdateDB(); 
            }else if(bt1.getText().trim().equals("ADD"))
            {  InsertDB();
            }else if(bt1.getText().trim().equals("ADD2"))
            {  InsertDB2();
            }else if(bt1.getText().trim().equals("DELETE"))
            {  DeleteDB(); 
            }else if(bt1.getText().trim().equals("SEARCH"))
            {  Search();
            }else if(bt1.getText().trim().equals("SEARCH_2"))
            {  Search2();
            }else if(bt1.getText().trim().equals("Replace fk_id search"))
            {  Change_FK_Search();
            }else if(bt1.getText().trim().equals("COUNT ROWS"))
            {  CountRo(); 
            }else if(bt1.getText().trim().equals("SQL"))
            {  NewFormSQL();
            }else if(bt1.getText().trim().equals("Replace fk_id"))
            {  Change_FK();
            }
    }
       
    private void ConnectSQLite()
    {   
        ArrayList tabNam = new ArrayList();
        
        comb1.removeAllItems();
        
            try {
            conn = SQLConnectionSQLIte.getConnection(ed1.getText().trim());
            
            ResultSet res =  conn.getMetaData().getTables(null, null, null, null);
            while(res.next())
            {
                tabNam.add(res.getString(3));
            }          
            
            for(int i=0; i<tabNam.size(); i++)
            {
                comb1.addItem(tabNam.get(i).toString());
            }
        
            lb1.setText("Connection saccessful!!!!!");
             
        } catch (SQLException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void ConnectORCL()
    {   
        ArrayList tabNam = new ArrayList();
        
        comb1.removeAllItems();
        
            try{
            conn = OracleConnect.getConnection(ed1.getText().trim(),UsName,password);
            
          Statement stm = null;
            ResultSet res = null;
            stm = conn.createStatement();
                         
            res = stm.executeQuery("Select object_name From user_objects Where object_type = 'TABLE'");
            
            while(res.next())
            {
                tabNam.add(res.getString(1));
            }
   
            for(int i=0; i<tabNam.size(); i++)
            {
                comb1.addItem(tabNam.get(i).toString());
            }
                      
            lb1.setText("Connection saccessful!!!!!");
            UsName=null;
            password=null;
        } catch (SQLException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     
    private void LoadTable()
    {
        try {
        
        nameSel = String.valueOf(comb1.getSelectedItem());
            
        mod = new MyTableMode(conn, nameSel,"Select * From "+nameSel);        
         
        lb1.setText(null);                   
                    
         tb.setModel(mod);
        
        } catch (SQLException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 private void LoadTable2()
    {
        try {
          nameSel = String.valueOf(comb1.getSelectedItem());        
            
          mod = new MyTableMode(conn, nameSel,"Select * From "+nameSel);
          
          if(mod.getFkColCount()>0)
          { 
            lb1.setText(null);
            Change_FK();
          }else
          {
            mod = new MyTableMode(conn, nameSel,"Select * From "+nameSel);
            lb1.setText(null);
            tb.setModel(mod);
          }
          
          
           
        } catch (SQLException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }      
      
    }
    
    
    private void UpdateDB()
    {
      if(mod.refreshDb(nameSel))JOptionPane.showMessageDialog(null, "Update saccessful!!");
      else JOptionPane.showMessageDialog(null, "Update error!", "Error",JOptionPane.ERROR_MESSAGE);
    }
    
    private void InsertDB()
    {
          fr1.setEnabled(false);          
          addFr = new JFrame("Add values");
          bt = new JButton("ADD");
          
          
          panel1 = new JPanel();
          panel2 = new JPanel();
          panel3 = new JPanel();
          panel4 = new JPanel();     
          
          addFr.setLayout(null);        
            
          panel1.setLayout(new FlowLayout(0,0,7));       
          panel2.setLayout(new FlowLayout(0,0,7));    
          panel3.setLayout(new FlowLayout(0,0,7));   
          panel4.setLayout(new FlowLayout(0,0,7));
          
          addFr.add(panel1);
          addFr.add(panel2);
          addFr.add(panel3);
          addFr.add(panel4);
          addFr.add(bt);
          
          final ArrayList text = new ArrayList();
          final ArrayList labl = new ArrayList();           
          
          for(int i=0; i<mod.getColumnCount(); i++)
          {        
              if(i%2==0)
              {     
              count++;
              tf = new JTextField();
              lb = new JLabel();
              lb.setPreferredSize(new Dimension(100,20));
              lb.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
              lb.setText(mod.getColumnName(i));      
              tf.setPreferredSize(new Dimension(100,20));
              tf.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
	      text.add(tf);              
              labl.add(lb);
	      panel1.add(lb);
              panel2.add(tf);
              }
              else
              {
              tf = new JTextField();
              lb = new JLabel();
              lb.setPreferredSize(new Dimension(100,20));
              lb.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
              lb.setText(mod.getColumnName(i));      
              tf.setPreferredSize(new Dimension(100,20));
              tf.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
	      text.add(tf);
              labl.add(lb);
	      panel3.add(lb);
              panel4.add(tf);
              }
          }  
          int i=30;
          while(count>0)
          {               
              panel1.setBounds(10, 10, 100, i);
              panel2.setBounds(110, 10, 100, i);
              panel3.setBounds(215, 10, 100, i);
              panel4.setBounds(315, 10, 100, i);              
              count--;
              i+=30;             
          }   
          bt.setBounds(110, panel1.getHeight()+20, 200, 25);        
          panel1.repaint();
          addFr.setSize(450,panel1.getHeight()+80);
          addFr.setLocationRelativeTo(null);
          addFr.setResizable(false); 
          
          addFr.addWindowListener(new WindowAdapter() {

              @Override
              public void windowClosing(WindowEvent we) {
                fr1.setEnabled(true);
              }

          });
          bt.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent ae) { 
               
                  Object [] values = new Object[text.size()];
               
               for(int i=0; i<text.size(); i++)
                {
                   JTextField tt;
                   tt = (JTextField) text.get(i);                 
                   values[i] = tt.getText();
                }
                            
            if(mod.addRows(nameSel,values))
            {  UpdateTable();  
                 for(int i=0; i<text.size(); i++)
                {
                   JTextField tt;
                   tt = (JTextField) text.get(i); 
                   tt.setText("");
                }
            }else
            {  JOptionPane.showMessageDialog(null, "ADD error!", "Error",JOptionPane.ERROR_MESSAGE);
            } 
            }              
              
          });
          
          addFr.setVisible(true);        
    }
    
     private void InsertDB2()
    {        
          fr1.setEnabled(false);          
          addFr2 = new JFrame("Add values");
          bt = new JButton("Filling combobox and active textbox");        
          
          panel1 = new JPanel();
          panel2 = new JPanel();
          panel3 = new JPanel();
          panel4 = new JPanel();     
          
          addFr2.setLayout(null);        
            
          panel1.setLayout(new FlowLayout(0,0,7));       
          panel2.setLayout(new FlowLayout(0,0,7));    
          panel3.setLayout(new FlowLayout(0,0,7));   
          panel4.setLayout(new FlowLayout(0,0,7));
          
          addFr2.add(panel1);
          addFr2.add(panel2);
          addFr2.add(panel3);
          addFr2.add(panel4);
          addFr2.add(bt);
          
          
        
          final ArrayList text = new ArrayList();
          final ArrayList labl = new ArrayList(); 
          final ArrayList box = new ArrayList(); 
          final ArrayList BoxTex = new ArrayList();
                   
          for(int i=0; i<mod.getColumnCount(); i++)
          {                      
                    if(i%2==0)
                    {     
                    count++;             
                    lb = new JLabel();               
                    lb.setPreferredSize(new Dimension(100,20));
                    lb.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
                    lb.setText(mod.getColumnName(i));  
                    labl.add(lb);
                    panel1.add(lb);
                            if(mod.getFK(mod.getColumnName(i)))
                            {
                                cb = new JComboBox();
                                cb.setPreferredSize(new Dimension(100,20));
                                cb.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));                    
                                mod.TabColNam(mod.getFkTable(mod.getFkTableInd(mod.getColumnName(i))));
                                for(int k=0; k<mod.getFKTableColCountAdd(); k++)
                                {
                                    cb.addItem(mod.getFkClNamAdd(k));
                                }
                                box.add(cb); 
                                BoxTex.add(cb);
                                panel2.add(cb); 
                                
                            }else
                            {
                                tf = new JTextField();
                                tf.setPreferredSize(new Dimension(100,20));
                                tf.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
                                tf.setEnabled(false);
                                text.add(tf);
                                BoxTex.add(tf);
                                panel2.add(tf); 
                            }
                        }                                
                    else
                    {                   
                    lb = new JLabel();
                    lb.setPreferredSize(new Dimension(100,20));
                    lb.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
                    lb.setText(mod.getColumnName(i));                    
                    labl.add(lb);
                    panel3.add(lb);
                     
                            if(mod.getFK(mod.getColumnName(i)))
                            {
                                cb = new JComboBox();
                                cb.setPreferredSize(new Dimension(100,20));
                                cb.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
                                mod.TabColNam(mod.getFkTable(mod.getFkTableInd(mod.getColumnName(i))));
                                for(int k=0; k<mod.getFKTableColCountAdd(); k++)
                                {
                                    cb.addItem(mod.getFkClNamAdd(k));
                                }
                                box.add(cb);  
                                BoxTex.add(cb);
                                panel4.add(cb);                              
                            }else
                            {
                                tf = new JTextField();
                                tf.setPreferredSize(new Dimension(100,20));
                                tf.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
                                tf.setEnabled(false);
                                text.add(tf);
                                BoxTex.add(tf);
                                panel4.add(tf); 
                            }
                    }                     
            }
         
          int i=30;
          while(count>0)
          {               
              panel1.setBounds(10, 10, 100, i);
              panel2.setBounds(110, 10, 100, i);
              panel3.setBounds(215, 10, 100, i);
              panel4.setBounds(315, 10, 100, i);              
              count--;
              i+=30;             
          }   
          bt.setBounds(110, panel1.getHeight()+20, 210, 25);        
          panel1.repaint();
          addFr2.setSize(450,panel1.getHeight()+80);
          addFr2.setLocationRelativeTo(null);
          addFr2.setResizable(false); 
          
          addFr2.addWindowListener(new WindowAdapter() {

              @Override
              public void windowClosing(WindowEvent we) {
                fr1.setEnabled(true);
              }

          });
          bt.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent ae) { 
                  if(bt.getText().trim().equals("Filling combobox and active textbox"))
                  {
                      valFk = new String[box.size()];                      
                      
                      for(int i=0; i<box.size(); i++)
                      {
                          JComboBox tt;
                          tt = (JComboBox) box.get(i);
                          valFk[i] = (String) tt.getSelectedItem();
                          tt.removeAllItems();                         
                      }                    
                      
                      for(int i=0; i<valFk.length; i++)
                      {
                          mod.getValueColFKTabl(mod.getFkTable(i),valFk[i]);
                          
                          for(int j=0; j<mod.getValuesKFTSize(); j++)
                          {
                              JComboBox tt;
                              tt = (JComboBox) box.get(i);
                              tt.addItem(mod.getValuesKFT(j));
                          }
                      }
                      
                      for(int i=0; i<text.size(); i++)
                      {
                          JTextField tf;
                          tf = (JTextField) text.get(i);
                          tf.setEnabled(true);
                      }
                      
                       bt.setText("ADD");
                       
                  }else
                  {   
                       Object [] SelVal = new Object[BoxTex.size()];
                      
                       for(int i=0; i<BoxTex.size(); i++)
                       {
                          if(BoxTex.get(i) instanceof JComboBox)
                          {
                              JComboBox tt;
                              tt = (JComboBox) BoxTex.get(i);                              
                              SelVal[i]=tt.getSelectedIndex()+1;                               
                              
                          }else if(BoxTex.get(i) instanceof JTextField)
                          {
                              JTextField tf;
                              tf = (JTextField) BoxTex.get(i);
                              SelVal[i]=tf.getText();
                          }
                       }
                       fr1.setEnabled(true);
                       addFr2.setVisible(false); 
                         
                if(mod.addRows(nameSel,SelVal))
                { UpdateFK(valFk);
                }else
                {  JOptionPane.showMessageDialog(null, "ADD error!", "Error",JOptionPane.ERROR_MESSAGE);
                } 

            }           
            }
              
          });
          
          addFr2.setVisible(true);        
    }
    
    
    
    private void DeleteDB()
    {
            if(mod.deleteRows(nameSel))
            {  UpdateTable();
            }else
            {
                JOptionPane.showMessageDialog(null, "Delete error!", "Error",JOptionPane.ERROR_MESSAGE);
            }  
    }
    
    public void CountRo()
    {
        JOptionPane.showMessageDialog(null, "Count rows: "+mod.getRowCount(),"Info count",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void UpdateTable()
    {
        try {  
            mod = new MyTableMode(conn, nameSel,"Select * From "+nameSel);
            tb.setModel(mod);
        } catch (SQLException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void UpdateFK(String [] val)
    {  
        try {
            mod = new MyTableMode(conn, nameSel,"Select * From "+nameSel);
            mod.newFKTable(nameSel,"Select * From "+nameSel, val);          
            tb.setModel(mod);
        } catch (SQLException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Search()
    {    
          mod.search(nameSel);        
    } 
    
    private void Search2()
    {       
               fr1.setEnabled(false);
               ed = new Edit(70,40,150,20);
               boxSearch = new ComboBox(70,40,150,20);
               for(int i=0; i<mod.getColumnCount(); i++)
               {
                   boxSearch.addItem(mod.getColumnName(i));
               }
               lab = new Label(70,20,200,20,"Select column and value");
               bt2 = new Button("Load", 100, 20, 95,90);
               serFr3 = new JFrame("Search");            
               serFr3.setSize(300, 150);
               serFr3.setLocationRelativeTo(null);
               serFr3.setResizable(false);
               serFr3.setLayout(null);
               serFr3.getContentPane().add(lab);
               serFr3.getContentPane().add(boxSearch);
               serFr3.getContentPane().add(bt2);
               serFr3.addWindowListener(new WindowAdapter() {

              @Override
              public void windowClosing(WindowEvent we) {
                fr1.setEnabled(true);
              }

          });
            bt2.addActionListener(new ActionListener() {

                   @Override
                   public void actionPerformed(ActionEvent ae) {                       
                               
                           if(mod.getFK(boxSearch.getSelectedItem().toString()))
                           {
                               lab.setText("Search of "+boxSearch.getSelectedItem());                               
                               namTab = mod.getFkTable(mod.getColTabNam(boxSearch.getSelectedItem().toString())); 
                               namColPK = boxSearch.getSelectedItem().toString();
                               mod.TabColNam(namTab);
                               colFk = new String[mod.getFKTableColCountAdd()];
                               SearchBoxVal = boxSearch.getSelectedItem().toString();
                               MyTableMode.selVal = SearchBoxVal;
                               for(int i=0; i<mod.getFKTableColCountAdd(); i++)
                               {
                                   colFk[i]=mod.getFkClNamAdd(i);
                               }                               
                               selColFK = (String)JOptionPane.showInputDialog(null,"Select column:",null,JOptionPane.PLAIN_MESSAGE,null,colFk,colFk[0]);
                               mod.getValueColFKTabl(namTab, selColFK);
                               boxSearch.removeAllItems();
                               for(int i=0; i<mod.getValuesKFTSize(); i++)
                               {
                                   boxSearch.addItem(mod.getValuesKFT(i).toString());
                               } 
                               bt2.setText("Search");
                               
                           }else if(!mod.getFK(boxSearch.getSelectedItem().toString())&& bt2.getText().trim().equals("Load"))
                           {
                               boxSearch.setVisible(false);
                               lab.setText("Search of "+boxSearch.getSelectedItem()); 
                               SearchBoxVal = boxSearch.getSelectedItem().toString();
                               MyTableMode.selVal = SearchBoxVal;
                               serFr3.getContentPane().add(ed);
                               bt2.setText("Search");
                               
                           }else if(selColFK!=null)
                           {
                               MyTableMode.idSel = String.valueOf((boxSearch.getSelectedIndex()+1));
                               mod.search2(nameSel, namColPK, (boxSearch.getSelectedIndex()+1));     
                               fr1.setEnabled(true);
                               serFr3.setVisible(false);
                               selColFK=null;
                           }else if(selColFK==null && bt2.getText().trim().equals("Search"))
                           {
                               MyTableMode.idSel = ed.getText();
                               mod.search2(nameSel, SearchBoxVal, Integer.valueOf(ed.getText()));                               
                               fr1.setEnabled(true);
                               serFr3.setVisible(false);
                           }
                       
                   }
                   
               });
               serFr3.setVisible(true);
    }
    
    private void NewFormSQL()
    {
        nameSel = String.valueOf(comb1.getSelectedItem()); 
        final String TextArr="New SQL query";
        final JButton btSQL = new JButton("Running SQL");
        btSQL.setSize(100, 25);
        final JTextArea arr = new JTextArea(TextArr);
        arr.setPreferredSize(new Dimension(480,240));
        arr.setForeground(Color.GRAY);
        arr.setFocusable(false);
        arr.addMouseListener(new MouseAdapter() {

           @Override
           public void mouseClicked(MouseEvent me) {
              if(arr.getText().trim().equals(TextArr))
              {
               arr.setFocusable(true);
               arr.setText("");
               arr.setForeground(Color.BLACK);
              }
           }
            
        });
        
        arr.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
        
        btSQL.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {                
               if(arr.getText().trim().equals(TextArr) || arr.getText().trim().equals(""))
               {
                   JOptionPane.showMessageDialog(null, "You haven't written query!","Error!", JOptionPane.ERROR_MESSAGE);
                   arr.setForeground(Color.GRAY);
                   arr.setText(TextArr);
               }else
               {
                   String[] from = arr.getText().split(" ");  
                   ArrayList select = new ArrayList(); // name coll           
                   String tabName=""; 
                   String star =""; 
                   int s = 0,f=0;
                   
                   
                   for(int i=0; i<from.length; i++)
                   {
                       if(from[i].equals("from") || from[i].equals("From") || from[i].equals("FROM"))
                       {
                           f=i;
                           tabName=from[i+1].replace(',', ' ').trim();                           
                       }
                       else if(from[i].equals("select") || from[i].equals("Select") || from[i].equals("SELECT"))
                       {
                           s=i;
                           first=from[i].toLowerCase();
                       }else if(from[i].equals("delete") || from[i].equals("Delete") || from[i].equals("Delete"))
                       {
                           first=from[i].toLowerCase();                                
                       }else if(from[i].equals("insert") || from[i].equals("Insert") || from[i].equals("INSERT"))
                       {
                           first=from[i].toLowerCase();                                
                       }else if(from[i].equals("update") || from[i].equals("Update") || from[i].equals("UPDATE"))
                       {
                           first=from[i].toLowerCase();                                
                       }else if(from[i].trim().equals("*"))
                       {
                           star=from[i];
                       }
                   }                   
                   comb1.setSelectedItem(tabName);
                   
                   for(int i=0; i<from.length; i++)
                       {
                            if(i>s && i<f)
                            {
                                  select.add(from[i].replace(',', ' ').trim());                                 
                            }
                       }                    
                   
                   masCollNam = new String [select.size()];
                   select.toArray(masCollNam);
                       
                   String sql = arr.getText().replaceAll("[\\s]{2,}", " ");
                  
                  try {
                    if(first.trim().equals("select"))
                    {  
                       if(star.trim().equals("*"))
                       {
                           mod = new MyTableMode(conn, tabName, sql);
                           tb.setModel(mod);
                       }else  if(star.trim().equals(""))
                       {
                            mod = new MyTableMode(conn, tabName, sql, masCollNam);
                            tb.setModel(mod);
                       }
                    }else if(first.trim().equals("delete"))
                    {
                        mod.querySQL(sql);                        
                        UpdateTable(); 
                    }else if(first.trim().equals("insert"))
                    {
                        mod.querySQL(sql);                        
                        UpdateTable(); 
                    }else if(first.trim().equals("update"))
                    {
                        mod.querySQL(sql);                        
                        UpdateTable(); 
                    }
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
                    }
               }
            }
        });
       
            JFrame fr = new JFrame("New SQL query");          
            fr.setLayout(new FlowLayout());
            fr.setSize(500, 303);
            fr.setResizable(false);
            fr.getContentPane().add(arr);
            fr.getContentPane().add(btSQL);
            fr.setLocationRelativeTo(null); 
            fr1.setEnabled(false);
            fr.setVisible(true);               
            fr.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                fr1.setEnabled(true);
            }
            
            
        });    
    }
    
    public void Change_FK_Search()
    {
          fr1.setEnabled(false);          
          addFr = new JFrame("Replacementm of fk_id");
          bt = new JButton("Replace");
          
          
          panel1 = new JPanel();
          panel2 = new JPanel();
          panel3 = new JPanel();
          panel4 = new JPanel();     
          
          addFr.setLayout(null);        
            
          panel1.setLayout(new FlowLayout(0,0,7));       
          panel2.setLayout(new FlowLayout(0,0,7));    
          panel3.setLayout(new FlowLayout(0,0,7));   
          panel4.setLayout(new FlowLayout(0,0,7));
          
          addFr.add(panel1);
          addFr.add(panel2);
          addFr.add(panel3);
          addFr.add(panel4);
          addFr.add(bt);
          
          final ArrayList text = new ArrayList();
          final ArrayList labl = new ArrayList();                
          
          for(int i=0; i<mod.getFkColCount(); i++)
          {   
              if(i%2==0)
              {     
              count++;
              cb = new JComboBox();
              lb = new JLabel();
              lb.setPreferredSize(new Dimension(100,20));
              lb.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
              lb.setText(mod.getFkColumn(i));       
              cb.setPreferredSize(new Dimension(100,20));
              cb.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
              for(int j=0; j<mod.getFKTableColCount(); j++)
              {
                       cb.addItem(mod.addComboBox(mod.getFkTable(i), j));
              }      
              text.add(cb);
              labl.add(lb);
	      panel1.add(lb);
              panel2.add(cb);
              }
              else
              {
              cb = new JComboBox();
              lb = new JLabel();
              lb.setPreferredSize(new Dimension(100,20));
              lb.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
              lb.setText(mod.getFkColumn(i));      
              cb.setPreferredSize(new Dimension(100,20));
              cb.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
              for(int j=0; j<mod.getFKTableColCount(); j++)
              {
                       cb.addItem(mod.addComboBox(mod.getFkTable(i), j));
              }  
              text.add(cb);
              labl.add(lb);
	      panel3.add(lb);
              panel4.add(cb);
              }
          } 
          
          int i=30;
          while(count>0)
          {               
              panel1.setBounds(10, 10, 110, i);
              panel2.setBounds(120, 10, 100, i);
              panel3.setBounds(225, 10, 110, i);
              panel4.setBounds(335, 10, 100, i);              
              count--;
              i+=30;             
          }   
          bt.setBounds(110, panel1.getHeight()+20, 200, 25);        
          panel1.repaint();
          addFr.setSize(470,panel1.getHeight()+80);
          addFr.setLocationRelativeTo(null);
          addFr.setResizable(false); 
          
          addFr.addWindowListener(new WindowAdapter() {

              @Override
              public void windowClosing(WindowEvent we) {
                fr1.setEnabled(true);
              }

          });
          bt.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent ae) { 
             
                 
                      String [] values = new String[text.size()];
                      
                      for(int i=0; i<text.size(); i++)
                      {
                          JComboBox tt;
                          tt = (JComboBox) text.get(i);
                          values[i] = (String) tt.getSelectedItem();
                      }
                      mod.newFKTableSearch(nameSel,values);                                 
                      tb.setModel(mod);                    
                      fr1.setEnabled(true);
                      addFr.setVisible(false);                  
                      
               }            
          });
          
          addFr.setVisible(true);  
       
       
    }
    
    
    public void Change_FK()
    {       
       
          fr1.setEnabled(false);          
          addFr = new JFrame("Replacementm of fk_id");
          bt = new JButton("Replace");
          
          
          panel1 = new JPanel();
          panel2 = new JPanel();
          panel3 = new JPanel();
          panel4 = new JPanel();     
          
          addFr.setLayout(null);        
            
          panel1.setLayout(new FlowLayout(0,0,7));       
          panel2.setLayout(new FlowLayout(0,0,7));    
          panel3.setLayout(new FlowLayout(0,0,7));   
          panel4.setLayout(new FlowLayout(0,0,7));
          
          addFr.add(panel1);
          addFr.add(panel2);
          addFr.add(panel3);
          addFr.add(panel4);
          addFr.add(bt);
          
          final ArrayList text = new ArrayList();
          final ArrayList labl = new ArrayList();                
          
          for(int i=0; i<mod.getFkColCount(); i++)
          {   
              if(i%2==0)
              {     
              count++;
              cb = new JComboBox();
              lb = new JLabel();
              lb.setPreferredSize(new Dimension(100,20));
              lb.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
              lb.setText(mod.getFkColumn(i));       
              cb.setPreferredSize(new Dimension(100,20));
              cb.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
              for(int j=0; j<mod.getFKTableColCount(); j++)
              {
                       cb.addItem(mod.addComboBox(mod.getFkTable(i), j));
              }      
              text.add(cb);
              labl.add(lb);
	      panel1.add(lb);
              panel2.add(cb);
              }
              else
              {
              cb = new JComboBox();
              lb = new JLabel();
              lb.setPreferredSize(new Dimension(100,20));
              lb.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
              lb.setText(mod.getFkColumn(i));      
              cb.setPreferredSize(new Dimension(100,20));
              cb.setBorder(BorderFactory.createEtchedBorder(Color.yellow, Color.black));
              for(int j=0; j<mod.getFKTableColCount(); j++)
              {
                       cb.addItem(mod.addComboBox(mod.getFkTable(i), j));
              }  
              text.add(cb);
              labl.add(lb);
	      panel3.add(lb);
              panel4.add(cb);
              }
          } 
          
          int i=30;
          while(count>0)
          {               
              panel1.setBounds(10, 10, 110, i);
              panel2.setBounds(120, 10, 100, i);
              panel3.setBounds(225, 10, 110, i);
              panel4.setBounds(335, 10, 100, i);              
              count--;
              i+=30;             
          }   
          bt.setBounds(110, panel1.getHeight()+20, 200, 25);        
          panel1.repaint();
          addFr.setSize(470,panel1.getHeight()+80);
          addFr.setLocationRelativeTo(null);
          addFr.setResizable(false); 
          
          addFr.addWindowListener(new WindowAdapter() {

              @Override
              public void windowClosing(WindowEvent we) {
                fr1.setEnabled(true);
              }

          });
          bt.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent ae) { 
             
                 
                      String [] values = new String[text.size()];
                      
                      for(int i=0; i<text.size(); i++)
                      {
                          JComboBox tt;
                          tt = (JComboBox) text.get(i);
                          values[i] = (String) tt.getSelectedItem();
                      }
                           
                      mod.newFKTable(nameSel,"Select * From "+nameSel, values);                      
                      tb.setModel(mod);
                      fr1.setEnabled(true);
                      addFr.setVisible(false);                  
                      
               }            
          });
          
          addFr.setVisible(true);                 
    }
}
