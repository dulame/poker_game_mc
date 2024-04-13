package components;

import components.cards.Card;
import logic.Combination;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final ArrayList<Card> cards;
    private Combination combination;

    public void setCombination(Combination combination) {
        this.combination = combination;
    }

    public Combination getCombination() {
        return combination;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Player(String name) {
        this.name = name;
        combination = null;
        cards = new ArrayList<>();
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return name;
    }
}
