package bin.Activitats;


import bin.Entitats.Entitat;

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

    public Visita ( String nom, String lloc, int cpostal, int dia, String nomEntitat, boolean audioguia, boolean adaptada ){
        super(nom, lloc, cpostal, dia, nomEntitat);
        this.audioguia = audioguia;
        this.adaptada  = adaptada;
    }

    public Visita ( String codi, String nom, String lloc, int cpostal, int dia, String nomEntitat, boolean audioguia, boolean adaptada ){
        super( codi, nom, lloc, cpostal, dia, nomEntitat);
        this.audioguia = audioguia;
        this.adaptada  = adaptada;
    }

    /* METODES */
    /* METODES: setters i getters */
    /**Getter de l'atribut audiogia
     *
     * @return audiogia   es retorna true o false segons si es fa o no es fa audigia
     */
    public boolean esAudioguia() {
        return this.audioguia;
    }

    /**setter de l'atribut audiogia
     *
     * @param audioguia    boolea de l'estat d'audiogia
     */
    public void setAudioguia( boolean audioguia) {
        this.audioguia = audioguia;
    }

    /**getter de l'atribut adaptada
     *
     * @return adaptada     es retorna true o false segons si la visita esta adaptada o no
     */
    public boolean esAdaptada() {
        return this.adaptada;
    }

    /**setter de l'atribut adaptada
     *
     * @param adaptada     boolea de l'estat d'adaptada
     */
    public void setAdaptada( boolean adaptada) {
        this.adaptada = adaptada;
    }

    public Visita copia () {
        return new Visita ( this.getCodi(), this.getNom(), this.getLloc(), this.getCPostal(), this.getDia(), this.getNomEntitat(), this.audioguia, this.adaptada);
    }

    public String toString() {
        return "Visita  [ " + String.join(":", super.toString(), "autog=" + String.valueOf(this.audioguia), "adapt=" + String.valueOf(this.adaptada)) +"]";
    }

    public String toStringCSV() {
        return String.join(";", super.toStringCSV(), String.valueOf(this.audioguia), String.valueOf(this.adaptada));
    }
}
