
package maristas.beans;


public class PlanOperativoBean {

    private int id;
    private String nombre;
    private String descripcion;
    private int id_plan_estrategico;
    private int id_encargado;
    private int id_unidad_organica;
    
    public PlanOperativoBean(){
        
    }
    
    public PlanOperativoBean(int id, String nombre, String descripcion,
            int id_plan_estrategico, int id_encargado, int id_unidad_organica){
        
            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.id_plan_estrategico = id_plan_estrategico;
            this.id_encargado = id_encargado;
            this.id_unidad_organica = id_unidad_organica;
        
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
     * @return the id_plan_estrategico
     */
    public int getId_plan_estrategico() {
        return id_plan_estrategico;
    }

    /**
     * @param id_plan_estrategico the id_plan_estrategico to set
     */
    public void setId_plan_estrategico(int id_plan_estrategico) {
        this.id_plan_estrategico = id_plan_estrategico;
    }

    /**
     * @return the id_encargado
     */
    public int getId_encargado() {
        return id_encargado;
    }

    /**
     * @param id_encargado the id_encargado to set
     */
    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }

    /**
     * @return the id_unidad_organica
     */
    public int getId_unidad_organica() {
        return id_unidad_organica;
    }

    /**
     * @param id_unidad_organica the id_unidad_organica to set
     */
    public void setId_unidad_organica(int id_unidad_organica) {
        this.id_unidad_organica = id_unidad_organica;
    }
    
    
}
