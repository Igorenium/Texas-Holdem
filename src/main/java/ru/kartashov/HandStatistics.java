package ru.kartashov;

import lombok.Getter;
import ru.kartashov.card.Card;
import ru.kartashov.card.Rating;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class HandStatistics {

    private int maxNumCardsWithSameRating;
    private int maxNumCardsWithSameSuit;
    private int numPairs;

    private int lengthOfStraight = 1;

    private Rating highestRating;

    private Rating ratingOfQuad;
    private Rating ratingOfSet;
    private Rating ratingOfHighestPair;
    private Rating ratingOfLowestPair;

    private Rating kicker;

    private final List<Card> cards;

    public HandStatistics(Set<Card> cards) {
        this.cards = new ArrayList<>(cards);
        processCards();
    }

    public boolean hasStraightFlash() {
        return hasStraight() & hasFlush();
    }

    public boolean hasFourOfKind() {
        return maxNumCardsWithSameRating == 4;
    }

    public boolean hasFullHouse() {
        return hasThreeOfKind() & numPairs == 1;
    }

    public boolean hasFlush() {
        return maxNumCardsWithSameSuit == 5;
    }

    public boolean hasStraight() {
        return lengthOfStraight == 5;
    }

    public boolean hasThreeOfKind() {
        return maxNumCardsWithSameRating == 3;
    }

    public boolean hasTwoPairs() {
        return numPairs == 2;
    }

    public boolean hasPair() {
        return numPairs == 1;
    }

    private void processCards() {
        Collections.sort(cards);
        highestRating = cards.get(4).getRating();

        processStraight();
        processFlash();
        if (hasStraightFlash()) return;

        Map<Rating, Integer> repetitionsPerRating = cards.stream()
                .collect(Collectors.toMap(Card::getRating, c -> 1, Integer::sum));

        maxNumCardsWithSameRating = repetitionsPerRating.values().stream().mapToInt(Integer::intValue).max().orElse(1);
        if (maxNumCardsWithSameRating == 4) {
            processFourOfKind(repetitionsPerRating);
            return;
        } else if (maxNumCardsWithSameRating == 3) {
            processSet(repetitionsPerRating);
            if (repetitionsPerRating.entrySet().stream().anyMatch(e -> e.getValue() == 2)) {
                processPair(repetitionsPerRating);
                return;
            }
        }

        if (hasFlush()) return;
        if (hasStraight()) return;
        if (hasThreeOfKind()) return;

        if (maxNumCardsWithSameRating == 2)
            processPair(repetitionsPerRating);
    }

    private void processStraight() {
        int tmpMaxLen = 1;
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getRating().ordinal() == cards.get(i-1).getRating().ordinal() + 1) {
                tmpMaxLen++;
                if (tmpMaxLen > lengthOfStraight) {
                    lengthOfStraight = tmpMaxLen;
                }
            } else {
                tmpMaxLen = 1;
            }
        }
    }

    private void processFlash() {
        maxNumCardsWithSameSuit = cards.stream()
                .collect(Collectors.toMap(Card::getSuit, c -> 1, Integer::sum))
                .values().stream().mapToInt(Integer::intValue).max().orElse(1);
    }

    private void processFourOfKind(Map<Rating, Integer> repetitionsPerRating) {
        ratingOfQuad = repetitionsPerRating.entrySet().stream()
                .filter(e -> e.getValue() == 4)
                .map(Map.Entry::getKey)
                .findFirst().get();

        kicker = repetitionsPerRating.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    private void processSet(Map<Rating, Integer> repetitionsPerRating) {
        ratingOfSet = repetitionsPerRating.entrySet().stream()
                .filter(e -> e.getValue() == 3)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    private void processPair(Map<Rating, Integer> repetitionsPerRating) {
        List<Rating> tmpRatings = repetitionsPerRating.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        numPairs = tmpRatings.size();
        if (numPairs == 1) {
            ratingOfHighestPair = tmpRatings.get(0);
        } else if (numPairs == 2) {
            ratingOfHighestPair = Rating.max(tmpRatings.get(0), tmpRatings.get(1));
            ratingOfLowestPair = ratingOfHighestPair.equals(tmpRatings.get(0)) ? tmpRatings.get(1) : tmpRatings.get(0);
            kicker = repetitionsPerRating.entrySet().stream()
                    .filter(e -> e.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .findFirst().get();
        }
    }
}