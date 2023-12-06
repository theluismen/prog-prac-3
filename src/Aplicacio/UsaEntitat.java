import Entitats.Entitat;

// Clase que valida la clase Entitat
public class UsaEntitat {
    public static void main ( String[] args ) {
        Entitat entitat = new Entitat ("Apple", "660083024", "apple@apple.com");

        // Validar Constructor
        System.out.println( entitat.toString() );
        System.out.println();

        // Validar Setters
        entitat.setNom("Fanoso SA");
        entitat.setTelf("12341212");
        entitat.setCorreu("fanoso@fanoso.com");
        System.out.println( entitat.toString() );
        System.out.println();

        // Validar Getters
        System.out.println( "Nom: " + entitat.getNom() );
        System.out.println( "Telf: " + entitat.getTelf() );
        System.out.println( "Correu: " + entitat.getCorreu() );
    }
}
