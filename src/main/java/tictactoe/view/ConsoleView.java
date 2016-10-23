package tictactoe.view;

import tictactoe.model.Field;
import tictactoe.model.Game;
import tictactoe.model.Point;
import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.AbstractPlayer;
import tictactoe.model.players.HumanPlayer;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleView implements IView {

    private PrintStream stream = System.out;
    private Game game;

    public ConsoleView(Game game) {
        this.game = game;
    }

    public void printField() {
        stream.println();
        for (int j = 0; j < Field.SIZE; j++) {
            for (int i = 0; i < Field.SIZE; i++) {
                stream.print((i != (Field.SIZE) - 1) ?
                        " " + game.getField().getFigures()[j][i].getValue()
                            + " |" : " " + game.getField().getFigures()[j][i].getValue());
            }
            if (j != Field.SIZE - 1) {
                printSeparator();
            }
        }
        stream.println();
        stream.println();
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
                Point point = new Point(sc.nextInt(Field.SIZE + 1) - 1, sc.nextInt(Field.SIZE + 1) - 1);
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
            stream.println("It's draw!");
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

    private void printSeparator() {
        StringBuilder builder = new StringBuilder("\n");
        for (int i = 0; i < Field.SIZE; i++) {
            if (i != Field.SIZE - 1) {
                builder.append("~~~~");
            } else {
                builder.append("~~~");
            }
        }
        stream.println(builder.toString());
    }

}
