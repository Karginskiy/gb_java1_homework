package tictactoe;

import tictactoe.controller.GameController;
import tictactoe.model.enums.Difficulty;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.HumanPlayer;

public class Main {

    public static void main(String[] args) {

        // Entry point
        // This will be the start of the game.
        HumanPlayer player = new HumanPlayer("Nikita", Figure.X);
        AIPlayer aiPlayer = new AIPlayer(Difficulty.HARD, Figure.O);
        int FIELD_SIZE = 3;
        GameController gameController = new GameController(player, aiPlayer, FIELD_SIZE);
        gameController.start();
    }

}
