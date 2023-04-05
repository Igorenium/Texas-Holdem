package ru.kartashov.card.comparator;

import org.junit.jupiter.api.Test;
import ru.kartashov.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class FullHouseComparatorTest {

    private final FullHouseComparator comparator = new FullHouseComparator();

    @Test
    public void testCombinationsComparison() {
        assertEquals(0, comparator.compare(new PokerHand("AD AC AS JS JD").getHandStat(),
                                                    new PokerHand("AD AC AS JS JD").getHandStat()));

        assertEquals(0, comparator.compare(new PokerHand("AD AC AS JS JD").getHandStat(),
                                                    new PokerHand("AH AS AD JH JC").getHandStat()));

        assertTrue(comparator.compare(new PokerHand("AD AC AS JS JD").getHandStat(),
                                               new PokerHand("KD KC KS JS JD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("AD AC AS JS JD").getHandStat(),
                                               new PokerHand("AD AC AS TS TD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("KD KC KS JS JD").getHandStat(),
                                               new PokerHand("AD AC AS JS JD").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("AD AC AS TS TD").getHandStat(),
                                               new PokerHand("AD AC AS JS JD").getHandStat()) < 0);
    }
}