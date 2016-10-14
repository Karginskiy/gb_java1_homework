package tictactoe.controller;

import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.Point;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;

import java.util.Random;

class AIMoveController extends AbstractMoveController {

    private final AIPlayer aiPlayer;

    AIMoveController(Game game) {
        super(game);
        this.aiPlayer = game.getAiPlayer();
    }

    void move() {

        Random rd = new Random();

        Point point = getToWinCoordinate(field);
        if (point != null) {
            field.setFigure(point, aiPlayer.getFigure());
            return;
        }
        point = getBlockingCoordinate(field);
        if (point != null) {
            field.setFigure(point, aiPlayer.getFigure());
            return;
        }

        field.setFigure(new Point(rd.nextInt(Field.SIZE), rd.nextInt(Field.SIZE)),
                        aiPlayer.getFigure());


    }

    boolean checkForWinner() {
        return checkHorizAndVertWins(aiPlayer.getFigure()) || checkForDiagonWin(aiPlayer.getFigure());
    }


    private Figure anotherFigure(Figure figure) {

        switch (figure) {
            case O:
                return Figure.X;
            case X:
                return Figure.O;
        }

        return null;
    }

    private Point getBlockingCoordinate(final Field field) {

        for (int y = 0; y < Field.SIZE; y++) {
            for (int x = 0; x < Field.SIZE; x++) {
                if (isSet(new Point(x, y), anotherFigure(aiPlayer.getFigure()))) {
                    for (int y_found = y; y_found < y + Field.SIZE; y_found++) {
                        for (int x_found = x; x_found < x + Field.SIZE; x_found++) {
                            if (!((y == y_found) && (x == x_found))) {
                                if (isSet(new Point(x_found, y_found), anotherFigure(aiPlayer.getFigure()))) {
                                    if (isSet(new Point(x * 2 - x_found, y * 2 - y_found), Figure.EMPTY)) {
                                        return new Point((x * 2 - x_found), (y * 2 - y_found));
                                    }
                                    if (isSet(new Point(x_found * 2 - x, y_found * 2 - y), Figure.EMPTY)) {
                                        return new Point((x_found * 2 - x), (y_found * 2 - y));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;

    }

    private Point getToWinCoordinate(final Field field) {

        // BEGIN (write your solution here)
        for (int i = 0; i < Field.SIZE; i++) {
            int index = checkHorizontalsForWinSituations(field, i);
            if (index != -1) {
                for (int j = 0; j < Field.SIZE; j++) {
                    if (isSet(new Point(index, j), Figure.EMPTY)) {
                        return new Point(index, j);
                    }
                }
            }
            index = checkVerticalsForWinSituations(field, i);
            if (index != -1) {
                for (int j = 0; j < Field.SIZE; j++) {
                    if (isSet(new Point(j, index), Figure.EMPTY)) {
                        return new Point(j, index);
                    }
                }
            }
            index = checkDiagonalsForWinSituations(field, i);
            if (index == 1) {
                for (int j = 0; j < Field.SIZE; j++) {
                    if (isSet(new Point(j, j), Figure.EMPTY)) {
                        return new Point(j, j);
                    }
                }
            } else if (index == 2) {
                for (int j = 0, k = Field.SIZE - 1; j < Field.SIZE; j++, k--) {
                    if (isSet(new Point(j, k), Figure.EMPTY)) {
                        return new Point(j, k);
                    }
                }
            }

        }

        return null;
        // END
    }

    private int checkHorizontalsForWinSituations(Field field, int indexOfLine) {

        int counter = 0;
        for (int j = 0; j < Field.SIZE; j++) {

            if (isSet(new Point(indexOfLine, j), aiPlayer.getFigure())) {
                counter++;
            }
            if (counter > 1) {
                return indexOfLine;
            }
        }

        return -1;

    }

    private int checkVerticalsForWinSituations(Field field, int indexOfLine) {

        int counter = 0;
        for (int j = 0; j < Field.SIZE; j++) {
            if (isSet(new Point(j, indexOfLine), aiPlayer.getFigure())) {
                counter++;
            }
        }

        if (counter > 1) {
            return indexOfLine;
        }

        return -1;

    }

    private int checkDiagonalsForWinSituations(Field field, int indexOfDiagonal) {

        int counter = 0;
        if (indexOfDiagonal == 1) {
            for (int i = 0; i < Field.SIZE; i++) {
                if (isSet(new Point(i, i), aiPlayer.getFigure())) {
                    counter++;
                }
            }
        } else if (indexOfDiagonal == 2) {
            for (int i = 0, k = Field.SIZE - 1; i < Field.SIZE; i++, k--) {
                if (isSet(new Point(i, k), Figure.X)) {
                    counter++;
                }
            }
        }

        if (counter > 1) return indexOfDiagonal;

        return -1;
    }




}
