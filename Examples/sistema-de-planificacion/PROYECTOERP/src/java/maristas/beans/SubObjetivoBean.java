package maristas.beans;


public class SubObjetivoBean {
    
    private int id;
    private int id_objetivo;
    private String nombre;
    private String descripcion;

    public SubObjetivoBean() {
    }

    public SubObjetivoBean(int id, int id_objetivo, String nombre, String descripcion) {
        this.id = id;
        this.id_objetivo = id_objetivo;
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
     * @return the id_objetivo
     */
    public int getId_objetivo() {
        return id_objetivo;
    }

    /**
     * @param id_objetivo the id_objetivo to set
     */
    public void setId_objetivo(int id_objetivo) {
        this.id_objetivo = id_objetivo;
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
