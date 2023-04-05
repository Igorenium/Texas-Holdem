package ru.kartashov.card.comparator;

import ru.kartashov.HandStatistics;
import ru.kartashov.card.Card;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ru.kartashov.card.CardValidator.HAND_SIZE;

public class PairComparator implements Comparator<HandStatistics> {

    @Override
    public int compare(HandStatistics o1, HandStatistics o2) {
        boolean hasP1 = o1.hasPair();
        boolean hasP2 = o2.hasPair();
        if (hasP1 && hasP2) {
            int res;
            if ((res = o1.getRatingOfHighestPair().compareTo(o2.getRatingOfHighestPair())) != 0)
                return res;

            List<Card> kickers1 = o1.getCards().stream()
                    .filter(c -> !c.getRating().equals(o1.getRatingOfHighestPair()))
                    .sorted().collect(Collectors.toList());

            List<Card> kickers2 = o2.getCards().stream()
                    .filter(c -> !c.getRating().equals(o2.getRatingOfHighestPair()))
                    .sorted().collect(Collectors.toList());

            for (int i = HAND_SIZE-3; i >= 0; i--) {
                if ((res = kickers1.get(i).compareTo(kickers2.get(i))) != 0)
                    return res;
            }
            return res;
        } else if (hasP1)
            return 1;
        else if (hasP2)
            return -1;
        else
            return 0;
    }
}