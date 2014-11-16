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
public class roleBean {
    private int id_role;
    private String titulo;

    public roleBean(int id_role, String titulo) {
        this.id_role = id_role;
        this.titulo = titulo;
    }

    /**
     * @return the id_role
     */
    public int getId_role() {
        return id_role;
    }

    /**
     * @param id_role the id_role to set
     */
    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
