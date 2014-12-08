
package maristas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import maristas.beans.UsuarioBean;
import maristas.conexion.conecctionBDMysql;


public class usuarioDAO {
    UsuarioBean objUsuario = null;
    Connection          cnn = null;
    PreparedStatement   pt = null;
    ResultSet           rs = null;
    
    
    public UsuarioBean getUser(String username, String contra) throws Exception{
        try{
                conecctionBDMysql cn = new conecctionBDMysql();
                Connection cnn = cn.getConnection();
                
                pt = cnn.prepareStatement("SELECT * FROM usuario WHERE username=? and contra=?");
                pt.setString(1, username);
                pt.setString(2, contra);
                
                rs = pt.executeQuery();
                if(rs.next()){
                    objUsuario = new UsuarioBean();
                    objUsuario.setId(rs.getInt(1));
                    objUsuario.setUsername(rs.getString(2));
                    objUsuario.setContra(rs.getString(3));
                    objUsuario.setId_rol(rs.getInt(4));
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
}
