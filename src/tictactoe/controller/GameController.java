package tictactoe.controller;

import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.enums.Figure;
import tictactoe.view.ConsoleView;

import java.util.Random;

public class GameController {

    private Game game;
    private HumanMoveController humanMoveController;
    private AIMoveController aiMoveController;

    public GameController(Game game)
    {
        this.game = game;
    }

    public void start() {

        ConsoleView view = new ConsoleView(game);
        humanMoveController = new HumanMoveController(game, view);
        aiMoveController = new AIMoveController(game, view);

        view.printHello();
        AbstractMoveController moveController = getRandomStartPlayerController();

        while (!isFieldFull()) {

            moveController.move();
            view.printField();

            if (isFieldFull()) {
                view.printWinner(null);
                System.exit(0);
            }

            moveController = nextPlayerController(moveController);

            System.lineSeparator();

            if (!isFieldFull()) {
                moveController.move();
                view.printField();
            }

            moveController = nextPlayerController(moveController);

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

    private AbstractMoveController getRandomStartPlayerController() {
        Random random = new Random();
        int randomise = random.nextInt(2);

        switch (randomise) {
            case 0:
                return humanMoveController;
            case 1:
                return aiMoveController;
        }

        return humanMoveController;

    }

    private AbstractMoveController nextPlayerController(
            AbstractMoveController abstractMoveController) {

        if (abstractMoveController instanceof HumanMoveController) {
            return aiMoveController;
        } else {
            return humanMoveController;
        }

    }


}
