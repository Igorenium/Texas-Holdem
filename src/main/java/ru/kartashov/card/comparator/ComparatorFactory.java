package ru.kartashov.card.comparator;

import ru.kartashov.HandStatistics;

import java.util.Comparator;

public class ComparatorFactory {

    public Comparator<HandStatistics> getComparator(HandStatistics o1, HandStatistics o2) {
        if (o1.hasStraightFlash() || o2.hasStraightFlash())
            return new StraightFlushComparator();
        else if (o1.hasFourOfKind() || o2.hasFourOfKind())
            return new FourOfKindComparator();
        else if (o1.hasFullHouse() || o2.hasFullHouse())
            return new FullHouseComparator();
        else if (o1.hasFlush() || o2.hasFlush())
            return new FlushComparator();
        else if (o1.hasStraight() || o2.hasStraight())
            return new StraightComparator();
        else if (o1.hasThreeOfKind() || o2.hasThreeOfKind())
            return new ThreeOfKindComparator();
        else if (o1.hasTwoPairs() || o2.hasTwoPairs())
            return new TwoPairsComparator();
        else
            return new HighCardComparator();
    }
}