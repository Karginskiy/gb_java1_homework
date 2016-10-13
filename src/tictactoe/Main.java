package tictactoe;

import tictactoe.controller.GameController;
import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.enums.Difficulty;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.HumanPlayer;

public class Main {

    public static void main(String[] args) {

        int FIELD_SIZE = 3;
        int WIN_SERIES = 3;

        HumanPlayer player = new HumanPlayer("Nikita", Figure.X);
        AIPlayer aiPlayer = new AIPlayer(Difficulty.HARD, Figure.O);
        Game game = new Game(new Field(FIELD_SIZE), WIN_SERIES, aiPlayer, player);
        GameController gameController = new GameController(game);
        gameController.start();

    }

}
