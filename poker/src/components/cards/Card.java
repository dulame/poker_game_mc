package components.cards;

public class Card implements Comparable<Card> {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public int getNumericValue() {
        return value.getValue();
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(value.getValue(), o.getNumericValue());
    }
}
