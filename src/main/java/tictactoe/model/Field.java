package tictactoe.model;

import tictactoe.model.enums.Figure;
import tictactoe.model.players.AbstractPlayer;

import java.io.Serializable;

public class Field implements Serializable {

    private Figure[][] figures;
    public static int SIZE;
    private AbstractPlayer lastMoveBy;

    public Field(int size) {
        SIZE = size;
        figures = new Figure[SIZE][SIZE];
        initField();
    }

    @Override
    public String toString() {
        return "Field{" +
                "lastMoveBy=" + lastMoveBy +
                '}';
    }

    public Field() {}

    public Figure[][] getFigures() {
        return figures;
    }

    public void setFigure(Point point, Figure figure, AbstractPlayer lastMoveBy) {
        figures[point.getX()][point.getY()] = figure;
        this.lastMoveBy = lastMoveBy;
    }

    private void initField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                figures[i][j] = Figure.EMPTY;
            }
        }
    }

    public AbstractPlayer getLastMoveBy() {
        return lastMoveBy;
    }
}
