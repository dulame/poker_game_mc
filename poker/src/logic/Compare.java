package logic;

import components.Player;

public class Compare {
    public static void compare(Player player1, Player player2) {
        Combination combination1 = player1.getCombination();
        Combination combination2 = player2.getCombination();

        if (combination1.getHandRanking().ordinal() < combination2.getHandRanking().ordinal()) {
            System.out.printf("%s won!\n", player1);
        } else if (combination1.getHandRanking().ordinal() > combination2.getHandRanking().ordinal()) {
            System.out.printf("%s won!\n", player2);
        } else {
            if (combination1.getHighestCard().compareTo(combination2.getHighestCard()) > 0) {
                System.out.printf("%s won!\n", player1);
            } else if (combination1.getHighestCard().compareTo(combination2.getHighestCard()) < 0) {
                System.out.printf("%s won!\n", player2);
            } else {
                System.out.println("Draw");
            }
        }
    }
}
