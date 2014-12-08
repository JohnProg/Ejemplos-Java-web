/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.interfaces;

import java.sql.SQLException;
import maristas.beans.UsuarioBean;

/**
 *
 * @author johnmachahuay
 */
public interface UsuarioDAO {

    public UsuarioBean validarAcceso(UsuarioBean objUsuBean) throws SQLException;
    
}
