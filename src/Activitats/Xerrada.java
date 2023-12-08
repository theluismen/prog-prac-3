package Activitats;



public class Xerrada extends Activitat {

        /* ATRIBUTS */
    private final int hora = 17;
    private String nomAutor;


    /* CONSTRUCTORS */
    public Xerrada (String nomAutor, String nom, String lloc, int cpostal, int dia){
    super(nom, lloc, cpostal, dia);
    this.nomAutor=nomAutor;

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
    
    /**
     * Metode que retorna un String que conte les dades del objecte
     * 
     * @return nomAutor     Autor de la xerrada
     */
    @Override
    public String toString() {
        return "Xerrada [hora=" + hora + ", nomAutor=" + nomAutor + super.toString()+"]";
    }

    /**
    * Metode que retorna una copia de xerrada
    *
    * @return xerrada  una copia de la xerrada
    */
    /*public Xerrada copia () {
        return new Xerrada (this.nomAutor, nom,  lloc,  cpostal,  dia);
    }
    
*/
}
