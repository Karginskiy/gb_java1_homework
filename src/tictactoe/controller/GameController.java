package tictactoe.controller;

import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.Point;
import tictactoe.model.enums.Figure;
import tictactoe.view.ConsoleView;

public class GameController {

    private Game game;

    public GameController(Game game)
    {
        this.game = game;
    }

    public void start() {

        HumanMoveController humanMoveController = new HumanMoveController(game);
        AIMoveController aiMoveController = new AIMoveController(game);
        ConsoleView view = new ConsoleView(game);

        view.printHello();
        view.printField();

        while (!isFieldFull()) {

            Point point = view.getAMove();
            if (!humanMoveController.isSet(point, Figure.EMPTY)) continue;
            humanMoveController.move(point);
            view.printTurnPlayerName(game.getHumanPlayer());
            view.printField();

            if (humanMoveController.checkForWinner()) {
                view.printWinner(game.getHumanPlayer());
                System.exit(0);
            }

            if (isFieldFull()) {
                view.printWinner(null);
                System.exit(0);
            }

            System.lineSeparator();
            view.printTurnPlayerName(game.getAiPlayer());

            if (!isFieldFull()) {
                aiMoveController.move();
                view.printField();
                if (aiMoveController.checkForWinner()) {
                    view.printWinner(game.getAiPlayer());
                    System.exit(0);
                }
            }

        }

        view.printWinner(null);


    }

    private boolean isFieldFull() {
        for (int y = 0; y < Field.SIZE; y++) {
            for (int x = 0; x < Field.SIZE; x++) {
                if (game.getField().getFigures()[x][y] == Figure.EMPTY)
                    return false;
            }
        }
        return true;
    }


}
