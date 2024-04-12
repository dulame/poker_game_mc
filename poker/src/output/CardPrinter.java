package output;

import components.Player;
import components.cards.Card;

import java.util.ArrayList;

public class CardPrinter {
    public static void printPlayersCards(Player player) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("┌───────────┐\t┌───────────┐\n");
        stringBuilder.append("│ ").append(player.getCards().get(0).getValue()).append("       │\t");
        stringBuilder.append("│ ").append(player.getCards().get(1).getValue()).append("       │\n");
        stringBuilder.append("│         │\t│         │\n");
        stringBuilder.append("│ ").append(player.getCards().get(0).getSuit()).append("       │\t");
        stringBuilder.append("│ ").append(player.getCards().get(1).getSuit()).append("       │\n");
        stringBuilder.append("│         │\t│         │\n");
        stringBuilder.append("│       ").append(player.getCards().get(0).getValue()).append(" │\t");
        stringBuilder.append("│       ").append(player.getCards().get(1).getValue()).append(" │\n");
        stringBuilder.append("└─────────┘");

        System.out.println(stringBuilder);
    }

    public static void printCardsList(ArrayList<Card> cards) {
        int n = cards.size();

        // print top
        for (int i = 0; i < n; ++i) {
            System.out.print("┌─────────┐   ");
        }
        System.out.println();

        // print rank
        for (Card card: cards) {
            System.out.printf("│ %4s    │   ", card.getValue());
        }
        System.out.println();

        for (int i = 0; i < n; ++i) {
            System.out.print("│         │   ");
        }
        System.out.println();

        // print suit
        for (Card card: cards) {
            System.out.printf("│    %s    │   ", card.getSuit());
        }
        System.out.println();

        for (int i = 0; i < n; ++i) {
            System.out.print("│         │   ");
        }
        System.out.println();

        // print rank
        for (Card card: cards) {
            System.out.printf("│    %4s │   ", card.getRank());
        }
        System.out.println();

        // print bottom
        for (int i = 0; i < n; ++i) {
            System.out.print("└─────────┘   ");
        }
        System.out.println();
    }
}
