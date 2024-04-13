package output;

import components.cards.Card;

import java.util.ArrayList;

public class CardPrinter {

    public static void printCardsList(ArrayList<Card> cards) {
        int n = cards.size();

        // print top
        for (int i = 0; i < n; ++i) {
            System.out.print("┌───────────┐   ");
        }
        System.out.println();

        // print value
        for (Card card: cards) {
            System.out.printf("│ %2s        │   ", card.getValue());
        }
        System.out.println();

        for (int i = 0; i < n; ++i) {
            System.out.print("│           │   ");
        }
        System.out.println();

        // print suit
        for (Card card: cards) {
            System.out.printf("│  %7s  │   ", card.getSuit());
        }
        System.out.println();

        for (int i = 0; i < n; ++i) {
            System.out.print("│           │   ");
        }
        System.out.println();

        // print value
        for (Card card: cards) {
            System.out.printf("│       %2s  │   ", card.getValue());
        }
        System.out.println();

        // print bottom
        for (int i = 0; i < n; ++i) {
            System.out.print("└───────────┘   ");
        }
        System.out.println();
    }

    public static void newBatch() {
        System.out.println("------------------------------------------------------------------------------");
    }
}
