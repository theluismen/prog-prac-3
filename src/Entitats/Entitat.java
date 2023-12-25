package bin.Entitats;

public class Entitat {
    /* ATRIBUTOS */
    private String  nom;
    private String  telf;
    private String  correu;

    /* CONSTRUCTOR */
    /**
     * Constructor de la clase Entitat
     *
     * @param nom       Nom de l'entitat ( identificador )
     * @param telf      Telefon de l'entitat
     * @param correu    Correu de l'entitat
     */
    public Entitat ( String nom, String telf, String correu ) {
        this.nom    = nom;
        this.telf   = telf;
        this.correu = correu;
    }

    /* METODOS */
    /* METODOS: Setters */

    /**
     * Setter de l'atribut this.nom
     *
     * @param nom       Nom de l'entitat ( identificador )
     */
    public void setNom ( String nom ) {
        this.nom    = nom;
    }

    /**
     * Setter de l'atribut this.telf
     *
     * @param telf      Telefon de l'entitat
     */
    public void setTelf ( String telf ) {
        this.telf   = telf;
    }

    /**
    * Setter de l'atribut this.correu
    *
    * @param correu    Correu de l'entitat
    */
    public void setCorreu ( String correu ) {
        this.correu = correu;
    }

    /* METODOS: Getters */
    /**
    * Getter de l'atribut this.nom
    *
    * @return nom    Nom de l'entitat
    */
    public String getNom ( ) {
        return this.nom;
    }

    /**
    * Getter de l'atribut this.telf
    *
    * @return telf   Telf de l'entitat
    */
    public String getTelf ( ) {
        return this.telf;
    }

    /**
    * Getter de l'atribut this.correu
    *
    * @return correu  Correu de l'entitat
    */
    public String getCorreu ( ) {
        return this.correu;
    }

    /* METODOS: Varios */

    /**
    * Metode que retorna un String que conte informació
    * de l'objecte
    *
    * @return  String  String que conte informació
    */
    public String toString ( ) {
        return String.join(":", this.nom, this.telf, this.correu );
    }

    /**
    * Metode que retorna una copia de l'instancia
    *
    * @return entitat  Copia de l'entitat
    */
    public Entitat copia ( ) {
        return new Entitat ( this.nom, this.telf, this.correu );
    }
}
