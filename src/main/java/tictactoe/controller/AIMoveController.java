package tictactoe.controller;

import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.Point;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.view.IView;

import java.util.Random;

class AIMoveController extends AbstractMoveController {

    private final AIPlayer aiPlayer;
    private final IView view;

    AIMoveController(Game game, IView view) {
        super(game);
        this.aiPlayer = game.getAiPlayer();
        this.view = view;
    }

    public void move() {

        view.printTurnPlayerName(game.getAiPlayer());

        Random rd = new Random();

        switch (aiPlayer.getDifficulty()) {
            case HARD:
                Point point = getToWinCoordinate(aiPlayer.getFigure());
                if (point != null) {
                    game.getField().setFigure(point, aiPlayer.getFigure());
                    checkAndPrintOut();
                    return;
                }
                point = getToWinCoordinate(anotherFigure(aiPlayer.getFigure()));
                if (point != null) {
                    game.getField().setFigure(point, aiPlayer.getFigure());
                    checkAndPrintOut();
                    return;
                }
            case EASY:
                while (true) {
                    point = new Point(rd.nextInt(Field.SIZE), rd.nextInt(Field.SIZE));
                    if (game.isSet(point, Figure.EMPTY)) {
                        game.getField().setFigure(point, aiPlayer.getFigure());
                        checkAndPrintOut();
                        break;
                    }
                }
                break;
        }

        if (checkForWinner()) {
            view.printWinner(game.getAiPlayer());
            System.exit(0);
        }

    }

    boolean checkForWinner() {
        return checkHorizAndVertWins(aiPlayer.getFigure()) || checkForDiagonWin(aiPlayer.getFigure());
    }

    private void checkAndPrintOut() {
        if (checkForWinner()) {
            view.printField();
            view.printWinner(aiPlayer);
            System.exit(0);
        }
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

    private Point getToWinCoordinate(Figure figure) {

        // BEGIN (write your solution here)
        for (int i = 0; i < Field.SIZE; i++) {
            int index = checkHorizontalsForWinSituations(i, figure);
            if (index != -1) {
                for (int j = 0; j < Field.SIZE; j++) {
                    if (game.isSet(new Point(index, j), Figure.EMPTY)) {
                        return new Point(index, j);
                    }
                }
            }
            index = checkVerticalsForWinSituations(i, figure);
            if (index != -1) {
                for (int j = 0; j < Field.SIZE; j++) {
                    if (game.isSet(new Point(j, index), Figure.EMPTY)) {
                        return new Point(j, index);
                    }
                }
            }
            index = checkDiagonalsForWinSituations(i, figure);
            if (index == 1) {
                for (int j = 0; j < Field.SIZE; j++) {
                    if (game.isSet(new Point(j, j), Figure.EMPTY)) {
                        return new Point(j, j);
                    }
                }
            } else if (index == 2) {
                for (int j = 0, k = Field.SIZE - 1; j < Field.SIZE; j++, k--) {
                    if (game.isSet(new Point(j, k), Figure.EMPTY)) {
                        return new Point(j, k);
                    }
                }
            }

        }

        return null;
        // END
    }

    private int checkHorizontalsForWinSituations(int indexOfLine, Figure figure) {

        int counter = 0;
        for (int j = 0; j < Field.SIZE; j++) {

            if (game.isSet(new Point(indexOfLine, j), figure)) {
                counter++;
            }
            if (counter > 1) {
                return indexOfLine;
            }
        }

        return -1;

    }

    private int checkVerticalsForWinSituations(int indexOfLine, Figure figure) {

        int counter = 0;
        for (int j = 0; j < Field.SIZE; j++) {
            if (game.isSet(new Point(j, indexOfLine), figure)) {
                counter++;
            }
        }

        if (counter > 1) {
            return indexOfLine;
        }

        return -1;

    }

    private int checkDiagonalsForWinSituations(int indexOfDiagonal, Figure figure) {

        int counter = 0;
        if (indexOfDiagonal == 1) {
            for (int i = 0; i < Field.SIZE; i++) {
                if (game.isSet(new Point(i, i), figure)) {
                    counter++;
                }
            }
        } else if (indexOfDiagonal == 2) {
            for (int i = 0, k = Field.SIZE - 1; i < Field.SIZE; i++, k--) {
                if (game.isSet(new Point(i, k), figure)) {
                    counter++;
                }
            }
        }

        if (counter > 1) return indexOfDiagonal;

        return -1;
    }




}
