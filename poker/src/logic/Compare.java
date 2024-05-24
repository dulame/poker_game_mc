package logic;

import components.Player;

import java.util.Arrays;
import java.util.List;

public class Compare {
    public static void comparePlayers(Player ... players) {
        List<Player> list = Arrays.asList(players);
        list.sort(new PlayerComparator());

        System.out.println(list.get(list.size() - 1).getName() + " have won!");
    }

    public static Combination highestCombination(Combination ... combinations) {
        List<Combination> list = Arrays.asList(combinations);
        list.sort(new CombinationComparator());

        return list.get(list.size() - 1);
    }
}
