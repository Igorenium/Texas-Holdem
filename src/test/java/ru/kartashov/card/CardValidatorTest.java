package ru.kartashov.card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardValidatorTest {

    @Test
    public void testWrongHandSize() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new CardValidator().validate(new String[]{"2D", "3D", "4D", "5D"});
        });

        Assertions.assertEquals("Wrong size of hand: 4", exception.getMessage());
    }

    @Test
    public void testWrongCardSuit() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new CardValidator().validate(new String[]{"2D", "3D", "4D", "5D", "6M"});
        });

        Assertions.assertEquals("Wrong suit of card 6M", exception.getMessage());
    }

    @Test
    public void testWrongCardRating() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new CardValidator().validate(new String[]{"2D", "3D", "4D", "5D", "1D"});
        });

        Assertions.assertEquals("Wrong rating of card 1D", exception.getMessage());
    }
}