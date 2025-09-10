import cards.*;
import java.util.ArrayList;

public class Player {
    private String color;
    ArrayList<Card> playHand;
    private int points;

    public Player(String color) {
        this.color = color;
        this.playHand = new ArrayList<>();
        this.points = 0;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<Card> getPlayHand() {
        return playHand;
    }

    public ArrayList<Card> addCardToHand(Card card) {
        playHand.add(card);
        return playHand;
    }
}