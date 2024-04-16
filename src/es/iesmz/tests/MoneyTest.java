package es.iesmz.tests;

import org.junit.jupiter.api.Test;

import static es.iesmz.tests.TipoMoneda.*;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void testEurUsd(){
        assertEquals(28.37f, Money.change(EUR, USD, 23.88f), 1);
    }

    @Test
    void testGbpEur(){
        assertEquals(1165.83f, Money.change(GBP, EUR, 1000.0f), 1);
    }

    @Test
    void testEurGbp(){
        assertEquals(201.21f, Money.change(EUR, GBP, 234.56f), 1);
    }

    @Test
    void testUsdEur(){
        assertEquals(37.51f, Money.change(USD, EUR, 44.56f), 1);
    }

    @Test
    void testGbpUsd(){
        assertEquals(138.49f, Money.change(GBP, USD, 100.0f), 1);
    }

    @Test
    void testUsdGbp(){
        assertEquals(722.14f, Money.change(USD, GBP, 1000.0f), 1);
    }

    @Test
    void testFallidoPtsEur(){
        assertEquals(-1f, Money.change(PTS, EUR, 100.0f));
    }

    @Test
    void testFallidoEurPts(){
        assertEquals(-1f, Money.change(EUR, PTS, 123.3f));
    }

    @Test
    void testFallidoUsdEurNegativo(){
        assertEquals(-1f, Money.change(USD, EUR, -167.34f));
    }
}