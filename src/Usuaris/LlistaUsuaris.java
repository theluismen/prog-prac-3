package bin.Usuaris;

import bin.Excepcions.UsuariNoTrobatExcepcio;

public class LlistaUsuaris {
    /* ATRIBUTOS */
    private int         nElem;
    private Usuari[]   llista;

    /* CONSTRUCTOR */
    /**
     * Constructor de la clase LlistaUsuaris
     *
     * @param mida      Nombre màxim de instancies a guardar
     */
    public LlistaUsuaris ( int mida ) {
        this.llista = new Usuari[ mida ];
        this.nElem  = 0;
    }

    /* METODOS */
    /* METODOS: Setters */

    /* METODOS: Getters */
    /**
     * Metode que retorna una copia de la instancia indicada.
     * @param  index    Index del objecte a retornar
     * @return Usuari   Objecte a retornar
     */
    public Usuari getUsuari ( int index ) {
        return this.llista[index].copia();
    }

    /**
     * Metode que retorna el usuari que tingui el mateix nom que el que
     * es passa per parametre. NO RETORNA COPIA
     * @param  codi     Codi del Taller a buscar
     * @return Taller   Taller que te el codi indicat
     */
    public Usuari getUsuariPerNom ( String aliesUsuari ) throws UsuariNoTrobatExcepcio {
        int i; boolean trobat = false;
        for ( i = 0; i < this.nElem && ! trobat; i++ ) {
            if ( this.llista[i].getAlies().equals(aliesUsuari) ) {
                trobat = true;
            }
        }
        if ( ! trobat ) {
            throw new UsuariNoTrobatExcepcio( aliesUsuari );
        } else {
            return this.llista[i-1];
        }
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
    public boolean addUsuari ( Usuari usuari ) {
        boolean added = false;

        if ( ! this.llistaPlena() ) {   // Si hi ha lloc
            this.llista[ this.nElem ] = usuari.copia();
            this.nElem ++;
            added = true;
        }

        return added;
    }

    /**
     * Metode que afegeix un objecte al final de la llista.
     * Retorna un valor booleà: si s'ha pogut afegir o no.
     * Es tracta d'un metode sobrecarregat. Enlloc de rebre l'
     * objecte Usuari, rep els arguments per a crear un.
     *
     * @param alies       Alies del Usuari
     * @param correu      Correu electronic del Usuari
     * @param cpostal     Codi Postal del Usuari
     */
    public boolean addUsuari ( String alies, String correu, int cpostal ) {
        return this.addUsuari( new Usuari ( alies, correu, cpostal ) );
    }

    /**
     * Metode que retorna informacio del tots
     * objectes emmaatzemats.
     *
     */
    public String usuaris ( ) {
        String all = new String("");
        int i;
        for ( i = 0; i < this.nElem; i++ ) {
            all += this.llista[i].toString() + "\n";
        }
        return all;
    }
}
