package tictactoe.controller;

import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.Point;
import tictactoe.model.enums.Figure;

abstract class AbstractMoveController {

    Game game;

    AbstractMoveController(Game game) {
        this.game = game;
    }

    abstract public void move();

    abstract boolean checkForWinner();

    boolean checkForDiagonWin(Figure figure) {

        int countLeftToRightDiag = 0;
        int countRightToLeftDiag = 0;
        for (int i = 0, k = Field.SIZE - 1; i < Field.SIZE; i++, k--) {
            if (game.isSet(new Point(i, i), figure)) countLeftToRightDiag++;
            if (game.isSet(new Point(i, k), figure)) countRightToLeftDiag++;
        }
        return countLeftToRightDiag >= Game.WIN_SERIES || countRightToLeftDiag >= Game.WIN_SERIES;

    }

    boolean checkHorizAndVertWins(Figure figure) {

        for (int i = 0; i < Field.SIZE; i++) {
            int counterHor = 0;
            int counterVert = 0;
            for (int j = 0; j < Field.SIZE; j++) {
                if (game.isSet(new Point(i, j), figure)) counterHor++;
                if (game.isSet(new Point(j, i), figure)) counterVert++;
            }
            if (counterHor >= Game.WIN_SERIES || counterVert >= Game.WIN_SERIES) return true;
        }

        return false;

    }



}
