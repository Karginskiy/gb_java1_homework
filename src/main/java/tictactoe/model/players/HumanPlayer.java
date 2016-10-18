package tictactoe.model.players;

import tictactoe.model.enums.Figure;

public class HumanPlayer extends AbstractPlayer {

    private String name;

    public HumanPlayer(String name, Figure figure) {
        super(figure);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Figure getFigure() {
        return super.getFigure();
    }

}
