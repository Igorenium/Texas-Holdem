package ru.kartashov.card.comparator;

import ru.kartashov.HandStatistics;

import java.util.Comparator;

public class TwoPairsComparator implements Comparator<HandStatistics> {

    @Override
    public int compare(HandStatistics o1, HandStatistics o2) {
        boolean hasTP1 = o1.hasTwoPairs();
        boolean hasTP2 = o2.hasTwoPairs();
        if (hasTP1 && hasTP2) {
            int res;
            return  ((res = o1.getRatingOfHighestPair().compareTo(o2.getRatingOfHighestPair())) != 0) ? res :
                    ((res = o1.getRatingOfLowestPair().compareTo(o2.getRatingOfLowestPair())) != 0) ? res :
                    o1.getKicker().compareTo(o2.getKicker());
        } else if (hasTP1)
            return 1;
        else if (hasTP2)
            return -1;
        else
            return 0;
    }
}