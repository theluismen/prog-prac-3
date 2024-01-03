package bin.Aplicacio;

import bin.Activitats.*;
import bin.Entitats.Entitat;

public class UsaLlistaActivitats {
    public static void main ( String args[] ) {
        LlistaActivitats activitats = new LlistaActivitats();
        int i = 0;

        // Validar que addEntitat funciona bien
        while ( i < 35 ) {
            System.out.print(i + "  ");
            switch ( i % 3 ) {
                case 0:
                    activitats.addTaller( new Taller("Carreres", "Tarragona", 43400, 13, (new Entitat("Redbull", "123456789", "redbull@gmail.com")).getNom(), 10, 10, 10) );
                    break;
                case 1:
                    activitats.addXerrada( new Xerrada("Tecnologia", "Reus", 43500, 23, (new Entitat("SpaceX", "98765431", "spacex@gmail.com")).getNom(), "Elon Musk" ) );
                    break;
                case 2:
                    activitats.addVisita( new Visita("Fabricacio", "lleida", 43700, 18, (new Entitat("Mahle", "456123789", "mahle@gmail.com")).getNom(), true, true ) );
                    break;
            }
            i++;
        }
        System.out.print(activitats.tallers());
        System.out.print(activitats.visites());
        System.out.print(activitats.xerrades());
        System.out.print(activitats.activitats());

    }
}
