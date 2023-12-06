package Activitats;

import Entitats.Entitat;

public class Activitat {
    /* ATRIBUTOS */
    private String  codi;
    private String  nom;
    private String  lloc;
    private int     cpostal;
    private int     dia;
    private Entitat entitat;

    /* ATRIBUTOS: Estaticos */
    private static int codiIndex = 100;

    /* CONSTRUCTOR */
    /**
     * Constuctor de la clase Activitat.
     * @param   nom     Nom de l'activitat
     * @param   lloc    Lloc de l'activitat
     * @param   cpostal Codi Postal de l'activitat
     * @param   dia     Dia de l'activitat
     */
    public Activitat ( String nom, String lloc, int cpostal, int dia ) {
        this.codi    = crearCodi( nom );
        this.nom     = nom;
        this.lloc    = lloc;
        this.cpostal = cpostal;
        this.dia     = dia;
    }

    /* METODOS */
    /* METODOS: Varios */
    /**
     * Metode que retorna un codi identificatiu per a
     * l'activitat i a més incrementa l'atribut estatic que
     * forma part del codi.
     *
     * @param   nom     nom de l'activitat
     * @return  codi    El codi de la activitat
     */
     private String crearCodi ( String nom ) {
         String codi = nom.substring(0, 3) + Integer.toString( codiIndex );
         codiIndex ++;
         return codi;
     }

     /**
     * Metode que retorna un String que conte informació
     * de l'objecte.
     *
     * @return  String  String que conte informació
     */
     public String toString ( ) {
         return this.codi;
     }
}
