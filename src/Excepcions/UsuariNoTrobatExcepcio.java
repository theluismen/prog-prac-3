package bin.Excepcions;

public class UsuariNoTrobatExcepcio extends Exception {
    /* ATRIBUTOS */
    private String nomUsuari;
    /* CONSTRUCTOR */
    public UsuariNoTrobatExcepcio ( String nomUsuari ) {
        this.nomUsuari = nomUsuari;
    }
    /* METODOS */
    public String toString() {
        return "No s'ha trobat el usuari amb nom: " + this.nomUsuari;
    }
}
