package ru.kartashov.card;

import java.util.HashSet;
import java.util.Set;

public class CardParser {

    public Set<Card> parse(String[] cards) {
        Set<Card> result = new HashSet<>();
        for (String card : cards) {
            Rating rating = Rating.getBySign(String.valueOf(card.charAt(0)));
            Suit suit = Suit.getBySign(String.valueOf(card.charAt(1)));
            result.add(new Card(rating, suit));
        }
        return result;
    }
}