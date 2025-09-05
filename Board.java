class Board {
    private Piece[][] board;

    // Coordinates for white and black kings (Default to -1, -1 if not placed)
    private int whiteKingX = -1, whiteKingY = -1;
    private int blackKingX = -1, blackKingY = -1;

    // Board constructor
    public Board() {
        board = new Piece[8][8];
    }

    // Places object on board to x y position
    public void placePiece(int x, int y, Piece piece) {
        board[x][y] = piece;

        // Update king coordinates if a king is placed
        if (piece != null && piece.getType().equals("King")) {
            if (piece.getColor().equals("white")) {
                whiteKingX = x;
                whiteKingY = y;
            } else if (piece.getColor().equals("black")) {
                blackKingX = x;
                blackKingY = y;
            }
        }
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
                
                //check if king is in check after move
                if(this.isKingInCheck(this.getPiece(toX, toY).getColor())) {
                    // returns pieces back to original position if king is in check
                    System.out.println("You can't move there, King is in check!");
                    this.placePiece(fromX, fromY, this.getPiece(toX, toY));
                    this.placePiece(toX, toY, null);
                }
            }
        }
    }

    // Retrieves the object at the x y position
    public Piece getPiece(int x, int y) {
        // Out of bounds check
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {
            return null;
        }

        return board[x][y];
    }

    // Check if king is in check
    public boolean isKingInCheck(String color){
        int kingX, kingY;
        if (color.equals("white")) {
            kingX = whiteKingX;
            kingY = whiteKingY;
        } else {
            kingX = blackKingX;
            kingY = blackKingY;
        }

        // Check if Pawns can attack the King
        if (color.equals("white")) {
            if ((this.getPiece(kingX - 1, kingY + 1) != null && this.getPiece(kingX - 1, kingY + 1).getType().equals("Pawn") && this.getPiece(kingX - 1, kingY + 1).getColor().equals("black")) ||
                (this.getPiece(kingX + 1, kingY + 1) != null && this.getPiece(kingX + 1, kingY + 1).getType().equals("Pawn") && this.getPiece(kingX + 1, kingY + 1).getColor().equals("black"))) {
                return true;
            }
        } else {
            if ((this.getPiece(kingX - 1, kingY - 1) != null && this.getPiece(kingX - 1, kingY - 1).getType().equals("Pawn") && this.getPiece(kingX - 1, kingY - 1).getColor().equals("white")) ||
                (this.getPiece(kingX + 1, kingY - 1) != null && this.getPiece(kingX + 1, kingY - 1).getType().equals("Pawn") && this.getPiece(kingX + 1, kingY - 1).getColor().equals("white"))) {
                return true;
            }
        }

        // Check if Knights can attack the king
        if ((this.getPiece(kingX - 1, kingY - 2) != null && this.getPiece(kingX - 1, kingY - 2).getType().equals("Knight")) && !this.getPiece(kingX - 1, kingY - 2).getColor().equals(this.getPiece(kingX, kingY).getColor()) ||
            (this.getPiece(kingX - 1, kingY + 2) != null && this.getPiece(kingX - 1, kingY + 2).getType().equals("Knight")) && !this.getPiece(kingX - 1, kingY + 2).getColor().equals(this.getPiece(kingX, kingY).getColor()) ||
            (this.getPiece(kingX + 1, kingY - 2) != null && this.getPiece(kingX + 1, kingY - 2).getType().equals("Knight")) && !this.getPiece(kingX + 1, kingY - 2).getColor().equals(this.getPiece(kingX, kingY).getColor()) ||
            (this.getPiece(kingX + 1, kingY + 2) != null && this.getPiece(kingX + 1, kingY + 2).getType().equals("Knight")) && !this.getPiece(kingX + 1, kingY + 2).getColor().equals(this.getPiece(kingX, kingY).getColor()) ||
            (this.getPiece(kingX - 2, kingY - 1) != null && this.getPiece(kingX - 2, kingY - 1).getType().equals("Knight")) && !this.getPiece(kingX - 2, kingY - 1).getColor().equals(this.getPiece(kingX, kingY).getColor()) ||
            (this.getPiece(kingX - 2, kingY + 1) != null && this.getPiece(kingX - 2, kingY + 1).getType().equals("Knight")) && !this.getPiece(kingX - 2, kingY + 1).getColor().equals(this.getPiece(kingX, kingY).getColor()) ||
            (this.getPiece(kingX + 2, kingY - 1) != null && this.getPiece(kingX + 2, kingY - 1).getType().equals("Knight")) && !this.getPiece(kingX + 2, kingY - 1).getColor().equals(this.getPiece(kingX, kingY).getColor()) ||
            (this.getPiece(kingX + 2, kingY + 1) != null && this.getPiece(kingX + 2, kingY + 1).getType().equals("Knight")) && !this.getPiece(kingX + 2, kingY + 1).getColor().equals(this.getPiece(kingX, kingY).getColor())) {
            return true;
        }

        // Check if Rooks or Queens can attack the king (horizontal and vertical)
        int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int x = kingX + dir[0];
            int y = kingY + dir[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (getPiece(x, y) != null) {
                    if ((getPiece(x, y).getType().equals("Rook") || getPiece(x, y).getType().equals("Queen")) &&
                        !getPiece(x, y).getColor().equals(this.getPiece(kingX, kingY).getColor())) {
                        return true;
                    } else {
                        break; // Blocked by another piece
                    }
                }
                x += dir[0];
                y += dir[1];
            }
        }

        // Check if Bishop or Queens can attack the king (diagonal)
        int diagonalDirections[][] = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] dir : diagonalDirections) {
            int x = kingX + dir[0];
            int y = kingY + dir[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (getPiece(x, y) != null) {
                    if ((getPiece(x, y).getType().equals("Bishop") || getPiece(x, y).getType().equals("Queen")) &&
                        !getPiece(x, y).getColor().equals(this.getPiece(kingX, kingY).getColor())) {
                        return true;
                    } else {
                        break; // Blocked by another piece
                    }
                }
                x += dir[0];
                y += dir[1];
            }
        }

        return false; // King is not in check
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