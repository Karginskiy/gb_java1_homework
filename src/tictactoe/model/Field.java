package tictactoe.model;

import tictactoe.model.enums.Figure;

public class Field {

    private static Figure[][] figures;
    public static int SIZE;

    public Field(int size) {
        SIZE = size;
        figures = new Figure[SIZE][SIZE];
        initField();
    }

    public Figure[][] getFigures() {
        return figures;
    }

    public void setFigure(Point point, Figure figure) {
        figures[point.getX()][point.getY()] = figure;
    }

    private void initField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                figures[i][j] = Figure.EMPTY;
            }
        }
    }

}
