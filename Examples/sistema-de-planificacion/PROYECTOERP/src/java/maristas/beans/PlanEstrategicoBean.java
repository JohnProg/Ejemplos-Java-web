package maristas.beans;


public class PlanEstrategicoBean {
    private int id;
    private String nombre;
    private String fec_vigencia;
    private String fec_termino;
    private String anio_inicio;
    private String anio_termino;
    private int aprobado_por;
    private String descripcion;

    public PlanEstrategicoBean() {
    }

    public PlanEstrategicoBean(int id, String nombre, String fec_vigencia, String fec_termino, String anio_inicio, String anio_termino, int aprobado_por, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fec_vigencia = fec_vigencia;
        this.fec_termino = fec_termino;
        this.anio_inicio = anio_inicio;
        this.anio_termino = anio_termino;
        this.aprobado_por = aprobado_por;
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
     * @return the fec_vigencia
     */
    public String getFec_vigencia() {
        return fec_vigencia;
    }

    /**
     * @param fec_vigencia the fec_vigencia to set
     */
    public void setFec_vigencia(String fec_vigencia) {
        this.fec_vigencia = fec_vigencia;
    }

    /**
     * @return the fec_termino
     */
    public String getFec_termino() {
        return fec_termino;
    }

    /**
     * @param fec_termino the fec_termino to set
     */
    public void setFec_termino(String fec_termino) {
        this.fec_termino = fec_termino;
    }

    /**
     * @return the anio_inicio
     */
    public String getAnio_inicio() {
        return anio_inicio;
    }

    /**
     * @param anio_inicio the anio_inicio to set
     */
    public void setAnio_inicio(String anio_inicio) {
        this.anio_inicio = anio_inicio;
    }

    /**
     * @return the anio_termino
     */
    public String getAnio_termino() {
        return anio_termino;
    }

    /**
     * @param anio_termino the anio_termino to set
     */
    public void setAnio_termino(String anio_termino) {
        this.anio_termino = anio_termino;
    }

    /**
     * @return the aprobado_por
     */
    public int getAprobado_por() {
        return aprobado_por;
    }

    /**
     * @param aprobado_por the aprobado_por to set
     */
    public void setAprobado_por(int aprobado_por) {
        this.aprobado_por = aprobado_por;
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
