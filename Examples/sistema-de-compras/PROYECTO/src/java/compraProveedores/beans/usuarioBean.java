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
public class usuarioBean {
    private int id_usuario;
    private String usuario;
    private String contrasena;
    private String nombre;
    private int id_fk_role;

    public usuarioBean(int id_usuario, String usuario, String contrasena, String nombre, int id_fk_role) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.id_fk_role = id_fk_role;
    }

    public usuarioBean() {
        
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the id_fk_role
     */
    public int getId_fk_role() {
        return id_fk_role;
    }

    /**
     * @param id_fk_role the id_fk_role to set
     */
    public void setId_fk_role(int id_fk_role) {
        this.id_fk_role = id_fk_role;
    }
}
