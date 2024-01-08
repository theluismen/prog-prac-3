package bin.Usuaris;

public class Usuari {
    /* ATRIBUTOS */
    private String alies;
    private String correu;
    private int    cpostal;
    private int    tallers; // tallers als que s'ha apuntat

    /* CONSTRUCTOR */
    /**
     * Constructor de la clase Usuari
     *
     * @param alies       Alies del Usuari
     * @param correu      Correu electronic del Usuari
     * @param cpostal     Codi Postal del Usuari
     */
    public Usuari ( String alies, String correu, int cpostal ) {
        this.alies   = alies;
        this.correu  = correu;
        this.cpostal = cpostal;
        this.tallers = 0;
    }

    public Usuari ( String alies, String correu, int cpostal, int tallers ) {
        this.alies   = alies;
        this.correu  = correu;
        this.cpostal = cpostal;
        this.tallers = tallers;
    }

    /* METODOS */
    /* METODOS: Setters */
    /**
     * Setter de l'atribut this.alies
     *
     * @param alies       Alies del Usuari
     */
    public void setAlies ( String alies ) {
        this.alies   = alies;
    }

    /**
     * Setter de l'atribut this.correu
     *
     * @param correu      Correu electronic del Usuari
     */
    public void setCorreu ( String correu ) {
        this.correu  = correu;
    }

    /**
    * Setter de l'atribut this.cpostal
    *
    * @param cpostal     Codi Postal del Usuari
    */
    public void setCPostal ( int cpostal ) {
        this.cpostal = cpostal;
    }

    /* METODOS: Getters */
    /**
    * Getter de l'atribut this.alies
    *
    * @return alies       Alies del Usuari
    */
    public String getAlies ( ) {
        return this.alies;
    }

    /**
    * Getter de l'atribut this.alies
    *
    * @return correu      Correu electronic del Usuari
    */
    public String getCorreu ( ) {
        return this.correu;
    }

    /**
    * Getter de l'atribut this.cpostal
    *
    * @return cpostal     Codi Postal del Usuari
    */
    public int getCPostal ( ) {
        return this.cpostal;
    }

    /**
    * Getter de l'atribut this.tallers
    *
    * @return tallers     tallers
    */
    public int getTallers ( ) {
        return this.tallers;
    }

    /**
    * Incrementa el contador de tallers apuntats
    */
    public void incTallers ( ) {
        this.tallers ++;
    }

    /* METODOS: Varios */
    /**
    * Metode que retorna una copia de l'instancia
    *
    * @return entitat  Copia de l'entitat
    */
    public Usuari copia ( ) {
        return new Usuari ( this.alies, this.correu, this.cpostal, this.tallers );
    }

    /**
    * Metode que retorna un String que conte informació
    * de l'objecte
    *
    * @return  String  String que conte informació
    */
    public String toString ( ) {
        return String.format("%-15s:%-30s:%s:%s", this.alies, this.correu, String.valueOf(this.cpostal), String.valueOf(this.tallers));
    }
}
