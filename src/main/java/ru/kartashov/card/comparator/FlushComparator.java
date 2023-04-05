package ru.kartashov.card.comparator;

import ru.kartashov.HandStatistics;
import ru.kartashov.card.Card;

import java.util.Comparator;
import java.util.List;

import static ru.kartashov.card.CardValidator.HAND_SIZE;

public class FlushComparator implements Comparator<HandStatistics> {

    @Override
    public int compare(HandStatistics o1, HandStatistics o2) {
        boolean hasF1 = o1.hasFlush();
        boolean hasF2 = o2.hasFlush();
        if (hasF1 && hasF2) {
            List<Card> cards1 = o1.getCards();
            List<Card> cards2 = o2.getCards();
            int res = 0;
            for (int i = HAND_SIZE-1; i >= 0; i--) {
                if ((res = cards1.get(i).compareTo(cards2.get(i))) != 0)
                    return res;
            }
            return res;
        } else if (hasF1)
            return 1;
        else if (hasF2)
            return -1;
        else
            return 0;
    }
}