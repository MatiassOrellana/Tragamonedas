package cl.ucn.disc.ads.tragamonedas;

import cl.ucn.disc.ads.tragamonedas.services.Tragamonedas;
import cl.ucn.disc.ads.tragamonedas.services.TragamonedasImpl;

/**
 * Tragamonedas implementation.
 *
 * @author Arquitectura de Sistemas.
 */
public final class TheMain {

    /**
     * Pantalla de entrada.
     */
    private static final java.util.Scanner IN = new java.util.Scanner(System.in);

    /**
     * The Main.
     *
     * @param args to use.
     */
    public static void main(String[] args) {

        // imprimir bienvenida en pantalla
        System.out.println("Bienvenido al Tragamonedas v2.0");
        System.out.println("============================================");
        System.out.print("Ingrese su saldo inicial: ");
        int saldoInicial = IN.nextInt();
        System.out.println();

        // tragamonedas the game
        final Tragamonedas tg = new TragamonedasImpl(saldoInicial);

        // mientras tenga saldo para jugar
        while (tg.getSaldo() != 0) {

            System.out.printf("Su saldo actual es de $%s. ¿Cuanto desea apostar? ", tg.getSaldo());

            int apuesta = IN.nextInt();
            System.out.println();

            if (apuesta == 0) {
                System.out.printf("Muchas gracias por jugar. Su saldo final es de $%s.%n", tg.getSaldo());
                break;
            } else {
                int premio = tg.realizarApuesta(apuesta);

                StringBuilder sb = new StringBuilder("+---+---+---+\n");
                for (Character c : tg.getRuedasValues()) {
                    sb.append("| ").append(c).append(" ");
                }
                sb.append("|\n").append("+---+---+---+\n");
                System.out.println(sb);

                if (premio > 0) {
                    System.out.printf("Ud. obtiene $%s ;)%n", premio);
                }

            }

            // si el saldo llega a 0 termina el programa y agradece al jugador
            if (tg.getSaldo() == 0) {
                System.out.println("Muchas Gracias por jugar, su saldo es cero. Mejor suerte la próxima vez.");
            }

        }

    }

}
