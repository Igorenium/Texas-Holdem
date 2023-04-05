package ru.kartashov.card.comparator;

import org.junit.jupiter.api.Test;
import ru.kartashov.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class FourOfKindComparatorTest {

    private final FourOfKindComparator comparator = new FourOfKindComparator();

    @Test
    public void testCombinationsComparison() {
        assertEquals(0, comparator.compare(new PokerHand("AD AC AS AH JD").getHandStat(),
                                                    new PokerHand("AD AC AS AH JD").getHandStat()));

        assertEquals(0, comparator.compare(new PokerHand("AD AC AS AH JD").getHandStat(),
                                                    new PokerHand("AH AD AC AS JC").getHandStat()));

        assertTrue(comparator.compare(new PokerHand("AD AC AS AH JD").getHandStat(),
                                               new PokerHand("AD AC AS AH TD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("AD AC AS AH JD").getHandStat(),
                                               new PokerHand("KD KC KS KH JD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("AD AC AS AH TD").getHandStat(),
                                               new PokerHand("AD AC AS AH JD").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("KD KC KS KH JD").getHandStat(),
                                               new PokerHand("AD AC AS AH JD").getHandStat()) < 0);
    }
}