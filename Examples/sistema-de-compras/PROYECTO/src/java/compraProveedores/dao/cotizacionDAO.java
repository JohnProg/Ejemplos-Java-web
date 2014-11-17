/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraProveedores.dao;

import compraProveedores.beans.cotizacionBean;
import compraProveedores.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author johnmachahuay
 */
public class cotizacionDAO {
    ArrayList<cotizacionBean> lista=null;
    Connection          cnn=null;
    PreparedStatement   pt=null;
    ResultSet           rs=null;
    
    public ArrayList<cotizacionBean> listado(){
       lista = new ArrayList<cotizacionBean>();
       
       try{
            Conexion cn = new Conexion();
            cnn = cn.getConnection();

            pt=cnn.prepareStatement("select id_cotizacion, id_fk_pedido, id_fk_usuario,"
                    + " forma_pago, descripcion"
                    + " from cotizacion");

            rs=pt.executeQuery();


            while(rs.next()){
                cotizacionBean objCotizacion = new cotizacionBean();

                objCotizacion.setId_cotizacion(rs.getInt(1));
                objCotizacion.setId_fk_pedido(rs.getInt(2));
                objCotizacion.setId_fk_usuario(rs.getInt(3));
                objCotizacion.setForma_pago(rs.getString(4));
                objCotizacion.setDescripcion(rs.getString(5));

                lista.add(objCotizacion);                            
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
    
    public int InsertarCotizacion(cotizacionBean objPedido) {
        int estado = 0;
        try{
            Conexion cn = new Conexion();
            cnn = cn.getConnection();
            pt=cnn.prepareStatement("insert into cotizacion(id_fk_pedido, id_fk_usuario, forma_pago, descripcion, costo) values(?, ?, ?, ?, ?)");
            pt.setInt(1, objPedido.getId_fk_pedido());
            pt.setInt(2, objPedido.getId_fk_usuario());
            pt.setString(3, objPedido.getForma_pago());
            pt.setString(4, objPedido.getDescripcion());
            pt.setFloat(5, objPedido.getCosto());
            
            estado = pt.executeUpdate();
            
            pt.close();
            cnn.close();
            return estado;
        
        } catch(Exception e){
            estado = 0;
            return estado;
        }
    }
}
