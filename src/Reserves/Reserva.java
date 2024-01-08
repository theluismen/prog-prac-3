package bin.Reserves;

public class Reserva {
    /* ATRIBUTOS */
    private int     codi;
    private String  aliesUsuari;
    private String  codiTaller;
    private int     valoracio;

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
        this.valoracio   = -1;
    }

    /**
     * Constuctor de la clase Reserva. Amb l'atribut valoracio. Aquest constructor
     * es emprat pel metode copia().
     *
     * @param   codi         Codi de la Reserva
     * @param   aliesUsuari  Alies del Usuari que fa la reserva
     * @param   codiTaller   Codi del Taller on l'Usuari fa la reserva
     * @param   valoracio    Valoracio del Taller on l'Usuari fa la reserva
     */
    public Reserva ( int codi, String aliesUsuari, String codiTaller, int valoracio ) {
        this.codi        = codi;
        this.aliesUsuari = aliesUsuari;
        this.codiTaller  = codiTaller;
        this.valoracio   = valoracio;
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
    public void setAliesUsuari ( String aliesUsuari ) {
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

    /**
    * Setter de l'atribut this.valoracio
    *
    * @param valoracio Valoracio de l'usuari sobre el Taller
    */
    public void setValoracio ( int valoracio ) {
        this.valoracio = valoracio;
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

    /**
    * Getter de la valoracio del Taller
    *
    * @return this.valoracio Valoracio de l'usuari sobre el Taller
    */
    public int getValoracio () {
        return this.valoracio;
    }

    /* METODOS: Varios */
    /**
    * Metode que retorna una copia de l'instancia
    *
    * @return reserva Copia de la reserva
    */
    public Reserva copia ( ) {
        return new Reserva ( this.codi, this.aliesUsuari, this.codiTaller, this.valoracio );
    }

    /**
    * Metode que retorna un String que conte informació
    * de l'objecte.
    *
    * @return  String  String que conte informació
    */
    public String toString ( ) {
        return String.join(":", String.valueOf(this.codi), this.aliesUsuari, this.codiTaller, String.valueOf(this.valoracio));
    }

    /**
    * Metode que retorna un String que conte informació
    * de l'objecte.
    *
    * @return  String  String que conte informació
    */
    public String toStringCSV ( ) {
        return String.join(";", this.aliesUsuari, this.codiTaller);
    }
}
