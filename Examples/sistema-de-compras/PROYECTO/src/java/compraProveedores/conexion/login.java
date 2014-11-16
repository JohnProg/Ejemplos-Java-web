/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraProveedores.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author johnmachahuay
 */
public class login extends Conexion{
    private ResultSet resultado;
    PreparedStatement   pt = null;
    // devuleve el usuario si existe
    public ResultSet getUser(String usuario, String contrasena) throws Exception{
        try{
                Conexion cn = new Conexion();
                Connection cnn = cn.getConnection();
                pt = cnn.prepareStatement("SELECT * FROM usuario WHERE usuario = ? and contrasena = ?");
                pt.setString(1, usuario);
                pt.setString(2, contrasena);
                
                resultado = pt.executeQuery();
                return resultado;
            } catch (Exception ex){
                System.err.println("SQLException: " + ex.getMessage());
                return null;
           }
    }
}
