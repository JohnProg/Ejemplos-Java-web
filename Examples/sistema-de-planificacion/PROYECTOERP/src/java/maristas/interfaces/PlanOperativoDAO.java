/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maristas.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import maristas.beans.PlanOperativoBean;

/**
 *
 * @author johnmachahuay
 */
public interface PlanOperativoDAO {
    public int InsertarPlanOp(PlanOperativoBean objPlanO) throws SQLException;
    public int ActualizarPlanOperativo(PlanOperativoBean objPlanO) throws SQLException;
    public int EliminarPlanOperativo(PlanOperativoBean objPlanO) throws SQLException;
    public PlanOperativoBean getPlanO(PlanOperativoBean objPlanO) throws SQLException;
    public ArrayList<PlanOperativoBean> getPlansO() throws SQLException;
}
