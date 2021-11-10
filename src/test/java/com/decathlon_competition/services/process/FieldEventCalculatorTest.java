package com.decathlon_competition.services.process;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldEventCalculatorTest {

    @Test
    public void testValidEntry() {
        double result = FieldEventCalculator.calculate(0.14354,220,1.4,780);
        assertEquals(1010.27,result,0);
    }

    @Test(expected = NumberFormatException.class)
    public void testInvalidEntry() {
        double result = FieldEventCalculator.calculate(0.14354,-220,1.4,-780);
        assertEquals(1010.27,result,0);
    }
}
