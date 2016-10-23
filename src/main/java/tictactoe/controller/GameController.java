package tictactoe.controller;

import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.AbstractPlayer;
import tictactoe.view.ConsoleView;

import java.io.*;
import java.util.Arrays;
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
        AbstractMoveController moveController;


        Field field = game.getFieldFromFile();

        if (field != null) {
            game.setField(field);
            moveController = getNextPlayerController(field.getLastMoveBy());
            view.printField();
        } else {
            moveController = getRandomStartPlayerController();
        }

        while (!isFieldFull()) {

            view.printHello();

            moveController.move();
            game.saveField();
            view.printField();

            if (isFieldFull()) {
                view.printWinner(null);
                break;
            }

            moveController = nextPlayerController(moveController);

            System.lineSeparator();

            if (!isFieldFull()) {
                moveController.move();
                game.saveField();
                view.printField();
            }

            moveController = nextPlayerController(moveController);

        }

        view.printWinner(null);
        game.cleanFile();


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

    private AbstractMoveController getNextPlayerController(AbstractPlayer player) {
        if (player instanceof AIPlayer) {
            return humanMoveController;
        } else {
            return aiMoveController;
        }
    }


}
