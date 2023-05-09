


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class PopulationCounterTest {
    @Test
    public void testPopulationCounterDisplaysCorrectTotal() throws Exception {

        // Setup
        String expected = "World population is: 1,347,982,728\n";

        // https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        // Exercise
        PopulationCounter.main(new String[] {"./data/worldcitiespop.csv"});

        // Assert
        System.out.flush();
        String output = baos.toString();
        assertEquals(expected, output );

        // Teardown
        System.setOut(old);
    }


 

}
