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

    /**
     * The number of Ruedas.
     */
    private final int NUMERO_RUEDAS = 3;

    /**
     * The List of Rueda.
     */
    private final List<Rueda> ruedas;


    /**
     * The Constructor.
     */
    public Box() {

        // construction
        this.ruedas = Stream
                .generate(Rueda::new)
                .limit(NUMERO_RUEDAS)
                .collect(Collectors.toList());

    }


    /**
     * calculates the value of the prize to be obtained from the value of the bet.
     *
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
