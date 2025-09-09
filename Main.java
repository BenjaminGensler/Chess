import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        Board board = new Board();

        Card[] deck = {
            new PawnUpgrade()
        };

        ArrayList<Card> play1Hand = new ArrayList<>();
        ArrayList<Card> play2Hand = new ArrayList<>();

        play1Hand.add(deck[0]);

        // // Adds white/black Pawns
        // for(int i = 0; i < 8; i++) {
        //     board.placePiece(6, i, new Pawn("black"));
        //     board.placePiece(1, i, new Pawn("white"));
        // }

        // // Adds Rooks
        // board.placePiece(0, 0, new Rook("white"));
        // board.placePiece(0, 7, new Rook("white"));
        // board.placePiece(7, 0, new Rook("black"));
        // board.placePiece(7, 7, new Rook("black"));

        // // Add Knights
        // board.placePiece(0, 1, new Knight("white"));
        // board.placePiece(0, 6, new Knight("white"));
        // board.placePiece(7, 1, new Knight("black"));
        // board.placePiece(7, 6, new Knight("black"));

        // // Add Bishops
        // board.placePiece(0, 2, new Bishop("white"));
        // board.placePiece(0, 5, new Bishop("white"));
        // board.placePiece(7, 2, new Bishop("black"));
        // board.placePiece(7, 5, new Bishop("black"));

        // //Add Queens
        // board.placePiece(0, 3, new Queen("white"));
        // board.placePiece(7, 3, new Queen("black"));

        // //Add Kings
        // board.placePiece(0, 4, new King("white"));
        // board.placePiece(7, 4, new King("black"));

        // Checkmate testing setup
        board.placePiece(0, 0, new King("white"));
        board.placePiece(1, 2, new Rook("black"));
        board.placePiece(2, 3, new Rook("black"));
        board.placePiece(7, 7, new King("black"));
        board.placePiece(6, 5, new Pawn("white"));
        board.placePiece(1, 4, new Pawn("black"));

        board.printBoard();

        while(true) {
            // System.out.println("Main Loop 1");
            // Prompt for and read a string
            System.out.print("Enter your next move: ");
            String userMove = scanner.nextLine();

            // System.out.println("Main Loop 2");

            //convert move to function correct input
            int fromY = (int) userMove.charAt(0) - 'a';
            int fromX = Character.getNumericValue(userMove.charAt(1)) - 1;
            int toY = (int) userMove.charAt(2) - 'a';
            int toX = Character.getNumericValue(userMove.charAt(3)) - 1;

            // System.out.println("Main Loop 3");

            Piece movingPiece = board.getPiece(fromX, fromY);
            if (!movingPiece.getColor().equals(board.currentPlayer)) {
                System.out.println("It is " + board.currentPlayer + "'s turn.");
                continue;
            }

            // Simulate a move
            board.movePiece(fromX, fromY, toX, toY);

            // System.out.println("Main Loop 4");

            board.printBoard();

            System.out.println("Current Player: " + board.currentPlayer);
        }
    }
}