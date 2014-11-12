package maristas.beans;


public class SubObjetivoIndicadorBean {
    private int id_indicador;
    private int id_sub_objetivo;

    public SubObjetivoIndicadorBean() {
    }

    public SubObjetivoIndicadorBean(int id_indicador, int id_sub_objetivo) {
        this.id_indicador = id_indicador;
        this.id_sub_objetivo = id_sub_objetivo;
    }
    
    /**
     * @return the id_indicador
     */
    public int getId_indicador() {
        return id_indicador;
    }

    /**
     * @param id_indicador the id_indicador to set
     */
    public void setId_indicador(int id_indicador) {
        this.id_indicador = id_indicador;
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
    
    
    
}
