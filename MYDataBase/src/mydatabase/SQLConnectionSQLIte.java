/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mydatabase;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vadym
 */
public class SQLConnectionSQLIte {
            
    public static Connection conn;
    
    public static Connection getConnection(String patch)
    {       
        conn=null;
        
        try
        {       // динамическая регистрация драйвера SQLite
               Driver dr = (Driver) Class.forName("org.sqlite.JDBC").newInstance();    
             
               // создание подключение к базе данных по пути, указанному в урле
               String url ="jdbc:sqlite:"+patch;
               
               if(conn==null)
               {
                   conn = DriverManager.getConnection(url);
               }            
    
               return conn;           
        }  
        catch(SQLException|ClassNotFoundException|InstantiationException|IllegalAccessException ex)
        {
            Logger.getLogger(SQLConnectionSQLIte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
