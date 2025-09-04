public class Knight extends Piece {
    public Knight(String color) {
        super(color, "Knight");
    }

    // Knights can move forward one square, or two squares from their starting position
    public boolean isLegalMove(int fromX, int fromY, int toX, int toY, Board board) {
        
        // move in "L" shape
        if(board.getPiece(toX, toY) == null || !board.getPiece(toX, toY).getColor().equals(board.getPiece(fromX, fromY).getColor())){
            if((fromX == toX -1 || fromX == toX + 1) && (fromY == toY - 2 || fromY == toY + 2)){
                return true;
            }
            else if((fromX == toX -2 || fromX == toX + 2) && (fromY == toY - 1 || fromY == toY + 1)){
                return true;
            }
        }

        return false;
    }
    
}