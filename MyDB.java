/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vol_au_courant.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author haifa
 */
public class MyDB {
    
   /* String url ="jdbc:mysql://localhost:8012/voll_au_courant";
    String user = "root";
    String pwd = "";
    Connection connection;
    static MyDB instance;
    

    
   public MyDB(){
        try {
            
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("vol_au_c");
            System.out.println("connexion etablie ");    
        } catch (SQLException ex) {
            System.out.println("errreur" + ex.getMessage());
            
        }
    }
    
    public static MyDB getInstance(){
        
        if (instance==null){
            instance = new MyDB();
        }
        return instance;
    }
    
    public Connection getConnection (){
        return connection ; 
    }*/
    String url= "jdbc:mysql://localhost:3306/voll_au_courant";
    String user = "root";
    String pwd ="";
   public Connection connection;
    static MyDB instance;
    
    private MyDB(){
        try {
            connection = DriverManager.getConnection(url, user, pwd);
                   System.out.println("Connexion établie");

        } catch (SQLException ex) {
           System.out.println("Erreur de connexion a la base de données");
        }
    }
    
    public static MyDB getInstance(){
    if(instance == null){
       instance = new MyDB();
    }
    return instance;
    }
    
    public Connection getConnection(){
   return connection;
    }
    
    
}
