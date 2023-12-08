import Activitats.Activitat;
import Entitats.Entitat;

// Clase que valida la clase LlistaEntitats
class UsaActivitat {
    public static void main ( String[] args ) {
        Activitat activitat = new Activitat (
            "Firma Llibres", "Tarragona", 43205, 25,
            new Entitat ("Apple", "660083024", "apple@apple.com")
        );

        Activitat activitat2 = new Activitat (
            "Firma Llibres", "Murcia", 43205, 25,
            new Entitat ("Apple", "660083024", "apple@apple.com")
        );

        System.out.println( activitat.toString() );
        System.out.println( activitat2.toString() );
    }
}
