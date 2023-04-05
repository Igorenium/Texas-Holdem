package ru.kartashov.card;

public enum Suit {

    SPADES("S"),
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C");

    private final String sign;

    private Suit(String sign) {
        this.sign = sign;
    }

    public static Suit getBySign(String sign) {
        for (Suit rating : values()) {
            if (rating.sign.equals(sign))
                return rating;
        }
        return null;
    }
}