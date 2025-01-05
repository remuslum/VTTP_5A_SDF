package src.main.java.project3.player;

import java.util.List;
import src.main.java.project3.card.Card;

public class Banker extends Player{

    public Banker(List<Card> hand) {
        super(hand);
    }
    
    public boolean run() {
        return this.getPlayerPoints() == 15;
    }
}
