
package maristas.dao;

import maristas.beans.UnidadOrganicaBean;
import java.sql.*;
import java.util.ArrayList;
import maristas.conexion.conecctionBDMysql;
import maristas.interfaces.UnidadOrganicaDAO;


public class MysqlUnidadOrganicaDAO implements UnidadOrganicaDAO{
    
    ArrayList<UnidadOrganicaBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<UnidadOrganicaBean> lista(){
       lista = new ArrayList<UnidadOrganicaBean>();
       
       try{
            conecctionBDMysql cn = new conecctionBDMysql();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id,"
                    + " nombre"
                    + " from UnidadOrganizativa");

            rs=pt.executeQuery();


            while(rs.next()){
                UnidadOrganicaBean objPlan=new UnidadOrganicaBean();

                objPlan.setId(rs.getInt(1));
                objPlan.setNombre(rs.getString(2));

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
       
}
