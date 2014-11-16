
package maristas.beans;

/**
 *
 * @author Autonoma
 */
public class UsuarioBean {
        private int id;
        private String username;
        private String contra;
        private int id_rol;

    public UsuarioBean() {
    }

    public UsuarioBean(int id, String username, String contra, int id_rol) {
        this.id = id;
        this.username = username;
        this.contra = contra;
        this.id_rol = id_rol;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the contra
     */
    public String getContra() {
        return contra;
    }

    /**
     * @param contra the contra to set
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    /**
     * @return the id_rol
     */
    public int getId_rol() {
        return id_rol;
    }

    /**
     * @param id_rol the id_rol to set
     */
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    
        
}
