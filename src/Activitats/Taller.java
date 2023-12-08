package Activitats;

import Entitats.Entitat;

// Clase Taller ( filla de Activitat )
public class Taller extends Activitat {
    /* ATRIBUTOS */
    private int hora;
    private int durada; // Mesura en hores
    // private LlistaReserves reserves;

    /* CONSTRUCTOR */
    public Taller ( String nom, String lloc, int cpostal, int dia, Entitat entitat, int hora, int durada, int capacitat ) {
        super( nom, lloc, cpostal, dia, entitat );
        this.hora       = hora;
        this.durada     = durada;
        // this.reserves   = new LlistaReserves( capacitat );
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
    * Getter de la durada del taller
    *
    * @return this.durada  Durada de realitzacio del Taller
    */
    public int getDurada () {
        return this.durada;
    }

    /**
    * Getter de la capacitat del taller
    *
    * @return this.reserves.length  Capacitat del taller
    */
    // public int getCapacitat () {
    //     return this.reserves.length;
    // }

    /**
    * Getter de les reserves fetes i guardades.
    *
    * @return this.reserves.getNElem()
    */
    // public int getNReservas () {
    //     return this.reserves.getNElem();
    // }

    /**
    * Getter del nombre de places lliures.
    *
    * @return places Nombre de places lliures.
    */
    // public int getNLliures () {
    //     return this.capacitat - this.reserves.getNElem();
    // }
}
