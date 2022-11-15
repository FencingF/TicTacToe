package org.fenci.tictactoe.game.board;

public class Rows {

    private static final int[][] rows = new int[][]{
            //horizontal
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},

            //vertical
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},

            //diag up right
            {7, 5, 3},
            //diag up left
            {9, 5, 1}
    };

    public static int[][] getRows() {
        return rows;
    }

    public static int[] getRowFromNumbers(int a, int b) {
        for (int[] row : rows) {
            if ((row[0] == a && row[1] == b) || (row[0] == b && row[1] == a) || (row[1] == a && row[2] == b) || (row[1] == b && row[2] == a) || (row[0] == a && row[2] == b) || (row[0] == b && row[2] == a)) {
                return row;
            }
        }
        return new int[0];
    }
}

