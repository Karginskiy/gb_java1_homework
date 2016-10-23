package tictactoe.model.players;

import tictactoe.model.enums.Difficulty;
import tictactoe.model.enums.Figure;

import java.io.Serializable;

public class AIPlayer extends AbstractPlayer implements Serializable{

    private Difficulty difficulty;

    public AIPlayer(Difficulty difficulty, Figure figure) {
        super(figure);
        this.difficulty = difficulty;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public AIPlayer() {}

}
