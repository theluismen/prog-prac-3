import Entitats.LlistaEntitats;

// Clase que valida la clase LlistaEntitats
public class UsaLlistaEntitats {
    public static void main ( String[] args ) {
        LlistaEntitats llista = new LlistaEntitats( 10 );
        int i = 0;

        // Validar que addEntitat funciona bien
        while ( i < 15 ) {
            System.out.print(i + "  ");
            if ( llista.addEntitat( "Tusi","123123","tusi@tusi.com" ) ) {
                System.out.println( "Afegit ->" + llista.getEntitat(i).toString() );
            } else {
                System.out.println( "No s'ha afegit. NO HI HA ESPAI" );
            }
            i++;
        }

        llista.mostrarEntitats();
    }
}
