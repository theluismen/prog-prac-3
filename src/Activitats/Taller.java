package bin.Activitats;

import bin.Excepcions.NoHiHanValoracionsExcepcio;
import bin.Entitats.Entitat;
import bin.Reserves.*;
import bin.Usuaris.Usuari;

// Clase Taller ( filla de Activitat )
public class Taller extends Activitat {
    /* ATRIBUTOS */
    private int hora;
    private int durada; // Mesura en minuts
    private LlistaReserves reserves;

    /* CONSTRUCTOR */
    public Taller ( String nom, String lloc, int cpostal, int dia, String nomEntitat, int hora, int durada, int capacitat ) {
        super( nom, lloc, cpostal, dia, nomEntitat );
        this.hora      = hora;
        this.durada    = durada;
        this.reserves  = new LlistaReserves( capacitat );
    }

    public Taller ( String codi, String nom, String lloc, int cpostal, int dia, String nomEntitat, int hora, int durada, int capacitat ) {
        super( codi, nom, lloc, cpostal, dia, nomEntitat );
        this.hora      = hora;
        this.durada    = durada;
        this.reserves  = new LlistaReserves( capacitat );
    }

    /* METODOS */
    /* METODOS: Setters */

    /* METODOS: Getters */
    /**
    * Getter de la hora del taller
    *
    * @return this.hora  Hora de realitzacio del Taller
    */
    public int getHora () {
        return this.hora;
    }

    /**
    * Getter de la durada del taller en minuts
    *
    * @return this.durada  Durada de realitzacio del Taller
    */
    public int getDurada () {
        return this.durada;
    }

    /**
    * Getter de la capacitat del taller
    *
    * @return this.capacitat  Capacitat del taller
    */
    public int getCapacitat () {
        return this.reserves.getMida();
    }

    /**
    * Getter de la capacitat del taller
    *
    * @return this.capacitat  Capacitat del taller
    */
    public Reserva getReserva ( int index ) {
        return this.reserves.getReserva(index);
    }

    /**
    * Getter de les reserves fetes i guardades.
    *
    * @return this.reserves.getNElem()
    */
    public int getNReservas () {
        return this.reserves.getNElem();
    }

    /**
    * Getter del nombre de places lliures.
    *
    * @return places Nombre de places lliures.
    */
    public int getNLliures () {
        return this.reserves.getMida() - this.reserves.getNElem();
    }

    /**
    * Getter del nombre de places lliures.
    *
    * @return places Nombre de places lliures.
    */
    public double getValoracioMitja () throws NoHiHanValoracionsExcepcio {
        int valoracions = 0, suma = 0, n;
        for ( int i = 0; i < this.reserves.getNElem(); i++ ) {
            n = this.reserves.getReserva(i).getValoracio();
            if ( n >= 0 ) {
                valoracions++;
                suma += n;
            }
        }
        if ( valoracions == 0 ) {
            throw new NoHiHanValoracionsExcepcio();
        } else {
            return suma / valoracions;
        }
    }

    /**
    * Getter del nombre de places lliures.
    *
    * @return places Nombre de places lliures.
    */
    public double exit () {
        System.out.println(this.getNReservas());
        System.out.println(this.getCapacitat());
        return 100 * (((double)this.getNReservas()) / ((double)this.getCapacitat()));
    }

    /* METODOS: Varios */

    /**
    * Metode que retorna el valor boolea corresponent a si hi han places lliures
    * al taller.
    *
    * @return placesLliures
    */
    public boolean hiHaPlacesLliures ( ) {
        return ! this.reserves.llistaPlena();
    }

    /**
    * Metode que retorna el valor boolea corresponent a si hi han reserves
    * fetes al taller.
    *
    * @return reservesfetes
    */
    public boolean hiHaReservesFetes ( ) {
        return this.reserves.getNElem() > 0;
    }

    /**
    * Metode que retorna el valor boolea corresponent a si hi ha un usari a la llista
    * de reserves amb el mateix nom que es que es pasa per parametre
    * fetes al taller.
    *
    * @return reservesfetes
    */
    public boolean hiHaUsuari ( String aliesUsuari ) {
        boolean trobat = false;
        for ( int i = 0; i < this.reserves.getNElem() && ! trobat; i++ ) {
            if ( this.reserves.getReserva(i).getAliesUsuari().equals(aliesUsuari) ) {
                trobat = true;
            }
        }
        return trobat;
    }

    /**
    * Metode realitza una reserva al taller actual.
    *
    * @param  usuari  Objecte Usuari al que se li fa la reserva
    * @return afegit  Si s'ha afegit o no
    */
    public boolean ferReserva ( Usuari usuari ) {
        return this.reserves.addReserva( usuari.getAlies(), super.getCodi() );
    }

    /**
    * Metode realitza una reserva al taller actual.
    *
    * @param  aliesUsuari  Alies del usuari al que se li fa la reserva
    * @return afegit  Si s'ha afegit o no
    */
    public boolean ferReserva ( String aliesUsuari ) {
        return this.reserves.addReserva( aliesUsuari, super.getCodi() );
    }

    /**
    * Metode realitza una reserva al taller actual.
    *
    * @param  aliesUsuari  Alies del usuari al que se li fa la reserva
    * @return afegit  Si s'ha afegit o no
    */
    public boolean ferValoracio ( String aliesUsuari, int valoracio ) {
        boolean fet = false; Reserva reserva;
        for ( int i = 0; i < this.reserves.getNElem() && ! fet; i++ ) {
            reserva = this.reserves.getReserva(i);
            if ( reserva.getAliesUsuari().equals(aliesUsuari) ) {
                this.reserves.setValoracioPerIndexUsuari(i, valoracio);
                fet = true;
            }
        }
        return fet;
    }

    /**
    * Metode que retorna una copia de l'instancia
    *
    * @return entitat  Copia de l'entitat
    */
    public String toString () {
        return "Taller  [ " + String.join(":", super.toString(), String.valueOf(this.hora)+"h", String.valueOf(this.durada)+"min", String.valueOf(this.getCapacitat())+"p") + " ]";
    }

    /**
    * Metode que retorna una copia de l'instancia
    *
    * @return entitat  Copia de l'entitat
    */
    public String toStringCSV () {
        return String.join(";", super.toStringCSV(), String.valueOf(this.hora), String.valueOf(this.durada), String.valueOf(this.getCapacitat()));
    }

    /**
    * Metode que retorna una copia de l'instancia
    *
    * @return entitat  Copia de l'entitat
    */
    public Taller copia () {
        Taller nou = new Taller ( this.getCodi(), this.getNom(), this.getLloc(), this.getCPostal(), this.getDia(), this.getNomEntitat(), this.hora, this.durada, this.getCapacitat());
        copiarReserves(this, nou);
        return nou;
    }

    /**
    * Metode que copia reserves d'un taller a l'altre.
    *
    * @param origen Taller d'origen
    * @param desti  Taller desti
    */
    private void copiarReserves ( Taller origen, Taller desti ) {
        int i;
        for ( i = 0; i < origen.getNReservas(); i++ ) {
            desti.ferReserva(origen.getReserva(i).getAliesUsuari());
        }
    }

    /**
     * Metode mostra informacio dels objectes emmaatzemats.
     *
     */
    public String reserves () {
        return this.reserves.reserves();
    }
    /**
     * Metode mostra informacio dels objectes per a guardar en fitxer.
     *
     */
    public String reservesCSV () {
        return this.reserves.reservesCSV();
    }
}
