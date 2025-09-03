public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        board.placePiece(1, 0, new Piece("black", "pawn"));
        board.placePiece(1, 1, new Piece("black", "pawn"));
        board.placePiece(1, 2, new Piece("black", "pawn"));
        board.placePiece(1, 3, new Piece("black", "pawn"));
        board.placePiece(1, 4, new Piece("black", "pawn"));
        board.placePiece(1, 5, new Piece("black", "pawn"));
        board.placePiece(1, 6, new Piece("black", "pawn"));
        board.placePiece(1, 7, new Piece("black", "pawn"));

        // White Pieces
        board.placePiece(6, 0, new Piece("white", "pawn"));
        board.placePiece(6, 1, new Piece("white", "pawn"));
        board.placePiece(6, 2, new Piece("white", "pawn"));
        board.placePiece(6, 3, new Piece("white", "pawn"));
        board.placePiece(6, 4, new Piece("white", "pawn"));
        board.placePiece(6, 5, new Piece("white", "pawn"));
        board.placePiece(6, 6, new Piece("white", "pawn"));
        board.placePiece(6, 7, new Piece("white", "pawn"));

        board.printBoard();
    }
}