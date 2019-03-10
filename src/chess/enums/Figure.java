package chess.enums;

public enum  Figure {

    W_ROOK ("white_rook"),
    W_KNIGHT ("white_knight"),
    W_BISHOP ("white_bishop"),
    W_QUEEN ("white_queen"),
    W_KING ("white_king"),
    W_PAWN ("white_pawn"),

    B_ROOK ("black_rook"),
    B_KNIGHT ("black_knight"),
    B_BISHOP ("black_bishop"),
    B_QUEEN ("black_queen"),
    B_KING ("black_king"),
    B_PAWN ("black_pawn"),

    FRM_W_ROOK ("frm_white_rook"),
    FRM_W_KNIGHT ("frm_white_knight"),
    FRM_W_BISHOP ("frm_white_bishop"),
    FRM_W_QUEEN ("frm_white_queen"),
    FRM_W_KING ("frm_white_king"),
    FRM_W_PAWN ("frm_white_pawn"),

    FRM_B_ROOK ("frm_black_rook"),
    FRM_B_KNIGHT ("frm_black_knight"),
    FRM_B_BISHOP ("frm_black_bishop"),
    FRM_B_QUEEN ("frm_black_queen"),
    FRM_B_KING ("frm_black_king"),
    FRM_B_PAWN ("frm_black_pawn"),

    EMPTY("empty");

    private String name;

    Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
