/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.ads.tragamonedas.services;

import cl.ucn.disc.ads.tragamonedas.model.Box;

import java.util.List;

/**
 * Implementation of the Tragamonedas Game.
 *
 * @author Arquitectura de Sistemas.
 */
public final class TragamonedasImpl implements Tragamonedas {

    /**
     * The internal Tragamonedas.
     */
    private final Box box = new Box();

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
        if (saldo <= 0) {
            throw new IllegalArgumentException("No se puede tener saldo inicial cero o negativo");
        }
        this.saldo = saldo;
    }

    /**
     * {@inheritDoc}
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
        int premio = box.realizarApuesta(apuesta);

        // sumo el saldo
        this.saldo += premio;

        // retorno el premio
        return premio;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Character> getRuedasValues() {
        return box.getRuedasValues();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSaldo() {
        return this.saldo;
    }
}
