package onlinevoting;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class databsaeconnectivity {
   private static final String dLoc = "jdbc:ucanaccess://voter.accdb";
   private Connection con;
   private PreparedStatement pState;
   private ResultSet ReSet;
   public Connection getCon(){
       return con;
   }
   public void Connectivity(){
       try{
           con = DriverManager.getConnection(dLoc);
           System.out.println("connected");
       }
       catch(SQLException e){
           System.out.println(e.getMessage());
                      System.out.println("not connected");

       }
   }
} 