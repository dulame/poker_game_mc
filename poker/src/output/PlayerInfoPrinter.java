package output;

import components.Player;

public class PlayerInfoPrinter {
    public static void playerInfoPrinter(Player player) {
        System.out.printf("\n%s cards : \n", player);
        CardPrinter.printCardsList(player.getCards());
    }

    public static void playerCombinationPrinter(Player player) {
        System.out.println(player.getCombination());
        System.out.println();
    }
}
