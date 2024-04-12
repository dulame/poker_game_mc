package logic;

public enum HandRanking {
    ROYAL_FLUSH(9),
    STRAIGHT_FLUSH(8),
    FOUR(7),
    FULL_HOUSE(6),
    FLUSH(5),
    STRAIGHT(4),
    THREE(3),
    TWO_PAIR(2),
    PAIR(1),
    HIGH(0);

    private final int value;

    HandRanking(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "HandRanking{" +
                "value=" + value +
                '}';
    }
}
