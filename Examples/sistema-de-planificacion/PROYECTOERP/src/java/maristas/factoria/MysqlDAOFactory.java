/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.factoria;

import maristas.dao.MysqlPresupuestoDAO;
import maristas.dao.MysqlUsuarioDAO;
import maristas.interfaces.PresupuestoDAO;
import maristas.interfaces.UsuarioDAO;

/**
 *
 * @author johnmachahuay
 */
public class MysqlDAOFactory extends DAOFactory{
    
    public UsuarioDAO getUsuarioDAO() {
        return new MysqlUsuarioDAO();
    }
    
    public PresupuestoDAO getPresupuestoDAO() {
        return new MysqlPresupuestoDAO();
    }
}
