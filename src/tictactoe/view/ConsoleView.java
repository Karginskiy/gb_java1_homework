package tictactoe.view;

import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.Point;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.AbstractPlayer;
import tictactoe.model.players.HumanPlayer;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleView implements IView {

    private PrintStream stream = System.out;
    private Game game;

    public ConsoleView(Game game) {
        this.game = game;
    }

    public void printField() {
        for (Figure[] value : game.getField().getFigures()) {
            for (int i = 0; i < value.length; i++) {
                stream.print((i != (Field.SIZE) - 1) ?
                        value[i].getValue() + "|" : value[i].getValue());
            }
            stream.println();
        }
    }

    public void printHello() {
        stream.printf("Hello, %s!" + "\n", game.getHumanPlayer().getName());
        stream.println("Let's play!");
    }

    public Point getAMove() {

        while (true) {
            try {
                final Scanner sc = new Scanner(System.in);
                stream.println("Make a move! Coordinates x, y");
                Point point = new Point(sc.nextInt(), sc.nextInt());
                if (game.isSet(point, Figure.EMPTY)) {
                    return point;
                }
            } catch (Exception e) {
                stream.println("Wrong coordinate!");
            }
        }
    }

    public void printWinner(AbstractPlayer player) {

        if (player instanceof AIPlayer) {
            stream.println("Sorry.. You've lost..");
        } else if (player == null) {
            System.out.println("It's draw!");
        } else {
            stream.printf("You won, %s", ((HumanPlayer) player).getName());
        }
    }

    public void printTurnPlayerName(AbstractPlayer player) {

        if (player instanceof AIPlayer) {
            stream.println("AI's turn");
        } else {
            stream.println(((HumanPlayer) player).getName() + "'s turn");
        }

    }

}
