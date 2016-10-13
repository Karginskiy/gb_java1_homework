package tictactoe.model;

import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.HumanPlayer;

public class Game {

    public static int WIN_SERIES;
    private Field field;
    private HumanPlayer humanPlayer;
    private AIPlayer aiPlayer;

    public Game(Field field, AIPlayer aiPlayer, HumanPlayer humanPlayer, int WIN_SERIES) {
        this.field = field;
        this.aiPlayer = aiPlayer;
        this.humanPlayer = humanPlayer;
        Game.WIN_SERIES = WIN_SERIES;
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
