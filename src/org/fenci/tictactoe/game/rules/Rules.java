package org.fenci.tictactoe.game.rules;

import org.fenci.tictactoe.game.Globals;
import org.fenci.tictactoe.game.Letter;
import org.fenci.tictactoe.game.Player;
import org.fenci.tictactoe.game.board.Board;
import org.fenci.tictactoe.game.board.Cube;
import org.fenci.tictactoe.game.board.RowInARow;
import org.fenci.tictactoe.game.board.Rows;

import java.awt.*;

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

    public static int[] checkForWin() { //returns null if there is no win
        int[] winningRow = null;
        for (int[] row : Rows.getRows()) {
            if (Board.getINSTANCE().getLettersOnBoard().containsKey(row[0]) && Board.getINSTANCE().getLettersOnBoard().containsKey(row[1]) && Board.getINSTANCE().getLettersOnBoard().containsKey(row[2])) {
                if (Board.getINSTANCE().getLettersOnBoard().get(row[0]) == Board.getINSTANCE().getLettersOnBoard().get(row[1]) && Board.getINSTANCE().getLettersOnBoard().get(row[1]) == Board.getINSTANCE().getLettersOnBoard().get(row[2])) {
                    winningRow = Rows.getRowFromNumbers(row[0], row[1]);
                }
            }
        }
        return winningRow;
    }

    public static boolean manageWin(Graphics graphics) {
        int[] winningRow = checkForWin();
        if (winningRow != null) {
            graphics.setColor(Color.RED);
            ((Graphics2D) graphics).setStroke(new BasicStroke(10));
            int x1 = Cube.getMiddleCoordinates(Cube.fromInt(winningRow[0]))[0];
            int y1 = Cube.getMiddleCoordinates(Cube.fromInt(winningRow[0]))[1];
            int x2 = Cube.getMiddleCoordinates(Cube.fromInt(winningRow[2]))[0];
            int y2 = Cube.getMiddleCoordinates(Cube.fromInt(winningRow[2]))[1];
            graphics.drawLine(x1, y1, x2, y2);
            return true;
        }
        return false;
    }
}
