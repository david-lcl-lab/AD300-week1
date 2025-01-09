package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GradesToolBoxTest {
    private GradesToolBox tb;
   @BeforeEach
    public void setUp() {
        tb = new GradesToolBox();
    }
    @AfterEach
    public void tearDown() {
       tb = null;
       System.gc();
    }
    @Test
    void gpaToPctSwitchTest() {
        String result = tb.gpaToPctSwitch("4.0");
        assertEquals("100.0% to 95.0%", result);
    }

    @Test
    void gpaToPctSwitchCStudentTest() {
        String result = tb.gpaToPctSwitch("2.0");
        assertEquals("76.0% to 75.0%", result);
    }
    @Test
    void gpaToPctSwitchFStudentTest() {
        String result = tb.gpaToPctSwitch("0.0");
        assertEquals("65.0% to 0%", result);
    }

    @Test
    void gpaToPctNegativeSwitchTest() {
        assertThrows(NumberFormatException.class, () ->tb.gpaToPctSwitch("-1.0"));
    }

    @Test
    void GpaToPctOverflowSwitchTest() {
       assertThrows(NumberFormatException.class, () ->tb.gpaToPctSwitch("\u221E")); //infinity
    }

    @Test
    void gpaToPctNullSwitchTest(){
        assertThrows(NumberFormatException.class, () ->tb.gpaToPctSwitch("Null")); //  null
    }

    @Test
    void pctToGpaIfDecimalTest(){
        double result = tb.pctToGpaIf("95.1%");
        assertEquals(4.0, result, 0.1);
    }

    @Test
    void pctToGpaIfBTest(){
        double result = tb.pctToGpaIf("80.0%");
        assertEquals(2.5, result, 0.1);
    }

    @Test
    void pctToGpaIfWhiteSpaceTest() {
       double result = tb.pctToGpaIf("100 % to 95.0%");
       assertEquals(4.0, result, 0.1);
    }

    @Test
    void pctToGpaIfLineBreakTest() {
        double result = tb.pctToGpaIf(" 70.0 %\n" + "\t\n" + "to 69.0%");
        assertEquals(1.5, result, 0.1);
    }

    @Test
    void pctToGpaIfEmptyTest() {
        assertThrows(NumberFormatException.class, () -> tb.pctToGpaIf(""));
    }
}
