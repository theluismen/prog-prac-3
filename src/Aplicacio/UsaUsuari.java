package bin.Aplicacio;

import bin.Usuaris.Usuari;

public class UsaUsuari {
    public static void main ( String args[] ) {
        Usuari usuari, usuari2;

        System.out.println("CONSTRUCTOR");
        usuari = new Usuari ("perrosanxe23", "perrosanxe@spain.com", 12345);
        System.out.println(usuari.toString());
        System.out.println();

        System.out.println("SETTERS");
        usuari.setAlies("Frionel Pesi");
        usuari.setCorreu("mesi@farsa.cat");
        usuari.setCPostal(54321);

        System.out.println("GETTERS");
        System.out.println("Alies   : " + usuari.getAlies());
        System.out.println("Correu  : " + usuari.getCorreu());
        System.out.println("CPostal : " + usuari.getCPostal());

        System.out.println("OBJECTE COPIA");
        usuari2 = usuari.copia();
        System.out.println("Alies   : " + usuari2.getAlies());
        System.out.println("Correu  : " + usuari2.getCorreu());
        System.out.println("CPostal : " + usuari2.getCPostal());
    }
}
