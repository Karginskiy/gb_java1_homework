import java.util.Scanner;

public class TicTacToe {

    final char PLAYER_DOT = 'x';
    final char AI = 'o';
    final char EMPTY_DOT = '.';
    final int FIELD_SIZE = 3;
    final int[][] field = new int[FIELD_SIZE][FIELD_SIZE];
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        new TicTacToe();

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

}
