

package maristas.beans;


public class IndicadoresBean {
    
    private int id;
    private int id_actividad;
    private String nombre;
    private String tipo_logo;
    private String logo;
    
    public IndicadoresBean(){
        
    }
    
    public IndicadoresBean(int id, int id_actividad, String nombre,
            String tipo_logo, String logo){
            
        this.id = id;
        this.id_actividad = id_actividad;
        this.nombre = nombre;
        this.tipo_logo = tipo_logo;
        this.logo = logo;
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
     * @return the id_actividad
     */
    public int getId_actividad() {
        return id_actividad;
    }

    /**
     * @param id_actividad the id_actividad to set
     */
    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
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
     * @return the tipo_logo
     */
    public String getTipo_logo() {
        return tipo_logo;
    }

    /**
     * @param tipo_logo the tipo_logo to set
     */
    public void setTipo_logo(String tipo_logo) {
        this.tipo_logo = tipo_logo;
    }

    /**
     * @return the logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    
}
