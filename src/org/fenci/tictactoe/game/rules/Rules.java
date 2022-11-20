package org.fenci.tictactoe.game.rules;

import org.fenci.tictactoe.game.Globals;
import org.fenci.tictactoe.game.Player;
import org.fenci.tictactoe.game.board.Board;
import org.fenci.tictactoe.game.board.RowInARow;
import org.fenci.tictactoe.game.board.Rows;

public class Rules implements Globals {

    public static int canWinInOneMove(Player player) { //will return -1 if you can't win in one move
        int winningBox = -1;
        for (RowInARow row : Board.getINSTANCE().getHorizontalLettersInARow(player)) {
            System.out.println(row.getRow() + " " + row.getBoxes());
            if (row.getBoxes().size() >= 2) {
                //find the number that is not in the row
                System.out.println("more than two");
                int[] numbers = new int[2];
                numbers[0] = row.getBoxes().get(0);
                numbers[1] = row.getBoxes().get(1);
                System.out.println("numbers: " + numbers[0] + " " + numbers[1]);
                int[] winningRow = Rows.getRowFromNumbers(numbers[0], numbers[1]);
                //get the number from the winning row that is not in the numbers array
                for (int i : winningRow) {
                    if (i != numbers[0] && i != numbers[1] && !Board.getINSTANCE().getLettersOnBoard().containsKey(i)) {
                        winningBox = i;
                    }
                }
            }
        }
        for (RowInARow row : Board.getINSTANCE().getVerticalLettersInARow(player)) {
            System.out.println(row.getRow() + " " + row.getBoxes());
            if (row.getBoxes().size() >= 2) {
                //find the number that is not in the row
                int[] numbers = new int[2];
                numbers[0] = row.getBoxes().get(0);
                numbers[1] = row.getBoxes().get(1);
                int[] winningRow = Rows.getRowFromNumbers(numbers[0], numbers[1]);
                //get the number from the winning row that is not in the numbers array
                for (int i : winningRow) {
                    if (i != numbers[0] && i != numbers[1] && !Board.getINSTANCE().getLettersOnBoard().containsKey(i)) {
                        winningBox = i;
                    }
                }
            }
        }
        for (RowInARow row : Board.getINSTANCE().getDiagonalLettersInARow(player)) {
            System.out.println(row.getRow() + " " + row.getBoxes());
            if (row.getBoxes().size() >= 2) {
                //find the number that is not in the row
                int[] numbers = new int[2];
                numbers[0] = row.getBoxes().get(0);
                numbers[1] = row.getBoxes().get(1);
                int[] winningRow = Rows.getRowFromNumbers(numbers[0], numbers[1]);
                //get the number from the winning row that is not in the numbers array
                for (int i : winningRow) {
                    if (i != numbers[0] && i != numbers[1] && !Board.getINSTANCE().getLettersOnBoard().containsKey(i)) {
                        winningBox = i;
                    }
                }
            }
        }
        return winningBox;
    }
}
