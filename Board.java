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
        if (this.getPiece(fromX, fromY) != null) {
            // check if the pieces move is legal
            if(this.getPiece(fromX, fromY).isLegalMove(fromX, fromY, toX, toY, this) == false) {
                System.out.println("Illegal move");
                return;
            }
            else {
                this.placePiece(toX, toY, this.getPiece(fromX, fromY));
                this.placePiece(fromX, fromY, null);
            }
        }
    }

    // Retrieves the object at the x y position
    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    //Display the board
    public void printBoard() {
        // System.out.println("printBoard() 1");
        // Top border
        System.out.print("   ");
        for (int i = 0; i < 8; i++) {
            System.out.print("---");
        }
        System.out.println();
        // System.out.println("printBoard() 2");

        // Board rows with row numbers (reverse order)
        for (int row = board.length - 1; row >= 0; row--) {
            System.out.print((row + 1) + " |");
            for (int col = 0; col < board.length; col++) {
                Piece piece = board[row][col];
                if (piece != null) {
                    System.out.print(" " + piece.getLetter() + " ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println(" |");
        }

        // System.out.println("printBoard() 3");

        // Bottom border
        System.out.print("   ");
        for (int i = 0; i < 8; i++) {
            System.out.print("---");
        }
        System.out.println();
        
        // System.out.println("printBoard() 4");

        // Column letters
        System.out.print("   ");
        for (char c = 'a'; c <= 'h'; c++) {
            System.out.print(" " + c + " ");
        }
        System.out.println();

        // System.out.println("printBoard() 5");
    }
}