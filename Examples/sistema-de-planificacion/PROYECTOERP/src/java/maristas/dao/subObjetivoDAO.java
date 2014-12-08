
package maristas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import maristas.beans.SubObjetivoBean;
import maristas.conexion.conecctionBDMysql;
import maristas.conexion.connectionBD;


public class subObjetivoDAO {
    ArrayList<SubObjetivoBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
   
   public ArrayList<SubObjetivoBean> GetSubObjetivos(){
       lista = new ArrayList<SubObjetivoBean>();
       
       try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, id_objetivo, nombre, descripcion from SubObjetivo");

            rs=pt.executeQuery();


            while(rs.next()){
                SubObjetivoBean objSubObjetivo=new SubObjetivoBean();
                
                objSubObjetivo.setId(rs.getInt(1
                ));
                objSubObjetivo.setNombre(rs.getString(2));
                objSubObjetivo.setId_objetivo(rs.getInt(3));
                objSubObjetivo.setDescripcion(rs.getString(4));

                lista.add(objSubObjetivo);                            
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

   public SubObjetivoBean GetSubObjetivo(int id_plan){
       SubObjetivoBean objSubObjetivo = new SubObjetivoBean();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, "
                    + " id_objetivo,  "
                    + " nombre, descripcion "
                    + " from SubObjetivo"
                    + " where id=?");
            pt.setInt(1, id_plan);
            rs=pt.executeQuery();
                objSubObjetivo.setId(rs.getInt(1));
                objSubObjetivo.setId_objetivo(rs.getInt(2));
                objSubObjetivo.setNombre(rs.getString(3));
                objSubObjetivo.setDescripcion(rs.getString(4));
            rs.close();
            pt.close();
            cnn.close();
            return objSubObjetivo;
       } 
       catch(Exception e){
           return objSubObjetivo;
       }
   }

   public int InsertarObjetivo(SubObjetivoBean objObjetivo) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into Objetivo(id_linea, nombre, descripcion) values(?,?,?)");
            pt.setInt(1, objObjetivo.getId_objetivo());
            pt.setString(2, objObjetivo.getNombre());
            pt.setString(3, objObjetivo.getDescripcion());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    
   public int ActualizarObjetivo(SubObjetivoBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("update Objetivo set "
                    + " id_linea = ?,"
                    + " nombre=?,"
                    + " descripcion=?,"
                    + " where id = ?");
            pt.setInt(1, objPlan.getId_objetivo());
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
    
   public int EliminarObjetivo(SubObjetivoBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("delete SubObjetivo where id=?");
            pt.setInt(1, objPlan.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
   public ArrayList<SubObjetivoBean> GetSubObjetivesByObjetiveId(int id_obj){
       lista = new ArrayList<SubObjetivoBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, objetivo, nombre, descripcion from SubObjetivo where objetivo = ?");
            
            pt.setInt(1, id_obj);
            rs=pt.executeQuery();
            while(rs.next()){
                SubObjetivoBean objSubObjetivo=new SubObjetivoBean();
                
                objSubObjetivo.setId(rs.getInt(1));
                objSubObjetivo.setId_objetivo(rs.getInt(2));
                objSubObjetivo.setNombre(rs.getString(3));
                objSubObjetivo.setDescripcion(rs.getString(4));

                lista.add(objSubObjetivo);                            
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
}
