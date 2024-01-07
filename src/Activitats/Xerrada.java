package bin.Activitats;

import bin.Entitats.Entitat;

public class Xerrada extends Activitat {
    /* ATRIBUTS */
    private static final int hora = 17;
    private String nomAutor;


    /* CONSTRUCTORS */
    public Xerrada ( String nom, String lloc, int cpostal, int dia, String nomEntitat, String nomAutor ){
        super(nom, lloc, cpostal, dia, nomEntitat);
        this.nomAutor = nomAutor;
    }

    public Xerrada ( String codi, String nom, String lloc, int cpostal, int dia, String nomEntitat, String nomAutor ){
        super(codi, nom, lloc, cpostal, dia, nomEntitat);
        this.nomAutor = nomAutor;
    }

    /* METODES */
    /* METODES: getters */

    /**
     * getter de l'hora de les xerrades (sempre les 17)
     *
     * @return hora     hora de la xerrada
     */
    public int getHora() {
        return hora;
    }

    /**
     * getter de la persona que fa la xerrada
     *
     * @return nomAutor     Autor de la xerrada
     */
    public String getNomAutor() {
        return nomAutor;
    }

    /* METODES: SETTERS */
    /**
     * Setter de l'atribut this.nomAutor
     *
     * @param nomAutor       Nom de l'autor de la xerrada
     */
    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public Xerrada copia () {
        return new Xerrada (  this.getCodi(), this.getNom(), this.getLloc(), this.getCPostal(), this.getDia(), this.getNomEntitat(), this.nomAutor);
    }

    /**
     * Metode que retorna un String que conte les dades del objecte
     *
     * @return nomAutor     Autor de la xerrada
     */
    public String toString() {
        return "Xerrada [ " + String.join(":", super.toString(), this.hora+"h", this.nomAutor) + "]";
    }

    /**
     * Metode que retorna un String que conte les dades del objecte
     *
     * @return nomAutor     Autor de la xerrada
     */
    public String toStringCSV() {
        return String.join(";", super.toStringCSV(), this.nomAutor);
    }
}
