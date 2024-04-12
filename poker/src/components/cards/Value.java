package components.cards;

public enum Value {
    TWO(2) {
        @Override
        public String toString() {
            return "2";
        }
    },
    THREE(3) {
        @Override
        public String toString() {
            return "3";
        }
    },
    FOUR(4) {
        @Override
        public String toString() {
            return "4";
        }
    },
    FIVE(5) {
        @Override
        public String toString() {
            return "5";
        }
    },
    SIX(6) {
        @Override
        public String toString() {
            return "6";
        }
    },
    SEVEN(7) {
        @Override
        public String toString() {
            return "7";
        }
    },
    EIGHT(8) {
        @Override
        public String toString() {
            return "8";
        }
    },
    NINE(9) {
        @Override
        public String toString() {
            return "9";
        }
    },
    TEN(10) {
        @Override
        public String toString() {
            return "10";
        }
    },
    JACK(11) {
        @Override
        public String toString() {
            return "J";
        }
    },
    QUEEN(12) {
        @Override
        public String toString() {
            return "Q";
        }
    },
    KING(13) {
        @Override
        public String toString() {
            return "K";
        }
    },
    ACE(14) {
        @Override
        public String toString() {
            return "A";
        }
    };

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
