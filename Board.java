class Board {
    private Piece[][] board;

    // Board constructor
    public Board() {
        board = new Piece[8][8];
    }

    // Moves/Places object on board to x y position
    public void placePiece(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    // Retrieves the object at the x y position
    public Piece getPiece(int x, int y) {
        return board[x][y];
    }
}