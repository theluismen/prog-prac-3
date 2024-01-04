package bin.Excepcions;

public class TallerNoTrobatExcepcio extends Exception {
    /* ATRIBUTOS */
    private String codiTaller;
    /* CONSTRUCTOR */
    public TallerNoTrobatExcepcio ( String codiTaller ) {
        this.codiTaller = codiTaller;
    }
    /* METODOS */
    public String toString() {
        return "No s'ha trobat el taller " + this.codiTaller;
    }
}
