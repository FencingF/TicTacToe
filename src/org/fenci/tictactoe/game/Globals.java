package org.fenci.tictactoe.game;

import org.fenci.tictactoe.game.board.Board;
import org.fenci.tictactoe.game.board.RowInARow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface Globals {

    default Game getGame() {
        return Game.getINSTANCE();
    }

    default Letter getLetter() {
        return getGame().getLetter();
    }

    default boolean isGoingFirst() {
        return getGame().isGoingFirst();
    }

    default Board getBoard() {
        return Board.getINSTANCE();
    }

    default void addLetterToBoard(Letter letter, int box) {
        getBoard().addLetterToBoard(letter, box);
    }

//    default Set<Integer> getLettersInARow(Player player) {
//        return getBoard().getLettersInARow(player);
//    }

    int[] corners = {1, 3, 7, 9};

    default Set<Integer> getEmptyBoxes() {
        Set<Integer> emptyBoxes = new HashSet<>();
        for (int i : getBoard().getEmtpyBoxes()) {
            if (i == 0) continue;
            emptyBoxes.add(i);
        }
        return emptyBoxes;
    }

    default boolean areAnyBoxesEmpty() {
        for (int i : getBoard().getEmtpyBoxes()) {
            if (i != 0) return true;
        }
        return false;
    }
}
