package com.decathlon_competition.services.process.impl;

import com.decathlon_competition.services.process.EventCalculator;

import java.text.DecimalFormat;

public class FieldEventCalculator implements EventCalculator {

    @Override
    public double calculate(double a, double b, double c, double p) throws NumberFormatException {
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        double total = Math.pow(p-b, c) * a;
        return Double.parseDouble(decimalFormat.format(total));
    }
}
