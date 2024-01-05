package bin.Activitats;

import bin.Entitats.Entitat;
import bin.Excepcions.TallerNoTrobatExcepcio;

public class LlistaActivitats {
    /* ATRIBUTOS */
    private int        nTallers;
    private int        nVisites;
    private int        nXerrades;
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
        this.nTallers    = 0;
        this.nVisites    = 0;
        this.nXerrades   = 0;
    }

    /* METODOS */
    /* METODOS: Setters */

    /* METODOS: Getters */
    /**
     * Metode que retorna una copia de la instancia indicada.
     * @param  index    Index del objecte a retornar
     * @return Entitat  objecte a retornar
     */
    public Taller getTaller ( int index ) {
        return this.tallers[index].copia();
    }

    /**
     * Metode que retorna el taller que tingui el mateix codi que el que
     * es passa per parametre. NO RETORNA COPIA
     * @param  codi     Codi del Taller a buscar
     * @return Taller   Taller que te el codi indicat
     */
    public Taller getTallerPerCodi ( String codi ) throws TallerNoTrobatExcepcio {
        int i; boolean trobat = false;
        for ( i = 0; i < this.nTallers && ! trobat; i++ ) {
            if ( this.tallers[i].getCodi().equals(codi.toUpperCase()) ) {
                trobat = true;
            }
        }
        if ( ! trobat ) {
            throw new TallerNoTrobatExcepcio( codi );
        } else {
            return this.tallers[i-1];
        }
    }

    /**
     * Metode que retorna una copia del taller que tingui el mateix codi
     * que el que es passa per parametre. RETORNA COPIA
     * @param  codi     Codi del Taller a buscar
     * @return Taller   Taller que te el codi indicat
     */
    public Taller getTallerPerCodiCopia ( String codi ) throws TallerNoTrobatExcepcio {
        return getTallerPerCodi(codi).copia();
    }

    /**
     * Metode que retorna una LlistaActivitats amb les activitats que pertanyin a la entitat
     * especificada per parametre.
     *
     * @param  nomEntitat   Nom de la entitat que es volen retornar les activitats
     * @return LlistaActivitats   Conjunt de activitats que dona la entitat indicada
     */
    public LlistaActivitats getActivitatsPerNomEntitat ( String nomEntitat ) {
        LlistaActivitats acts = new LlistaActivitats();
        Xerrada xerrada; Visita visita; Taller taller;
        int i;
        for ( i = 0; i < this.nXerrades; i++ ) {
            xerrada = this.getXerrada(i).copia();
            if ( xerrada.getNomEntitat().equalsIgnoreCase(nomEntitat) ) {
                acts.addXerrada( xerrada );
            }
        }
        for ( i = 0; i < this.nVisites; i++ ) {
            visita = this.getVisita(i).copia();
            if ( visita.getNomEntitat().equalsIgnoreCase(nomEntitat) ) {
                acts.addVisita( visita );
            }
        }
        for ( i = 0; i < this.nTallers; i++ ) {
            taller = this.getTaller(i).copia();
            if ( taller.getNomEntitat().equalsIgnoreCase(nomEntitat) ) {
                acts.addTaller( taller );
            }
        }
        return acts;
    }

    /**
     * Metode que retorna una LlistaActivitats amb les activitats que es realitzin
     * en un dia especificat per parametre.
     *
     * @param  nomEntitat   Nom de la entitat que es volen retornar les activitats
     * @return LlistaActivitats   Conjunt de activitats realitzades en un dia indicat
     */
    public LlistaActivitats getActivitatsPerDia ( int dia ) {
        LlistaActivitats acts = new LlistaActivitats();
        Xerrada xerrada; Visita visita; Taller taller;
        int i;
        for ( i = 0; i < this.nXerrades; i++ ) {
            xerrada = this.getXerrada(i).copia();
            if ( xerrada.getDia() == dia ) {
                acts.addXerrada( xerrada );
            }
        }
        for ( i = 0; i < this.nVisites; i++ ) {
            visita = this.getVisita(i).copia();
            if ( visita.getDia() == dia ) {
                acts.addVisita( visita );
            }
        }
        for ( i = 0; i < this.nTallers; i++ ) {
            taller = this.getTaller(i).copia();
            if ( taller.getDia() == dia ) {
                acts.addTaller( taller );
            }
        }
        return acts;
    }

    /**
     * Metode que retorna una LlistaActivitats amb els Tallers que tenen places lliures
     *
     * @return LlistaActivitats   Conjunt de activitats
     */
    public LlistaActivitats getTallersAmbPlacesLliures () {
        LlistaActivitats acts = new LlistaActivitats();
        for ( int i = 0; i < this.nTallers; i++ ) {
            if ( this.tallers[i].hiHaPlaceslliures() ) {
                acts.addTaller( this.tallers[i].copia() );
            }
        }
        return acts;
    }

    /**
     * Metode que retorna una copia de la instancia indicada.
     * @param  index    Index del objecte a retornar
     * @return Entitat  objecte a retornar
     */
    public Visita getVisita ( int index ) {
        return this.visites[index].copia();
    }

    /**
     * Metode que retorna una copia de la instancia indicada.
     * @param  index    Index del objecte a retornar
     * @return Entitat  objecte a retornar
     */
    public Xerrada getXerrada ( int index ) {
        return this.xerrades[index].copia();
    }

    /**
    * Metode que retorna la quantitat d'elements
    * emmagatzemats a la llista.
    *
    * @return length  No Elements Guardats
    */
    public int getNElem () {
        return this.nTallers + this.nVisites + this.nXerrades;
    }

    /**
    * Metode que retorna la quantitat de tallers
    * emmagatzemats.
    *
    * @return length  No Tallers Guardats
    */
    public int getNTallers () {
        return this.nTallers;
    }

    /**
    * Metode que retorna la quantitat de visites
    * emmagatzemades.
    *
    * @return length  No Visites Guardades
    */
    public int getNVisites () {
        return this.nVisites;
    }

    /**
    * Metode que retorna la quantitat de Xerrades
    * emmagatzemades.
    *
    * @return length  No Xerrades Guardades
    */
    public int getNXerrades () {
        return this.nXerrades;
    }

    /**
    * Metode que retorna la quantitat de reserves
    * emmagatzemades.
    *
    * @return length  No reserves Guardades
    */
    public int getNReserves() {
        int i, nRes = 0;
        for ( i = 0; i < this.tallers.length; i++ ) {
            nRes += this.tallers[i].getNReservas();
        }
        return nRes;
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
     * Metode que retorna un valor booleà: si la llista esta buida o no.
     * true     en cas que sigui buida.
     * false    en cas que NO sigui buida.
     *
     * @return llistaPlena
     */
    public boolean llistaBuida ( ) {
        return this.getNElem() == 0;
    }

    /**
     * Metode que retorna un valor booleà: si la llista de tallers esta plena o no.
     * true     en cas que sigui plena.
     * false    en cas que NO sigui plena.
     *
     * @return llistaPlenaTallers
     */
    public boolean llistaTallersPlena ( ) {
        return this.nTallers >= this.tallers.length;
    }

    /**
     * Metode que retorna un valor booleà: si la llista de visites esta plena o no.
     * true     en cas que sigui plena.
     * false    en cas que NO sigui plena.
     *
     * @return llistaPlenaVisites
     */
    public boolean llistaVisitesPlena ( ) {
        return this.nVisites >= this.visites.length;
    }

    /**
     * Metode que retorna un valor booleà: si la llista de tallers esta plena o no.
     * true     en cas que sigui plena.
     * false    en cas que NO sigui plena.
     *
     * @return llistaPlenaXerrades
     */
    public boolean llistaXerradesPlena ( ) {
        return this.nXerrades >= this.xerrades.length;
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
            this.tallers[ this.nTallers ] = taller.copia();
        } else {
            // Si no hi ha lloc, reservo mes espai
            aux = new Taller[ this.nTallers + 2 ];
            copiaTallers( this.tallers, aux );
            // Añado el taller que he recibido
            aux[ this.nTallers ] = taller.copia();
            this.tallers = aux;
        }
        this.nTallers ++;
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
            this.visites[ this.nVisites ] = visita.copia();
        } else {
            // Si no hi ha lloc, reservo mes espai
            aux = new Visita[ this.nVisites + 2 ];
            copiaVisites( this.visites, aux );
            // Añado el taller que he recibido
            aux[ this.nVisites ] = visita.copia();
            this.visites = aux;
        }
        this.nVisites ++;
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
            this.xerrades[ this.nXerrades ] = xerrada.copia();
        } else {
            // Si no hi ha lloc, reservo mes espai
            aux = new Xerrada[ this.nXerrades + 2 ];
            copiaXerrades( this.xerrades, aux );
            // Añado el taller que he recibido
            aux[ this.nXerrades ] = xerrada.copia();
            this.xerrades = aux;
        }
        this.nXerrades ++;
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
        return this.xerrades() + this.visites() + this.tallers();
    }

    /**
     * Metode que retorna informacio del tots
     *  TALLERS emmaatzemats.
     *
     */
    public String tallers ( ) {
        String all = new String("");
        int i;
        for ( i = 0; i < this.nTallers; i++ ) {
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
        for ( i = 0; i < this.nVisites; i++ ) {
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
        for ( i = 0; i < this.nXerrades; i++ ) {
            all += this.xerrades[i].toString() + "\n";
        }
        return all;
    }

    /**
     * Metode que retorna informacio del tots
     *  TALLERS emmaatzemats i les reserves fetes en cadascu.
     *
     */
    public String reserves ( ) {
        String all = new String("");
        int i;
        for ( i = 0; i < this.nTallers; i++ ) {
            all += this.tallers[i].toString() + "\n";
            all += this.tallers[i].reserves();
        }
        return all;
    }
}
