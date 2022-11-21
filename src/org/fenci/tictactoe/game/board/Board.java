package org.fenci.tictactoe.game.board;

import org.fenci.tictactoe.game.Game;
import org.fenci.tictactoe.game.Globals;
import org.fenci.tictactoe.game.Letter;
import org.fenci.tictactoe.game.Player;
import org.fenci.tictactoe.game.rules.Bot;
import org.fenci.tictactoe.game.rules.Rules;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class Board extends JFrame implements Globals {

    private static Map<Integer, Letter> lettersOnBoard = new HashMap<>();

    private static Board INSTANCE;

    public boolean isPlayerTurn;

    int antiLoop = 0;
    int antiLoop2 = 0;

    public Board() {
        JPanel panel = new JPanel();
        super.add(panel);
        super.setTitle("Tic Tac Toe");
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setSize(500, 500);
        super.setResizable(false);
        super.setVisible(true);
        super.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/tictactoe.png")));
        JLabel label = new JLabel("Tic Tac Toe");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBounds(0, 0, 500, 50);
        panel.add(label);
        isPlayerTurn = Game.getINSTANCE().isGoingFirst();
        INSTANCE = this;
    }

    public static Board getINSTANCE() {
        return INSTANCE;
    }

    public void resetBoard() { //TODO: Fix this
        //reset everything
        lettersOnBoard.clear();
        //redraw the board
        repaint();
        antiLoop2 = 0;
    }

    public void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //make the lines thicker
        g2d.setStroke(new BasicStroke(2.5f));

        //draws outside box
        g2d.drawLine(100, 100, 400, 100);
        g2d.drawLine(400, 100, 400, 400);
        g2d.drawLine(400, 400, 100, 400);
        g2d.drawLine(100, 400, 100, 100);

        //draws horizontal lines
        g2d.drawLine(100, 200, 400, 200);
        g2d.drawLine(100, 300, 400, 300);

        //draws vertical lines
        g2d.drawLine(200, 100, 200, 400);
        g2d.drawLine(300, 100, 300, 400);

        //draw a rectangle with rounded corners
        g2d.drawRoundRect(345, 40, 125, 41, 10, 10);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString("Reset", 365, 70);

        //add mouse listener
//        Bot.BotThread botThread = new Bot.BotThread();
//        botThread.start();
        Bot bot = new Bot();

        if (bot.hasFirstMove() && bot.isFirstMove()) {
            if (antiLoop == 1){
                addLetterToBoard(bot.botLetter, bot.getMove());
                isPlayerTurn = true;
            }
            antiLoop++;
        }

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isPlayerTurn) return;
                //check if the mouse is in the reset button
                if (e.getX() > 345 && e.getX() < 470 && e.getY() > 40 && e.getY() < 81) {
                    resetBoard();
                    return;
                }
                if (Rules.checkForWin() != null) {
                    if (Rules.checkForWin().length == 3) {
                        for (int i : Rules.checkForWin()) {
                            System.out.print(i + " ");
                        }
                        return;
                    }
                }

                if (e.getXOnScreen() > 100 && e.getXOnScreen() < 200 && e.getYOnScreen() > 100 && e.getYOnScreen() < 200 && !lettersOnBoard.containsKey(1)) {
                    System.out.println("1");
                    addLetterToBoard(Game.getINSTANCE().getLetter(), 1);
                    isPlayerTurn = false;

                } else if (e.getXOnScreen() > 200 && e.getXOnScreen() < 300 && e.getYOnScreen() > 100 && e.getYOnScreen() < 200 && !lettersOnBoard.containsKey(2)) {
                    System.out.println("2");
                    addLetterToBoard(Game.getINSTANCE().getLetter(), 2);
                    isPlayerTurn = false;

                } else if (e.getXOnScreen() > 300 && e.getXOnScreen() < 400 && e.getYOnScreen() > 100 && e.getYOnScreen() < 200 && !lettersOnBoard.containsKey(3)) {
                    System.out.println("3");
                    addLetterToBoard(Game.getINSTANCE().getLetter(), 3);
                    isPlayerTurn = false;

                } else if (e.getXOnScreen() > 100 && e.getXOnScreen() < 200 && e.getYOnScreen() > 200 && e.getYOnScreen() < 300 && !lettersOnBoard.containsKey(4)) {
                    System.out.println("4");
                    addLetterToBoard(Game.getINSTANCE().getLetter(), 4);
                    isPlayerTurn = false;

                } else if (e.getXOnScreen() > 200 && e.getXOnScreen() < 300 && e.getYOnScreen() > 200 && e.getYOnScreen() < 300 && !lettersOnBoard.containsKey(5)) {
                    System.out.println("5");
                    addLetterToBoard(Game.getINSTANCE().getLetter(), 5);
                    isPlayerTurn = false;

                } else if (e.getXOnScreen() > 300 && e.getXOnScreen() < 400 && e.getYOnScreen() > 200 && e.getYOnScreen() < 300 && !lettersOnBoard.containsKey(6)) {
                    System.out.println("6");
                    addLetterToBoard(Game.getINSTANCE().getLetter(), 6);
                    isPlayerTurn = false;

                } else if (e.getXOnScreen() > 100 && e.getXOnScreen() < 200 && e.getYOnScreen() > 300 && e.getYOnScreen() < 400 && !lettersOnBoard.containsKey(7)) {
                    System.out.println("7");
                    addLetterToBoard(Game.getINSTANCE().getLetter(), 7);
                    isPlayerTurn = false;

                } else if (e.getXOnScreen() > 200 && e.getXOnScreen() < 300 && e.getYOnScreen() > 300 && e.getYOnScreen() < 400 && !lettersOnBoard.containsKey(8)) {
                    System.out.println("8");
                    addLetterToBoard(Game.getINSTANCE().getLetter(), 8);
                    isPlayerTurn = false;

                } else if (e.getXOnScreen() > 300 && e.getXOnScreen() < 400 && e.getYOnScreen() > 300 && e.getYOnScreen() < 400 && !lettersOnBoard.containsKey(9)) {
                    System.out.println("9");
                    addLetterToBoard(Game.getINSTANCE().getLetter(), 9);
                    isPlayerTurn = false;

                }
                Rules.manageWin(getGraphics());
                if (!isPlayerTurn) {
                    bot.addBotLetterToBoard();
                    Rules.manageWin(getGraphics());
                    isPlayerTurn = true;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public int[] getEmtpyBoxes() {
        int[] emptyBoxes = new int[9];
        int i = 0;
        for (int j = 1; j < 10; j++) {
            if (!lettersOnBoard.containsKey(j)) {
                emptyBoxes[i] = j;
                i++;
            }
        }
        return emptyBoxes;
    }

    public List<RowInARow> getHorizontalLettersInARow(Player player) {
        List<RowInARow> horizontalLettersInARow = new ArrayList<>();
        List<Integer> numbersInRows;
        int[] rows = {1, 4, 7};
        for (int row : rows) {
            numbersInRows = new ArrayList<>();

            if (lettersOnBoard.containsKey(row)) {
                if (lettersOnBoard.get(row).equals(player.getPlayerLetter())) {
                    numbersInRows.add(row);
                }
            }
            if (lettersOnBoard.containsKey(row + 1)) {
                if (lettersOnBoard.get(row + 1).equals(player.getPlayerLetter())) {
                    numbersInRows.add(row + 1);
                }
            }
            if (lettersOnBoard.containsKey(row + 2)) {
                if (lettersOnBoard.get(row + 2).equals(player.getPlayerLetter())) {
                    numbersInRows.add(row + 2);
                }
            }

            horizontalLettersInARow.add(new RowInARow(row, numbersInRows));
        }
        return horizontalLettersInARow;
    }

    public List<RowInARow> getVerticalLettersInARow(Player player) {
        List<RowInARow> verticalLettersInARow = new ArrayList<>();
        List<Integer> numbersInRows;
        int[] rows = {1, 2, 3};
        for (int row : rows) {
            numbersInRows = new ArrayList<>();

            if (lettersOnBoard.containsKey(row)) {
                if (lettersOnBoard.get(row).equals(player.getPlayerLetter())) {
                    numbersInRows.add(row);
                }
            }
            if (lettersOnBoard.containsKey(row + 3)) {
                if (lettersOnBoard.get(row + 3).equals(player.getPlayerLetter())) {
                    numbersInRows.add(row + 3);
                }
            }
            if (lettersOnBoard.containsKey(row + 6)) {
                if (lettersOnBoard.get(row + 6).equals(player.getPlayerLetter())) {
                    numbersInRows.add(row + 6);
                }
            }

            verticalLettersInARow.add(new RowInARow(row, numbersInRows));
        }
        return verticalLettersInARow;
    }

    public List<RowInARow> getDiagonalLettersInARow(Player player) {
        List<RowInARow> diagonalLettersInARow = new ArrayList<>();
        List<Integer> numbersInRows;
        int[] rows = {1, 3};
        for (int row : rows) {
            numbersInRows = new ArrayList<>();

            if (lettersOnBoard.containsKey(row)) {
                if (lettersOnBoard.get(row).equals(player.getPlayerLetter())) {
                    numbersInRows.add(row);
                }
            }
            if (lettersOnBoard.containsKey(row + 4)) {
                if (lettersOnBoard.get(row + 4).equals(player.getPlayerLetter())) {
                    numbersInRows.add(row + 4);
                }
            }
            if (lettersOnBoard.containsKey(row + 8)) {
                if (lettersOnBoard.get(row + 8).equals(player.getPlayerLetter())) {
                    numbersInRows.add(row + 8);
                }
            }

            if (row == 3) {
                if(lettersOnBoard.containsKey(5)) {
                    if (lettersOnBoard.get(5).equals(player.getPlayerLetter())) numbersInRows.add(5);
                }
            }

            diagonalLettersInARow.add(new RowInARow(row, numbersInRows));
        }
        return diagonalLettersInARow;
    }

    public Map<Integer, Letter> getLettersOnBoard() {
        return lettersOnBoard;
    }

    public void addLetterToBoard(Letter letter, int cube) {
        Graphics g = getGraphics();
        if (Rules.checkForWin() == null) {
            //set the font
            g.setFont(new Font("Arial", Font.BOLD, 100));
            //get font height
            lettersOnBoard.put(cube, letter);
            switch (cube) {
                case 1:
                    g.drawString(letter.toString(), 150 - 35, 150 + 40);
                    break;
                case 2:
                    g.drawString(letter.toString(), 250 - 35, 150 + 40);
                    break;
                case 3:
                    g.drawString(letter.toString(), 350 - 35, 150 + 40);
                    break;
                case 4:
                    g.drawString(letter.toString(), 150 - 35, 250 + 40);
                    break;
                case 5:
                    g.drawString(letter.toString(), 250 - 35, 250 + 40);
                    break;
                case 6:
                    g.drawString(letter.toString(), 350 - 35, 250 + 40);
                    break;
                case 7:
                    g.drawString(letter.toString(), 150 - 35, 350 + 40);
                    break;
                case 8:
                    g.drawString(letter.toString(), 250 - 35, 350 + 40);
                    break;
                case 9:
                    g.drawString(letter.toString(), 350 - 35, 350 + 40);
                    break;
            }
        }
        if (!areAnyBoxesEmpty() && Rules.checkForWin() == null) {
            g.setColor(Color.RED);
            g.drawString("Draw!", 115, 275);
        }
        if (Rules.checkForWin() != null && antiLoop2 == 0) {
            Letter winningLetter = lettersOnBoard.get(Rules.checkForWin()[0]);
            Player winningPlayer = Player.getPlayerFromLetter(winningLetter);
            g.setColor(Color.RED);
            g.drawString(winningPlayer.equals(Player.PLAYER) ? "You win!" : "Bot wins!", 30, 275);
            antiLoop2++;
        }

        System.out.println("Winning move: " + Rules.canWinInOneMove(Player.PLAYER));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawLines(g);
    }
}
