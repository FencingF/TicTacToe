package org.fenci.tictactoe.game.rules;

import org.fenci.tictactoe.game.Game;
import org.fenci.tictactoe.game.Globals;
import org.fenci.tictactoe.game.Letter;
import org.fenci.tictactoe.game.Player;

import static org.fenci.tictactoe.game.board.Board.*;

public class Bot implements Globals {

    public final Letter botLetter = Game.getINSTANCE().getLetter() == Letter.X ? Letter.O : Letter.X;

    private static Bot INSTANCE;

    public Bot() {
        INSTANCE = this;
    }

    public static Bot getINSTANCE() {
        return INSTANCE;
    }

    public int getMove() { //basically if you have the first move place in the corner, but if you don't place in the center
        int move = -1;

        if (hasFirstMove()) { //if goes first
            if (isFirstMove()) {
                move = Globals.corners[(int) (Math.random() * 4)];
            } else if (!getLettersOnBoard().containsKey(5)) {
                move = 5;
            } else {

            }
        } else { //if doesn't go first
            if (!getLettersOnBoard().containsKey(5)) {
                move = 5;
            }
//            else if (getLettersInARow(Player.BOT).size() == 2) {
//                move = canWinInOneMove();
//            } else {
//                move = getEmptyBoxes().toArray(new Integer[0])[(int) (Math.random() * getEmptyBoxes().size())];
//            }
        }
        System.out.println("Bot move: " + move);
        return move;
    }

    public void addBotLetterToBoard() {
        addLetterToBoard(botLetter, getMove());
    }

    public boolean isFirstMove() {
        return getLettersOnBoard().keySet().isEmpty() || getLettersOnBoard().keySet().size() == 1;
    }

    public boolean hasFirstMove() {
        return !isGoingFirst();
    }
}
