package logic;

import components.cards.Card;
import components.cards.Value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

public class CombinationCheck {
    public static Combination getCombination(ArrayList<Card> playerCards, ArrayList<Card> dealerCards) {
        ArrayList<Card> cards = new java.util.ArrayList<>(Stream.of(playerCards, dealerCards)
                .flatMap(Collection::stream)
                .toList());

        Collections.sort(cards);

        if (royalFlush(cards)) return new Combination(HandRanking.ROYAL_FLUSH, cards.get(4));
        if (straightFlush(cards)) return new Combination(HandRanking.STRAIGHT_FLUSH, cards.get(4));
        if (fourOfKind(cards) != null) return fourOfKind(cards);
        if (fullHouse(cards) != null) return fullHouse(cards);
        if (checkFlush(cards)) return new Combination(HandRanking.FLUSH, cards.get(4));
        if (checkStraight(cards)) return new Combination(HandRanking.STRAIGHT, cards.get(4));
        if (threeOfKind(cards) != null) return threeOfKind(cards);
        if (twoPairs(cards) != null) return twoPairs(cards);
        if (pair(cards) != null) return pair(cards);

        return new Combination(HandRanking.HIGH, cards.get(4));
    }

    private static boolean royalFlush(ArrayList<Card> cards) {
        return cards.get(cards.size() - 1).getValue() == Value.ACE && straightFlush(cards);
    }

    private static boolean straightFlush(ArrayList<Card> cards) {
        return checkFlush(cards) && checkStraight(cards);
    }

    private static boolean checkStraight(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size() - 1; ++i) {
            if (cards.get(i).getNumericValue() + 1 != cards.get(i + 1).getNumericValue()) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkFlush(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size() - 1; ++i) {
            if (cards.get(i).getSuit() != cards.get(i + 1).getSuit()) {
                return false;
            }
        }
        return true;
    }

    private static Combination fourOfKind(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>();

        for (int i = 0; i < 2; ++i) {
            for (int j = i + 1; j < cards.size(); ++j) {
                if (cards.get(i).getValue() == cards.get(j).getValue()) {
                    if (temp.size() == 0) temp.add(cards.get(i));

                    temp.add(cards.get(j));
                } else {
                    if (temp.size() == 4) {
                        return new Combination(HandRanking.FOUR, cards.get(i));
                    } else return null;
                }
            }
        }

        return null;
    }

    private static Combination fullHouse(ArrayList<Card> cards) {
        if (cards.get(0) != cards.get(1)) return null;
        if (cards.get(2) == cards.get(3) && cards.get(3) == cards.get(4)) {
            return new Combination(HandRanking.FULL_HOUSE, cards.get(4));
        }
        return null;
    }

    private static Combination threeOfKind(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {
            for (int j = i + 1; j < cards.size(); ++j) {
                if (cards.get(i).getValue() == cards.get(j).getValue()) {
                    if (temp.size() == 0) temp.add(cards.get(i));

                    temp.add(cards.get(j));
                } else {
                    if (temp.size() == 3) {
                        return new Combination(HandRanking.THREE, cards.get(i));
                    } else return null;
                }
            }
        }

        return null;
    }

    private static Combination twoPairs(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>();

        for (int i = 0; i < cards.size() - 1; ++i) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue()) {
                temp.add(cards.get(i));
                temp.add(cards.get(i + 1));
                i++;
            }
        }

        if (temp.size() == 4) return new Combination(HandRanking.TWO_PAIR, temp.get(3));
        return null;
    }

    private static Combination pair(ArrayList<Card> cards) {
        Card highest = null;
        boolean res = false;

        for (int i = 0; i < cards.size() - 1; ++i) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue()) {
                res = true;
                highest = cards.get(i);
                break;
            }
        }

        if (res) return new Combination(HandRanking.PAIR, highest);
        return null;
    }
}
