package ru.kartashov.card.comparator;

import ru.kartashov.HandStatistics;
import ru.kartashov.card.Card;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ru.kartashov.card.CardValidator.HAND_SIZE;

public class ThreeOfKindComparator implements Comparator<HandStatistics> {

    @Override
    public int compare(HandStatistics o1, HandStatistics o2) {
        boolean hasTOK1 = o1.hasThreeOfKind();
        boolean hasTOK2 = o2.hasThreeOfKind();
        if (hasTOK1 && hasTOK2) {
            int res;
            if ((res = o1.getRatingOfSet().compareTo(o2.getRatingOfSet())) != 0)
                return res;

            List<Card> kickers1 = o1.getCards().stream()
                    .filter(c -> !c.getRating().equals(o1.getRatingOfSet()))
                    .sorted().collect(Collectors.toList());

            List<Card> kickers2 = o2.getCards().stream()
                    .filter(c -> !c.getRating().equals(o2.getRatingOfSet()))
                    .sorted().collect(Collectors.toList());

            for (int i = HAND_SIZE-4; i >= 0; i--) {
                if ((res = kickers1.get(i).compareTo(kickers2.get(i))) != 0)
                    return res;
            }
            return 0;
        } else if (hasTOK1)
            return 1;
        else if (hasTOK2)
            return -1;
        else
            return 0;
    }
}