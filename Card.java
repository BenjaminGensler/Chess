public class Card {
    private String description;
    private String type;

    public Card(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getCardType() {
        return type;
    }

    // Function that plays the card (to be overridden by subclasses)
    public void playCard() {
        return;
    }
}