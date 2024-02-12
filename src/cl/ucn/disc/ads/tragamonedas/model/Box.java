package cl.ucn.disc.ads.tragamonedas.model;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Box of Tragamonedas.
 *
 * @author Arquitectura de Sistemas.
 */
public final class Box {


    public Box() {

    }


    /*
     * @param apuesta to use.
     * @return the prize value.
     */
    public int getPremio(int zeros) {

        return switch (zeros) {
            // '*'
            case 1 -> 50;
            // '**'
            case 2 -> 300;
            // '***'
            case 3 -> 500;
            // nothing
            default -> 0;
        };

    }





}
