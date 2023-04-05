package ru.kartashov.card;

import java.util.Objects;

public class Card implements Comparable<Card> {

    private final Rating rating;
    private final Suit suit;

    public Card(Rating rating, Suit suit) {
        this.rating = rating;
        this.suit = suit;
    }

    public Rating getRating() {
        return rating;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card card) {
        return this.rating.compareTo(card.getRating());
    }

    @Override
    public String toString() {
        return "{" + rating +
                ", " + suit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return getRating() == card.getRating() && getSuit() == card.getSuit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRating(), getSuit());
    }
}