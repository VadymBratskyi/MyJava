/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mydatabase;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vadym
 */
public final class MyTableMode extends AbstractTableModel{

    static Connection conn;
    
    private Object[][] dataMas;
    private Object[][] dataMasFK;
    private Object[][] dataMasFK2;
    
    private Object[][] dataMasSearchFKID;
    private Object[][] dataMasSearchFKVL;
            
    private String[] nameCol;
    private String[] nameCol2;
    private String[] nameFKTBCol;
    private Object[] ValueFKT;
    private Class[] typeCol;
    private Class[] typeCol2;
    
    private String[] FkCol;  
    private String[] FkTable;

    public static String id;
    private int j;
    private String [] colSize;
    
    public static String selVal;
    public static String idSel;
    
    public MyTableMode(Connection con, String tablNam,String query) throws SQLException
    {
        super();
        MyTableMode.conn = con;
        getTableDate(tablNam, query);
    }
    
     public MyTableMode(Connection con, String tablNam,String query, String [] Size) throws SQLException
    {
        super();
        this.colSize = Size;
        MyTableMode.conn = con;
        getTableDateSQL(tablNam, query);
    }
        
    public void getTableDate(String tablNam, String query)
    {          
        try {
            DatabaseMetaData met = conn.getMetaData();
            
            ResultSet res = met.getColumns(null, null, tablNam, null);// получить методанные по столбцам
            ResultSet rset = met.getImportedKeys(null, null, tablNam);
            
            ArrayList NamColList = new ArrayList();// список имен столбцов
            ArrayList TypeColList = new ArrayList();// список типов столбцов
            ArrayList TabsFK = new ArrayList();
            ArrayList ColsFK = new ArrayList();
            
            //Get fk
            while(rset.next())
            {
                TabsFK.add(rset.getString("PKTABLE_NAME"));
                ColsFK.add(rset.getString("FKCOLUMN_NAME"));
            }
            
            // цикл по всем столбцам таблицы
            // для каждого столбца определить имя и тип
            while(res.next())
            {
                NamColList.add(res.getString("COLUMN_NAME"));// добавить в список имя столбца
                int dtType = res.getInt("DATA_TYPE");// определить тип столбца
         
                switch(dtType)
                {
                    case Types.INTEGER: TypeColList.add(Integer.class);
                    break;
                    case Types.FLOAT: TypeColList.add(Float.class);
                    break;
                    case Types.DOUBLE:
                    case Types.REAL: TypeColList.add(Double.class);
                    break;
                    case Types.DATE:
                    case Types.TIME:
                    case Types.TIMESTAMP: TypeColList.add(Date.class);
                    break;
                    default: TypeColList.add(String.class);
                    break;
                };
            }//while
            
            // имена столбцов сохранить в отдельный массив
            nameCol = new String[NamColList.size()];
            NamColList.toArray(nameCol);
            
            nameCol2 = new String[NamColList.size()];
            NamColList.toArray(nameCol2);
            
            // типы столбцов сохранить в отдельный массив
            typeCol = new Class[TypeColList.size()];
            TypeColList.toArray(typeCol);
            
            FkCol = new String[ColsFK.size()];
            ColsFK.toArray(FkCol);
            
            FkTable = new String[TabsFK.size()];
            TabsFK.toArray(FkTable);
            
            
            for (int i = 0; i < FkCol.length/2; i++) {
                String tmp = FkCol[FkCol.length - 1 - i];
                FkCol[FkCol.length - 1 - i] = FkCol[i];
                FkCol[i] = tmp;
            }
            
            for (int i = 0; i < FkTable.length/2; i++) {
                String tmp = FkTable[FkTable.length - 1 - i];
                FkTable[FkTable.length - 1 - i] = FkTable[i];
                FkTable[i] = tmp;
            }
            
            // выполнение запроса
            Statement stm = conn.createStatement();
            res = stm.executeQuery(query);

            ArrayList allRows = new ArrayList();// хранит записи из таблицы
            // цикл по всем записям таблицы
            while(res.next())
            {
                ArrayList calList = new ArrayList();// хранит данные по каждому столбцу (ячейки)
                
                for(int i=0; i<nameCol.length; i++)
                {
                    Object cellValue = null;
                    
                    if (typeCol[i] == String.class) {
                        cellValue = String.valueOf(res.getString(nameCol[i]));
                    } else if (typeCol[i] == Integer.class) {
                        cellValue = new Integer(res.getInt(nameCol[i]));
                    } else if (typeCol[i] == Float.class) {
                        cellValue = new Float(res.getInt(nameCol[i]));
                    } else if (typeCol[i] == Double.class) {
                        cellValue = new Double(res.getDouble(nameCol[i]));
                    } else if (typeCol[i] == java.sql.Date.class) {
                        cellValue = res.getDate(nameCol[i]);
                    } else {
                        System.out.println("Не могу определить тип поля " + nameCol[i]);
                    }
                    calList.add(cellValue);                   
                }//for
                
                Object [] cells = calList.toArray();
                allRows.add(cells);
                
            }//while
            
            dataMas = new Object[allRows.size()][];
            for(int i=0; i<dataMas.length; i++)
            {
                dataMas[i]=(Object[])allRows.get(i);
            }
            
                        
            if(res!=null) res.close();
            if(stm!=null) stm.close();
            if(rset!=null) rset.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MyTableMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public void getTableDateSQL(String tablNam, String query)throws SQLException
    {          
        DatabaseMetaData met = conn.getMetaData();       
        
        ResultSet res = met.getColumns(null, null, tablNam, null);// получить методанные по столбцам
       
        ArrayList NamColList = new ArrayList();// список имен столбцов
        ArrayList TypeColList = new ArrayList();// список типов столбцов
         
        // цикл по всем столбцам таблицы
        // для каждого столбца определить имя и тип 
        while(res.next())
        {
            NamColList.add(res.getString("COLUMN_NAME"));// добавить в список имя столбца
            int dtType = res.getInt("DATA_TYPE");// определить тип столбца
            
            switch(dtType)
            {
                case Types.INTEGER: TypeColList.add(Integer.class);
                    break;
                case Types.FLOAT: TypeColList.add(Float.class);
                    break;
                case Types.DOUBLE:
                case Types.REAL: TypeColList.add(Double.class);
                    break;
                case Types.DATE:
                case Types.TIME:
                case Types.TIMESTAMP: TypeColList.add(Date.class);
                    break;
                default: TypeColList.add(String.class);
                    break;
            };
        }//while
        
        // имена столбцов сохранить в отдельный массив
        nameCol = new String[NamColList.size()];
        NamColList.toArray(nameCol);   
                
        // типы столбцов сохранить в отдельный массив
        typeCol = new Class[TypeColList.size()];
        TypeColList.toArray(typeCol);   
        typeCol2 = new Class[colSize.length];
        
        // выполнение запроса
        Statement stm = conn.createStatement();
        res = stm.executeQuery(query);
        
        ArrayList allRows = new ArrayList();// хранит записи из таблицы      
         
        for(int i=0; i<nameCol.length; i++)
        {
            for(int j=0; j<colSize.length; j++)
            {
                if(nameCol[i].trim().equals(colSize[j]))
                {
                    typeCol2[j]=typeCol[i]; 
                }
            }
        } 
       
        
        // цикл по всем записям таблицы
        while(res.next())    
        {
            
           ArrayList calList = new ArrayList();// хранит данные по каждому столбцу (ячейки)
           
          
                for(int i=0; i<colSize.length; i++)
                {                    
                
                    Object cellValue = null;    

                    if (typeCol2[i] == String.class) {
                        cellValue = String.valueOf(res.getString(colSize[i]));
                    } else if (typeCol2[i] == Integer.class) {
                        cellValue = new Integer(res.getInt(colSize[i]));
                    } else if (typeCol2[i] == Float.class) {
                        cellValue = new Float(res.getInt(colSize[i]));
                    } else if (typeCol2[i] == Double.class) {
                        cellValue = new Double(res.getDouble(colSize[i]));
                    } else if (typeCol2[i] == java.sql.Date.class) {
                        cellValue = res.getDate(colSize[i]);
                    } else {
                        System.out.println("Не могу определить тип поля " + colSize[i]);
                    }                              
                 calList.add(cellValue);   
                
            }//for       
         
           Object [] cells = calList.toArray();
           allRows.add(cells);
        
        }//while
        
         for(int i=0; i<nameCol.length; i++)
        {
            for(int j=0; j<colSize.length; j++)
            {
                nameCol[j]=colSize[j];
            }
        } 
        
        dataMas = new Object[allRows.size()][];
        for(int i=0; i<dataMas.length; i++)
        {
           dataMas[i]=(Object[])allRows.get(i);
        }         
        if(res!=null) res.close();
        if(stm!=null) stm.close();
        
    }
    
     //обновление всех строк
    public boolean refreshDb(String tablName)
    {   
         ArrayList<String> sqlList = new ArrayList(); 
          for(int i=0; i<dataMas.length; i++)
          { 
              Object [] obj = dataMas[i];
              StringBuilder bld = new StringBuilder();
              bld.append("Update "+tablName+" set ");
              
            for(int j=1; j<nameCol.length; j++)
            {               
                if(nameCol[j] != nameCol[nameCol.length-1])
                {
                    bld.append(nameCol[j]+"='"+obj[j]+"', ");
                }else
                {
                    bld.append(nameCol[j]+"='"+obj[j]+"' ");
                }                 
            }
            bld.append("Where id = "+obj[0]);
            sqlList.add(bld.toString());           
           } 
        
        Statement stm = null;        
        
        try
        {
            stm = conn.createStatement();
            
            for(String sql: sqlList)
            {
                stm.executeUpdate(sql);
                
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
            return false;
            
        }finally
        {
            try
            {
                if(stm!=null) stm.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }        
        return true;
    }
    
    public boolean addRows(String nameTab, Object [] values)
   { 
       PreparedStatement stm = null;
       
      try
       {            
           StringBuilder bld = new StringBuilder();
           bld.append("Insert Into "+nameTab+" (");
           for(int i=0; i<nameCol.length; i++)
           {
              if(nameCol[i] != nameCol[nameCol.length-1])
                {
                    bld.append(nameCol[i]+", ");
                }
              else
                {
                    bld.append(nameCol[i]+") values (");
                }             
           }
           for(int i=0; i<nameCol.length; i++)
           {
               if(nameCol[i] != nameCol[nameCol.length-1])
                {  bld.append("?,");
                }
               else
                {
                   bld.append("?)");
                }
           }
   
           String sql = bld.toString(); 
           stm = conn.prepareStatement(sql);
          
           for(int i=0; i<nameCol.length; i++)
           {
               j++;
               Object value = values[i];
               stm.setObject(j, value);                
           }
           stm.execute(); 
                    
       }catch(SQLException ex)
       {
           Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
           return false;
       }finally
               {
                   try
                   {
                    if(stm!=null) stm.close();
                   }catch(SQLException ex)
                   {
                       Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
                   }   
               }
        return true;
   }
    public boolean deleteRows(String nameTab)
   {
       PreparedStatement stm = null;
       
       try
       {
           String sql = "Delete From '"+nameTab+"' Where id=?";
           
           stm = conn.prepareStatement(sql);
           stm.setString(1, id);
           stm.execute();
           
           
       }catch(SQLException ex)
       {
           Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
           return false;
       }finally
               {
                   try
                   {
                    if(stm!=null) stm.close();
                   }catch(SQLException ex)
                   {
                       Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
                   }   
               }
        return true;
   }
    
    public boolean querySQL(String sql)
    {
        Statement stm = null;
        
       try
       {                     
           stm = conn.createStatement();
           stm.executeUpdate(sql);           
       }catch(SQLException ex)
       {
           Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
           return false;
           
       }finally
               {
                   try
                   {
                    if(stm!=null) stm.close();
                   }catch(SQLException ex)
                   {
                       Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
                   }   
               }
        return true;            
    }
    
    public boolean search(String nameTable)
    {
        Statement stm=null;
        ResultSet res=null;
       try
       {
        String s = (String)JOptionPane.showInputDialog(null,"Select column:",null,JOptionPane.PLAIN_MESSAGE,null,nameCol,nameCol[0]);
        String val = (String)JOptionPane.showInputDialog("Write the "+ s);
        String sql = "Select * From "+nameTable+" Where "+s+" = "+val;
         
        selVal = s;
        idSel = val;
        
        stm=conn.createStatement();
        
        res = stm.executeQuery(sql);
        
        getTableDate(nameTable, sql);
        
        }catch(SQLException ex)
       {
           Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
           return false;
       }finally
               {
                   try
                   {
                    if(stm!=null) stm.close();
                   }catch(SQLException ex)
                   {
                       Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
                   }   
               }
        return true;
    }
    
    public boolean search2(String nameTable, String colNam,  int value)
    {
        Statement stm=null;
        ResultSet res=null;
       try
       {  
        String sql = "Select * From "+nameTable+" Where "+colNam+" = "+value;
        stm=conn.createStatement();
        
        res = stm.executeQuery(sql);
        
        getTableDate(nameTable, sql);
                
        }catch(SQLException ex)
       {
           Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
           return false;
       }finally
               {
                   try
                   {
                    if(stm!=null) stm.close();
                   }catch(SQLException ex)
                   {
                       Logger.getLogger(MYDataBase.class.getName()).log(Level.SEVERE,null,ex);
                   }   
               }
        return true;
    }
    
    public String addComboBox(String tableName, int i)
    {
        try {
            DatabaseMetaData met = conn.getMetaData();
            
            ResultSet res = met.getColumns(null, null, tableName, null);// получить методанные по столбцам
            
            ArrayList NamColList = new ArrayList();// список имен столбцов
            
            // цикл по всем столбцам таблицы
            // для каждого столбца определить имя и тип
            while(res.next())
            {
                NamColList.add(res.getString("COLUMN_NAME"));// добавить в список имя столбца
            }//while
            
            // имена столбцов сохранить в отдельный массив
            nameCol = new String[NamColList.size()];            
            NamColList.toArray(nameCol);
      
        } catch (SQLException ex) {
            Logger.getLogger(MyTableMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nameCol[i];
    }
    
     public void TabColNam(String tableName)
    {
        try {
            DatabaseMetaData met = conn.getMetaData();
            
            ResultSet res = met.getColumns(null, null, tableName, null);// получить методанные по столбцам
            
            ArrayList NamColList = new ArrayList();// список имен столбцов
            
            // цикл по всем столбцам таблицы
            // для каждого столбца определить имя и тип
            while(res.next())
            {
                NamColList.add(res.getString("COLUMN_NAME"));// добавить в список имя столбца
            }//while
            
            // имена столбцов сохранить в отдельный массив
            nameFKTBCol = new String[NamColList.size()];            
            NamColList.toArray(nameFKTBCol);
     
           
        } catch (SQLException ex) {
            Logger.getLogger(MyTableMode.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void newFKTable(String tablNam, String query, String [] values)
    {
        try {
            DatabaseMetaData met = conn.getMetaData();
            
            ResultSet res = met.getColumns(null, null, tablNam, null);// получить методанные по столбцам
            ResultSet rset = met.getImportedKeys(null, null, tablNam);
            
            ArrayList NamColList = new ArrayList();// список имен столбцов
            ArrayList TypeColList = new ArrayList();// список типов столбцов
            ArrayList TabsFK = new ArrayList();
            ArrayList ColsFK = new ArrayList();
            
            //Get fk
            while(rset.next())
            {
                TabsFK.add(rset.getString("PKTABLE_NAME"));
                ColsFK.add(rset.getString("FKCOLUMN_NAME"));
            }
            
            // цикл по всем столбцам таблицы
            // для каждого столбца определить имя и тип
            while(res.next())
            {
                NamColList.add(res.getString("COLUMN_NAME"));// добавить в список имя столбца
                int dtType = res.getInt("DATA_TYPE");// определить тип столбца
                
                switch(dtType)
                {
                    case Types.INTEGER: TypeColList.add(Integer.class);
                    break;
                    case Types.FLOAT: TypeColList.add(Float.class);
                    break;
                    case Types.DOUBLE:
                    case Types.REAL: TypeColList.add(Double.class);
                    break;
                    case Types.DATE:
                    case Types.TIME:
                    case Types.TIMESTAMP: TypeColList.add(Date.class);
                    break;
                    default: TypeColList.add(String.class);
                    break;
                };
            }//while
            
            // имена столбцов сохранить в отдельный массив
            nameCol = new String[NamColList.size()];
            NamColList.toArray(nameCol);
            
            // типы столбцов сохранить в отдельный массив
            typeCol = new Class[TypeColList.size()];
            TypeColList.toArray(typeCol);
            
            FkCol = new String[ColsFK.size()];
            ColsFK.toArray(FkCol);
            
            FkTable = new String[TabsFK.size()];
            TabsFK.toArray(FkTable);
            
            
            for (int i = 0; i < FkCol.length/2; i++) {
                String tmp = FkCol[FkCol.length - 1 - i];
                FkCol[FkCol.length - 1 - i] = FkCol[i];
                FkCol[i] = tmp;
            }
            
            for (int i = 0; i < FkTable.length/2; i++) {
                String tmp = FkTable[FkTable.length - 1 - i];
                FkTable[FkTable.length - 1 - i] = FkTable[i];
                FkTable[i] = tmp;
            }
            
            // выполнение запроса
            Statement stm = conn.createStatement();
            res = stm.executeQuery(query);
            
            ArrayList allRows = new ArrayList();// хранит записи из таблицы
            // цикл по всем записям таблицы
            while(res.next())
            {
                ArrayList calList = new ArrayList();// хранит данные по каждому столбцу (ячейки)
                
                for(int i=0; i<getFkColCount(); i++)
                {
                    Object cellValue = null;
                    
                    if (typeCol[i] == Integer.class) {
                        cellValue = new Integer(res.getInt(FkCol[i]));
                    } else if (typeCol[i] == Float.class) {
                        cellValue = new Integer(res.getInt(FkCol[i]));
                    } else if (typeCol[i] == String.class) {
                        cellValue = new Integer(res.getInt(FkCol[i]));
                    }
                    calList.add(cellValue);
                }//for
                
                Object [] cells = calList.toArray();
                allRows.add(cells);               
                                
            }//while
            
            dataMasFK = new Object[allRows.size()][];
            for(int i=0; i<dataMasFK.length; i++)
            {
                dataMasFK[i]=(Object[])allRows.get(i);                
            }       
             
            dataMasFK2 = new Object[dataMasFK.length][FkCol.length];
            for(int i=0; i<FkTable.length; i++)
             {
                 for(int j=0; j<dataMasFK.length; j++)
                 {
                     dataMasFK2[j][i]=getFKTablRowss(getFkTable(i), values[i], (int)dataMasFK[j][i]);                    
                 }                 
             }      
            
                for(int i=0; i<dataMasFK.length; i++)
                 {
                     for(int j=0; j<FkCol.length; j++)
                     {
                        for(int k=0; k<nameCol.length; k++)
                        {
                            if(nameCol[k].trim().equals(FkCol[j]))
                            {
                                dataMas[i][k]=dataMasFK2[i][j];
                            }                              
                        }  
                    }
                }            
               
                
            if(res!=null) res.close();
            if(stm!=null) stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MyTableMode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void newFKTableSearch(String tablNam, String [] values)
    {
          try {
            DatabaseMetaData met = conn.getMetaData();
            
            ResultSet res = met.getColumns(null, null, tablNam, null);// получить методанные по столбцам
            ResultSet rset = met.getImportedKeys(null, null, tablNam);
            
            ArrayList NamColList = new ArrayList();// список имен столбцов
            ArrayList TypeColList = new ArrayList();// список типов столбцов
            ArrayList TabsFK = new ArrayList();
            ArrayList ColsFK = new ArrayList();
            
            //Get fk
            while(rset.next())
            {
                TabsFK.add(rset.getString("PKTABLE_NAME"));
                ColsFK.add(rset.getString("FKCOLUMN_NAME"));
            }
            
            // цикл по всем столбцам таблицы
            // для каждого столбца определить имя и тип
            while(res.next())
            {
                NamColList.add(res.getString("COLUMN_NAME"));// добавить в список имя столбца
                int dtType = res.getInt("DATA_TYPE");// определить тип столбца
                
                switch(dtType)
                {
                    case Types.INTEGER: TypeColList.add(Integer.class);
                    break;
                    case Types.FLOAT: TypeColList.add(Float.class);
                    break;
                    case Types.DOUBLE:
                    case Types.REAL: TypeColList.add(Double.class);
                    break;
                    case Types.DATE:
                    case Types.TIME:
                    case Types.TIMESTAMP: TypeColList.add(Date.class);
                    break;
                    default: TypeColList.add(String.class);
                    break;
                };
            }//while
            
            // имена столбцов сохранить в отдельный массив
            nameCol = new String[NamColList.size()];
            NamColList.toArray(nameCol);
            
            // типы столбцов сохранить в отдельный массив
            typeCol = new Class[TypeColList.size()];
            TypeColList.toArray(typeCol);
            
            FkCol = new String[ColsFK.size()];
            ColsFK.toArray(FkCol);
            
            FkTable = new String[TabsFK.size()];
            TabsFK.toArray(FkTable);
            
            
            for (int i = 0; i < FkCol.length/2; i++) {
                String tmp = FkCol[FkCol.length - 1 - i];
                FkCol[FkCol.length - 1 - i] = FkCol[i];
                FkCol[i] = tmp;
            }
            
            for (int i = 0; i < FkTable.length/2; i++) {
                String tmp = FkTable[FkTable.length - 1 - i];
                FkTable[FkTable.length - 1 - i] = FkTable[i];
                FkTable[i] = tmp;
            }
            
            // выполнение запроса
            Statement stm = conn.createStatement();
            res = stm.executeQuery("Select * From "+tablNam+" Where "+selVal+" = "+idSel);

            ArrayList allRows = new ArrayList();// хранит записи из таблицы
            // цикл по всем записям таблицы
            while(res.next())
            {
                ArrayList calList = new ArrayList();// хранит данные по каждому столбцу (ячейки)
                
                for(int i=0; i<getFkColCount(); i++)
                {
                    Object cellValue = null;
                    
                    if (typeCol[i] == Integer.class) {
                        cellValue = new Integer(res.getInt(FkCol[i]));
                    } else if (typeCol[i] == Float.class) {
                        cellValue = new Integer(res.getInt(FkCol[i]));
                    } else if (typeCol[i] == String.class) {
                        cellValue = new Integer(res.getInt(FkCol[i]));
                    }
                    calList.add(cellValue);
                }//for
                
                Object [] cells = calList.toArray();
                allRows.add(cells);               
                                
            }//while
            
            dataMasFK = new Object[allRows.size()][];
            for(int i=0; i<dataMasFK.length; i++)
            {
                dataMasFK[i]=(Object[])allRows.get(i);                
            }       
             
            dataMasFK2 = new Object[dataMasFK.length][FkCol.length];
            for(int i=0; i<FkTable.length; i++)
             {
                 for(int j=0; j<dataMasFK.length; j++)
                 {
                     dataMasFK2[j][i]=getFKTablRowss(getFkTable(i), values[i], (int)dataMasFK[j][i]);                    
                 }                 
             }
            
            for(int i=0; i<dataMasFK.length; i++)
                 {
                     for(int j=0; j<FkCol.length; j++)
                     {
                        for(int k=0; k<nameCol.length; k++)
                        {
                            if(nameCol[k].trim().equals(FkCol[j]))
                            {
                                dataMas[i][k]=dataMasFK2[i][j];
                            }                              
                        }  
                    }
                }    
           
            if(res!=null) res.close();
            if(stm!=null) stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MyTableMode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
     
    
    public void getValueColFKTabl(String tableName, String colNam)
    {
             Statement stm=null;
        try {
            DatabaseMetaData met = conn.getMetaData();
            
            ResultSet res = met.getColumns(null, null, tableName, null);// получить методанные по столбцам
            stm=conn.createStatement();
            
            ArrayList ValueColList = new ArrayList();// список имен столбцов
            
            String sql = "Select * From "+tableName;
            res=stm.executeQuery(sql);
            
            // цикл по всем столбцам таблицы
            // для каждого столбца определить имя и тип
            while(res.next())
            {
                ValueColList.add(res.getObject(colNam));// добавить в список имя столбца
            }//while
            
            // имена столбцов сохранить в отдельный массив
            ValueFKT = new Object[ValueColList.size()];            
            ValueColList.toArray(ValueFKT);
  
            if(res!=null) res.close();
            if(stm!=null) stm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MyTableMode.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
        
        
    public int getFKTableColCount()
    {
        return nameCol.length;
    }
    
    public int getFKTableColCountAdd()
    {
        return nameFKTBCol.length;
    }
    
    public String getFkClNamAdd(int i)
    {                 
         return nameFKTBCol[i];         
    }
    
     public Object getValuesKFT(int i)
    {  
         return ValueFKT[i];         
    }
     
     public int getValuesKFTSize()
    {                 
         return ValueFKT.length;         
    }
    
    @Override
    public int getRowCount() {
        return dataMas.length;
    }

    @Override
    public int getColumnCount() {
        if(dataMas == null)
        {
            return 0;
        }else
        {
            return dataMas[0].length;
        }
       
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        dataMas[i][i1]=o;
    }

    public String getFkColumn(int i)
    {                 
         return FkCol[i];         
    }
    
    
    public String getFKTablRowss(String tablNam, String Colnam, int id)
    {  
        String rez=null;
        try {
            
            DatabaseMetaData met = conn.getMetaData();
            
            ResultSet res = met.getColumns(null, null, tablNam, null);// получить методанные по столбцам
            
            String sql = "Select * From "+tablNam+" Where id="+id;
            
            Statement str = res.getStatement();
            res = str.executeQuery(sql);            
                
              while(res.next())
              {
                rez=res.getString(Colnam);
              } 
            
            
            if(res!=null) res.close();
            if(str!=null) str.close();
    
            } catch (SQLException ex) {
                Logger.getLogger(MyTableMode.class.getName()).log(Level.SEVERE, null, ex);
            }
        return rez;
    }
    
    public int getFkColCount()
    {
        if(FkCol == null)
        {
            return 0;
        }else
        {
            return FkCol.length;
        }
    }
    
     public String getFkTable(int i)
    {           
        return FkTable[i];         
    }
     
      public int getFkTableInd(String name)
    {           
        for(int i=0; i<FkCol.length; i++)
        {
            if(FkCol[i].trim().equals(name))
            {
                return i;
            }
        }       
        return 0;
    }
     
    public int getFkColTable()
    {
        if(FkTable == null)
        {
            return 0;
        }else
        {
            return FkTable.length;
        }
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        return dataMas[i][i1];
    }

    @Override
    public Class getColumnClass(int i) {
        return typeCol[i];
    }

    @Override
    public String getColumnName(int i) {
        return nameCol[i];
    }

    
    
    public boolean getFK(String name)
    {
        for(int i=0; i<FkCol.length; i++)
        {
            if(name.trim().equals(FkCol[i]))
            {
                return true;                
            }
        }        
        return false;             
    }   
    
    @Override
    public boolean isCellEditable(int rowInd, int colInd) {
       if(colInd == 0)
       {
           return false;
       } else
       {       
        return true;
       }
    }
    
    public int getColTabNam(String col)
    {
        for(int i=0; i<FkCol.length; i++)
        {
            if(FkCol[i].trim().equals(col))
            {
                return i;
            }
        }
        return 0;
    }
 
}
