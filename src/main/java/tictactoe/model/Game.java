package tictactoe.model;

import tictactoe.model.enums.Figure;
import tictactoe.model.players.AIPlayer;
import tictactoe.model.players.AbstractPlayer;
import tictactoe.model.players.HumanPlayer;

import java.io.*;

public class Game {

    public static int WIN_SERIES;
    private String fileName = null;
    private Field field;
    private HumanPlayer humanPlayer;
    private AIPlayer aiPlayer;

    public Game(Field field, int WIN_SERIES, AIPlayer aiPlayer, HumanPlayer humanPlayer, String fileName) {
        this(field, WIN_SERIES, aiPlayer, humanPlayer);
        this.fileName = fileName;
    }

    public Game(Field field, int WIN_SERIES, AIPlayer aiPlayer, HumanPlayer humanPlayer) {
        this.field = field;
        this.aiPlayer = aiPlayer;
        Game.WIN_SERIES = WIN_SERIES;
        this.humanPlayer = humanPlayer;
    }

    public AIPlayer getAiPlayer() {
        return aiPlayer;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public HumanPlayer getHumanPlayer() {
        return humanPlayer;
    }

    public boolean isSet(Point point, Figure figure) {
        int x = point.getX();
        int y = point.getY();
        return !(x < 0 || y < 0 || x > (Field.SIZE - 1)
                || y > (Field.SIZE - 1)) && field.getFigures()[x][y] == figure;
    }

    public Field getFieldFromFile() {

        if (checkFileForNull()) {
            return null;
        }

        Field field = null;
        if (isFileExists()) {

            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
                field = (Field) objectInputStream.readObject();
                objectInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return field;
    }

    public void saveField() {

        if (checkFileForNull()) {
            return;
        }

        try {
            File file = new File(fileName);
            boolean filed = file.createNewFile();
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
            stream.writeObject(this.getField());
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void cleanFile() {

        if (checkFileForNull()) {
            return;
        }

        try {
            File file = new File(fileName);
            boolean isDelete = file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean isFileExists() {
        return (new File(fileName).exists());
    }

    private boolean checkFileForNull() {
        return fileName == null;
    }

}
