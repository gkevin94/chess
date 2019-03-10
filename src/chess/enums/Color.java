package chess.enums;

public enum Color {

    BLACK("black"),WHITE("white"), EMPTY("empty");

    private String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
