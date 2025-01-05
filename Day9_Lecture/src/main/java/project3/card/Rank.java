package src.main.java.project3.card;

public enum Rank {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K");

    private final String rank;

    private Rank(String rank) {
        this.rank = rank;
    }

    public String getRankName() {
        return rank;
    }

}
