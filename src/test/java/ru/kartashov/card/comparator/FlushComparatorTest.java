package ru.kartashov.card.comparator;

import org.junit.jupiter.api.Test;
import ru.kartashov.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class FlushComparatorTest {

    private final FlushComparator comparator = new FlushComparator();

    @Test
    public void testCombinationsComparison() {
        assertEquals(0, comparator.compare(new PokerHand("6D 8D TD QD AD").getHandStat(),
                                                    new PokerHand("6D 8D TD QD AD").getHandStat()));

        assertEquals(0, comparator.compare(new PokerHand("6D 8D TD QD AD").getHandStat(),
                                                    new PokerHand("6C 8C TC QC AC").getHandStat()));

        assertTrue(comparator.compare(new PokerHand("6D 8D TD QD AD").getHandStat(),
                                               new PokerHand("6D 8D TD QD KD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("6D 8D TD QD AD").getHandStat(),
                                               new PokerHand("5D 8D TD QD AD").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("6D 8D TD QD KD").getHandStat(),
                                               new PokerHand("6D 8D TD QD AD").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("5D 8D TD QD AD").getHandStat(),
                                               new PokerHand("6D 8D TD QD AD").getHandStat()) < 0);
    }
}