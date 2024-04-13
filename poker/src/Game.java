import components.Deck;
import components.Player;
import logic.CombinationCheck;
import logic.Compare;
import output.CardPrinter;
import output.PlayerInfoPrinter;

import java.util.Scanner;

public class Game {
    private boolean onGame;
    private Scanner sc;

    public Game() {
        onGame = true;
    }

    public void run() {
        sc = new Scanner(System.in);

        newBatch();
        while (onGame) {
            System.out.println("Do you want to continue? (yes / no)");
            String ans = sc.nextLine();

            switch (ans) {
                case "yes" -> newBatch();
                case "no" -> onGame = false;
                default -> System.out.println("Invalid command");
            }
        }
    }

    private void newBatch() {
        Player dealer = new Player("Dealer");
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        Deck deck = new Deck();
        deck.createCards();
        deck.shuffle();

        deck.deal(dealer, 3);
        deck.deal(player1, 2);
        deck.deal(player2, 2);

        player1.setCombination(CombinationCheck.getCombination(player1.getCards(), dealer.getCards()));
        player2.setCombination(CombinationCheck.getCombination(player2.getCards(), dealer.getCards()));

        PlayerInfoPrinter.playerInfoPrinter(dealer);

        PlayerInfoPrinter.playerInfoPrinter(player1);
        PlayerInfoPrinter.playerCombinationPrinter(player1);

        PlayerInfoPrinter.playerInfoPrinter(player2);
        PlayerInfoPrinter.playerCombinationPrinter(player2);

        Compare.compare(player1, player2);

        CardPrinter.newBatch();
    }
}
