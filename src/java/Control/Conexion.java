
package Control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author duber
 */
public class Conexion {
    
    
    public static Connection getConnection(){
         String URL,USER,PASS;
         
         URL = "jdbc:mysql://localhost/consultorio_MedicoMVC1?serverTimezone=UTC&autoReconnect=true&useSSL=false";
         USER ="root";
         PASS ="123456";
         
         Connection con = null;
         
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection(URL, USER, PASS);
            
             
         
         }catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
            System.out.println(e.getMessage());
         
         }        
              
         return con; 
             
     }
}
