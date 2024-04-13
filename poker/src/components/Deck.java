package components;

import components.cards.Card;
import components.cards.Suit;
import components.cards.Value;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    Stack<Card> cards;

    public void createCards() {
        cards = new Stack<>();

        for (Suit suit: new Suit[]{Suit.CLUB, Suit.DIAMOND, Suit.SPADE, Suit.HEART}) {
            cards.push(new Card(suit, Value.THREE));
            cards.push(new Card(suit, Value.TWO));
            cards.push(new Card(suit, Value.FOUR));
            cards.push(new Card(suit, Value.FIVE));
            cards.push(new Card(suit, Value.SIX));
            cards.push(new Card(suit, Value.SEVEN));
            cards.push(new Card(suit, Value.EIGHT));
            cards.push(new Card(suit, Value.NINE));
            cards.push(new Card(suit, Value.TEN));
            cards.push(new Card(suit, Value.JACK));
            cards.push(new Card(suit, Value.QUEEN));
            cards.push(new Card(suit, Value.KING));
            cards.push(new Card(suit, Value.ACE));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void deal(Player player) {
        player.receiveCard(cards.pop());
    }

    public void deal(Player player, int n) {
        for (int i = 0; i < n; ++i)
            player.receiveCard(cards.pop());
    }

    @Override
    public String toString() {
        return "components.Deck{" +
                "components.cards=" + cards +
                '}';
    }
}
