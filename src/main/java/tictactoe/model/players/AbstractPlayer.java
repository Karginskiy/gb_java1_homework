package tictactoe.model.players;

import tictactoe.model.enums.Figure;

import java.io.Serializable;

public abstract class AbstractPlayer implements Serializable {

    private Figure figure;

    public Figure getFigure() {
        return figure;
    }

    AbstractPlayer(Figure figure) {
        this.figure = figure;
    }

    public AbstractPlayer() {}

}
