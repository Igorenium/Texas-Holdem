package ru.kartashov.card.comparator;

import org.junit.jupiter.api.Test;
import ru.kartashov.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class HighCardComparatorTest {

    private final HighCardComparator comparator = new HighCardComparator();

    @Test
    public void testCombinationsComparison() {
        assertEquals(0, comparator.compare(new PokerHand("AD JH 8S 5D 3C").getHandStat(),
                                                    new PokerHand("AD JH 8S 5D 3C").getHandStat()));

        assertEquals(0, comparator.compare(new PokerHand("AD JH 8S 5D 3C").getHandStat(),
                                                    new PokerHand("AH JC 8H 5S 3D").getHandStat()));

        assertTrue(comparator.compare(new PokerHand("AD JH 8S 5D 3C").getHandStat(),
                                               new PokerHand("KD JH 8S 5D 3C").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("AD JH 8S 5D 3C").getHandStat(),
                                               new PokerHand("AD JH 8S 5D 2C").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("KD JH 8S 5D 3C").getHandStat(),
                                               new PokerHand("AD JH 8S 5D 3C").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("AD JH 8S 5D 2C").getHandStat(),
                                               new PokerHand("AD JH 8S 5D 3C").getHandStat()) < 0);
    }
}