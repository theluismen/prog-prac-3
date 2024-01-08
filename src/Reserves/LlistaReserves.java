package bin.Reserves;

public class LlistaReserves {
    /* ATRIBUTOS */
    private int         nElem;
    private Reserva[]   llista;
    /* ATRIBUTOS: Estaticos */
    private static int codiIndex = 1000;

    /* CONSTRUCTOR */
    /**
     * Constructor de la clase LlistaReserves
     *
     * @param mida      Nombre màxim de instancies a guardar
     */
    public LlistaReserves ( int mida ) {
        this.llista = new Reserva[ mida ];
        this.nElem  = 0;
    }

    /* METODOS */
    /* METODOS: Setters */

    /* METODOS: Getters */
    /**
     * Metode que retorna una copia de la instancia indicada.
     * @param  index    Index del objecte a retornar
     * @return Reserva  Objecte a retornar
     */
    public Reserva getReserva ( int index ) {
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
    public boolean addReserva ( Reserva reserva ) {
        boolean added = false;
        if ( ! this.llistaPlena() ) {   // Si hi ha lloc
            this.llista[ this.nElem ] = reserva.copia();
            this.nElem ++;
            codiIndex  ++;
            added = true;
        }
        return added;
    }

    /**
     * Metode que afegeix un objecte al final de la llista.
     * Retorna un valor booleà: si s'ha pogut afegir o no.
     * Es tracta d'un metode sobrecarregat. Enlloc de rebre l'
     * objecte Reserva, rep els arguments per a crear un.
     *
     * @param   aliesUsuari  Alies del Usuari que fa la reserva
     * @param   codiTaller   Codi del Taller on l'Usuari fa la reserva
     */
    public boolean addReserva ( String aliesUsuari, String codiTaller ) {
        return this.addReserva( new Reserva(codiIndex, aliesUsuari, codiTaller) );
    }

    /**
     * Metode que retorna informacio del tots
     * objectes emmaatzemats.
     *
     */
    public String reserves ( ) {
        String all = new String("");
        int i;
        for ( i = 0; i < this.nElem; i++ ) {
            all += this.llista[i].toString() + "\n";
        }
        return all;
    }

    /**
     * Metode que retorna informacio del tots
     * objectes emmaatzemats.
     *
     */
    public String reservesCSV ( ) {
        String all = new String("");
        int i;
        for ( i = 0; i < this.nElem; i++ ) {
            all += this.llista[i].toStringCSV() + "\n";
        }
        return all;
    }
}
