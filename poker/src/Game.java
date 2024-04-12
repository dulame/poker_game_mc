import components.Deck;
import components.Player;
import logic.CombinationCheck;
import output.CardPrinter;

public class Game {
    private Deck deck;
    private boolean onGame;

    public Game() {
        onGame = true;
        deck = new Deck();
        deck.createCards();
    }

    public void run() {
        deck.shuffle();

        System.out.println(deck);
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player dealer = new Player("dealer");

        deck.deal(player1);
        deck.deal(player1);
        deck.deal(player2);
        deck.deal(player2);
        deck.deal(player3);
        deck.deal(player3);
        deck.deal(dealer);
        deck.deal(dealer);
        deck.deal(dealer);

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(dealer);

        player1.setCombination(CombinationCheck.getCombination(player1.getCards(), dealer.getCards()));
        player2.setCombination(CombinationCheck.getCombination(player2.getCards(), dealer.getCards()));
        player3.setCombination(CombinationCheck.getCombination(player3.getCards(), dealer.getCards()));

        System.out.println(player1.getCombination());
        System.out.println(player2.getCombination());
        System.out.println(player3.getCombination());

        CardPrinter.printPlayersCards(player1);
        CardPrinter.printPlayersCards(player2);
        CardPrinter.printPlayersCards(player3);

    }
}
