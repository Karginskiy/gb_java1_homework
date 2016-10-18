package tictactoe.view;

import tictactoe.model.Point;
import tictactoe.model.players.AbstractPlayer;

public interface IView {

    Point getAMove();
    void printWinner(AbstractPlayer player);
    void printField();
    void printTurnPlayerName(AbstractPlayer player);

}
