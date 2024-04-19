package logic;

import components.Player;

import java.util.Arrays;
import java.util.List;

public class Compare {
    public static void compare(Player ... players) {
        List<Player> list = Arrays.asList(players);
        list.sort(new PlayerComparator());

        System.out.println(list.get(list.size() - 1).getName() + " have won!");
    }
}
