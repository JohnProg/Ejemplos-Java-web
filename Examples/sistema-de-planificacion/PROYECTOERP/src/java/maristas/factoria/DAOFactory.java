/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.factoria;

import maristas.interfaces.UsuarioDAO;

/**
 *
 * @author johnmachahuay
 */
public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public abstract UsuarioDAO getUsuarioDAO();
    
    public static DAOFactory getDAOFactory(int op) {
        switch(op) {
            case MYSQL :
                return new MysqlDAOFactory();
            default :
                return null;
        }
    };
}
