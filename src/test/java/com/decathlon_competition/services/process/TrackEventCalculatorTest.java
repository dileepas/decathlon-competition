package com.decathlon_competition.services.process;

import com.decathlon_competition.services.process.impl.TrackEventCalculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TrackEventCalculatorTest {

    @Test
    public void testValidEntry() {
        double result = new TrackEventCalculator().calculate(25.4347,18,1.81,10.55);
        assertEquals(963.89,result,0);
    }

    @Test (expected = NumberFormatException.class)
    public void testInvalidEntry() {
        double result = new TrackEventCalculator().calculate(25.4347,-18,1.81,-10.55);
        assertEquals(963.89,result,0);
    }
}
