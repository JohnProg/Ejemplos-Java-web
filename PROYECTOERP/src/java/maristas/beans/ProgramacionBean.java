
package maristas.beans;


public class ProgramacionBean {
    
    private int id;
    private int id_actividad;
    private String fecha_inicio;
    private String fecha_final;
    
    public ProgramacionBean(){
        
    }
    
    public ProgramacionBean(int id, int id_actividad, String fecha_inicio,
            String fecha_final){
        
        this.id = id;
        this.id_actividad = id_actividad;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
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
     * @return the fecha_inicio
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * @return the fecha_final
     */
    public String getFecha_final() {
        return fecha_final;
    }

    /**
     * @param fecha_final the fecha_final to set
     */
    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }
            
    
           
           
    
}
