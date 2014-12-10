/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import maristas.beans.PresupuestoBean;

/**
 *
 * @author johnmachahuay
 */
public interface PlanPresupuestalDAO {
    public int InsertarPlanPr(PresupuestoBean objPlanP) throws SQLException;
    public int ActualizaPlanPr(PresupuestoBean objPlanP) throws SQLException;
    public int EliminarPlanPr(PresupuestoBean objPlanP) throws SQLException;
    public PresupuestoBean obtenerPlanPr(PresupuestoBean objPlanP) throws SQLException;
    public ArrayList<PresupuestoBean> ListaPlanPr() throws SQLException;
}
