package logic;

import components.cards.Card;

public class Combination {
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
    public String toString() {
        return handRanking.toString();
    }
}
