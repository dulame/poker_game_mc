package logic;

import java.util.Comparator;

public class CombinationComparator implements Comparator<Combination> {
    @Override
    public int compare(Combination o1, Combination o2) {
        if (o1.getHandRanking().ordinal() < o2.getHandRanking().ordinal()) {
            return 1;
        } else if (o1.getHandRanking().ordinal() > o2.getHandRanking().ordinal()) {
            return -1;
        } else {
            return o1.getHighestCard().compareTo(o2.getHighestCard());
        }
    }
}
