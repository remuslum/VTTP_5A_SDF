package src.main.java.project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.main.java.project3.card.Card;
import src.main.java.project3.card.Rank;
import src.main.java.project3.card.Suits;

public class Task3 {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        for(Suits suit:Suits.values()){
            for(Rank rank:Rank.values()){
                deck.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(deck);

        for(Card card:deck) {
            System.out.println(card.getSuit().getSuitName() + " " + card.getRank().getRankName());
        }
    }
}
