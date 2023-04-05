package ru.kartashov.card.comparator;

import ru.kartashov.HandStatistics;

import java.util.Comparator;

public class StraightFlushComparator implements Comparator<HandStatistics> {

    @Override
    public int compare(HandStatistics o1, HandStatistics o2) {
        boolean hasSF1 = o1.hasStraightFlash();
        boolean hasSF2 = o2.hasStraightFlash();
        if (hasSF1 && hasSF2)
            return o1.getHighestRating().compareTo(o2.getHighestRating());
        else if (hasSF1)
            return 1;
        else if (hasSF2)
            return -1;
        else
            return 0;
    }
}