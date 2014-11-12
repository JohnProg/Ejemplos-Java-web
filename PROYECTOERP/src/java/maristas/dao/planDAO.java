package maristas.dao;

import maristas.conexion.connectionBD;
import maristas.beans.PlanEstrategicoBean;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import maristas.conexion.conecctionBDMysql;

public class planDAO {
    ArrayList<PlanEstrategicoBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
   
   public ArrayList<PlanEstrategicoBean> GetPlans(){
       lista = new ArrayList<PlanEstrategicoBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, nombre,"
                    + " fecha_vigencia, fecha_termino,"
                    + " anio_inicio, anio_termino,"
                    + " aprobado_por, descripcion"
                    + " from Planes");

            rs=pt.executeQuery();


            while(rs.next()){
                PlanEstrategicoBean objPlan=new PlanEstrategicoBean();

                objPlan.setNombre(rs.getString(2));
                objPlan.setFec_vigencia(rs.getString(3));
                objPlan.setFec_termino(rs.getString(4));
                objPlan.setAnio_inicio(rs.getString(5));
                objPlan.setAnio_termino(rs.getString(6));
                objPlan.setAprobado_por(rs.getInt(7));
                objPlan.setDescripcion(rs.getString(8));

                lista.add(objPlan);                            
            }
            rs.close();
            pt.close();
            cnn.close();
            return lista;
       } 
       catch(Exception e){
           return lista;
       }
   }
   public PlanEstrategicoBean GetPlan(int id_plan){
       PlanEstrategicoBean objPlan = new PlanEstrategicoBean();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, nombre,"
                    + " fecha_vigencia, fecha_termino,"
                    + " anio_inicio, anio_termino,"
                    + " aprobado_por, descripcion"
                    + " from Planes where id=?");
            pt.setInt(1, id_plan);
            rs=pt.executeQuery();

                objPlan.setNombre(rs.getString(2));
                objPlan.setFec_vigencia(rs.getString(3));
                objPlan.setFec_termino(rs.getString(4));
                objPlan.setAnio_inicio(rs.getString(5));
                objPlan.setAnio_termino(rs.getString(6));
                objPlan.setAprobado_por(rs.getInt(7));
                objPlan.setDescripcion(rs.getString(8));
            rs.close();
            pt.close();
            cnn.close();
            return objPlan;
       } 
       catch(Exception e){
           return objPlan;
       }
   }
   

    public int InsertarPlan(PlanEstrategicoBean objPlan) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into Planes(nombre, fecha_vigencia, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion) " +
                    "values(?, ?, ?, ?, ?, ?, ?)");
            pt.setString(1, objPlan.getNombre());
            pt.setString(2, objPlan.getFec_vigencia());
            pt.setString(3, objPlan.getFec_termino());
            pt.setString(4, objPlan.getAnio_inicio());
            pt.setString(5, objPlan.getAnio_termino());
            pt.setInt(6, objPlan.getAprobado_por());
            pt.setString(7, objPlan.getDescripcion());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    public int ActualizarPlan(PlanEstrategicoBean objPlan) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("update Planes set "
                    + " nombre = ?,"
                    + " fecha_vigencia=?,"
                    + " fecha_termino=?,"
                    + " anio_inicio=?,"
                    + " anio_termino=?,"
                    + " aprobado_por=?,"
                    + " descripcion= ? "
                    + " where id = ?");
            pt.setString(1, objPlan.getNombre());
            pt.setString(2, objPlan.getFec_vigencia());
            pt.setString(3, objPlan.getFec_termino());
            pt.setString(4, objPlan.getAnio_inicio());
            pt.setString(5, objPlan.getAnio_termino());
            pt.setInt(6, objPlan.getAprobado_por());
            pt.setString(7, objPlan.getDescripcion());
            pt.setInt(8, objPlan.getId());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    public int EliminarPlan(PlanEstrategicoBean objPlan) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("delete Planes where id=?");
            pt.setInt(1, objPlan.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
}
