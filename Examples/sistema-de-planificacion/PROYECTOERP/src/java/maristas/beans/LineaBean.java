package maristas.beans;

public class LineaBean {
    private int id;
    private int id_plan;
    private String nombre;
    private String descripcion;

    public LineaBean() {
        
    }

    public LineaBean(int id, int id_plan, String nombre, String descripcion) {
        this.id = id;
        this.id_plan = id_plan;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
     * @return the id_plan
     */
    public int getId_plan() {
        return id_plan;
    }

    /**
     * @param id_plan the id_plan to set
     */
    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
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
    
    
    
}
