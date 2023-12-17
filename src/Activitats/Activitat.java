package Activitats;

import Entitats.Entitat;

public class Activitat {
    /* ATRIBUTOS */
    private String  codi;
    private String  nom;
    private String  lloc;
    private int     cpostal;
    private int     dia;
    private Entitat entitat;

    /* ATRIBUTOS: Estaticos */
    private static int codiIndex = 100;

    /* CONSTRUCTOR */
    /**
     * Constuctor de la clase Activitat.
     * @param   nom     Nom de l'activitat
     * @param   lloc    Lloc de l'activitat
     * @param   cpostal Codi Postal de l'activitat
     * @param   dia     Dia de l'activitat
     */
    public Activitat ( String nom, String lloc, int cpostal, int dia, Entitat entitat ) {
        this.codi    = crearCodi( nom );
        this.nom     = nom;
        this.lloc    = lloc;
        this.cpostal = cpostal;
        this.dia     = dia;
        this.entitat = entitat.copia();
    }

    /**
     * Constuctor de la clase Activitat. Con codigo de activitat
     * @param   codi    Codi de l'activitat
     * @param   nom     Nom de l'activitat
     * @param   lloc    Lloc de l'activitat
     * @param   cpostal Codi Postal de l'activitat
     * @param   dia     Dia de l'activitat
     */
    public Activitat ( String codi, String nom, String lloc, int cpostal, int dia, Entitat entitat ) {
        this.codi    = codi;
        this.nom     = nom;
        this.lloc    = lloc;
        this.cpostal = cpostal;
        this.dia     = dia;
        this.entitat = entitat.copia();
    }

    /* METODOS */
    /* METODOS: Setters */
    /**
     * Setter de l'atribut this.nom
     *
     * @param nom       Nom de l'activitat
     */
    public void setNom ( String nom ) {
        this.nom = nom;
    }

    /**
     * Setter de l'atribut this.lloc
     *
     * @param lloc      Lloc de l'activitat
     */
    public void setLloc ( String lloc ) {
        this.lloc = lloc;
    }

    /**
     * Setter de l'atribut this.cpostal
     *
     * @param cpostal    Codi Postal de l'activitat
     */
    public void setCPostal ( int cpostal ) {
        this.cpostal = cpostal;
    }

    /**
     * Setter de l'atribut this.dia
     *
     * @param dia    Dia de l'activitat
     */
    public void setDia ( int dia ) {
        this.dia = dia;
    }

    /**
     * Setter de l'atribut this.entitat
     *
     * @param entitat Entitat que organitza l'activitat
     */
    public void setDia ( Entitat entitat ) {
        this.entitat = entitat.copia();
    }

    /* METODOS: Getters */
    /**
    * Getter del codi de l'activitat
    *
    * @return this.codi  Codi de l'activitat
    */
    public String getCodi () {
        return this.codi;
    }

    /**
    * Getter del nom de l'activitat
    *
    * @return this.nom  Nom de l'activitat
    */
    public String getNom () {
        return this.nom;
    }

    /**
    * Getter del lloc de l'activitat
    *
    * @return this.lloc  Lloc de l'activitat
    */
    public String getLloc () {
        return this.lloc;
    }

    /**
    * Getter del Codi Postal de l'activitat
    *
    * @return this.cpostal  Codi Postal de l'activitat
    */
    public int getCPostal () {
        return this.cpostal;
    }

    /**
    * Getter del dia de l'activitat
    *
    * @return this.dia  Dia de l'activitat
    */
    public int getDia () {
        return this.dia;
    }

    /**
    * Getter de l'entitat de l'activitat
    *
    * @return this.entitat  Entitat que organitza l'activitat
    */
    public Entitat getEntitat () {
        return this.entitat.copia();
    }

    /* METODOS: Varios */
    /**
    * Metode que retorna un codi identificatiu per a
    * l'activitat i a més incrementa l'atribut estatic que
    * forma part del codi.
    *
    * @param   nom     nom de l'activitat
    * @return  codi    El codi de la activitat
     */
    private String crearCodi ( String nom ) {
        String codi = nom.substring(0, 3) + Integer.toString( codiIndex );
        codiIndex ++;
        return codi;
    }

    /**
    * Metode que retorna un String que conte informació
    * de l'objecte.
    *
    * @return  String  String que conte informació
    */
    public String toString ( ) {
        return this.codi + ":" + this.nom + ":" + this.lloc + ":" +
            this.cpostal + ":" + this.dia + ":" + this.entitat.getNom();
    }

    /**
    * Metode que retorna una copia de l'instancia
    *
    * @return entitat  Copia de l'activitat
    */
    public Activitat copia () {
        return new Activitat ( this.codi, this.nom, this.lloc, this.cpostal, this.dia, this.entitat );
    }
}
