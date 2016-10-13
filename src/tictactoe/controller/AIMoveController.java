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
