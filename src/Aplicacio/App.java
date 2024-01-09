package bin.Aplicacio;

/* IMPORTAR: Excepcions */
import java.io.*;
import bin.Excepcions.*;
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
     * Funcio que guarda les Activitats al fitxer
     *
     * @param   filename    Nom del fixer on hi han les dades
     * @param   llista      Llista que guardara les activitats
     */
    private static void desarActivitats ( final String filename, LlistaActivitats activitats ) {
        BufferedWriter br;
        int i;
        try {
            br = new BufferedWriter( new FileWriter( filename ) );
            /* Guardar Xerrades */
            i = 0;
            while ( i < activitats.getNXerrades() ) {
                br.write(activitats.getXerrada(i).toStringCSV());
                br.newLine();
                i++;
            }
            /* Guardar Visites */
            i = 0;
            while ( i < activitats.getNVisites() ) {
                br.write(activitats.getVisita(i).toStringCSV());
                br.newLine();
                i++;
            }
            /* Guardar Xerrades */
            i = 0;
            while ( i < activitats.getNTallers() ) {
                br.write(activitats.getTaller(i).toStringCSV());
                br.newLine();
                i++;
            }
            br.close();
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
    private static void carregarReserves  ( final String filename, LlistaActivitats activitats, LlistaUsuaris usuaris ) {
        BufferedReader br; String linia; int valoracio;
        String[] dades; String aliesUsuari, coditaller;  // Informacio del Usuari llegit
        try {
            br = new BufferedReader( new FileReader( filename ) );
            linia = br.readLine();   // Llegir linia
            while ( linia != null ) {
                dades = linia.split(ArxiusApp.ARXIU_DELIMITER);
                /* Guardar informacio en variables ( comoditat ) */
                aliesUsuari = dades[0];
                coditaller  = dades[1];
                valoracio   = -1;
                if ( dades.length == 3 ) {
                    valoracio = Integer.parseInt(dades[2]);
                }
                /* Afegir una nova Reserva amb la informacio llegida */
                try {
                    activitats.getTallerPerCodi(coditaller).ferReserva( aliesUsuari, valoracio );
                    usuaris.getUsuariPerNom(aliesUsuari).incTallers();
                } catch ( TallerNoTrobatExcepcio ex ) {
                    System.out.println(ex.toString());
                } catch ( UsuariNoTrobatExcepcio ex ) {
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
     * Funcio que guarda les Reserves al fitxer
     *
     * @param   filename    Nom del fixer on hi han les dades
     * @param   llista      Llista que guardara les activitats
     */
    private static void desarReserves ( final String filename, LlistaActivitats activitats ) {
        BufferedWriter br;
        int i;
        try {
            br = new BufferedWriter( new FileWriter( filename ) );
            i = 0;
            while ( i < activitats.getNTallers() ) {
                br.write(activitats.getTaller(i).reservesCSV());
                i++;
            }
            br.close();
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
        carregarReserves(ArxiusApp.ARXIU_RESERVES, activitats, usuaris);
    }

    /**
    * Funcio que guarda la informacio de les llistes dinamiques als fitxers
    * corresponents.
    *
    * @param   activitats  Objecte tipus LlistaActivitats
    */
    private static void desarInfoFitxers( LlistaActivitats activitats ) {
        desarActivitats(ArxiusApp.ARXIU_ACTIVITATS, activitats);
        desarReserves(ArxiusApp.ARXIU_RESERVES, activitats);
    }

    /*
    * Mostra el menu d'opcions
    */
    private static void mostrarMenuOpcions() {
        System.out.println("[+] - MENU D'OPCIONS");
        System.out.println("    1  -> Mostrar TOTES les dades");
        System.out.println("    2  -> Mostrar les activitats que ofereix una entitat concreta");
        System.out.println("    3  -> Mostrar les activitats que es fan un dia concret");
        System.out.println("    4  -> Mostrar els tallers amb places lliures");
        System.out.println("    5  -> Afegir una nova activitat");
        System.out.println("    6  -> Registrar un usuari a taller");
        System.out.println("    7  -> Mostrar usuaris apuntats a un taller");
        System.out.println("    8  -> Calcular l’usuari que s’ha apuntat a més tallers");
        System.out.println("    9  -> Registrar valoracio d'un usuari a un taller.");
        System.out.println("   10  -> Calcular la nota mitja que ha rebut un taller");
        System.out.println("   11  -> Quin és el taller que ha tingut més èxit?");
        System.out.println("   12  -> Mostrar les dades de les visites ofertes per una entitat");
        System.out.println("   13  -> Mostrar les dades de les xerrades que farà una persona concreta.");
        System.out.println("   14  -> Donar de baixa un taller ( si no hi ha usuaris apuntats )");
        System.out.println("   15  -> Sortir de l'aplicacio");
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
    * @return dia dia
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

    /*
    * Funcio que retorna un nombre enter; la hora en que es realitza
    * una Taller.
    * @return hora hora
    */
    private static int demanarHora() {
		int hora = -1;
		do {
			try {
                System.out.print("Hora: ");
				hora = teclat.nextInt();
			} catch ( InputMismatchException  ex ) {
				teclat.nextLine();
                System.out.println(" Escriu un valor numeric correcte del 0 al 23");
			}
		} while ( hora < 0 || hora > 23 );
        return hora;
	}

    /*
    * Funcio que retorna un nombre enter; la durada d'un Taller.
    * @return durada durada
    */
    private static int demanarDurada() {
		int durada = -1;
		do {
			try {
                System.out.print("Durada[min]: ");
				durada = teclat.nextInt();
			} catch ( InputMismatchException  ex ) {
				teclat.nextLine();
                System.out.println(" Escriu un valor numeric correcte");
			}
		} while ( durada <= 0 );
        return durada;
	}

    /*
    * Funcio que retorna un nombre enter; la capacitat d'un Taller.
    * @return capacitat capacitat
    */
    private static int demanarCapacitat() {
		int capacitat = -1;
		do {
			try {
                System.out.print("Capacitat: ");
				capacitat = teclat.nextInt();
			} catch ( InputMismatchException  ex ) {
				teclat.nextLine();
                System.out.println(" Escriu un valor numeric correcte");
			}
		} while ( capacitat <= 0 );
        return capacitat;
	}

    /*
    * Funcio que retorna un String; el nom de una entitat.
    * @return nomEntitat nomEntitat
    */
    private static String demanarNomEntitat() {
		String nomEntitat;
		do {
            System.out.print("Nom Entitat: ");
			nomEntitat = teclat.next();
		} while ( nomEntitat.length() < 3 );
        return nomEntitat;
	}

    /*
    * Funcio que retorna un nombre enter; el fckin codigo postal.
    * @return cpostal cpostal
    */
    private static int demanarCPostal() {
        int cpostal = 0;
        do {
            try {
                System.out.print("Codi Postal: ");
                cpostal = teclat.nextInt();
            } catch ( InputMismatchException ex ) {
                teclat.nextLine();
                System.out.println(" Escriu un valor numeric correcte");
            }
        } while ( cpostal < 43000 || cpostal > 43999 );
        return cpostal;
    }

    /*
    * Funcio que retorna un nombre enter; el fckin valoracio del taller.
    * @return taller taller
    */
    private static int demanarValoracio() {
        int val = 0;
        do {
            try {
                System.out.print("Valoracio[0..10]: ");
                val = teclat.nextInt();
            } catch ( InputMismatchException ex ) {
                teclat.nextLine();
                System.out.println(" Escriu un valor numeric correcte del 0 al 10");
            }
        } while ( val < 1 || val > 10 );
        return val;
    }

    /*
    * Funcio que retorna un nombre enter; el tipus de la activitat.
    * @return tipus tipus
    */
    private static int demanarTipusActivitat() {
        int tipus = 0;
        do {
            try {
                System.out.print("Tipus: ");
                tipus = teclat.nextInt();
            } catch ( InputMismatchException ex ) {
                teclat.nextLine();
                System.out.println(" Escriu un valor numeric correcte del 1 al 3");
            }
        } while ( tipus < 1 || tipus > 3 );
        return tipus;
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

    /*
    * Metode que retorna un valor boolea ( adaptada ) segons si es vol guardar la informacio o no.
    * @return siono siono
    */
    private static boolean demanarGuardarInfor () {
        String aux;

        do {
            System.out.print("Vols guardar la info?[s/n]: ");
            aux = teclat.next();
        } while ( ! aux.equalsIgnoreCase("s") && ! aux.equalsIgnoreCase("n"));

        return ( aux.equalsIgnoreCase("s") ) ? true : false;
    }

    /*
    * Funcio que afegeix una activitat.
    * @param activitats La llista on afegir la activitat
    */
    private static void afegirNovaActivitat ( LlistaActivitats activitats ) {
        /* Dades especifiques de Activitat */
        String  nom, lloc, nomEntitat;
        int     cpostal = 0, dia;
        int     tipus   = 0;

        System.out.println("Afegint activitat. Demanant dades basiques...");
        /* Demanar Nom */
        System.out.print("Nom: ");
        nom  = teclat.nextLine();
        /* Demanar LLoc */
        System.out.print("Lloc: ");
        lloc = teclat.next();
        /* Demanar Codi Postal */
        cpostal = demanarCPostal();
        /* Demanar Dia */
        dia     = demanarDiaActivitat();
        /* Demanar Nom Entitat */
        nomEntitat = demanarNomEntitat();
        /* Demanar Tipus Activitat */
        System.out.println("Selecciona tipus d'activitat:");
        System.out.println("   1 - Xerrada");
        System.out.println("   2 - Visita");
        System.out.println("   3 - Taller");
        /* Validar entrada Tipus Activitat */
        tipus = demanarTipusActivitat();
        teclat.nextLine();
        /*  */
        switch ( tipus ) {
            case 1:     // Xerrada
                System.out.print("Nom Autor: ");
                String nomAutor = teclat.nextLine();
                activitats.addXerrada( new Xerrada( nom, lloc, cpostal, dia, nomEntitat, nomAutor) );
                break;
            case 2:     // Visita
                boolean audioguia = demanarAudioguia();
                boolean adaptada  = demanarAdaptada();
                activitats.addVisita( new Visita( nom, lloc, cpostal, dia, nomEntitat, audioguia, adaptada ) );
                break;
            case 3:     // Taller
                int hora      = demanarHora();
                int durada    = demanarDurada();
                int capacitat = demanarCapacitat();
                activitats.addTaller( new Taller( nom, lloc, cpostal, dia, nomEntitat, hora, durada, capacitat ) );
                break;
        }
    }

    public static void main ( String[] args ) {
        /* LLISTES, VARIABLES, CONSTANTS */
        LlistaEntitats   entitats   = new LlistaEntitats(liniesFitxer(ArxiusApp.ARXIU_ENTITATS));
        LlistaUsuaris    usuaris    = new LlistaUsuaris(liniesFitxer(ArxiusApp.ARXIU_USUARIS));
        LlistaActivitats activitats = new LlistaActivitats();
        boolean sortir = false;
        int opcio;
        /* Variables d'ajut */
        LlistaActivitats acts; String nomEntitat, nomAutor, codiTaller, aliesUsuari;
        boolean audioguia, adaptada, guardar;
        Taller tallerAux;
        int dia, valoracio;

        /* Carregar tota la informació del fitxer a les llistes */
        carregarInfoFitxers(entitats, usuaris, activitats);

        /* INICI DEL PROGRAMA */
        System.out.println("[+] - Comencant programa...");
        /* Bucle principal del Programa */
        do {
            mostrarMenuOpcions();
            opcio = demanarOpcio();
            teclat.nextLine();
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
                    System.out.print("Codi Taller: ");
                    codiTaller = teclat.next();
                    try {
                        tallerAux  = activitats.getTallerPerCodi(codiTaller); // No passa res per treballar sobre la referencia, enlloc d'una copia
                        if ( tallerAux.hiHaPlacesLliures() ) {
                            System.out.print("Nom Usuari: ");
                            aliesUsuari = teclat.next();
                            try {
                                if ( ! tallerAux.hiHaUsuari( aliesUsuari ) ) {
                                    if ( tallerAux.ferReserva( usuaris.getUsuariPerNom(aliesUsuari).getAlies() )) {
                                        System.out.println("Usuari: " + aliesUsuari + ", afegit al taller " + codiTaller.toUpperCase());
                                        usuaris.getUsuariPerNom(aliesUsuari).incTallers();
                                    } else {
                                        System.out.println("No s'ha pogut afegir l'usuri al taller");
                                    }
                                } else {
                                    System.out.println("L'usuari ja es apuntat al taller");
                                }
                            } catch ( UsuariNoTrobatExcepcio ex ) {
                                System.out.println(ex.toString() );
                            }
                        } else {
                            System.out.println("No hi ha places lliures per al taller " + codiTaller.toUpperCase() );
                        }
                    } catch ( TallerNoTrobatExcepcio ex ) {
                        System.out.println(ex.toString() );
                    }
                    break;
                case 7:
                    System.out.print("Codi del taller: ");
                    codiTaller = teclat.next();
                    try {
                        tallerAux  = activitats.getTallerPerCodi(codiTaller); // No passa res per treballar sobre la referencia, enlloc d'una copia
                        if ( ! tallerAux.hiHaReservesFetes() ) {
                            System.out.println("No hi ha reserves fetes al taller " + codiTaller );
                        } else {
                            System.out.println("Reserves fetes per al taller " + codiTaller.toUpperCase() + ":\n" + tallerAux.reserves());
                        }
                    } catch ( TallerNoTrobatExcepcio ex ) {
                        System.out.println(ex.toString() );
                    }
                    break;
                case 8:
                    System.out.println("Usuari en més tallers apuntats es: " + usuaris.getUsuariMesApuntat());
                    break;
                case 9:
                    System.out.print("Codi Taller: ");
                    codiTaller = teclat.next();
                    try {
                        tallerAux  = activitats.getTallerPerCodi(codiTaller); // No passa res per treballar sobre la referencia, enlloc d'una copia
                        if ( tallerAux.hiHaReservesFetes() ) {
                            System.out.print("Nom Usuari: ");
                            aliesUsuari = teclat.next();
                            if ( tallerAux.hiHaUsuari( aliesUsuari ) ) {
                                valoracio = demanarValoracio();
                                tallerAux.ferValoracio(aliesUsuari, valoracio);
                                System.out.println("Valoracio guardada");
                            } else {
                                System.out.println("L'usuari " + aliesUsuari + " no pretany al taller " + codiTaller.toUpperCase());
                            }
                        } else {
                            System.out.println("No hi han usuaris");
                        }
                    } catch ( TallerNoTrobatExcepcio ex ) {
                        System.out.println(ex.toString() );
                    }
                    break;
                case 10:
                    System.out.print("Codi del taller: ");
                    codiTaller = teclat.next();
                    try {
                        tallerAux  = activitats.getTallerPerCodi(codiTaller); // No passa res per treballar sobre la referencia, enlloc d'una copia
                        try {
                            System.out.println("Valoracio Mitja del taller " + codiTaller.toUpperCase() + ": " + tallerAux.getValoracioMitja());
                        } catch ( NoHiHanValoracionsExcepcio ex ) {
                            System.out.println( ex.toString() );
                        }
                    } catch ( TallerNoTrobatExcepcio ex ) {
                        System.out.println( ex.toString() );
                    }
                    break;
                case 11:
                    tallerAux = activitats.getTallerMesExitos();
                    System.out.println("el Taller mes exitos es " + tallerAux.getCodi() + " amb " + tallerAux.exit() + "%");
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
                    System.out.print("Nom de l'autor de la xerrada: ");
                    nomAutor = teclat.nextLine();
                    acts     = activitats.getXerradesSegonsAutor(nomAutor);
                    if ( acts.llistaBuida() ) {
                        System.out.println("No hi han xerrades fetes per aquest autor: " + nomAutor);
                    } else {
                        System.out.println("XERRADES donades per " + nomAutor + ":\n" + acts.xerrades());
                    }
                    break;
                case 14:
                    System.out.print("Codi del taller: ");
                    codiTaller = teclat.next();
                    try {
                        tallerAux  = activitats.getTallerPerCodi(codiTaller); // No passa res per treballar sobre la referencia, enlloc d'una copia
                        if ( ! tallerAux.hiHaReservesFetes() ) {
                            activitats.eliminaTallerPerCodi(codiTaller);
                            System.out.println("Taller " + codiTaller.toUpperCase() + " ha sigut eliminat");
                        } else {
                            System.out.println("No es pot eliminar hi ha reserves fetes.");
                        }
                    } catch ( TallerNoTrobatExcepcio ex ) {
                        System.out.println(ex.toString() );
                    }
                    break;
                case 15:
                    System.out.println("[-] - Sortint del programa...");
                    sortir  = true;
                    guardar = demanarGuardarInfor();
                    if ( guardar ) {
                        desarInfoFitxers(activitats);
                    }
                    System.out.println("[-] - Programa acabat");
                    break;
            }
        } while ( ! sortir );
        teclat.close();
    }
}
