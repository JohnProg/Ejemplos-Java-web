/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraProveedores.beans;

/**
 *
 * @author johnmachahuay
 */
public class cotizacionBean {
    private int id_cotizacion;
    private int id_fk_pedido;
    private int id_fk_usuario;
    private String forma_pago;
    private String descripcion;
    private float costo;

    public cotizacionBean(int id_cotizacion, int id_fk_pedido, int id_fk_usuario, String forma_pago, String descripcion, float costo) {
        this.id_cotizacion = id_cotizacion;
        this.id_fk_pedido = id_fk_pedido;
        this.id_fk_usuario = id_fk_usuario;
        this.forma_pago = forma_pago;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public cotizacionBean() {
        
    }

    /**
     * @return the id_cotizacion
     */
    public int getId_cotizacion() {
        return id_cotizacion;
    }

    /**
     * @param id_cotizacion the id_cotizacion to set
     */
    public void setId_cotizacion(int id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    /**
     * @return the id_fk_pedido
     */
    public int getId_fk_pedido() {
        return id_fk_pedido;
    }

    /**
     * @param id_fk_pedido the id_fk_pedido to set
     */
    public void setId_fk_pedido(int id_fk_pedido) {
        this.id_fk_pedido = id_fk_pedido;
    }

    /**
     * @return the id_fk_usuario
     */
    public int getId_fk_usuario() {
        return id_fk_usuario;
    }

    /**
     * @param id_fk_usuario the id_fk_usuario to set
     */
    public void setId_fk_usuario(int id_fk_usuario) {
        this.id_fk_usuario = id_fk_usuario;
    }

    /**
     * @return the forma_pago
     */
    public String getForma_pago() {
        return forma_pago;
    }

    /**
     * @param forma_pago the forma_pago to set
     */
    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the costo
     */
    public float getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }
}
