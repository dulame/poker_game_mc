package logic;

import components.cards.Card;
import components.cards.Value;

import java.util.*;
import java.util.stream.Stream;

public class CombinationCheck {
    public static Combination getCombination(ArrayList<Card> playerCards, ArrayList<Card> dealerCards) {
        ArrayList<Card> cards = new java.util.ArrayList<>(Stream.of(playerCards, dealerCards)
                .flatMap(Collection::stream)
                .toList());

        Collections.sort(cards);
        Map<Value, Integer> countRank = getRankCount(cards);

        if (royalFlush(cards)) return new Combination(HandRanking.ROYAL_FLUSH, cards.get(4));

        if (straightFlush(cards)) return new Combination(HandRanking.STRAIGHT_FLUSH, cards.get(4));

        if (checkFourOfKind(countRank)) {
            for (Card card: cards) {
                if (countRank.get(card.getValue()) == 4) {
                    return new Combination(HandRanking.FOUR, card);
                }
            }
        }

        if (checkFullHouse(countRank)) {
            for (Card card: cards) {
                if (countRank.get(card.getValue()) == 3) {
                    return new Combination(HandRanking.FULL_HOUSE, card);
                }
            }
        }

        if (checkFlush(cards)) {
            return new Combination(HandRanking.FLUSH, cards.get(4));
        }

        if (checkStraight(cards)) {
            return new Combination(HandRanking.STRAIGHT, cards.get(4));
        }

        if (checkThreeOfKind(countRank)) {
            for (Card card: cards) {
                if (countRank.get(card.getValue()) == 3) {
                    return new Combination(HandRanking.THREE, card);
                }
            }
        }

        if (checkTwoPairs(countRank)) {
            Card highest = null;

            for (Card card: cards) {
                if (countRank.get(card.getValue()) == 2) {
                    if (highest == null) highest = card;
                    else {
                        highest = (highest.getNumericValue() > card.getNumericValue() ? highest : card);
                        return new Combination(HandRanking.TWO_PAIR, highest);
                    }
                }
            }
        }

        if (checkPair(countRank)) {
            for (Card card: cards) {
                if (countRank.get(card.getValue()) == 2) {
                    return new Combination(HandRanking.PAIR, card);
                }
            }
        }

        return new Combination(HandRanking.HIGH, cards.get(4));
    }

    private static boolean royalFlush(ArrayList<Card> cards) {
        return cards.get(cards.size() - 1).getValue() == Value.ACE && straightFlush(cards);
    }

    private static boolean straightFlush(ArrayList<Card> cards) {
        return checkFlush(cards) && checkStraight(cards);
    }

    private static boolean checkFourOfKind(Map<Value, Integer> countRank) {
        for (int count: countRank.values()) {
            if (count == 4) return true;
        }
        return false;
    }

    private static boolean checkFullHouse(Map<Value, Integer> countRank) {
        boolean isThree = false, isPair = false;

        for (int count : countRank.values()) {
            if (count == 3) {
                isThree = true;
            } else if (count == 2) {
                isPair = true;
            }
        }

        return isPair && isThree;
    }

    private static boolean checkFlush(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size() - 1; ++i) {
            if (cards.get(i).getSuit() != cards.get(i + 1).getSuit()) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkStraight(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size() - 1; ++i) {
            if (cards.get(i).getNumericValue() + 1 != cards.get(i + 1).getNumericValue()) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkThreeOfKind(Map<Value, Integer> countRank) {
        for (int count : countRank.values()) {
            if (count == 3) return true;
        }
        return false;
    }

    private static boolean checkTwoPairs(Map<Value, Integer> countRank) {
        int pairCount = 0;

        for (int count : countRank.values()) {
            if (count == 2) pairCount++;
        }

        return pairCount == 2;
    }

    private static boolean checkPair(Map<Value, Integer> countRank) {
        for (int count : countRank.values()) {
            if (count == 2) return true;
        }
        return false;
    }

    private static Map<Value, Integer> getRankCount(ArrayList<Card> cards) {
        Map<Value, Integer> rankCount = new HashMap<>();

        for (Card card : cards) {
            rankCount.put(card.getValue(), rankCount.getOrDefault(card.getValue(), 0) + 1);
        }

        return rankCount;
    }
}
