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
public class pedidoBean {
    private int id_pedido;
    private Boolean estado;
    private String descripcion;
    private String area;
    private String fecha_titulo;

    public pedidoBean() {
        
    }

    public pedidoBean(int id_pedido, Boolean estado, String descripcion, String area, String fecha_titulo) {
        this.id_pedido = id_pedido;
        this.estado = estado;
        this.descripcion = descripcion;
        this.area = area;
        this.fecha_titulo = fecha_titulo;
    }

    /**
     * @return the id_pedido
     */
    public int getId_pedido() {
        return id_pedido;
    }

    /**
     * @param id_pedido the id_pedido to set
     */
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
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
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the fecha_titulo
     */
    public String getFecha_titulo() {
        return fecha_titulo;
    }

    /**
     * @param fecha_titulo the fecha_titulo to set
     */
    public void setFecha_titulo(String fecha_titulo) {
        this.fecha_titulo = fecha_titulo;
    }
    
}
