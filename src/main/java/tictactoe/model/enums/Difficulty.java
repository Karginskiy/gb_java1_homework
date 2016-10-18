package tictactoe.model.enums;

public enum Difficulty {

    HARD(3),
    EASY(1);

    private final int difficulty;

    Difficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
