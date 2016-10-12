package tictactoe.view;

import tictactoe.model.Point;
import tictactoe.model.enums.Figure;
import tictactoe.model.Game;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public PrintStream getStream() {
        return stream;
    }

    private PrintStream stream = System.out;
    private Game currentGame;

    public ConsoleView(Game game) {
        currentGame = game;
    }

    public void printField() {
        for (Figure[] value : currentGame.getField().getFigures()) {
            for (int i = 0; i < value.length; i++) {
                stream.print((i != (currentGame.getField().getSIZE()) - 1) ?
                        value[i].getValue() + "|" : value[i].getValue());
            }
            stream.println();
        }
    }

    public void printHello() {
        stream.printf("Hello, %s!" + "\n", currentGame.getHumanPlayer().getName());
        stream.println("Let's play!");
    }

    public Point getAMove() {

        stream.println("Make a move! Coordinates x, y");
        Point point = new Point(scanner.nextInt(), scanner.nextInt());
        return point;

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        scanner.close();
    }
}
