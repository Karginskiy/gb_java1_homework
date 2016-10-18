package tictactoe.model.players;

import tictactoe.model.enums.Figure;

public abstract class AbstractPlayer {

    private Figure figure;

    public Figure getFigure() {
        return figure;
    }

    AbstractPlayer(Figure figure) {
        this.figure = figure;
    }

}
