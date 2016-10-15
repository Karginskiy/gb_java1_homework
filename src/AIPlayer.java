import java.util.Random;

public class AIPlayer {

    private String figure;

    AIPlayer(String figure) {
        this.figure = figure;
    }

    public String getFigure() {
        return figure;
    }

    void move() {

        Random rd = new Random();

        int[] point = getToWinCoordinate(getFigure());
        if (point != null) {
            Field.setFigure(point[0],point[1], getFigure());
            checkAndPrintOut();
            return;
        }
        point = getToWinCoordinate(anotherFigure(getFigure()));
        if (point != null) {
            Field.setFigure(point[0], point[1], getFigure());
            checkAndPrintOut();
            return;
        }
        while (true) {
            point = new int[] {rd.nextInt(Field.SIZE), rd.nextInt(Field.SIZE)};
            if (Field.isSet(point[0], point[1], " ")) {
                Field.setFigure(point[0], point[1], getFigure());
                checkAndPrintOut();
                break;
            }
        }

        if (checkForWinner()) {
            System.out.println("AI Won!");
            System.exit(0);
        }

    }

    private boolean checkForWinner() {
        return checkHorizAndVertWins(getFigure()) || checkForDiagonWin(getFigure());
    }

    private void checkAndPrintOut() {
        if (checkForWinner()) {

            System.out.println("AI Wins");
            System.exit(0);
        }
    }

    private String anotherFigure(String figure) {
        if (figure.equals("X")) {
            return "O";
        } else {
            return "X";
        }
    }



    private int[] getToWinCoordinate(String figure) {

        for (int i = 0; i < Field.SIZE; i++) {
            int index = checkHorizontalsForWinSituations(i, figure);
            if (index != -1) {
                for (int j = 0; j < Field.SIZE; j++) {
                    if (Field.isSet(index, j, " ")) {
                        return new int[] {index, j};
                    }
                }
            }
            index = checkVerticalsForWinSituations(i, figure);
            if (index != -1) {
                for (int j = 0; j < Field.SIZE; j++) {
                    if (Field.isSet(j, index, " ")) {
                        return new int[] {j, index};
                    }
                }
            }
            index = checkDiagonalsForWinSituations(i, figure);
            if (index == 1) {
                for (int j = 0; j < Field.SIZE; j++) {
                    if (Field.isSet(j, j, " ")) {
                        return new int[] {j, j};
                    }
                }
            } else if (index == 2) {
                for (int j = 0, k = Field.SIZE - 1; j < Field.SIZE; j++, k--) {
                    if (Field.isSet(j, k, " ")) {
                        return new int[] {j, k};
                    }
                }
            }

        }

        return null;
    }

    private int checkHorizontalsForWinSituations(int indexOfLine, String figure) {

        int counter = 0;
        for (int j = 0; j < Field.SIZE; j++) {

            if (Field.isSet(indexOfLine, j, figure)) {
                counter++;
            }
            if (counter > 1) {
                return indexOfLine;
            }
        }

        return -1;

    }

    private int checkVerticalsForWinSituations(int indexOfLine, String figure) {

        int counter = 0;
        for (int j = 0; j < Field.SIZE; j++) {
            if (Field.isSet(j, indexOfLine, figure)) {
                counter++;
            }
        }

        if (counter > 1) {
            return indexOfLine;
        }

        return -1;

    }

    private int checkDiagonalsForWinSituations(int indexOfDiagonal, String figure) {

        int counter = 0;
        if (indexOfDiagonal == 1) {
            for (int i = 0; i < Field.SIZE; i++) {
                if (Field.isSet(i, i, figure)) {
                    counter++;
                }
            }
        } else if (indexOfDiagonal == 2) {
            for (int i = 0, k = Field.SIZE - 1; i < Field.SIZE; i++, k--) {
                if (Field.isSet(i, k, figure)) {
                    counter++;
                }
            }
        }

        if (counter > 1) return indexOfDiagonal;

        return -1;
    }

    private boolean checkForDiagonWin(String figure) {

        int countLeftToRightDiag = 0;
        int countRightToLeftDiag = 0;
        for (int i = 0, k = Field.SIZE - 1; i < Field.SIZE; i++, k--) {
            if (Field.isSet(i, i, figure)) countLeftToRightDiag++;
            if (Field.isSet(i, k, figure)) countRightToLeftDiag++;
        }
        return countLeftToRightDiag >= Field.WIN_SERIES || countRightToLeftDiag >= Field.WIN_SERIES;

    }

    private boolean checkHorizAndVertWins(String figure) {

        for (int i = 0; i < Field.SIZE; i++) {
            int counterHor = 0;
            int counterVert = 0;
            for (int j = 0; j < Field.SIZE; j++) {
                if (Field.isSet(i, j, figure)) counterHor++;
                if (Field.isSet(j, i, figure)) counterVert++;
            }
            if (counterHor >= Field.WIN_SERIES || counterVert >= Field.WIN_SERIES) return true;
        }

        return false;

    }

}
