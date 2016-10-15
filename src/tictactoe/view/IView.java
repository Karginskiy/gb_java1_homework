package tictactoe.view;

import tictactoe.model.Point;
import tictactoe.model.players.AbstractPlayer;

interface IView {

    Point getAMove();
    void printWinner(AbstractPlayer player);


}
