package tictactoe.controller;

import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.Point;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.HumanPlayer;
import tictactoe.view.ConsoleView;

public class GameController {

    private HumanPlayer player;
    private AIPlayer aiPlayer;
    private int size;
    private Field field;
    private int winSeries;

    public GameController(HumanPlayer player, AIPlayer aiPlayer, int fieldSize, int winSeries)
    {
        this.player = player;
        this.aiPlayer = aiPlayer;
        this.size = fieldSize;
        this.winSeries = winSeries;
    }

    public void start() {

        this.field = new Field(size);
        Game currentGame = new Game(field, aiPlayer, player, winSeries);
        HumanMoveController humanMoveController = new HumanMoveController(currentGame);
        AIMoveController aiMoveController = new AIMoveController(currentGame);
        ConsoleView view = new ConsoleView(currentGame);

        view.printHello();
        view.printField();

        while (!isFieldFull()) {

            Point point = view.getAMove();
            if (!humanMoveController.isSet(point, Figure.EMPTY)) continue;
            humanMoveController.move(point);
            view.printTurnPlayerName(player);
            view.printField();

            if (humanMoveController.checkForWinner()) {
                view.printWinner(player);
                System.exit(0);
            }

            System.lineSeparator();
            view.printTurnPlayerName(aiPlayer);

            if (!isFieldFull()) {
                aiMoveController.move();
                view.printField();
                if (aiMoveController.checkForWinner()) {
                    view.printWinner(aiPlayer);
                    System.exit(0);
                }
            }

        }

        view.printWinner(null);


    }

    private boolean isFieldFull() {
        for (int y = 0; y < Field.SIZE; y++) {
            for (int x = 0; x < Field.SIZE; x++) {
                if (field.getFigures()[x][y] == Figure.EMPTY)
                    return false;
            }
        }
        return true;
    }


}
