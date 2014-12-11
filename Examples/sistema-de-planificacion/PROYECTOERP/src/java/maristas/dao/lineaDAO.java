
package maristas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import maristas.beans.LineaBean;
import maristas.conexion.conecctionBDMysql;


public class lineaDAO {
    
    ArrayList<LineaBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
   
   public ArrayList<LineaBean> GetLineas(int id_plan){
       lista = new ArrayList<LineaBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();
            String sql = "select l.id,"
                    + " l.id_plan_estrategico,"
                    + " p.nombre as nombre_plan,"
                    + " l.nombre as nombre_linea,"
                    + " l.descripcion"
                    + " from Linea l"
                    + " inner join PlanEstrategico"
                    + " p on p.id = l.id_plan_estrategico";
            
            if(id_plan > 0){
                sql = sql + " where  id_plan_estrategico="+id_plan;
            }
            pt=cnn.prepareStatement(sql);

            rs=pt.executeQuery();

            while(rs.next()){
                LineaBean objLinea=new LineaBean();
                objLinea.setId(rs.getInt(1));
                objLinea.setNombre(rs.getString(3));
                objLinea.setDescripcion(rs.getString(4));
                lista.add(objLinea);                            
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
   
   public LineaBean GetLinea(int id_linea){
       LineaBean objObjetivo = new LineaBean();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, "
                    + " id_plan_estrategico, nombre, "
                    + " descripcion "
                    + " from Linea"
                    + " where id=?");
            pt.setInt(1, id_linea);
            rs=pt.executeQuery();
                objObjetivo.setId(rs.getInt(1));
                objObjetivo.setId_plan(rs.getInt(2));
                objObjetivo.setNombre(rs.getString(3));
                objObjetivo.setDescripcion(rs.getString(4));
            rs.close();
            pt.close();
            cnn.close();
            return objObjetivo;
       } 
       catch(Exception e){
           return objObjetivo;
       }
   }
   
   public ArrayList<LineaBean> GetLinesByPlanId(int id_plan){
       lista = new ArrayList<LineaBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, "
                    + " id_plan_estrategico, nombre, "
                    + " descripcion "
                    + " from Linea"
                    + " where id_plan_estrategico=?");
            pt.setInt(1, id_plan);
            rs=pt.executeQuery();
            while(rs.next()){
                LineaBean objLinea=new LineaBean();
                objLinea.setId(rs.getInt(1));
                objLinea.setNombre(rs.getString(3));
                objLinea.setDescripcion(rs.getString(4));
                lista.add(objLinea);                            
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
   
   public int InsertarLinea(LineaBean objLinea) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into Linea(id_plan_estrategico, nombre, descripcion) values(?, ?, ?)");
            pt.setInt(1, objLinea.getId_plan());
            pt.setString(2, objLinea.getNombre());
            pt.setString(3, objLinea.getDescripcion());
    
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    
   public int ActualizarPlan(LineaBean objPlan) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("update Linea set "
                    + " nombre = ?,"
                    + " id_plan_estrategico=?,"
                    + " descripcion=?,"
                    + " where id = ?");
            pt.setInt(1, objPlan.getId_plan());
            pt.setString(2, objPlan.getNombre());
            pt.setString(3, objPlan.getDescripcion());
            pt.setInt(4, objPlan.getId());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    
   public int EliminarLinea(LineaBean objLinea) {
        int estado = 0;
        try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("delete Linea where id=?");
            pt.setInt(1, objLinea.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
   
}
