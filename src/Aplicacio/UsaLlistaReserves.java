import Reserves.LlistaReserves;

// Clase que valida la clase LlistaUsuaris
public class UsaLlistaReserves {
    public static void main ( String[] args ) {
        LlistaReserves llista = new LlistaReserves( 10 );
        int i = 0;

        // Validar que addReserva funciona bien
        while ( i < 15 ) {
            System.out.print(i + "  ");
            if ( llista.addReserva( "perrosanxe", "TAL" + String.valueOf(100 + i) ) ) {
                System.out.println( "Afegit ->" + llista.getReserva(i).toString() );
            } else {
                System.out.println( "No s'ha afegit. NO HI HA ESPAI" );
            }
            i++;
        }

        llista.mostrar();
    }
}
