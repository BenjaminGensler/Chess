public class Card {
    private String description;
    private String title;

    public Card(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Function that plays the card (to be overridden by subclasses)
    public void playCard() {
        return;
    }
}