package cl.ucn.disc.ads.tragamonedas.model;

import java.util.Random;

/**
 * Class Rueda de un Tragamonedas.
 *
 * @author Arquitectura de Sistemas.
 */
public final class Rueda {

    /**
     * The Random.
     */
    private static final Random RANDOM = new Random();

    /**
     * The max number.
     */
    private static final int MAX_VALUE = 10;

    /**
     * Valor de la rueda.
     */
    private int valor = 0;

    /**
     * The Constructor.
     */
    public Rueda() {
        this.girarAlAzar();
    }

    /**
     * Make the wheel spin randomly.
     */
    public void girarAlAzar() {
        this.valor = RANDOM.nextInt(MAX_VALUE);
    }

    /**
     * @return the value of Rueda.
     */
    public int getValor() {
        return this.valor;
    }

    /**
     * @return the char value of valor.
     */
    public char getChar() {
        return this.valor == 0 ? '*' : Character.forDigit(this.valor, 10);
    }

}
