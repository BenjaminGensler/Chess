package cards;
import pieces.*;
import board.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shop {
    // Arrays of available cards in the shop
    private Card[] availableCards = {
        new PawnUpgrade(),
        new PawnUpgrade(),
        new PawnUpgrade(),
        new PawnUpgrade()
    };

    public Shop() {
        // Shuffle the availableCards array at the start
        List<Card> cardList = Arrays.asList(availableCards);
        Collections.shuffle(cardList);
        // If you want to keep availableCards as an array:
        availableCards = cardList.toArray(new Card[0]);
    }

    public void displayShop() {
        System.out.println("Welcome to the Shop! Here are the available cards:");
        int count = 1;
        for (int i = 0; i < availableCards.length && count <= 3; i++) {
            if (availableCards[i] != null) {
                System.out.println(count + ". " + availableCards[i].getType() + ": " + availableCards[i].getDescription());
                count++;
            }
        }
    }

    public Card buyCard(int choice) {
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice. Please select a valid card number.");
            return null;
        }
        Card purchasedCard = availableCards[choice - 1];
        System.out.println("You purchased: " + purchasedCard.getType());
        // Remove the card from the available cards
        availableCards[choice - 1] = null;
        return purchasedCard;
    }

}