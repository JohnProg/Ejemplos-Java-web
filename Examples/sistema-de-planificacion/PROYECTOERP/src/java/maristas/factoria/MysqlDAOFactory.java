/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.factoria;

import maristas.dao.MysqlActividadDAO;
import maristas.dao.MysqlPlanOperativoDAO;
import maristas.dao.MysqlPlanPresupuestalDAO;
import maristas.dao.MysqlUnidadOrganicaDAO;
import maristas.dao.MysqlUsuarioDAO;
import maristas.interfaces.ActividadDAO;
import maristas.interfaces.PlanOperativoDAO;
import maristas.interfaces.PlanPresupuestalDAO;
import maristas.interfaces.UnidadOrganicaDAO;
import maristas.interfaces.UsuarioDAO;

/**
 *
 * @author johnmachahuay
 */
public class MysqlDAOFactory extends DAOFactory{
    
    public UsuarioDAO getUsuarioDAO() {
        return new MysqlUsuarioDAO();
    }
    
    public PlanPresupuestalDAO getPresupuestoDAO() {
        return new MysqlPlanPresupuestalDAO();
    }
    
    public PlanOperativoDAO getPlanOperativoDAO() {
        return new MysqlPlanOperativoDAO();
    }
    
    public ActividadDAO getActividadDAO() {
        return new MysqlActividadDAO();
    }
    
    public UnidadOrganicaDAO getUnidadOrganicaDAO() {
        return new MysqlUnidadOrganicaDAO();
    }
    
}
