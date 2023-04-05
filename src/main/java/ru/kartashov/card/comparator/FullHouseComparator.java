package ru.kartashov.card.comparator;

import ru.kartashov.HandStatistics;

import java.util.Comparator;

public class FullHouseComparator implements Comparator<HandStatistics> {

    @Override
    public int compare(HandStatistics o1, HandStatistics o2) {
        boolean hasFH1 = o1.hasFullHouse();
        boolean hasFH2 = o2.hasFullHouse();
        if (hasFH1 && hasFH2) {
            int res;
            return ((res = o1.getRatingOfSet().compareTo(o2.getRatingOfSet())) != 0) ? res :
                    o1.getRatingOfHighestPair().compareTo(o2.getRatingOfHighestPair());
        } else if (hasFH1)
            return 1;
        else if (hasFH2)
            return -1;
        else
            return 0;
    }
}