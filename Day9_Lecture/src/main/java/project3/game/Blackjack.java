package src.main.java.project3.game;

import java.io.Console;
import java.util.Collections;
import java.util.List;
import src.main.java.project3.card.Card;
import src.main.java.project3.player.Banker;
import src.main.java.project3.player.Player;

public class Blackjack {
    private List<Card> deck;
    private final Player player;
    private final Banker banker;

    public Blackjack(List<Card> deck, Player player, Banker banker) {
        this.deck = deck;
        this.player = player;
        this.banker = banker;
    }

    public Player getPlayer() {
        return player;
    }

    public Banker getBanker() {
        return banker;
    }

    public String runGame() {
        Console console = System.console();
        String userInput = "";
        Collections.shuffle(this.deck);
        dealHand();
        if(!this.banker.run()) {
            System.out.println("Player points: " + this.player.getPlayerPoints());
            while(this.player.getHand().size() < 5){
                userInput = console.readLine("Would you like an extra card? \n");
                if(userInput.equals("N")) {
                    break;
                }
                if(userInput.equals("Y")) {
                    drawCardFromDeck(this.player);
                    System.out.println("Player points: " + this.player.getPlayerPoints());
                }
            }
            System.out.println("Determining winner");
            while(this.banker.getHand().size() < 5){
                if (this.banker.getPlayerPoints() > 16 && this.banker.getPlayerPoints() < 22){
                    break;
                }
                drawCardFromDeck(this.banker);
            }
            System.out.println("Banker points: " + banker.getPlayerPoints());
            determineWinner();
        }
        return console.readLine("Would you like to continue? (Y/N)");
    }

    private void dealHand(){
        int j = 0;
        for(int i  = 0; i < 3; i = i+2){
            j = i+1;
            this.player.draw(deck.get(i));
            this.banker.draw(deck.get(j));
        }
        this.deck = this.deck.subList(j+1, this.deck.size());
    }

    private void drawCardFromDeck(Player player) {
        player.draw(this.deck.get(0));
        this.deck = this.deck.subList(1, this.deck.size());
    }

    private void determineWinner(){
        if(this.banker.getPlayerPoints() > 21){
            System.out.println("Player has won!");
        } else if (this.player.getPlayerPoints() > 21) {
            System.out.println("Banker has won!");
        } else if (this.player.getPlayerPoints() > this.banker.getPlayerPoints()){
            System.out.println("Player has won!");
        } else {
            System.out.println("Banker has won!");
        }
    }

    
}
