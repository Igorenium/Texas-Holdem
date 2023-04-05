package ru.kartashov;

import ru.kartashov.card.Card;
import ru.kartashov.card.CardParser;
import ru.kartashov.card.CardValidator;
import ru.kartashov.card.comparator.*;

import java.util.Objects;
import java.util.Set;

public class PokerHand implements Comparable<PokerHand> {

    private final Set<Card> cards;
    private final HandStatistics handStat;

    private final CardValidator cardValidator = new CardValidator();
    private final CardParser cardParser = new CardParser();

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
        if (handStat.hasStraightFlash() || o.getHandStat().hasStraightFlash())
            return new StraightFlushComparator().compare(handStat, o.getHandStat());

        if (handStat.hasFourOfKind() || o.getHandStat().hasFourOfKind())
            return new FourOfKindComparator().compare(handStat, o.getHandStat());

        if (handStat.hasFullHouse() || o.getHandStat().hasFullHouse())
            return new FullHouseComparator().compare(handStat, o.getHandStat());

        if (handStat.hasFlush() || o.getHandStat().hasFlush())
            return new FlushComparator().compare(handStat, o.getHandStat());

        if (handStat.hasStraight() || o.getHandStat().hasStraight())
            return new StraightComparator().compare(handStat, o.getHandStat());

        if (handStat.hasThreeOfKind() || o.getHandStat().hasThreeOfKind())
            return new ThreeOfKindComparator().compare(handStat, o.getHandStat());

        if (handStat.hasTwoPairs() || o.getHandStat().hasTwoPairs())
            return new TwoPairsComparator().compare(handStat, o.getHandStat());

        return new HighCardComparator().compare(handStat, o.getHandStat());
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