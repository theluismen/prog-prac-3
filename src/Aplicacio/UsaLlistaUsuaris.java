import Usuaris.LlistaUsuaris;

// Clase que valida la clase LlistaUsuaris
public class UsaLlistaUsuaris {
    public static void main ( String[] args ) {
        LlistaUsuaris llista = new LlistaUsuaris( 10 );
        int i = 0;

        // Validar que addUsuari funciona bien
        while ( i < 15 ) {
            System.out.print(i + "  ");
            if ( llista.addUsuari( "perrosanxe23", "perrosanxe@spain.com", 12345 ) ) {
                System.out.println( "Afegit ->" + llista.getUsuari(i).toString() );
            } else {
                System.out.println( "No s'ha afegit. NO HI HA ESPAI" );
            }
            i++;
        }

        System.out.println( llista.usuaris() );
    }
}
