package tictactoe.model;

import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.HumanPlayer;

public class Game {

    private Field field;
    private HumanPlayer humanPlayer;
    private AIPlayer aiPlayer;

    public Game(Field field, AIPlayer aiPlayer, HumanPlayer humanPlayer) {
        this.field = field;
        this.aiPlayer = aiPlayer;
        this.humanPlayer = humanPlayer;
    }

    public AIPlayer getAiPlayer() {
        return aiPlayer;
    }

    public Field getField() {
        return field;
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

}
