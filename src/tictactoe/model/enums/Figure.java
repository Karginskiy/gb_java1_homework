package tictactoe.model.enums;

public enum Figure {

    X("X"), O("O"), EMPTY(" ");

    private String value;

    Figure(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
