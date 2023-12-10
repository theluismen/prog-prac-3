package Reserves;

public class Reserva {
    /* ATRIBUTOS */
    private int     codi;
    private String  aliesUsuari;
    private String  codiTaller;
    /* ATRIBUTOS: Estaticos */
    // private static int codiIndex = 1000;

    /* CONSTRUCTOR */
    /**
     * Constuctor de la clase Reserva.
     *
     * @param   codi         Codi de la Reserva
     * @param   aliesUsuari  Alies del Usuari que fa la reserva
     * @param   codiTaller   Codi del Taller on l'Usuari fa la reserva
     */
    public Reserva ( int codi, String aliesUsuari, String codiTaller ) {
        this.codi        = codi;
        this.aliesUsuari = aliesUsuari;
        this.codiTaller  = codiTaller;
    }

    /* METODOS*/
    /* METODOS: Setters */
    /**
     * Setter de l'atribut this.codi
     *
     * @param codi       Codi de la reserva
     */
    public void setCodi ( int codi ) {
        this.codi = codi;
    }

    /**
     * Setter de l'atribut this.aliesUsuari
     *
     * @param aliesUsuari Alies del Usuari que fa la reserva
     */
    public void setCodi ( String aliesUsuari ) {
        this.aliesUsuari = aliesUsuari;
    }

    /**
     * Setter de l'atribut this.codiTaller
     *
     * @param codiTaller Codi del Taller on es fa la reserva
     */
    public void setCodiTaller ( String codiTaller ) {
        this.codiTaller = codiTaller;
    }

    /* METODOS: Getters */
    /**
    * Getter del codi de la reserva
    *
    * @return this.codi  Codi de la reserva
    */
    public int getCodi () {
        return this.codi;
    }

    /**
    * Getter del usuari que fa la reserva
    *
    * @return this.aliesUsuari Usuari que fa la reserva
    */
    public String getAliesUsuari () {
        return this.aliesUsuari;
    }

    /**
    * Getter del codi del Taller on es reserva.
    *
    * @return this.codiTaller Codi del Taller on es reserva.
    */
    public String getCodiTaller () {
        return this.codiTaller;
    }

    /* METODOS: Varios */
    /**
    * Metode que retorna una copia de l'instancia
    *
    * @return reserva Copia de la reserva
    */
    public Reserva copia ( ) {
        return new Reserva ( this.codi, this.aliesUsuari, this.codiTaller );
    }

    /**
    * Metode que retorna un String que conte informació
    * de l'objecte.
    *
    * @return  String  String que conte informació
    */
    public String toString ( ) {
        return this.codi + ":" + this.aliesUsuari + ":" + this.codiTaller;
    }
}
