package ru.kartashov.card.comparator;

import org.junit.jupiter.api.Test;
import ru.kartashov.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class StraightFlushComparatorTest {

    private final StraightFlushComparator comparator = new StraightFlushComparator();

    @Test
    public void testCombinationsComparison() {
        assertEquals(0, comparator.compare(new PokerHand("2D 6D 3D 4D 5D").getHandStat(),
                                                    new PokerHand("2D 6D 3D 4D 5D").getHandStat()));

        assertEquals(0, comparator.compare(new PokerHand("2D 6D 3D 4D 5D").getHandStat(),
                                                    new PokerHand("2C 3C 4C 5C 6C").getHandStat()));

        assertTrue(comparator.compare(new PokerHand("AD KD QD JD TD").getHandStat(),
                                               new PokerHand("KC QC JC TC 9C").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("KC QC JC TC 9C").getHandStat(),
                                               new PokerHand("AD KD QD JD TD").getHandStat()) < 0);
    }
}