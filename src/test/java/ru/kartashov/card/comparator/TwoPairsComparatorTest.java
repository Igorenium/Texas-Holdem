package ru.kartashov.card.comparator;

import org.junit.jupiter.api.Test;
import ru.kartashov.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class TwoPairsComparatorTest {

    private final TwoPairsComparator comparator = new TwoPairsComparator();

    @Test
    public void testCombinationsComparison() {
        assertEquals(0, comparator.compare(new PokerHand("AD AH JD JH 6S").getHandStat(),
                                                    new PokerHand("AD AH JD JH 6S").getHandStat()));

        assertEquals(0, comparator.compare(new PokerHand("AD AH JD JH 6S").getHandStat(),
                                                    new PokerHand("AC AS JC JS 6H").getHandStat()));

        assertTrue(comparator.compare(new PokerHand("AD AH JD JH 6S").getHandStat(),
                                               new PokerHand("KD KH JD JH 6S").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("AD AH JD JH 6S").getHandStat(),
                                               new PokerHand("AD AH TD TH QS").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("AD AH JD JH 6S").getHandStat(),
                                               new PokerHand("AD AH TD TH 6S").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("AD AH JD JH 6S").getHandStat(),
                                               new PokerHand("AD AH JD JH 5S").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("KD KH JD JH 6S").getHandStat(),
                                               new PokerHand("AD AH JD JH 6S").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("AD AH TD TH QS").getHandStat(),
                                               new PokerHand("AD AH JD JH 6S").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("AD AH TD TH 6S").getHandStat(),
                                               new PokerHand("AD AH JD JH 6S").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("AD AH JD JH 5S").getHandStat(),
                                               new PokerHand("AD AH JD JH 6S").getHandStat()) < 0);
    }
}