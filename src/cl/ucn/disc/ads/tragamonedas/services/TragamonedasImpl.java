/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.ads.tragamonedas.services;

import cl.ucn.disc.ads.tragamonedas.model.Box;
import cl.ucn.disc.ads.tragamonedas.model.Rueda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of the Tragamonedas Game.
 *
 * @author Arquitectura de Sistemas.
 */
public final class TragamonedasImpl implements Tragamonedas {

    /**
     * one is for spin and other is for detect
     */
    private final int NUMERO_RUEDAS = 3;

    private Box box;

    /**
     * The List of Rueda.
     */
    private final List<Rueda> ruedas;
    /**
     * The internal Tragamonedas.
     */


    /**
     * The saldo of user.
     */
    private int saldo;

    /**
     * The Constructor.
     *
     * @param saldo del Usuario.
     */
    public TragamonedasImpl(final int saldo) {
        this.ruedas = Stream
                .generate(Rueda::new)
                .limit(NUMERO_RUEDAS)
                .collect(Collectors.toList());
        if (saldo <= 0) {
            throw new IllegalArgumentException("No se puede tener saldo inicial cero o negativo");
        }
        this.saldo = saldo;
    }

    /**
     * method to realize the bet
     */
    private int realizar(int valorApuesta) {
        // protection!
        if (valorApuesta <= 0) {
            throw new IllegalArgumentException("No se puede realizar apuesta con valor cero o negativo");
        }

        // giro las ruedas
        girarRuedas();

        // realizo el calculo del premio
        return getPremio(valorApuesta);
    }

    /**
     * calculate the money
     */
    @Override
    public int realizarApuesta(final int apuesta) {

        // protection
        if (apuesta <= 0) {
            throw new IllegalArgumentException("El valor de la apuesta no puede ser cero o negativo");
        }

        // tengo saldo
        if (apuesta > this.saldo) {

            throw new IllegalArgumentException("No se puede apostar mas del saldo disponible");
        }

        // descuento la apuesta
        this.saldo -= apuesta;

        // realizo la apuesta
        int premio = realizar(apuesta);

        // sumo el saldo
        this.saldo += premio;

        // retorno el premio
        return premio;

    }

    /**
     * @return the current values of Ruedas.
     */
    @Override
    public List<Character> getRuedasValues() {
        return ruedas.stream()
                .map(Rueda::getChar)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSaldo() {
        return this.saldo;
    }

    private void girarRuedas(){
        // random throw.
        ruedas.forEach(Rueda::girarAlAzar);
    }

    private int getPremio(int apuesta) {

        // rule 1: all the values are equals
        if (this.isValorRuedasIgualesDistintoDeCero()) {
            return apuesta * this.ruedas.get(0).getValor();
        }

        // rule 2: count the ceros
        int zeros = Math.toIntExact(this.ruedas.stream()
                .filter(rueda -> rueda.getValor() == 0)
                .count());

        box = new Box();

        return box.getPremio(zeros);
    }

    /**
     * @return true if the values of all wheels are equal but non-zero
     */
    private boolean isValorRuedasIgualesDistintoDeCero() {
        return this.ruedas
                .stream()
                .allMatch(rueda -> rueda.getValor() == this.ruedas.get(0).getValor() && rueda.getValor() != 0);
    }


}
