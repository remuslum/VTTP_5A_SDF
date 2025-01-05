package src.main.java.project3.card;

public enum Suits {
    CLUBS("Clubs"), 
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMOND("Diamond");

    private final String suitName;

    Suits(String suitName) {
        this.suitName = suitName;
    }

    public String getSuitName() {
        return this.suitName;
    }

}
