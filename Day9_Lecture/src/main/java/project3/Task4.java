package src.main.java.project3;

import java.util.ArrayList;
import java.util.List;
import src.main.java.project3.card.Card;
import src.main.java.project3.card.Rank;
import src.main.java.project3.card.Suits;
import src.main.java.project3.game.Blackjack;
import src.main.java.project3.player.Banker;
import src.main.java.project3.player.Player;

public class Task4 {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        for(Suits suit:Suits.values()){
            for(Rank rank:Rank.values()){
                deck.add(new Card(suit, rank));
            }
        }

        String continueGame = "";
        while (!continueGame.equals("N")) {
            System.out.println("Welcome to Blackjack!");
            Player player = new Player(new ArrayList<>());
            Banker banker = new Banker(new ArrayList<>());
            Blackjack blackjack = new Blackjack(deck, player, banker);
            continueGame = blackjack.runGame();
        }
        System.out.println("Thanks for playing!");
    }
}
