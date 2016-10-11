package tictactoe.controller;

import tictactoe.model.*;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.AbstractPlayer;
import tictactoe.model.players.HumanPlayer;

import java.util.Random;

class MoveController {

    private Field field;

    MoveController(Field field) {
        this.field = field;
    }

    void move(AIPlayer player, HumanPlayer humanPlayer) {

        Random random = new Random();

        switch (player.getDifficulty()) {
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
            case HARD:
                for (int y = 0; y < field.getSIZE(); y++) {
                    for (int x = 0; x < field.getSIZE(); x++) {
                        if (isSet(new Point(x, y), humanPlayer.getFigure())) {
                            for (int y1 = y - 1; y1 < y + field.getSIZE(); y1++) {
                                for (int x1 = x - 1; x1 < x + field.getSIZE(); x1++) {
                                    if (!((y == y1) && (x == x1))) {
                                        if (isSet(new Point(x1, y1), humanPlayer.getFigure())) {
                                            System.out.println("LOL");
                                            // blocking continuation forward
                                            if (isSet(new Point(x * 2 - x1, y * 2 - y1), Figure.EMPTY)) {
                                                field.setFigure(new Point((x * 2 - x1), (y * 2 - y1)), player.getFigure());
                                            }
                                            // blocking continuation back
                                            if (isSet(new Point(x1 * 2 - x, y1 * 2 - y), Figure.EMPTY)) {
                                                field.setFigure(new Point((x * 2 - x1), (y * 2 - y1)), player.getFigure());
                                            }
                                        }
                                    }
                                }
                            }
                        }
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
        for (int i = 0; i < field.getSIZE(); i++) {
            if (arr[i][0] == cur && arr[i][1] == cur && arr[i][2] == cur) return true;
            if (arr[0][i] == cur && arr[1][i] == cur && arr[2][i] == cur) return true;
        }

        return arr[0][0] == cur && arr[1][1] == cur && arr[2][2] ==
                cur || arr[2][0] == cur && arr[1][1] == cur && arr[0][2] == cur;

    }

    boolean isSet(Point point, Figure figure) {
        int x = point.getX();
        int y = point.getY();
        return !(x < 0 || y < 0 || x > (field.getSIZE() - 1)
                || y > (field.getSIZE() - 1)) && field.getFigures()[x][y] == figure;
    }


}
