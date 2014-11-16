
package maristas.beans;


public class UnidadOrganicaBean {
    
    private int id;
    private String nombre;
    
    public UnidadOrganicaBean(){
        
    }
    
    public UnidadOrganicaBean(int id, String nombre){
        
        this.id = id;
        this.nombre = nombre;
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
    
    
    
}
