package ru.kartashov;

import ru.kartashov.card.Card;
import ru.kartashov.card.CardParser;
import ru.kartashov.card.CardValidator;
import ru.kartashov.card.comparator.*;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public class PokerHand implements Comparable<PokerHand> {

    private final Set<Card> cards;
    private final HandStatistics handStat;

    private final CardValidator cardValidator = new CardValidator();
    private final CardParser cardParser = new CardParser();
    private final ComparatorFactory comparatorFactory = new ComparatorFactory();

    public PokerHand(String hand) {
        String[] cards = hand.split(" ");
        cardValidator.validate(cards);
        this.cards = cardParser.parse(cards);
        this.handStat = new HandStatistics(this.cards);
    }

    public Set<Card> getCards() {
        return cards;
    }

    public HandStatistics getHandStat() {
        return handStat;
    }

    @Override
    public int compareTo(PokerHand o) {
        Comparator<HandStatistics> comparator = comparatorFactory.getComparator(handStat, o.getHandStat());
        return comparator.compare(handStat, o.getHandStat());
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "cards=" + cards +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerHand pokerHand = (PokerHand) o;
        return Objects.equals(getCards(), pokerHand.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCards());
    }
}