package ru.kartashov.card;

public enum Rating {

    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String sign;

    private Rating(String sign) {
        this.sign = sign;
    }

    public static Rating getBySign(String sign) {
        for (Rating rating : values()) {
            if (rating.sign.equals(sign))
                return rating;
        }
        return null;
    }

    public static Rating max(Rating o1, Rating o2) {
        return o1.compareTo(o2) > 0 ? o1 : o2;
    }
}