import java.util.Scanner;

/**
 *
 * simple TicTacToe
 *
 * @author Kargin Nikita
 * @version 0.1
 *
 */

public class SimpleTicTacToe {

    public static void main(String[] args) {
        start();
    }


    private static void start() {

        System.out.println("Hello!");
        Field field = new Field(3, 3);
        Human human = new Human("X");
        AIPlayer aiPlayer = new AIPlayer("O");

        while (!Field.isFieldFull()) {

            human.move();
            Field.printField();

            if (Field.isFieldFull()) {
                System.out.println("It's draw!");
                System.exit(0);
            }

            System.lineSeparator();

            if (!Field.isFieldFull()) {
                aiPlayer.move();
                Field.printField();
            }

        }

        System.out.println("It's draw!");


    }


}

/**********************/

class Field {

    static int SIZE;
    static int WIN_SERIES;
    private static String[][] figures;

    Field(int SIZE, int WIN_SERIES) {
        Field.SIZE = SIZE;
        Field.WIN_SERIES = WIN_SERIES;
        figures = fieldInit();
    }

    static void printField() {
        for (String[] value : figures) {
            for (int i = 0; i < value.length; i++) {
                System.out.print((i != (Field.SIZE) - 1) ?
                        value[i] + "|" : value[i]);
            }
            System.out.println();
        }
    }

    static boolean isFieldFull() {
        for (int y = 0; y < Field.SIZE; y++) {
            for (int x = 0; x < Field.SIZE; x++) {
                if (Field.figures[x][y].equals(" "))
                    return false;
            }
        }
        return true;
    }

    static void setFigure(int x, int y, String figure) {
        if (checkForBorders(x, y)) {
            figures[x][y] = figure;
        }
    }

    static boolean isSet(int x, int y, String figure) {
        if (!checkForBorders(x, y)) {
            return false;
        } else {
            if (figures[x][y].equals(figure)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkForBorders(int x, int y) {
        return (x < Field.SIZE || y < Field.SIZE || x > 0 || y > 0);
    }

    private static String[][] fieldInit() {
        String[][] result = new String[Field.SIZE][Field.SIZE];
        for (int i = 0; i < Field.SIZE; i++) {
            for (int j = 0; j < Field.SIZE; j++) {
                result[i][j] = " ";
            }
        }
        return result;
    }
}

/**********************/

class Human {

    private String figure;

    Human(String figure) {
        this.figure = figure;
    }

    void move() {

        System.out.println("Your turn!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int x, y;
            x = scanner.nextInt(Field.SIZE);
            y = scanner.nextInt(Field.SIZE);
            if (Field.isSet(x, y, " ")) {
                Field.setFigure(x, y, figure);
                return;
            }
        }

    }

}