package logic;

import components.cards.Card;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combination that = (Combination) o;
        return handRanking == that.handRanking && Objects.equals(highestCard, that.highestCard);
    }

    @Override
    public String toString() {
        return handRanking.toString();
    }
}
