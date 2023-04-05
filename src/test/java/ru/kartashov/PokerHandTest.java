package ru.kartashov;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandTest {

    @Test
    public void testPokerHandsSorting() {
        List<PokerHand> hands = new ArrayList<>();
        hands.add(new PokerHand("KS 2H 5C JD TD"));
        hands.add(new PokerHand("AC AH AS KD KS"));
        hands.add(new PokerHand("2C 3C AC 4C 5C"));
        hands.add(new PokerHand("AC AH QC QS 5C"));
        hands.add(new PokerHand("AC AH JC 9H 2D"));
        hands.add(new PokerHand("TC JC QC KC AC"));
        hands.add(new PokerHand("2C 3H 4D 5H 6S"));
        hands.add(new PokerHand("AC AH AS AD JD"));
        hands.add(new PokerHand("AC AH AS 4H QC"));

        Collections.sort(hands, Collections.reverseOrder());

        assertEquals(new PokerHand("TC JC QC KC AC"), hands.get(0));
        assertEquals(new PokerHand("AC AH AS AD JD"), hands.get(1));
        assertEquals(new PokerHand("AC AH AS KD KS"), hands.get(2));
        assertEquals(new PokerHand("2C 3C AC 4C 5C"), hands.get(3));
        assertEquals(new PokerHand("2C 3H 4D 5H 6S"), hands.get(4));
        assertEquals(new PokerHand("AC AH AS 4H QC"), hands.get(5));
        assertEquals(new PokerHand("AC AH QC QS 5C"), hands.get(6));
        assertEquals(new PokerHand("AC AH JC 9H 2D"), hands.get(7));
        assertEquals(new PokerHand("KS 2H 5C JD TD"), hands.get(8));
    }
}