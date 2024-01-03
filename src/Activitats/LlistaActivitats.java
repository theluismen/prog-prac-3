package bin.Activitats;

import bin.Entitats.Entitat;

public class LlistaActivitats {
    /* ATRIBUTOS */
    private int        nElemTaller;
    private int        nElemVisita;
    private int        nElemXerrada;
    private Taller[]   tallers;
    private Visita[]   visites;
    private Xerrada[]  xerrades;

    /* CONSTRUCTOR */
    /**
     * Constructor de la clase LlistaActivitats
     *
     */
    public LlistaActivitats ( ) {
        this.tallers  = new Taller [ 1 ];
        this.visites  = new Visita [ 1 ];
        this.xerrades = new Xerrada[ 1 ];
        this.nElemTaller    = 0;
        this.nElemVisita    = 0;
        this.nElemXerrada   = 0;
    }

    /* METODOS */
    /* METODOS: Setters */

    /* METODOS: Getters */
    /**
     * Metode que retorna una copia de la instancia indicada.
     * @param  index    Index del objecte a retornar
     * @return Entitat  objecte a retornar
     */
    public Activitat getTaller ( int index ) {
        return this.tallers[index].copia();
    }

    /**
     * Metode que retorna una copia de la instancia indicada.
     * @param  index    Index del objecte a retornar
     * @return Entitat  objecte a retornar
     */
    public Activitat getVisita ( int index ) {
        return this.visites[index].copia();
    }

    /**
     * Metode que retorna una copia de la instancia indicada.
     * @param  index    Index del objecte a retornar
     * @return Entitat  objecte a retornar
     */
    public Activitat getXerrada ( int index ) {
        return this.xerrades[index].copia();
    }

    /**
    * Metode que retorna la quantitat d'elements
    * emmagatzemats a la llista.
    *
    * @return length  No Elements Guardats
    */
    public int getNElem () {
        return this.nElemTaller + this.nElemVisita + this.nElemXerrada;
    }

    /**
     * Metode que retorna la quantitat maxima
     * d'elements que pot emmagatzemar la llista
     *
     * @return mida  No Maxim d'Elements
     */
    public int getMida () {
        return this.tallers.length + this.visites.length + this.xerrades.length;
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
        return this.getNElem() >= this.getMida();
    }

    /**
     * Metode que retorna un valor booleà: si la llista de tallers esta plena o no.
     * true     en cas que sigui plena.
     * false    en cas que NO sigui plena.
     *
     * @return llistaPlenaTallers
     */
    public boolean llistaTallersPlena ( ) {
        return this.nElemTaller >= this.tallers.length;
    }

    /**
     * Metode que retorna un valor booleà: si la llista de visites esta plena o no.
     * true     en cas que sigui plena.
     * false    en cas que NO sigui plena.
     *
     * @return llistaPlenaVisites
     */
    public boolean llistaVisitesPlena ( ) {
        return this.nElemVisita >= this.visites.length;
    }

    /**
     * Metode que retorna un valor booleà: si la llista de tallers esta plena o no.
     * true     en cas que sigui plena.
     * false    en cas que NO sigui plena.
     *
     * @return llistaPlenaXerrades
     */
    public boolean llistaXerradesPlena ( ) {
        return this.nElemXerrada >= this.xerrades.length;
    }

    /**
     * Metode que afegeix un objecte al final de la llista.
     * Retorna un valor booleà: si s'ha pogut afegir o no.
     * true     en cas que s'hagi afegit.
     * false    en cas que NO s'hagi afegit.
     *
     * @return added Si s'ha afegit
     */
    public void addTaller ( Taller taller ) {
        Taller[] aux;
        if ( ! this.llistaTallersPlena() ) {
            // Si hi ha lloc
            this.tallers[ this.nElemTaller ] = taller.copia();
            System.out.println("Hay espacio");
        } else {
            System.out.println("Realojando");
            // Si no hi ha lloc, reservo mes espai
            aux = new Taller[ this.nElemTaller + 2 ];
            copiaTallers( this.tallers, aux );
            // Añado el taller que he recibido
            aux[ this.nElemTaller ] = taller.copia();
            this.tallers = aux;
        }
        this.nElemTaller ++;
        System.out.println(this.nElemTaller + "/" + this.tallers.length);
    }

    /**
    * Metode que afegeix un objecte al final de la llista.
    * Retorna un valor booleà: si s'ha pogut afegir o no.
    * Es tracta d'un metode sobrecarregat. Enlloc de rebre l'
    * objecte Taller, rep els arguments per a crear un.
    *
    */
    public void addTaller ( String nom, String lloc, int cpostal, int dia, String nomEntitat, int hora, int durada, int capacitat ) {
        this.addTaller( new Taller ( nom, lloc, cpostal, dia, nomEntitat, hora, durada, capacitat ) );
    }

