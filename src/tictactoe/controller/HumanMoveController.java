package tictactoe.controller;

import tictactoe.model.Game;
import tictactoe.model.Point;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.HumanPlayer;
import tictactoe.view.IView;

class HumanMoveController extends AbstractMoveController {

    private HumanPlayer humanPlayer;
    private IView view;

    HumanMoveController(Game game, IView view) {
        super(game);
        this.humanPlayer = game.getHumanPlayer();
        this.view = view;
    }

    public void move() {

        Point point = view.getAMove();
        game.getField().setFigure(point, humanPlayer.getFigure());
        if (checkForWinner()) {
            view.printField();
            view.printWinner(game.getHumanPlayer());
            System.exit(0);
        }

        view.printTurnPlayerName(game.getHumanPlayer());

    }

    boolean checkForWinner() {

        Figure cur = humanPlayer.getFigure();
        return checkHorizAndVertWins(cur) || checkForDiagonWin(cur);

    }

}
