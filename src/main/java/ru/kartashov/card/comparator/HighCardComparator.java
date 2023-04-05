package ru.kartashov.card.comparator;

import ru.kartashov.HandStatistics;
import ru.kartashov.card.Card;

import java.util.Comparator;
import java.util.List;

import static ru.kartashov.card.CardValidator.HAND_SIZE;

public class HighCardComparator implements Comparator<HandStatistics> {

    @Override
    public int compare(HandStatistics o1, HandStatistics o2) {
        List<Card> cards1 = o1.getCards();
        List<Card> cards2 = o2.getCards();
        int res = 0;
        for (int i = HAND_SIZE-1; i >= 0; i--) {
            if ((res = cards1.get(i).compareTo(cards2.get(i))) != 0)
                return res;
        }
        return res;
    }
}