import cards.*;
import java.util.ArrayList;

public class Player {
    private String color;
    ArrayList<Card> playHand;

    public Player(String color) {
        this.color = color;
        this.playHand = new ArrayList<>();
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