package bin.Aplicacio;

import bin.Activitats.*;
import bin.Entitats.Entitat;

public class UsaLlistaActivitats {
    public static void main ( String args[] ) {
        LlistaActivitats activitats = new LlistaActivitats(30);
        int i = 0;
        boolean added = true;

        // Validar que addEntitat funciona bien
        while ( i < 35 ) {
            System.out.print(i + "  ");
            switch ( i % 3 ) {
                case 0:
                    added = activitats.addActivitat( new Activitat("Carreres", "Tarragona", 43400, 13, new Entitat("Redbull", "123456789", "redbull@gmail.com")) );
                    break;
                case 1:
                    added = activitats.addActivitat( new Xerrada("Elon Musk", "Tecnologia", "Reus", 43500, 23, new Entitat("SpaceX", "98765431", "spacex@gmail.com") ) );
                    break;
                case 2:
                    added = activitats.addActivitat( new Visita(true,true, "Fabricacio", "lleida", 43700, 18, new Entitat("Mahle", "456123789", "mahle@gmail.com") ) );
                    break;
            }
            if ( added ) {
                System.out.println( "Afegit ->" + activitats.getActivitat(i).toString() );
            } else {
                System.out.println( "No s'ha afegit. NO HI HA ESPAI" );
            }
            i++;
        }
    }
}
