public class Main {
    public static void main(String[] args) {
        CardDeck cardDeck = new CardDeck();

        cardDeck.createCards();
        System.out.println(cardDeck);
        cardDeck.shuffle();
        System.out.println(cardDeck);
    }
}