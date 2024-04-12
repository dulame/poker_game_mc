package logic;

import components.cards.Card;

public class Combination implements Comparable<Combination> {
    private final HandRanking handRanking;
    private final Card highestCard;

    public Combination(HandRanking handRanking, Card highestCard) {
        this.handRanking = handRanking;
        this.highestCard = highestCard;
    }

    public HandRanking getHandRanking() {
        return handRanking;
    }

    public Card getHighestCard() {
        return highestCard;
    }

    @Override
    public int compareTo(Combination o) {
        if (handRanking.getValue() > o.getHandRanking().getValue()) {
            return 1;
        } else if (handRanking.getValue() < o.getHandRanking().getValue()) {
            return -1;
        }

        return Integer.compare(highestCard.getNumericValue(),
                o.getHighestCard().getNumericValue());
    }

    @Override
    public String toString() {
        return "Combination{" +
                "handRanking=" + handRanking +
                ", highestCard=" + highestCard +
                '}';
    }
}
