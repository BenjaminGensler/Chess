class Board {
    private Piece[][] board;

    // Board constructor
    public Board() {
        board = new Piece[8][8];
    }

    // Places object on board to x y position
    public void placePiece(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    // moves object on board to x y position
    public void movePiece(int fromX, int fromY, int toX, int toY) {
        if (board[fromX][fromY] != null) {
            board[toX][toY] = board[fromX][fromY];
            board[fromX][fromY] = null;
        }
    }

    // Retrieves the object at the x y position
    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    //Display the board
    public void printBoard() {
        // Column letters
        System.out.print("   ");
        for (char c = 'a'; c <= 'h'; c++) {
            System.out.print(" " + c + " ");
        }
        System.out.println();

        // Top border
        System.out.print("   ");
        for (int i = 0; i < 8; i++) {
            System.out.print("---");
        }
        System.out.println();

        // Board rows with row numbers
        for (int row = 0; row < board.length; row++) {
            System.out.print((row + 1) + " |");
            for (int col = 0; col < board.length; col++) {
                Piece piece = board[row][col];
                if (piece != null) {
                    System.out.print(" " + piece.getType().charAt(0) + " ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println(" |");
        }

        // Bottom border
        System.out.print("   ");
        for (int i = 0; i < 8; i++) {
            System.out.print("---");
        }
        System.out.println();
    }
}