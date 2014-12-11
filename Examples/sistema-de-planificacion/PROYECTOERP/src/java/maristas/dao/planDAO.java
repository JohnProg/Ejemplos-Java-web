package maristas.dao;

import maristas.beans.PlanEstrategicoBean;
import java.sql.*;
import java.util.ArrayList;
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
                    + " fecha_inicio, fecha_termino,"
                    + " anio_inicio, anio_termino,"
                    + " aprobado_por, descripcion"
                    + " from PlanEstrategico");
            rs=pt.executeQuery();


            while(rs.next()){
                PlanEstrategicoBean objPlan=new PlanEstrategicoBean();
                
                objPlan.setId(rs.getInt(1));
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
   
   public PlanEstrategicoBean GetPlan(PlanEstrategicoBean objPlan){
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select * from PlanEstrategico where id=?");
            pt.setInt(1, objPlan.getId());
            rs=pt.executeQuery();

                if(rs.next()){
                    objPlan.setId(rs.getInt(1));
                    objPlan.setNombre(rs.getString(2));
                    objPlan.setFec_vigencia(rs.getString(3));
                    objPlan.setFec_termino(rs.getString(4));
                    objPlan.setAnio_inicio(rs.getString(5));
                    objPlan.setAnio_termino(rs.getString(6));
                    objPlan.setAprobado_por(rs.getInt(7));
                    objPlan.setDescripcion(rs.getString(8));
                }
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
            pt=cnn.prepareStatement("insert into PlanEstrategico(nombre, fecha_inicio, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion) " +
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
            pt=cnn.prepareStatement("update PlanEstrategico set "
                    + " nombre = ?,"
                    + " fecha_inicio=?,"
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
            pt=cnn.prepareStatement("delete FROM PlanEstrategico where id=?");
            pt.setInt(1, objPlan.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
}
