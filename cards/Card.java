package cards;
import board.*;

public class Card {
    private String description;
    private String type;

    public Card(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    // Function that plays the card (to be overridden by subclasses)
    public void playCard(Board board) {
        return;
    }
}