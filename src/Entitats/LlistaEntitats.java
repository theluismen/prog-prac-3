package Entitats;

public class LlistaEntitats {
    /* ATRIBUTOS */
    private int         nElem;
    private Entitat[]   llista;

    /* CONSTRUCTOR */
    /**
     * Constructor de la clase LlistaEntitats
     *
     * @param mida      Nombre màxim de instancies a guardar
     */
    public LlistaEntitats ( int mida ) {
        this.llista = new Entitat[ mida ];
        this.nElem  = 0;
    }

    /* METODOS */
    /* METODOS: Setters */

    /* METODOS: Getters */
    /**
     * Metode que retorna una copia de la instancia indicada.
     * @param  index    Index del objecte a retornar
     * @return Entitat  objecte a retornar
     */
    public Entitat getEntitat ( int index ) {
        return this.llista[index].copia();
    }

    /**
    * Metode que retorna la quantitat d'elements
    * emmagatzemats a la llista.
    *
    * @return length  No Elements Guardats
    */
    public int getNElem () {
        return this.nElem;
    }

    /**
     * Metode que retorna la quantitat maxima
     * d'elements que pot emmagatzemar la llista
     *
     * @return mida  No Maxim d'Elements
     */
    public int getMida () {
        return this.llista.length;
    }

    /* METODOS: Varios */
    /**
     * Metode que retorna un valor booleà: si la llista esta plena o no.
     * true     en cas que sigui plena.
     * false    en cas que NO sigui plena.
     *
     * @return llistaPlena
     */
    public boolean llistaPlena ( ) {
        return this.nElem >= this.llista.length;
    }

    /**
     * Metode que afegeix un objecte al final de la llista.
     * Retorna un valor booleà: si s'ha pogut afegir o no.
     * true     en cas que s'hagi afegit.
     * false    en cas que NO s'hagi afegit.
     *
     * @return added Si s'ha afegit
     */
    public boolean addEntitat ( Entitat entitat ) {
        boolean added = false;

        if ( ! this.llistaPlena() ) {   // Si hi ha lloc
            this.llista[ this.nElem ] = entitat.copia();
            this.nElem ++;
            added = true;
        }

        return added;
    }

    /**
     * Metode que afegeix un objecte al final de la llista.
     * Retorna un valor booleà: si s'ha pogut afegir o no.
     * Es tracta d'un metode sobrecarregat. Enlloc de rebre l'
     * objecte Entitat, rep els arguments per a crear un.
     *
     * @param  nom      Nom de l'entitat ( identificador )
     * @param  telf     Telefon de l'entitat
     * @param  correu   Correu de l'entitat
     * @return added    Si s'ha afegit
     */
    public boolean addEntitat ( String nom, String telf, String correu ) {
        return this.addEntitat( new Entitat(nom, telf, correu) );
    }

    /**
     * Metode mostra informacio dels objectes emmaatzemats.
     *
     */
    public void mostrarEntitats ( ) {
        int i;
        for ( i = 0; i < this.nElem; i++ ) {
            System.out.println( this.llista[i].toString() );
        }
    }
}