    private void copiaTallers ( Taller[] origen, Taller[] desti ) {
        int i;
        for ( i = 0; i < origen.length; i++ ) {
            desti[i] = origen[i].copia();
        }
    }

    /**
     * Metode que afegeix un objecte al final de la llista.
     * Retorna un valor booleà: si s'ha pogut afegir o no.
     * true     en cas que s'hagi afegit.
     * false    en cas que NO s'hagi afegit.
     *
     * @return added Si s'ha afegit
     */
    public void addVisita ( Visita visita ) {
        Visita[] aux;
        if ( ! this.llistaVisitesPlena() ) {
            // Si hi ha lloc
            this.visites[ this.nElemVisita ] = visita.copia();
            System.out.println("Hay espacio");
        } else {
            System.out.println("Realojando");
            // Si no hi ha lloc, reservo mes espai
            aux = new Visita[ this.nElemVisita + 2 ];
            copiaVisites( this.visites, aux );
            // Añado el taller que he recibido
            aux[ this.nElemVisita ] = visita.copia();
            this.visites = aux;
        }
        this.nElemVisita ++;
        System.out.println(this.nElemVisita + "/" + this.visites.length);
    }

    /**
    * Metode que afegeix un objecte al final de la llista.
    * Retorna un valor booleà: si s'ha pogut afegir o no.
    * Es tracta d'un metode sobrecarregat. Enlloc de rebre l'
    * objecte Visita, rep els arguments per a crear un.
    *
    */
    public void addVisita ( String nom, String lloc, int cpostal, int dia, String nomEntitat, boolean audioguia, boolean adaptada ) {
        this.addVisita( new Visita ( nom, lloc, cpostal, dia, nomEntitat, audioguia, adaptada ) );
    }

    private void copiaVisites ( Visita[] origen, Visita[] desti ) {
        int i;
        for ( i = 0; i < origen.length; i++ ) {
            desti[i] = origen[i].copia();
        }
    }

    /**
     * Metode que afegeix un objecte al final de la llista.
     * Retorna un valor booleà: si s'ha pogut afegir o no.
     * true     en cas que s'hagi afegit.
     * false    en cas que NO s'hagi afegit.
     *
     * @return added Si s'ha afegit
     */
    public void addXerrada ( Xerrada xerrada ) {
        Xerrada[] aux;
        if ( ! this.llistaXerradesPlena() ) {
            // Si hi ha lloc
            this.xerrades[ this.nElemXerrada ] = xerrada.copia();
            System.out.println("Hay espacio");
        } else {
            System.out.println("Realojando");
            // Si no hi ha lloc, reservo mes espai
            aux = new Xerrada[ this.nElemXerrada + 2 ];
            copiaXerrades( this.xerrades, aux );
            // Añado el taller que he recibido
            aux[ this.nElemXerrada ] = xerrada.copia();
            this.xerrades = aux;
        }
        this.nElemXerrada ++;
        System.out.println(this.nElemXerrada + "/" + this.xerrades.length);
    }

    private void copiaXerrades ( Xerrada[] origen, Xerrada[] desti ) {
        int i;
        for ( i = 0; i < origen.length; i++ ) {
            desti[i] = origen[i].copia();
        }
    }

    /**
     * Metode que retorna informacio del tots
     *  objectes emmaatzemats.
     *
     */
    public String activitats ( ) {
        return this.tallers() + this.visites() + this.xerrades();
    }

    /**
     * Metode que retorna informacio del tots
     *  TALLERS emmaatzemats.
     *
     */
    public String tallers ( ) {
        String all = new String("");
        int i;
        for ( i = 0; i < this.nElemTaller; i++ ) {
            all += this.tallers[i].toString() + "\n";
        }
        return all;
    }

    /**
     * Metode que retorna informacio del tots
     *  VISITES emmaatzemats.
     *
     */
    public String visites ( ) {
        String all = new String("");
        int i;
        for ( i = 0; i < this.nElemVisita; i++ ) {
            all += this.visites[i].toString() + "\n";
        }
        return all;
    }

    /**
     * Metode que retorna informacio del tots
     *  XERRADES emmaatzemats.
     *
     */
    public String xerrades ( ) {
        String all = new String("");
        int i;
        for ( i = 0; i < this.nElemXerrada; i++ ) {
            all += this.xerrades[i].toString() + "\n";
        }
        return all;
    }
}
