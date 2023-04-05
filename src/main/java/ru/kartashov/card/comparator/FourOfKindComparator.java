package ru.kartashov.card.comparator;

import ru.kartashov.HandStatistics;

import java.util.Comparator;

public class FourOfKindComparator implements Comparator<HandStatistics> {

    @Override
    public int compare(HandStatistics o1, HandStatistics o2) {
        boolean hasFOK1 = o1.hasFourOfKind();
        boolean hasFOK2 = o2.hasFourOfKind();
        if (hasFOK1 && hasFOK2) {
            int res;
            return ((res = o1.getRatingOfQuad().compareTo(o2.getRatingOfQuad())) != 0) ? res :
                    o1.getKicker().compareTo(o2.getKicker());
        } else if (hasFOK1)
            return 1;
        else if (hasFOK2)
            return -1;
        else
            return 0;
    }
}