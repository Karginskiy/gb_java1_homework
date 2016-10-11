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

    private void go() {



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

    private boolean isCellEmpty(int x, int y) {
        if ((y < 0)) return false;
        else {
            if ((x > 2)) {
                return false;
            }
            else if ((x < 0) || (y > 2)) {
                return false;
            }
        }
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
        if (field[0][0] == ch && field[0][1] == ch && field[0][2] == ch) return true;
        if (field[1][0] == ch && field[1][1] == ch && field[1][2] == ch) return true;
        if (field[2][0] == ch && field[2][1] == ch && field[2][2] == ch) return true;

        if (field[0][0] == ch && field[1][0] == ch && field[2][0] == ch) return true;
        if (field[0][1] == ch && field[1][1] == ch && field[2][1] == ch) return true;
        if (field[0][2] == ch && field[1][2] == ch && field[2][2] == ch) return true;

        if (field[0][0] == ch && field[1][1] == ch && field[2][2] == ch) return true;
        if (field[2][2] == ch && field[1][1] == ch && field[0][2] == ch) return true;
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
