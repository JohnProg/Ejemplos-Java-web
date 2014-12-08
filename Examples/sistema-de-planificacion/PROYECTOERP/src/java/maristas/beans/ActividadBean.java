
package maristas.beans;


public class ActividadBean {
    
    private int id;
    private int id_plan_operativo;
    private String nombre;
    private double gastos;
    private double ingresos;
    private int id_sub_objetivo;
    private int id_presupuesto;
    private String descripcion;
    
    public ActividadBean(){
        
    }
    
    public ActividadBean(int id, int id_plan_operativo, String nombre, 
    double gastos, double ingresos, int id_sub_objetivo, int id_presupuesto, String descripcion ){
        
        this.id = id;
        this.id_plan_operativo = id_plan_operativo;
        this.nombre = nombre;
        this.gastos = gastos;
        this.ingresos = ingresos;
        this.id_sub_objetivo = id_sub_objetivo;
        this.id_presupuesto = id_presupuesto;
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
     * @return the id_plan_operativo
     */
    public int getId_plan_operativo() {
        return id_plan_operativo;
    }

    /**
     * @param id_plan_operativo the id_plan_operativo to set
     */
    public void setId_plan_operativo(int id_plan_operativo) {
        this.id_plan_operativo = id_plan_operativo;
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
     * @return the gastos
     */
    public double getGastos() {
        return gastos;
    }

    /**
     * @param gastos the gastos to set
     */
    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    /**
     * @return the ingresos
     */
    public double getIngresos() {
        return ingresos;
    }

    /**
     * @param ingresos the ingresos to set
     */
    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    /**
     * @return the id_sub_objetivo
     */
    public int getId_sub_objetivo() {
        return id_sub_objetivo;
    }

    /**
     * @param id_sub_objetivo the id_sub_objetivo to set
     */
    public void setId_sub_objetivo(int id_sub_objetivo) {
        this.id_sub_objetivo = id_sub_objetivo;
    }

    /**
     * @return the id_presupuesto
     */
    public int getId_presupuesto() {
        return id_presupuesto;
    }

    /**
     * @param id_presupuesto the id_presupuesto to set
     */
    public void setId_presupuesto(int id_presupuesto) {
        this.id_presupuesto = id_presupuesto;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
