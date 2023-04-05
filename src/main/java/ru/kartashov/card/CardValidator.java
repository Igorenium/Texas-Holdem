package ru.kartashov.card;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardValidator {

    public static final int HAND_SIZE = 5;

    private final List<String> refRatings = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");
    private final List<String> refSuits = Arrays.asList("S", "H", "D", "C");

    public void validate(String[] cardArray) {
        Set<String> cards = new HashSet<>(Arrays.asList(cardArray));
        if (cards.size() != HAND_SIZE)
            throw new RuntimeException("Wrong size of hand: " + cards.size());

        for (String card : cards) {
            if (card.length() != 2)
                throw new RuntimeException("Wrong length of card name " + card);

            if (!refRatings.contains(String.valueOf(card.charAt(0))))
                throw new RuntimeException("Wrong rating of card " + card);

            if (!refSuits.contains(String.valueOf(card.charAt(1))))
                throw new RuntimeException("Wrong suit of card " + card);
        }
    }
}