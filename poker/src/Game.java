public class Game {
    private CardDeck cardDeck;
    private boolean onGame;

    public Game() {
        onGame = true;
        cardDeck = new CardDeck();
        cardDeck.createCards();
    }

    public void run() {
        cardDeck.shuffle();

        while (onGame) {

        }
    }
}
