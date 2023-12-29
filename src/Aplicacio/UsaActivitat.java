package bin.Aplicacio;

import bin.Activitats.Activitat;
import bin.Activitats.Taller;
import bin.Entitats.Entitat;
import bin.Usuaris.Usuari;
import bin.Activitats.Visita;
import bin.Activitats.Xerrada;

// Clase que valida la clase LlistaEntitats
class UsaActivitat {
    public static void main ( String[] args ) {
        Activitat activitat = new Activitat (
            "Taller LEGO", "Tarragona", 43205, 25,
            (new Entitat ("Apple", "660083024", "apple@apple.com")).getNom()
        );
        System.out.println( activitat.toString() );

        Taller taller = new Taller (
            "Taller LEGO", "Reus", 43205, 25,
            (new Entitat ("Apple", "660083024", "apple@apple.com")).getNom(), 17, 30, 35
        );

        System.out.println( taller.reserves() );
        taller.ferReserva( new Usuari ("theluismen","fana@gmail.com",12345) );
        taller.ferReserva( new Usuari ("sementerio","sida@gmail.com",12345) );
        taller.ferReserva( new Usuari ("manolo7223","mari@gmail.com",12345) );
        System.out.println( taller.reserves() );

        System.out.println( taller.toString() );

        Taller taller2 = taller.copia();


        System.out.println( taller.toString() );

        Activitat a = new Activitat("Carreres", "Tarragona", 43400, 13, (new Entitat("Redbull", "123456789", "redbull@gmail.com")).getNom());
        Xerrada x = new Xerrada("Tecnologia", "Reus", 43500, 23, (new Entitat("SpaceX", "98765431", "spacex@gmail.com")).getNom(), "Elon Musk");
        Visita v = new Visita("Fabricacio", "lleida", 43700, 18, (new Entitat("Mahle", "456123789", "mahle@gmail.com")).getNom(), true,true );

        System.out.println(a.toString());
        System.out.println(x.toString());
        System.out.println(v.toString());


        // Validar Setters
        a.setCPostal(66666);
        x.setNomAutor("Melchor");
        v.setAudioguia(false);
        System.out.println(a.toString());
        System.out.println(x);
        System.out.println(v);

        // Validar Getters
        System.out.println("Nom: "+ a.getNom());
        System.out.println("Nom: "+ x.getNom());
        System.out.println("Nom: "+ v.getNom());

        System.out.println("Codi: "+ x.getCodi());
        System.out.println("Codi: "+ v.getCodi());
        System.out.println("Codi: "+ a.getCodi());
    }

}
