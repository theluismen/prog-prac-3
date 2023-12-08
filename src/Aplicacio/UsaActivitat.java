import Activitats.Activitat;
import Activitats.Taller;
import Entitats.Entitat;

// Clase que valida la clase LlistaEntitats
class UsaActivitat {
    public static void main ( String[] args ) {
        Activitat activitat = new Activitat (
            "Firma Llibres", "Tarragona", 43205, 25,
            new Entitat ("Apple", "660083024", "apple@apple.com")
        );
        System.out.println( activitat.toString() );

        Taller taller = new Taller (
            "Taller LEGO", "Reus", 43205, 25,
            new Entitat ("Apple", "660083024", "apple@apple.com"), 17, 30, 35
        );

        System.out.println( taller.toString() );

        Taller taller2 = taller.copia();

        System.out.println( taller.toString() );
    }
}
