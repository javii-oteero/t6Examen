package es.iesmz.tests;

import org.junit.jupiter.api.Test;

import static es.iesmz.tests.TipoMoneda.*;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void testEurUsd(){
        assertEquals(Money.change(EUR, USD, 23.88f), 28.37f);
    }

    @Test
    void testGbpEur(){
        assertEquals(Money.change(GBP, EUR, 1000.0f), 1165.83f);
    }

    @Test
    void testEurGbp(){
        assertEquals(Money.change(EUR, GBP, 234.56f), 201.21f);
    }

    @Test
    void testUsdEur(){
        assertEquals(Money.change(USD, EUR, 44.56f), 37.51f);
    }

    @Test
    void testGbpUsd(){
        assertEquals(Money.change(GBP, USD, 100.0f), 138.49f);
    }

    @Test
    void testUsdGbp(){
        assertEquals(Money.change(USD, GBP, 1000.0f), 722.14f);
    }

    @Test
    void testFallidoPtsEur(){
        assertEquals(Money.change(PTS, EUR, 100.0f), -1f);
    }

    @Test
    void testFallidoEurPts(){
        assertEquals(Money.change(EUR, PTS, 123.3f), -1f);
    }

    @Test
    void testFallidoUsdEurNegativo(){
        assertEquals(Money.change(USD, EUR, -167.34f), -1f);
    }
}