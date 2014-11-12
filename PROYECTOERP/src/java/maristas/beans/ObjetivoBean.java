
package maristas.beans;


public class ObjetivoBean {
    
    private int id;
    private int id_linea;
    private String nombre;
    private String descripcion;

    public ObjetivoBean() {
    }

    public ObjetivoBean(int id, int id_linea, String nombre, String descripcion) {
        this.id = id;
        this.id_linea = id_linea;
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
     * @return the id_linea
     */
    public int getId_linea() {
        return id_linea;
    }

    /**
     * @param id_linea the id_linea to set
     */
    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
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
