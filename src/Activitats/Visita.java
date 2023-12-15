package Activitats;


import Entitats.Entitat;

public class Visita extends Activitat{
   /* ATRIBUTS */
    private boolean audioguia;
    private boolean adaptada;

    /* CONSTRUCTORS */

    /**
     * Constuctor de la clase Visita.
     * @param   audioguia       boolea per indicar si te audioguia o no.
     * @param   adaptada        boolea per indicar si esta adaptada o no.
     *
     * atributs de la clase pare activitat
     * @param   nom     Nom de l'activitat
     * @param   lloc    Lloc de l'activitat
     * @param   cpostal Codi Postal de l'activitat
     * @param   dia     Dia de l'activitat
     */

    public Visita ( boolean audioguia, boolean adaptada, String nom, String lloc, int cpostal, int dia, Entitat entitat ){

        super(nom, lloc, cpostal, dia, entitat);
        this.audioguia=audioguia;
        this.adaptada=adaptada;

    }


    /* METODES */
    /* METODES: setters i getters */


    /**getter de l'atribut audiogia
     *
     * @return audiogia   es retorna true o false segons si es fa o no es fa audigia
     */
    public boolean esAudioguia() {
        return audioguia;
    }
    /**setter de l'atribut audiogia
     *
     * @param audioguia    boolea de l'estat d'audiogia
     */
    public void setAudioguia(boolean audioguia) {
        this.audioguia = audioguia;
    }
    /**getter de l'atribut adaptada
     *
     * @return adaptada     es retorna true o false segons si la visita esta adaptada o no
     */
    public boolean esAdaptada() {
        return adaptada;
    }
    /**setter de l'atribut adaptada
     *
     * @param adaptada     boolea de l'estat d'adaptada
     */
    public void setAdaptada(boolean adaptada) {
        this.adaptada = adaptada;
    }


    @Override
    public String toString() {
        return "Visita [audioguia=" + audioguia + ", adaptada=" + adaptada + super.toString()+"]";
    }



}
