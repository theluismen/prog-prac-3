import Reserves.Reserva;

public class UsaReserva {
    public static void main ( String args[] ) {
        Reserva reserva, reserva2;

        System.out.println("CONSTRUCTOR");
        reserva = new Reserva ( 100, "perrosanxe", "XER100");
        reserva.setValoracio(0);
        System.out.println(reserva.toString());
        System.out.println();

        System.out.println("SETTERS");
        reserva.setCodi(69);
        reserva.setAliesUsuari("Frionel Pesi");
        reserva.setCodiTaller("VIS100");
        reserva.setValoracio(10);

        System.out.println("GETTERS");
        System.out.println("Codi        : " + reserva.getCodi());
        System.out.println("Correu      : " + reserva.getAliesUsuari());
        System.out.println("Codi Taller : " + reserva.getCodiTaller());
        System.out.println("Valoracio   : " + reserva.getValoracio());

        System.out.println("OBJECTE COPIA");
        reserva2 = reserva.copia();
        System.out.println("Codi        : " + reserva2.getCodi());
        System.out.println("Correu      : " + reserva2.getAliesUsuari());
        System.out.println("Codi Taller : " + reserva2.getCodiTaller());
        System.out.println("Valoracio   : " + reserva2.getValoracio());
    }
}
