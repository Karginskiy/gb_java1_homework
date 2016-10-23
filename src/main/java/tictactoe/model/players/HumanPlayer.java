package tictactoe.model.players;

import tictactoe.model.enums.Figure;

import java.io.Serializable;

public class HumanPlayer extends AbstractPlayer implements Serializable {

    private String name;

    public HumanPlayer(String name, Figure figure) {
        super(figure);
        this.name = name;
    }

    public HumanPlayer() {}

    public String getName() {
        return name;
    }

    @Override
    public Figure getFigure() {
        return super.getFigure();
    }

}
