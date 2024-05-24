package test;

import components.cards.Card;
import components.cards.Suit;
import components.cards.Value;
import logic.Combination;
import logic.CombinationCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CombinationCheckTest {
    private ArrayList<Card> cards;
    private ArrayList<Card> dealerCards;

    @BeforeEach
    void setUp() {
        cards = new ArrayList<>();
        dealerCards = new ArrayList<>();
    }

    @Test
    void getCombination_royalFlush() {
        dealerCards.add(new Card(Suit.CLUB, Value.ACE));
        dealerCards.add(new Card(Suit.CLUB, Value.KING));
        dealerCards.add(new Card(Suit.CLUB, Value.QUEEN));
        dealerCards.add(new Card(Suit.CLUB, Value.NINE));
        dealerCards.add(new Card(Suit.CLUB, Value.EIGHT));

        cards.add(new Card(Suit.CLUB, Value.JACK));
        cards.add(new Card(Suit.CLUB, Value.TEN));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Royal Flush", combination.toString());
    }

    @Test
    void getCombination_straightFlush() {
        dealerCards.add(new Card(Suit.HEART, Value.FIVE));
        dealerCards.add(new Card(Suit.HEART, Value.FOUR));
        dealerCards.add(new Card(Suit.HEART, Value.THREE));
        dealerCards.add(new Card(Suit.DIAMOND, Value.ACE));
        dealerCards.add(new Card(Suit.SPADE, Value.KING));

        cards.add(new Card(Suit.HEART, Value.SIX));
        cards.add(new Card(Suit.HEART, Value.SEVEN));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Straight Flush", combination.toString());
    }

    @Test
    void getCombination_fourOfKind() {
        dealerCards.add(new Card(Suit.HEART, Value.FIVE));
        dealerCards.add(new Card(Suit.DIAMOND, Value.FIVE));
        dealerCards.add(new Card(Suit.SPADE, Value.ACE));
        dealerCards.add(new Card(Suit.CLUB, Value.KING));
        dealerCards.add(new Card(Suit.DIAMOND, Value.JACK));

        cards.add(new Card(Suit.CLUB, Value.FIVE));
        cards.add(new Card(Suit.SPADE, Value.FIVE));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Four Of Kind", combination.toString());
    }

    @Test
    void getCombination_fullHouse() {
        cards.add(new Card(Suit.HEART, Value.SIX));
        cards.add(new Card(Suit.DIAMOND, Value.SIX));

        dealerCards.add(new Card(Suit.CLUB, Value.SIX));
        dealerCards.add(new Card(Suit.SPADE, Value.KING));
        dealerCards.add(new Card(Suit.HEART, Value.KING));
        dealerCards.add(new Card(Suit.CLUB, Value.THREE));
        dealerCards.add(new Card(Suit.DIAMOND, Value.FOUR));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Full House", combination.toString());
    }

    @Test
    void getCombination_flush() {
        cards.add(new Card(Suit.SPADE, Value.TWO));
        cards.add(new Card(Suit.SPADE, Value.FIVE));

        dealerCards.add(new Card(Suit.SPADE, Value.EIGHT));
        dealerCards.add(new Card(Suit.SPADE, Value.JACK));
        dealerCards.add(new Card(Suit.SPADE, Value.KING));
        dealerCards.add(new Card(Suit.CLUB, Value.THREE));
        dealerCards.add(new Card(Suit.DIAMOND, Value.FOUR));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Flush", combination.toString());
    }

    @Test
    public void getCombination_straight() {
        cards.add(new Card(Suit.SPADE, Value.SEVEN));
        cards.add(new Card(Suit.HEART, Value.EIGHT));

        dealerCards.add(new Card(Suit.HEART, Value.FOUR));
        dealerCards.add(new Card(Suit.CLUB, Value.FIVE));
        dealerCards.add(new Card(Suit.DIAMOND, Value.SIX));
        dealerCards.add(new Card(Suit.CLUB, Value.NINE));
        dealerCards.add(new Card(Suit.DIAMOND, Value.TEN));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Straight", combination.toString());
    }

    @Test
    public void getCombination_threeOfKind() {
        cards.add(new Card(Suit.HEART, Value.SEVEN));
        cards.add(new Card(Suit.DIAMOND, Value.SEVEN));

        dealerCards.add(new Card(Suit.CLUB, Value.SEVEN));
        dealerCards.add(new Card(Suit.SPADE, Value.NINE));
        dealerCards.add(new Card(Suit.HEART, Value.JACK));
        dealerCards.add(new Card(Suit.CLUB, Value.TWO));
        dealerCards.add(new Card(Suit.DIAMOND, Value.THREE));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Three Of Kind", combination.toString());
    }

    @Test
    public void getCombination_twoPairs() {
        cards.add(new Card(Suit.HEART, Value.EIGHT));
        cards.add(new Card(Suit.DIAMOND, Value.QUEEN));

        dealerCards.add(new Card(Suit.CLUB, Value.EIGHT));
        dealerCards.add(new Card(Suit.SPADE, Value.QUEEN));
        dealerCards.add(new Card(Suit.HEART, Value.FOUR));
        dealerCards.add(new Card(Suit.CLUB, Value.TWO));
        dealerCards.add(new Card(Suit.DIAMOND, Value.THREE));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Two Pairs", combination.toString());
    }

    @Test
    public void getCombination_pair() {
        cards.add(new Card(Suit.HEART, Value.THREE));
        cards.add(new Card(Suit.DIAMOND, Value.THREE));

        dealerCards.add(new Card(Suit.CLUB, Value.SIX));
        dealerCards.add(new Card(Suit.SPADE, Value.NINE));
        dealerCards.add(new Card(Suit.HEART, Value.KING));
        dealerCards.add(new Card(Suit.CLUB, Value.TWO));
        dealerCards.add(new Card(Suit.DIAMOND, Value.FOUR));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Pair", combination.toString());
    }

    @Test
    public void getCombination_weakHandWithoutDealers() {
        cards.add(new Card(Suit.DIAMOND, Value.TWO));
        cards.add(new Card(Suit.DIAMOND, Value.THREE));

        dealerCards.add(new Card(Suit.HEART, Value.EIGHT));
        dealerCards.add(new Card(Suit.SPADE, Value.EIGHT));
        dealerCards.add(new Card(Suit.SPADE, Value.TEN));
        dealerCards.add(new Card(Suit.CLUB, Value.ACE));
        dealerCards.add(new Card(Suit.DIAMOND, Value.QUEEN));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("Highest Card", combination.toString());
    }

    @Test
    public void error() {
        cards.add(new Card(Suit.SPADE, Value.EIGHT));
        dealerCards.add(new Card(Suit.DIAMOND, Value.FIVE));

        Combination combination = CombinationCheck.getCombination(cards, dealerCards);

        Assertions.assertEquals("ERROR", combination.toString());
    }
}
