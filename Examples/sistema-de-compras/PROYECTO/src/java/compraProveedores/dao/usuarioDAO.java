/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraProveedores.dao;

import compraProveedores.beans.usuarioBean;
import compraProveedores.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class usuarioDAO {
    usuarioBean objUsuario = null;
    ArrayList<usuarioBean> lista = null;
    Connection          cnn = null;
    PreparedStatement   pt = null;
    ResultSet           rs = null;
    
    
    public usuarioBean obtenerJefeCompra(String usuario, String contrasena) throws Exception{
        try{
                Conexion cn = new Conexion();
                Connection cnn = cn.getConnection();
                
                pt = cnn.prepareStatement("SELECT * FROM usuario WHERE usuario = ? and contrasena = ?");
                pt.setString(1, usuario);
                pt.setString(2, contrasena);
                
                rs = pt.executeQuery();
                
                    if(rs.next()){
                        if(rs.getInt(4) == 1) {
                            objUsuario = new usuarioBean();
                            objUsuario.setId_usuario(rs.getInt(1));
                            objUsuario.setUsuario(rs.getString(2));
                            objUsuario.setContrasena(rs.getString(3));
                            objUsuario.setId_fk_role(rs.getInt(4));
                            objUsuario.setNombre(rs.getString(5));
                        } else {return null;}
                    }
                
                
                
                rs.close();
                pt.close();
                cnn.close();
            
                return objUsuario;
                
            } catch (Exception ex){
                System.err.println("SQLException: " + ex.getMessage());
                return null;
           }
    }
    
    public ArrayList<usuarioBean> obtenerProveedores() throws Exception{
        lista = new ArrayList<usuarioBean>();
        try{
                Conexion cn = new Conexion();
                Connection cnn = cn.getConnection();
                
                pt = cnn.prepareStatement("SELECT * FROM usuario WHERE id_fk_role = 2");
                
                rs = pt.executeQuery();
                while(rs.next()){
                    usuarioBean objUsuario = new usuarioBean();
                    objUsuario.setId_usuario(rs.getInt(1));
                    objUsuario.setUsuario(rs.getString(2));
                    objUsuario.setNombre(rs.getString(5));
                    
                    lista.add(objUsuario);
                }
                
                rs.close();
                pt.close();
                cnn.close();
            
                return lista;
                
            } catch (Exception ex){
                System.err.println("SQLException: " + ex.getMessage());
                return null;
           }
    }
}
