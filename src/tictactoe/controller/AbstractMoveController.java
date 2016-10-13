package tictactoe.controller;

import tictactoe.model.*;
import tictactoe.model.enums.Figure;

abstract class AbstractMoveController {

    Field field;

    AbstractMoveController(Game game) {
        this.field = game.getField();
    }

    abstract boolean checkForWinner();

    boolean isSet(Point point, Figure figure) {
        int x = point.getX();
        int y = point.getY();
        return !(x < 0 || y < 0 || x > (Field.SIZE - 1)
                || y > (Field.SIZE - 1)) && field.getFigures()[x][y] == figure;
    }

    boolean checkForDiagonWin(Figure figure) {

        int countLeftToRightDiag = 0;
        int countRightToLeftDiag = 0;
        for (int i = 0, k = Field.SIZE - 1; i < Field.SIZE; i++, k--) {
            if (isSet(new Point(i, i), figure)) countLeftToRightDiag++;
            if (isSet(new Point(i, k), figure)) countRightToLeftDiag++;
        }
        return countLeftToRightDiag >= Game.WIN_SERIES || countRightToLeftDiag >= Game.WIN_SERIES;

    }

    boolean checkHorizAndVertWins(Figure figure) {

        for (int i = 0; i < Field.SIZE; i++) {
            int counterHor = 0;
            int counterVert = 0;
            for (int j = 0; j < Field.SIZE; j++) {
                if (isSet(new Point(i, j), figure)) counterHor++;
                if (isSet(new Point(j, i), figure)) counterVert++;
            }
            if (counterHor >= Game.WIN_SERIES || counterVert >= Game.WIN_SERIES) return true;
        }

        return false;

    }

}
