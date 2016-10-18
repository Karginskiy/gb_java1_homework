package tictactoe.model;

import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.HumanPlayer;

public class Game {

    public static int WIN_SERIES;
    private Field field;
    private HumanPlayer humanPlayer;
    private AIPlayer aiPlayer;

    public Game(Field field, int WIN_SERIES, AIPlayer aiPlayer, HumanPlayer humanPlayer) {
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

    public boolean isSet(Point point, Figure figure) {
        int x = point.getX();
        int y = point.getY();
        return !(x < 0 || y < 0 || x > (Field.SIZE - 1)
                || y > (Field.SIZE - 1)) && field.getFigures()[x][y] == figure;
    }

}
