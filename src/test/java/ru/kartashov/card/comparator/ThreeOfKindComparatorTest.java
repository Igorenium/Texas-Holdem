package ru.kartashov.card.comparator;

import org.junit.jupiter.api.Test;
import ru.kartashov.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class ThreeOfKindComparatorTest {

    private final ThreeOfKindComparator comparator = new ThreeOfKindComparator();

    @Test
    public void testCombinationsComparison() {
        assertEquals(0, comparator.compare(new PokerHand("TD JH AH AS AD").getHandStat(),
                                                    new PokerHand("TD JH AH AS AD").getHandStat()));

        assertEquals(0, comparator.compare(new PokerHand("TD JH AH AS AD").getHandStat(),
                                                    new PokerHand("JC TH AS AC AH").getHandStat()));

        assertTrue(comparator.compare(new PokerHand("TD JH AH AS AD").getHandStat(),
                                               new PokerHand("TD JH KH KS KD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("9D JH AH AS AD").getHandStat(),
                                               new PokerHand("9D TH AH AS AD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("TD JH AH AS AD").getHandStat(),
                                               new PokerHand("9D JH AH AS AD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("TD JH KH KS KD").getHandStat(),
                                               new PokerHand("TD JH AH AS AD").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("9D TH AH AS AD").getHandStat(),
                                               new PokerHand("TD JH AH AS AD").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("9D JH AH AS AD").getHandStat(),
                                               new PokerHand("TD JH AH AS AD").getHandStat()) < 0);
    }
}