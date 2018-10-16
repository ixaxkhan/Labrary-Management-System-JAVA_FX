
package librarary.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class DatabaseHandler {
     Connection conn = null;
      Statement stm=null;
      ResultSet result=null;
      private static  DatabaseHandler handler=null;
      private DatabaseHandler(){
      
      
      
      }
      public  static DatabaseHandler getInstant(){
      if(handler==null){
      
      handler=new DatabaseHandler();
      }
      return handler;
      }
 
    public Connection createConnection() throws ClassNotFoundException{
    
     Class.forName("com.mysql.jdbc.Driver");
         try {
             conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/librararymanagement","root","");
            
         } catch (SQLException ex) {
               
              System.out.println("not connected");
             Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    return conn;
    }
    
        
    public ResultSet excuteQuery(String sql) throws ClassNotFoundException{
   
    try{
    conn= createConnection();
    stm=conn.createStatement();
    result=stm.executeQuery(sql);
    
    }catch(SQLException e){
    
    return null;
    }
    return result;
    }
    public boolean excuteAction(String sql) throws ClassNotFoundException, SQLException{
    try{
     conn=createConnection();
    stm=conn.createStatement();
    stm.execute(sql);}catch(SQLException e){
    return false;
    }
    return true;
    }
}
