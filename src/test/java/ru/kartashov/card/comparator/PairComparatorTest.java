package ru.kartashov.card.comparator;

import org.junit.jupiter.api.Test;
import ru.kartashov.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class PairComparatorTest {

    private final PairComparator comparator = new PairComparator();

    @Test
    public void testCombinationsComparison() {
        assertEquals(0, comparator.compare(new PokerHand("AD AH TD 7H 4S").getHandStat(),
                                                    new PokerHand("AD AH TD 7H 4S").getHandStat()));

        assertEquals(0, comparator.compare(new PokerHand("AD AH TD 7H 4S").getHandStat(),
                                                    new PokerHand("AS AC TH 7C 4H").getHandStat()));

        assertTrue(comparator.compare(new PokerHand("AD AH TD 7H 4S").getHandStat(),
                                               new PokerHand("KD KH TD 7H 4S").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("AD AH TD 7H 4S").getHandStat(),
                                               new PokerHand("AD AH 9D 7H 4S").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("AD AH TD 7H 4S").getHandStat(),
                                               new PokerHand("AD AH TD 7H 3S").getHandStat()) > 0);

        assertTrue(comparator.compare(new PokerHand("KD KH TD 7H 4S").getHandStat(),
                                               new PokerHand("AD AH TD 7H 4S").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("AD AH 9D 7H 4S").getHandStat(),
                                               new PokerHand("AD AH TD 7H 4S").getHandStat()) < 0);

        assertTrue(comparator.compare(new PokerHand("AD AH TD 7H 3S").getHandStat(),
                                               new PokerHand("AD AH TD 7H 4S").getHandStat()) < 0);

    }
}