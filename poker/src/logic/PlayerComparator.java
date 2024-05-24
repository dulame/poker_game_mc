package logic;

import components.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getCombination().getHandRanking().ordinal() < o2.getCombination().getHandRanking().ordinal()) {
            return 1;
        } else if (o1.getCombination().getHandRanking().ordinal() > o2.getCombination().getHandRanking().ordinal()) {
            return -1;
        } else {
            return o1.getCombination().getHighestCard().compareTo(o2.getCombination().getHighestCard());
        }
    }
}
