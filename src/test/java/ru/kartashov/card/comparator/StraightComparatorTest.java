package ru.kartashov.card.comparator;

import org.junit.jupiter.api.Test;
import ru.kartashov.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class StraightComparatorTest {

    private final StraightComparator comparator = new StraightComparator();

    @Test
    public void testCombinationsComparison() {
        assertEquals(0, comparator.compare(new PokerHand("TD JH QC KS AD").getHandStat(),
                new PokerHand("TD JH QC KS AD").getHandStat()));

        assertEquals(0, comparator.compare(new PokerHand("TD JH QC KS AD").getHandStat(),
                                                    new PokerHand("TH JC QS KD AH").getHandStat()));

        assertTrue(comparator.compare(new PokerHand("TD JH QC KS AD").getHandStat(),
                                               new PokerHand("9D TH JC QS KD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("TD JH QC KS AD").getHandStat(),
                                               new PokerHand("2D 3H 4C 5S 6D").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("9D TH JC QS KD").getHandStat(),
                                               new PokerHand("TD JH QC KS AD").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("2D 3H 4C 5S 6D").getHandStat(),
                                               new PokerHand("TD JH QC KS AD").getHandStat()) < 0);
    }
}