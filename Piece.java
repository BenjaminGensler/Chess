public class Piece {
    private String color;
    private String type;

    public Piece(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public char getLetter() {
        switch (type.toLowerCase()) {
            case "pawn":
                return color.equalsIgnoreCase("white") ? 'P' : 'p';
            default:
                return '?';
        }
    }

    public boolean isLegalMove(int fromX, int fromY, int toX, int toY, Board board) {
        return false;
    }
}