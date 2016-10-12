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

    public GameController(HumanPlayer player, AIPlayer aiPlayer, int fieldSize)
    {
        this.player = player;
        this.aiPlayer = aiPlayer;
        this.size = fieldSize;
    }

    public void start() {

        this.field = new Field(size);
        Game currentGame = new Game(field, aiPlayer, player);
        MoveController moveController = new MoveController(field);
        ConsoleView view = new ConsoleView(currentGame);

        view.printHello();
        view.printField();

        while (!isFieldFull()) {

            Point point = view.getAMove();
            if (!moveController.isSet(point, Figure.EMPTY)) continue;
            moveController.move(player, point);
            view.printField();

            if (moveController.checkForWinner(player)) {
                view.getStream().println("Nice! You won!");
                System.exit(0);
            }

            view.getStream().println();

            if (!isFieldFull()) {
                moveController.move(aiPlayer, player);
                view.printField();
                if (moveController.checkForWinner(aiPlayer)) {
                    view.getStream().println("Sorry.. You've lost..");
                    System.exit(0);
                }
            }

        }

        view.getStream().println("It's draw!");


    }

    private boolean isFieldFull() {
        for (int y = 0; y < field.getSIZE(); y++) {
            for (int x = 0; x < field.getSIZE(); x++) {
                if (field.getFigures()[x][y] == Figure.EMPTY)
                    return false;
            }
        }
        return true;
    }


}
