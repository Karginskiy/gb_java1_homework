package tictactoe.controller;

import tictactoe.model.Game;
import tictactoe.model.Point;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.HumanPlayer;

class HumanMoveController extends AbstractMoveController {

    private HumanPlayer humanPlayer;

    HumanMoveController(Game game) {
        super(game);
        this.humanPlayer = game.getHumanPlayer();
    }

    void move(Point point) {
        field.setFigure(point, humanPlayer.getFigure());
    }

    boolean checkForWinner() {

        Figure cur = humanPlayer.getFigure();
        return checkHorizAndVertWins(cur) || checkForDiagonWin(cur);

    }

}
