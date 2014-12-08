/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import maristas.beans.UsuarioBean;
import maristas.conexion.conecctionBDMysql;
import maristas.interfaces.UsuarioDAO;

/**
 *
 * @author johnmachahuay
 */
public class MysqlUsuarioDAO implements UsuarioDAO{
     UsuarioBean objUsuario = null;
    Connection          cnn = null;
    PreparedStatement   pt = null;
    ResultSet           rs = null;
    
    public UsuarioBean validarAcceso(UsuarioBean objUB) throws SQLException {
        try{
                conecctionBDMysql cn = new conecctionBDMysql();
                cnn = cn.getConnection();
                
                pt = cnn.prepareStatement("SELECT * FROM usuario WHERE username=? and contra=?");
                pt.setString(1, objUB.getUsername());
                pt.setString(2, objUB.getContra());
                
                rs = pt.executeQuery();
                if(rs.next()){
                    objUsuario = new UsuarioBean();
                    objUsuario.setId(rs.getInt(1));
                    objUsuario.setUsername(rs.getString(2));
                    objUsuario.setContra(rs.getString(3));
                    objUsuario.setId_rol(rs.getInt(4));
                }
                return objUsuario;
                
            } catch (SQLException ex){
                System.err.println("SQLException: " + ex.getMessage());
                objUsuario = null;
           }finally {
            pt.close();
            rs.close();
            cnn.close();}
    return objUsuario;
    }
}
