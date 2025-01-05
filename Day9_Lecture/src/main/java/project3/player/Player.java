package src.main.java.project3.player;

import java.util.List;
import src.main.java.project3.card.Card;

public class Player {
    private final List<Card> hand;

    public Player(List<Card> hand) {
        this.hand = hand;
    }

    public void draw(Card card){
        if(this.hand.size() == 5){
            System.out.println("Your hand is full");
        } else {
            this.hand.add(card);
        }
    }

    public int getPlayerPoints() {
        int totalPoints = 0;
        for(Card card: this.hand){
            if(card.getRank().getRankName().equals("J") || card.getRank().getRankName().equals("Q") || card.getRank().getRankName().equals("K")){
                totalPoints += 10;
            } else {
                totalPoints += Integer.parseInt(card.getRank().getRankName());
            }
        }
        return totalPoints;
    }

    public List<Card> getHand() {
        return this.hand;
    }
}
