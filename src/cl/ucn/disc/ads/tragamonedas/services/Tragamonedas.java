/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.ads.tragamonedas.services;

import java.util.List;

/**
 * The Tragamonedas.
 *
 * @author Arquitectura de Sistemas.
 */
public interface Tragamonedas {



    /**
     * Places a bet verifying that the amount of the bet is equal to or less than the available balance.
     *
     * @param apuesta the value of the bet.
     * @return the value of the prize obtained.
     */
    int realizarApuesta(int apuesta);




    /**
     * @return the list of values in the wheels.
     */
    List<Character> getRuedasValues();

    /**
     * @return the value of saldo.
     */
    int getSaldo();


}
