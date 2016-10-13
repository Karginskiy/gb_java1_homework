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

        Random random = new Random();

        switch (aiPlayer.getDifficulty()) {
            case HARD:
                for (int y = 0; y < Field.SIZE; y++) {
                    for (int x = 0; x < Field.SIZE; x++) {
                        if (isSet(new Point(x, y), anotherFigure(aiPlayer.getFigure()))) {
                            for (int y_found = y; y_found < y + Field.SIZE; y_found++) {
                                for (int x_found = x; x_found < x + Field.SIZE; x_found++) {
                                    if (!((y == y_found) && (x == x_found))) {
                                        if (isSet(new Point(x_found, y_found), anotherFigure(aiPlayer.getFigure()))) {
                                            if (isSet(new Point(x * 2 - x_found, y * 2 - y_found), Figure.EMPTY)) {
                                                field.setFigure(new Point((x * 2 - x_found), (y * 2 - y_found)), aiPlayer.getFigure());
                                                return;
                                            }
                                            if (isSet(new Point(x_found * 2 - x, y_found * 2 - y), Figure.EMPTY)) {
                                                field.setFigure(new Point((x_found * 2 - x), (y_found * 2 - y)), aiPlayer.getFigure());
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
                        this.field.setFigure(point, aiPlayer.getFigure());
                        break;
                    }
                }
                break;
        }

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




}
