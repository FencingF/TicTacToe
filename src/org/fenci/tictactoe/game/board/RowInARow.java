package org.fenci.tictactoe.game.board;

import java.util.List;

public class RowInARow { //used this not only for rows but for columns and diagonals

    private final int row;
    private final List<Integer> boxes;

    public RowInARow(int row, List<Integer> boxes) {
        this.row = row;
        this.boxes = boxes;
    }

    public int getRow() {
        return row;
    }

    public List<Integer> getBoxes() {
        return boxes;
    }
}
