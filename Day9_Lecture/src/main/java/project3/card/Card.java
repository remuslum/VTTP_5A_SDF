package src.main.java.project3.card;

public class Card {
    private final Suits suit;
    private final Rank rank;

    public Card(Suits suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    
}
