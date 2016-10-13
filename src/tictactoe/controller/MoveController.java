package tictactoe.controller;

import tictactoe.model.*;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.AbstractPlayer;
import tictactoe.model.players.HumanPlayer;

import java.util.Random;

class MoveController {

    private Field field;
    private int winSeries;

    MoveController(Field field, int winSeries) {
        this.field = field;
        this.winSeries = winSeries;
    }

    void move(AIPlayer player, HumanPlayer humanPlayer) {

        Random random = new Random();

        switch (player.getDifficulty()) {
            case HARD:
                for (int y = 0; y < field.getSIZE(); y++) {
                    for (int x = 0; x < field.getSIZE(); x++) {
                        if (isSet(new Point(x, y), humanPlayer.getFigure())) {
                            for (int y_found = y; y_found < y + field.getSIZE(); y_found++) {
                                for (int x_found = x; x_found < x + field.getSIZE(); x_found++) {
                                    if (!((y == y_found) && (x == x_found))) {
                                        if (isSet(new Point(x_found, y_found), humanPlayer.getFigure())) {
                                            if (isSet(new Point(x * 2 - x_found, y * 2 - y_found), Figure.EMPTY)) {
                                                field.setFigure(new Point((x * 2 - x_found), (y * 2 - y_found)), player.getFigure());
                                                return;
                                            }
                                            if (isSet(new Point(x_found * 2 - x, y_found * 2 - y), Figure.EMPTY)) {
                                                field.setFigure(new Point((x_found * 2 - x), (y_found * 2 - y)), player.getFigure());
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            case EASY:
                while (true) {
                    int x_rand = random.nextInt(3);
                    int y_rand = random.nextInt(3);
                    Point point = new Point(x_rand, y_rand);
                    if (isSet(point, Figure.EMPTY)) {
                        this.field.setFigure(point, player.getFigure());
                        break;
                    }
                }
                break;
            }
    }

    void move(HumanPlayer player, Point point) {
        field.setFigure(point, player.getFigure());
    }

    boolean checkForWinner(AbstractPlayer player) {

        Figure[][] arr = field.getFigures();
        Figure cur = player.getFigure();
        return checkHorizAndVertWins(winSeries, cur) || checkForDiagonWin(winSeries, cur);

    }

    boolean isSet(Point point, Figure figure) {
        int x = point.getX();
        int y = point.getY();
        return !(x < 0 || y < 0 || x > (field.getSIZE() - 1)
                || y > (field.getSIZE() - 1)) && field.getFigures()[x][y] == figure;
    }

    private boolean checkForDiagonWin(int winSeries, Figure figure) {

        int countLeftToRightDiag = 0;
        int countRightToLeftDiag = 0;
        for (int i = 0, k = field.getSIZE() - 1; i < field.getSIZE(); i++, k--) {
            if (isSet(new Point(i, i), figure)) countLeftToRightDiag++;
            if (isSet(new Point(i, k), figure)) countRightToLeftDiag++;
        }
        return countLeftToRightDiag >= winSeries || countRightToLeftDiag >= winSeries;

    }

    private boolean checkHorizAndVertWins(int winSeries, Figure figure) {

        for (int i = 0; i < field.getSIZE(); i++) {
            int counterHor = 0;
            int counterVert = 0;
            for (int j = 0; j < field.getSIZE(); j++) {
                if (isSet(new Point(i, j), figure)) counterHor++;
                if (isSet(new Point(j, i), figure)) counterVert++;
            }
            if (counterHor >= winSeries || counterVert >= winSeries) return true;
        }

        return false;

    }

}
