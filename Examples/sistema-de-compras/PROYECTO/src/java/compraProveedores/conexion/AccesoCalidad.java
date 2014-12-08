/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package compraProveedores.conexion;

import compraProveedores.conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
EJEMPLOS DE PRUEBA FUERA DEL CURSO
*/
public class AccesoCalidad extends Conexion{
    private ResultSet resultado;
    PreparedStatement   pt = null;
    
    
    public ResultSet Listado()throws Exception {
            try{
            Conexion cn = new Conexion();
            Connection cnn = cn.getConnection();
             
             pt = cnn.prepareStatement("select * from pedido");

            resultado = pt.executeQuery();
             return resultado;
              } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
           }
    }

   
    public ResultSet BuscarExistente(int Codigo) throws Exception {   
        try{
                Conexion cn = new Conexion();
                Connection cnn = cn.getConnection();
                pt = cnn.prepareStatement("SELECT * FROM pedido WHERE id LIKE'" + Codigo+"%'");

                resultado = pt.executeQuery();
                return resultado;
            } catch (Exception ex){
                System.err.println("SQLException: " + ex.getMessage());
                return null;
            }
    }

    public ResultSet BuscarPorNombre(String Nombre) throws Exception{
        try{
                Conexion cn = new Conexion();
                Connection cnn = cn.getConnection();
                pt = cnn.prepareStatement("SELECT * FROM pedido WHERE (nombre LIKE '" + Nombre + "%')");

                resultado = pt.executeQuery();
                return resultado;
            } catch (Exception ex){
                System.err.println("SQLException: " + ex.getMessage());
                return null;
           }
    }

}


