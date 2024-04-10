import cards.Card;
import cards.Suit;
import cards.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    List<Card> cards;

    public void createCards() {
        cards = new ArrayList<>();

        for (Suit suit: new Suit[]{Suit.CLUB, Suit.DIAMOND, Suit.SPADE, Suit.HEART}) {
            cards.add(new Card(suit, Value.TWO));
            cards.add(new Card(suit, Value.THREE));
            cards.add(new Card(suit, Value.FOUR));
            cards.add(new Card(suit, Value.FIVE));
            cards.add(new Card(suit, Value.SIX));
            cards.add(new Card(suit, Value.SEVEN));
            cards.add(new Card(suit, Value.EIGHT));
            cards.add(new Card(suit, Value.NINE));
            cards.add(new Card(suit, Value.TEN));
            cards.add(new Card(suit, Value.JACK));
            cards.add(new Card(suit, Value.QUEEN));
            cards.add(new Card(suit, Value.KING));
            cards.add(new Card(suit, Value.ACE));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        return "CardDeck{" +
                "cards=" + cards +
                '}';
    }
}
