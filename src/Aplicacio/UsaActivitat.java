import Activitats.Activitat;
import Activitats.Taller;
import Entitats.Entitat;
import Usuaris.Usuari;

// Clase que valida la clase LlistaEntitats
class UsaActivitat {
    public static void main ( String[] args ) {
        Activitat activitat = new Activitat (
            "Taller LEGO", "Tarragona", 43205, 25,
            new Entitat ("Apple", "660083024", "apple@apple.com")
        );
        System.out.println( activitat.toString() );

        Taller taller = new Taller (
            "Taller LEGO", "Reus", 43205, 25,
            new Entitat ("Apple", "660083024", "apple@apple.com"), 17, 30, 35
        );
        
        taller.mostrarReserves();
        taller.ferReserva( new Usuari ("theluismen","fana@gmail.com",12345) );
        taller.ferReserva( new Usuari ("sementerio","sida@gmail.com",12345) );
        taller.ferReserva( new Usuari ("manolo7223","mari@gmail.com",12345) );
        taller.mostrarReserves();
        System.out.println( );

        System.out.println( taller.toString() );

        Taller taller2 = taller.copia();

        System.out.println( taller.toString() );
    }
}
