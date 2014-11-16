package maristas.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class connectionBD {
    
    String servidor = "";//Nombre del Servidor
    String puerto = "";//Puerto para conectarse a SQL SERVER 2008 
    String user = "";//Nombre del Usuario de BD
    String password = "";//Contraseña de acceso para el Usuario de BD
    String BaseDatos = "";//Nombre de la base de datos
    String driver = "";
    String url = "";
    Connection conn = null;

    /*Constructor de esta clase*/
    public connectionBD() {

    }
    
    public static void main(String[] args){
        connectionBD cn = new connectionBD();
        cn.getConnection();
    }

    /*Metoo para realizar la conexion*/
    public Connection getConnection() {
        Connection cn=null;
        try {
            servidor = "localhost";                     //Servidor
            user = "sa";                              //Nombre del Usuario de BD
            password = "321";                           //Contraseña de acceso para el Usuario de BD
            puerto = "1433";                            //Puerto para conectarse a SQL SERVER 2008 
            BaseDatos = "maristas";                //Nombre de la base de datos
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

            Class.forName(driver);
            url = "jdbc:sqlserver://" + servidor + ":" + puerto + ";" + "databaseName=" + BaseDatos + ";user=" + user + ";password=" + password + ";";
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                System.out.println("Conexion exitosa");
            }
            return conn;
        } catch (SQLException e) {
            System.out.println("error");
            JOptionPane.showMessageDialog(null, "Error en la conexion a la base de datos", "Error", JOptionPane.ERROR_MESSAGE,new javax.swing.ImageIcon("src/falabella/recursos/ico_error.png"));
            return cn;
        }
        catch(ClassNotFoundException e){
            System.out.println("error");
            JOptionPane.showMessageDialog(null, "Error en la conexion a la base de datos", "Error", JOptionPane.ERROR_MESSAGE,new javax.swing.ImageIcon("src/falabella/recursos/ico_error.png"));
            return cn;
        }
    }

    /*Metodo para desconectar la Conexion*/
    public void desconectar() {
        conn = null;
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la base de datos", "Advertencia", JOptionPane.WARNING_MESSAGE,new javax.swing.ImageIcon("src/falabella/recursos/ico_adv.png"));
        }
    }
    
}
