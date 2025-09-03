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

    //Display the board
    public void printBoard() {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
                Piece piece = board[row][col];

                if(piece != null) {
                    System.out.print(piece.getType().charAt(0) + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}