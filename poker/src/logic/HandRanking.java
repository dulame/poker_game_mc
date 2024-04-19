package logic;

public enum HandRanking {
    ROYAL_FLUSH {
        @Override
        public String toString() {
            return "Royal Flush";
        }
    },
    STRAIGHT_FLUSH {
        @Override
        public String toString() {
            return "Straight Flush";
        }
    },
    FOUR {
        @Override
        public String toString() {
            return "Four Of Kind";
        }
    },
    FULL_HOUSE {
        @Override
        public String toString() {
            return "Full House";
        }
    },
    FLUSH {
        @Override
        public String toString() {
            return "Flush";
        }
    },
    STRAIGHT {
        @Override
        public String toString() {
            return "Straight";
        }
    },
    THREE {
        @Override
        public String toString() {
            return "Three Of Kind";
        }
    },
    TWO_PAIR {
        @Override
        public String toString() {
            return "Two Pairs";
        }
    },
    PAIR {
        @Override
        public String toString() {
            return "Pair";
        }
    },
    HIGH {
        @Override
        public String toString() {
            return "Highest Card";
        }
    }
}
