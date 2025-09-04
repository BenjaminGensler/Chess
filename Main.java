import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        Board board = new Board();

        // Adds white/black Pawns
        for(int i = 0; i < 8; i++) {
            board.placePiece(6, i, new Pawn("black"));
            board.placePiece(1, i, new Pawn("white"));
        }

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

            System.out.println("Main Loop 3");

            // Simulate a move
            board.movePiece(fromX, fromY, toX, toY);

            // System.out.println("Main Loop 4");

            board.printBoard();
        }
    }
}