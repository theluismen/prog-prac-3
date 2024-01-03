package bin.Activitats;

import bin.Entitats.Entitat;
import bin.Reserves.LlistaReserves;
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

    /* METODOS: Varios */
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
    * Metode que retorna una copia de l'instancia
    *
    * @return entitat  Copia de l'entitat
    */
    public String toString () {
        return "Taller  [ " + String.join(":", super.toString(), String.valueOf(this.hora)+"h", String.valueOf(this.durada)+"m", String.valueOf(this.getCapacitat())+"p") + " ]";
    }

    /**
    * Metode que retorna una copia de l'instancia
    *
    * @return entitat  Copia de l'entitat
    */
    public Taller copia () {
        return new Taller ( this.getNom(), this.getLloc(), this.getCPostal(), this.getDia(), this.getNomEntitat(), this.hora, this.durada, this.getCapacitat());
    }

    /**
     * Metode mostra informacio dels objectes emmaatzemats.
     *
     */
     public String reserves () {
         return this.reserves.reserves();
     }
}
