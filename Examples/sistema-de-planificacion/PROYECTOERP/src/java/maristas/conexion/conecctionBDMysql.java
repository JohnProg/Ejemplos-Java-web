
package maristas.conexion;

//STEP 1. Import required packages
import java.sql.*;

public class conecctionBDMysql {
   // JDBC driver name and database URL
        private String DRIVER = "com.mysql.jdbc.Driver";  
        private String DB_URL = "jdbc:mysql://localhost:3306/maristas";
        private String USER = "root"; // mi usuario
        private String PASS = "admin"; // mi contraseña
         //private String selectMethod = "cursor";
         private String errString;
     
    //Creando un metodo de tipo Connection
     public Connection getConnection(){
        Connection con = null;
         try{
             Class.forName(DRIVER).newInstance(); // Obtenemos el driver de mysql
             con = DriverManager.getConnection(DB_URL, USER, PASS); //Conectamos
         }
         catch(SQLException e){
             System.out.println(e);
             return null;
         }
        catch(Exception e){
             errString= "Error Mientras se conectaba a la Base de Datos";
             System.out.println(errString);
             return null;
         }
        return con;
     }
}