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
     * Place a bet by spinning the wheels and returning the value of the prize obtained.
     *
     * @param valorApuesta a utilizar.
     * @return the prize obtained.
     */

    /**this method must be box's outside(added)*/
    public int realizarApuesta(int valorApuesta) {
        // protection!
        if (valorApuesta <= 0) {
            throw new IllegalArgumentException("No se puede realizar apuesta con valor cero o negativo");
        }

        // giro las ruedas
        this.girarRuedas();

        // realizo el calculo del premio
        return this.getPremio(valorApuesta);
    }

    /**this method also must be box's outside(added)*/
    /**
     * Spin the wheel!
     */
    private void girarRuedas() {
        // random throw.
        ruedas.forEach(Rueda::girarAlAzar);
    }


    /**this method also must be box's outside(added)*/
    /**
     * calculates the value of the prize to be obtained from the value of the bet.
     *
     * @param apuesta to use.
     * @return the prize value.
     */
    private int getPremio(int apuesta) {

        // rule 1: all the values are equals
        if (this.isValorRuedasIgualesDistintoDeCero()) {
            return apuesta * this.ruedas.get(0).getValor();
        }

        // rule 2: count the ceros
        int zeros = Math.toIntExact(this.ruedas.stream()
                .filter(rueda -> rueda.getValor() == 0)
                .count());

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

    /**
     * @return true if the values of all wheels are equal but non-zero
     */
    private boolean isValorRuedasIgualesDistintoDeCero() {
        return this.ruedas
                .stream()
                .allMatch(rueda -> rueda.getValor() == this.ruedas.get(0).getValor() && rueda.getValor() != 0);
    }

    /**
     * @return the current values of Ruedas.
     */
    public List<Character> getRuedasValues() {

        // the array of chars
        return this.ruedas.stream()
                .map(Rueda::getChar)
                .collect(Collectors.toList());
    }

}
