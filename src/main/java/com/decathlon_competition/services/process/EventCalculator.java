package com.decathlon_competition.services.process;

public interface EventCalculator {
    /**
     * This method is responsible to calculate the score for a given event in decathlon based on the given parameters.
     * @param a
     * @param b
     * @param c
     * @param p
     * @return Score for the given values based on the implemented formula .
     * @throws NumberFormatException
     */
    double calculate(double a, double b, double c, double p) throws NumberFormatException;
}
