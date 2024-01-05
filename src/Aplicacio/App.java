package bin.Aplicacio;

/* IMPORTAR: Excepcions */
import java.io.*;
import bin.Excepcions.TallerNoTrobatExcepcio;
import java.util.InputMismatchException;
/* IMPORTAR: Clases Propies */
import bin.Entitats.LlistaEntitats;
import bin.Usuaris.LlistaUsuaris;
import bin.Reserves.LlistaReserves;
import bin.Activitats.*;
/* IMPORTAR: Clases Predefinides de Java */
import java.util.Scanner;

public class App {
    /* Variables globals */
    private static Scanner teclat = new Scanner(System.in);

    /**
     * Funcio que retorna la quantitat de linies del fitxer especificat
     *
     * @param   filename    Nom del fixer on hi han les dades
     */
    private static int liniesFitxer ( final String filename ) {
        BufferedReader br; String linia; int linies = 0;
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null ) {
                linies++;
                linia = br.readLine();
            }
            br.close();
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
        return linies;
    }

    /**
     * Funcio que llegeix la informacio del fitxer de Entitats
     *
     * @param   filename    Nom del fixer on hi han les dades
     * @param   llista      Llista que guardara les entitats
     */
    private static void carregarEntitats ( final String filename, LlistaEntitats entitats ) {
        BufferedReader br; String linia;
        String[] dades; String nom, telf, correu; // Informacio de la entitat llegida
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null && ! entitats.llistaPlena() ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                nom    = dades[0];
                telf   = dades[1];
                correu = dades[2];
                /* Afegir una nova entitat amb la informacio llegida */
                entitats.addEntitat(nom, telf, correu);
                /* Tornar a Llegir linia */
                linia = br.readLine();
            }
            br.close();
            System.out.println("    - Carregades " + entitats.getNElem() + " entitats.");
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }

    /**
     * Funcio que llegeix la informacio del fitxer de Usuaris
     *
     * @param   filename    Nom del fixer on hi han les dades
     * @param   llista      Llista que guardara els Usuaris
     */
    private static void carregarUsuaris  ( final String filename, LlistaUsuaris usuaris ) {
        BufferedReader br; String linia;
        String[] dades; String alies, correu; int cpostal; // Informacio del Usuari llegit
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null && ! usuaris.llistaPlena() ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                alies    = dades[0];
                correu   = dades[1];
                cpostal  = Integer.parseInt(dades[2]);
                /* Afegir una nou Usuari amb la informacio llegida */
                usuaris.addUsuari(alies, correu, cpostal);
                /* Tornar a Llegir linia */
                linia = br.readLine();
            }
            br.close();
            System.out.println("    - Carregats  " + usuaris.getNElem() + " usuaris.");
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }

    /**
     * Funcio que llegeix la informacio del fitxer de Activitats
     *
     * @param   filename    Nom del fixer on hi han les dades
     * @param   llista      Llista que guardara les activitats
     */
    private static void carregarActivitats ( final String filename, LlistaActivitats activitats ) {
        BufferedReader br; String linia;
        String[] dades;
        /* Atributos de la clase Actividad*/
        String  codi, nom, lloc, nomEntitat;
        int     cpostal, dia;

        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                codi       = dades[0];
                nom        = dades[1];
                lloc       = dades[2];
                cpostal    = Integer.parseInt(dades[3]);
                dia        = Integer.parseInt(dades[4]);
                nomEntitat = dades[5];
                /* Segun la cantidad de datos leidos es un taller, visita o xerrada */
                switch ( dades.length ) {
                    case 7:
                        /* Variables de Xerrada Adicionals */
                        String nomAutor = dades[6];
                        /* Afegir una nova activitat tipus Xerrada */
                        activitats.addXerrada( new Xerrada(codi, nom, lloc, cpostal, dia, nomEntitat, nomAutor) );
                        break;
                    case 8:
                        /* Variables de Visita Adicionals */
                        boolean audioguia = Boolean.parseBoolean(dades[6]);
                        boolean adaptada  = Boolean.parseBoolean(dades[7]);
                        /* Afegir una nova activitat tipus Visita */
                        activitats.addVisita( new Visita(codi, nom, lloc, cpostal, dia, nomEntitat, audioguia, adaptada ) );
                        break;
                    case 9:
                        /* Variables de Taller Adicionals */
                        int hora      = Integer.parseInt(dades[6]);
                        int durada    = Integer.parseInt(dades[7]);
                        int capacitat = Integer.parseInt(dades[8]);
                        /* Afegir una nova activitat tipus Taller */
                        activitats.addTaller( new Taller(codi, nom, lloc, cpostal, dia, nomEntitat, hora, durada, capacitat ) );
                        break;
                }
                /* Tornar a Llegir linia */
                linia = br.readLine();
            }
            br.close();
            System.out.println("    - Carregades " + activitats.getNElem() + " activitats.");
            System.out.println("      ->         " + activitats.getNXerrades() + "  xerrades.");
            System.out.println("      ->         " + activitats.getNVisites() + "  visites.");
            System.out.println("      ->         " + activitats.getNTallers() + "  tallers.");
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }

    /**
    * Funcio que llegeix la informacio del fitxer de Reserves
    *
    * @param   filename    Nom del fixer on hi han les dades
    * @param   llista      Llista que guardara les reserves
    */
    private static void carregarReserves  ( final String filename, LlistaActivitats activitats ) {
        BufferedReader br; String linia;
        String[] dades; String aliesUsuari, coditaller;  // Informacio del Usuari llegit
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                //codi    = Integer.parseInt(dades[0]);
                aliesUsuari = dades[0];
                coditaller  = dades[1];
                /* Afegir una nova Reserva amb la informacio llegida */
                try {
                    activitats.getTallerPerCodi(coditaller).ferReserva( aliesUsuari );
                } catch ( TallerNoTrobatExcepcio ex ) {
                    System.out.println(ex.toString());
                }
                /* Tornar a Llegir linia */
                linia = br.readLine();
            }
            br.close();
            System.out.println("    - Carregades " + activitats.getNReserves() + " reserves.");
        } catch ( FileNotFoundException e ) {
            System.out.println( e.getMessage() );
        } catch ( IOException e ) {
            System.out.println( e.getMessage() );
        }
    }

    /**
    * Funcio que llegeix TOTA la informacio dels fitxer de dades
    *
    * @param   entitats    Objecte tipus LlistaEntitats
    * @param   usuaris     Objecte tipus LlistaUsuaris
    * @param   activitats  Objecte tipus LlistaActivitats
    */
    private static void carregarInfoFitxers ( LlistaEntitats entitats, LlistaUsuaris usuaris, LlistaActivitats activitats ) {
        System.out.println("[+] - Carregant informacio de fitxers...");
        carregarEntitats(ArxiusApp.ARXIU_ENTITATS, entitats);
        carregarUsuaris(ArxiusApp.ARXIU_USUARIS, usuaris);
        carregarActivitats(ArxiusApp.ARXIU_ACTIVITATS, activitats);
        carregarReserves(ArxiusApp.ARXIU_RESERVES, activitats);
    }

    private static void mostrarMenuOpcions() {
        System.out.println("[+] - MENU D'OPCIONS");
        System.out.println("    1 -> Mostrar les dades de qualsevol llista que tingueu definida");
        System.out.println("    2 -> Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta.");
        System.out.println("    3 -> Obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat.");
        // System.out.println("4 -> Obtenir i mostrar la llista dels tallers que tenen places disponibles. ");
        // System.out.println("5 -> Afegir una nova activitat");
        // System.out.println("6 -> Registrar la petició d’un usuari per reservar un taller.");
        // System.out.println("7 -> Mostrar els usuaris que s’han apuntat a un taller.");
        // System.out.println("8 -> Calcular l’usuari que s’ha apuntat a més tallers.");
        // System.out.println("9 -> Registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop s’ha fet.");
        // System.out.println("10 -> Calcular la nota mitja que ha rebut un taller");
        // System.out.println("11 -> Quin és el taller que ha tingut més èxit? Calcularem l’èxit segons el taller que ha tingut una ocupació més alta en proporció a les places que oferia");
        // System.out.println("12 -> Obtenir i mostrar les dades de la llista de visites ofertes per una entitat");
        // System.out.println("13 -> Mostrar les dades de les xerrades que farà una persona concreta.");
        // System.out.println("14 -> Donar de baixa un taller sempre que no hi hagi usuaris apuntats");
        // System.out.println("15 -> Sortir de l’aplicació");
    }

    /*
    * Funcio que retorna un nombre enter; la opcio que l'usuari
    * escolleix.
    * @return opcio Opcio del menu
    */
    private static int demanarOpcio() {
		int opcio = -1;
		do {
			try {
                System.out.print("[!] - Opcio: ");
				opcio = teclat.nextInt();
			} catch ( InputMismatchException  ex ) {
				teclat.nextLine();
                System.out.println("[X] - Escriu un valor numeric correcte del 1 al 15");
			}
		} while ( opcio < 1 || opcio > 15 );
        return opcio;
	}

    /*
    * Funcio que retorna un nombre enter; el dia en que es realitza
    * una activitat.
    * @return opcio Opcio del menu
    */
    private static int demanarDiaActivitat() {
		int dia = -1;
		do {
			try {
                System.out.print("Dia: ");
				dia = teclat.nextInt();
			} catch ( InputMismatchException  ex ) {
				teclat.nextLine();
                System.out.println(" Escriu un valor numeric correcte del 10 al 19");
			}
		} while ( dia < 10 || dia > 19 );
        return dia;
	}

    private static void afegirNovaActivitat ( LlistaActivitats activitats ) {
        String  nom, lloc, nomEntitat;
        int     cpostal, dia;

    }

    /*
    * Metode que retorna un valor boolea ( audioguia ) segons la entrada del
    * usuari. Es valida la entrada.
    * @return audioguia
    */
    private static boolean demanarAudioguia () {
        String aux;

        do {
            System.out.print("Vols que la visita tingui audioguia?[s/n]: ");
            aux = teclat.next();
        } while ( ! aux.equalsIgnoreCase("s") && ! aux.equalsIgnoreCase("n"));

        return ( aux.equalsIgnoreCase("s") ) ? true : false;
    }

    /*
    * Metode que retorna un valor boolea ( adaptada ) segons la entrada del
    * usuari. Es valida la entrada.
    * @return adaptada
    */
    private static boolean demanarAdaptada () {
        String aux;

        do {
            System.out.print("Vols que la visita estigui adaptada?[s/n]: ");
            aux = teclat.next();
        } while ( ! aux.equalsIgnoreCase("s") && ! aux.equalsIgnoreCase("n"));

        return ( aux.equalsIgnoreCase("s") ) ? true : false;
    }

    public static void main ( String[] args ) {
        /* LLISTES, VARIABLES, CONSTANTS */
        LlistaEntitats   entitats   = new LlistaEntitats(liniesFitxer(ArxiusApp.ARXIU_ENTITATS));
        LlistaUsuaris    usuaris    = new LlistaUsuaris(liniesFitxer(ArxiusApp.ARXIU_USUARIS));
        LlistaActivitats activitats = new LlistaActivitats();
        boolean sortir = false;
        int opcio;
        /* Variables d'ajut */
        LlistaActivitats acts; String nomEntitat, aux;
        boolean audioguia, adaptada;
        int dia;

        /* Carregar tota la informació del fitxer a les llistes */
        carregarInfoFitxers(entitats, usuaris, activitats);

        /* INICI DEL PROGRAMA */
        System.out.println("[+] - Comencant programa...");
        /* Bucle principal del Programa */
        do {
            mostrarMenuOpcions();
            opcio = demanarOpcio();
            switch ( opcio ) {
                case 1:
                    System.out.println("ENTITATS\n" + entitats.entitats());
                    System.out.println("USUARIS\n" + usuaris.usuaris());
                    System.out.println("ACTIVITATS\nXERRADES\n" + activitats.xerrades() + "VISITES\n" + activitats.visites() + "TALLERS (amb les seves reserves)\n" + activitats.reserves());
                    break;
                case 2:
                    System.out.print("Nom de l'entitat: ");
                    nomEntitat = teclat.next();
                    acts       = activitats.getActivitatsPerNomEntitat( nomEntitat );
                    if ( acts.llistaBuida() ) {
                        System.out.println("No hi han activitats fetes per la entitat: " + nomEntitat);
                    } else {
                        System.out.println("ACTIVITATS donades per " + nomEntitat + ":\n" + acts.activitats());
                    }
                    break;
                case 3:
                    dia  = demanarDiaActivitat();
                    acts = activitats.getActivitatsPerDia( dia );
                    if ( acts.llistaBuida() ) {
                        System.out.println("No hi han activitats fetes el dia: " + dia);
                    } else {
                        System.out.println("ACTIVITATS fetes el dia " + dia + ":\n" + acts.activitats());
                    }
                    break;
                case 4:
                    acts = activitats.getTallersAmbPlacesLliures();
                    if ( acts.llistaBuida() ) {
                        System.out.println("No hi han tallers amb places lliures");
                    } else {
                        System.out.println("TALLERS amb places lliures:\n" + acts.tallers());
                    }
                    break;
                case 5:
                    afegirNovaActivitat( activitats );
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:
                    System.out.print("Nom de l'entitat: ");
                    nomEntitat = teclat.next();
                    audioguia  = demanarAudioguia();
                    adaptada   = demanarAdaptada();
                    acts       = activitats.getVisitesSegonsEntitatIBools(nomEntitat, audioguia, adaptada);
                    if ( acts.llistaBuida() ) {
                        System.out.println("No hi ha visites fetes per "+ nomEntitat + " o no hi ha visites que complexin les condicions." );
                    } else {
                        System.out.println("VISITES donades per " + nomEntitat + ":\n" + acts.visites());
                    }
                    break;
                case 13:

                    break;
                case 14:

                    break;
                case 15:
                    System.out.println("[-] - Sortint del programa...");
                    sortir = true;
                    break;
            }
        } while ( ! sortir );
    }
}
