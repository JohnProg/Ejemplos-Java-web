

package maristas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import maristas.beans.ObjetivoBean;
import maristas.beans.PlanEstrategicoBean;
import maristas.conexion.conecctionBDMysql;
import maristas.conexion.connectionBD;


public class objetivoDAO {
    ArrayList<ObjetivoBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
   
   public ArrayList<ObjetivoBean> GetObjetivos(int id_linea){
       lista = new ArrayList<ObjetivoBean>();
       
       try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            String sql = "select id,"
                    + " linea,"
                    + " nombre,"
                    + " descripcion"
                    + " from Objetivo";
            
            if(id_linea > 0){
                sql = sql + " where linea="+id_linea;
            }
            
            pt=cnn.prepareStatement(sql);

            rs=pt.executeQuery();


            while(rs.next()){
                ObjetivoBean objObjetivo=new ObjetivoBean();
                objObjetivo.setId(rs.getInt(1));
                objObjetivo.setId_linea(rs.getInt(2));
                objObjetivo.setNombre(rs.getString(3));
                objObjetivo.setDescripcion(rs.getString(4));

                lista.add(objObjetivo);                            
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

   public ObjetivoBean GetObjetivo(int id_plan){
       ObjetivoBean objObjetivo = new ObjetivoBean();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            //connectionBD cn = new connectionBD();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, "
                    + " linea, nombre, "
                    + " descripcion "
                    + " from objetivo"
                    + " where id=?");
            pt.setInt(1, id_plan);
            rs=pt.executeQuery();
                objObjetivo.setId_linea(rs.getInt(2));
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
   
   public int InsertarObjetivo(ObjetivoBean objObjetivo) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into Objetivo(id_linea, nombre, descripcion) values(?,?,?)");
            pt.setInt(1, objObjetivo.getId_linea());
            pt.setString(2, objObjetivo.getNombre());
            pt.setString(3, objObjetivo.getDescripcion());
            estado = pt.executeUpdate();
            pt.close();
            cnn.close();
        
        } catch(Exception e){
            
        }
        return estado;
    }
    
   public int ActualizarObjetivo(ObjetivoBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("update Objetivo set "
                    + " id_linea = ?,"
                    + " nombre=?,"
                    + " descripcion=?,"
                    + " where id = ?");
            pt.setInt(1, objPlan.getId_linea());
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
    
   public int EliminarObjetivo(ObjetivoBean objPlan) {
        int estado = 0;
        try{
            connectionBD cn = new connectionBD();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("delete Objetivo where id=?");
            pt.setInt(1, objPlan.getId());
            estado = pt.executeUpdate();
            pt.close();
        } catch(Exception e){
            
        }
        return estado;
    }
   public ArrayList<ObjetivoBean> GetObjetivesByLineId(int id_linea){
       lista = new ArrayList<ObjetivoBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id, linea, nombre, descripcion from Objetivo where linea = ?");
            
            pt.setInt(1, id_linea);
            rs=pt.executeQuery();
            while(rs.next()){
                ObjetivoBean objObjetivo=new ObjetivoBean();
                objObjetivo.setId(rs.getInt(1));
                objObjetivo.setId_linea(rs.getInt(2));
                objObjetivo.setNombre(rs.getString(3));
                objObjetivo.setDescripcion(rs.getString(4));

                lista.add(objObjetivo);                            
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
