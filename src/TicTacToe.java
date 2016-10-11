import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final char PLAYER_DOT = 'x';
    final char AI = 'o';
    final char EMPTY_DOT = '.';
    final int FIELD_SIZE = 3;
    final int[][] field = new int[FIELD_SIZE][FIELD_SIZE];
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    public static void main(String[] args) {

        new TicTacToe().go();

    }

    public void go() {

    }

    void turnPlayer() {
        int x, y;
        do {
            System.out.println("Enter coordinates X Y (1 - 3)");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        field[x][y] = PLAYER_DOT;
    }

    boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) return false;
        return field[x][y] == EMPTY_DOT;
    }

    boolean isFieldFull() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    boolean checkWin(char ch) {
        return false;
    }

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt();
            y = random.nextInt();
        } while (!isCellEmpty(x, y));
        field[x][y] = AI;
    }



}
