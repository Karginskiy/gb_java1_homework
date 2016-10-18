package tictactoe.model.players;

import tictactoe.model.enums.Difficulty;
import tictactoe.model.enums.Figure;

public class AIPlayer extends AbstractPlayer {

    private Difficulty difficulty;

    public AIPlayer(Difficulty difficulty, Figure figure) {
        super(figure);
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

}
