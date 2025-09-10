package pieces;
import board.*;

public class Pawn extends Piece {
    public Pawn(String color) {
        super(color, "Pawn");
    }

    // Pawns can move forward one square, or two squares from their starting position
    public boolean isLegalMove(int fromX, int fromY, int toX, int toY, Board board) {
        
        System.out.println("isLegalMove() 0");
        System.out.println("fromX: " + fromX + " fromY: " + fromY + " toX: " + toX + " toY: " + toY);
        System.out.println("Piece Color: " + board.getPiece(fromX, fromY).getColor());
        System.out.println("Target Piece: " + (board.getPiece(toX, toY) != null ? board.getPiece(toX, toY).getColor() : "none"));

        // //White debugging checks
        // System.out.println("White debugging checks:");
        // System.out.println(board.getPiece(fromX, fromY).getColor().equals("white"));
        // System.out.println((toX == fromX + 1));
        // System.out.println((toX == fromX - 1));
        // System.out.println((toY == fromY));
        // System.out.println(board.getPiece(toX, toY) == null);

        
        // //Black debugging checks
        // System.out.println("Black debugging checks:");
        // System.out.println(board.getPiece(fromX, fromY).getColor().equals("black"));
        // System.out.println((toX == fromX - 1));
        // System.out.println((toY == fromY));
        // System.out.println(board.getPiece(toX, toY) == null);
        
        // Check if 1 space forward is empty
        if((board.getPiece(fromX, fromY).getColor().equals("white") && (toX == fromX + 1) && (toY == fromY) && board.getPiece(fromX, fromY) != null && board.getPiece(toX, toY) == null) ||
           (board.getPiece(fromX, fromY).getColor().equals("black") && (toX == fromX - 1) && (toY == fromY) && board.getPiece(fromX, fromY) != null && board.getPiece(toX, toY) == null)) {
            System.out.println("Pawn isLegalMove() 1");
            return true;
        }

        // Check if 2 spaces forward is empty (space in between must be empty)
        else if((board.getPiece(fromX, fromY).getColor().equals("white") && fromX == 1 && toX == fromX + 2 && toY == fromY && board.getPiece(fromX + 1, fromY) == null && board.getPiece(fromX, fromY) != null && board.getPiece(toX, toY) == null) ||
                (board.getPiece(fromX, fromY).getColor().equals("black") && fromX == 6 && toX == fromX - 2 && toY == fromY && board.getPiece(fromX - 1, fromY) == null && board.getPiece(fromX, fromY) != null && board.getPiece(toX, toY) == null)) {
            System.out.println("Pawn isLegalMove() 2");
            return true;
        }


        // White pawn captures diagonally forward
        if (board.getPiece(fromX, fromY).getColor().equals("white") &&
            toX == fromX + 1 && Math.abs(toY - fromY) == 1 &&
            board.getPiece(toX, toY) != null &&
            !board.getPiece(toX, toY).getColor().equals("white")) {
            System.out.println("Pawn isLegalMove() 3 white");
            return true;
        }

        // Black pawn captures diagonally forward
        if (board.getPiece(fromX, fromY).getColor().equals("black") &&
            toX == fromX - 1 && Math.abs(toY - fromY) == 1 &&
            board.getPiece(toX, toY) != null &&
            !board.getPiece(toX, toY).getColor().equals("black")) {
            System.out.println("Pawn isLegalMove() 3 black");
            return true;
        }

        System.out.println("Pawn isLegalMove() 4");
        return false;
    }
    
}