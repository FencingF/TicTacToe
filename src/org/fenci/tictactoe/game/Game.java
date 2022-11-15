package org.fenci.tictactoe.game;

import org.fenci.tictactoe.game.board.Board;

import javax.swing.*;

public class Game {

    public final Letter playerLetter;
    public final boolean goingFirst;

    private static Game INSTANCE;

    public Game() {
        playerLetter = Letter.values()[(int) (Math.random() * 2)]; //gets a random letter
        goingFirst = Math.random() < 0.9; //gets a random boolean
        INSTANCE = this;
    }

    public static Game getINSTANCE() {
        return INSTANCE;
    }

    public void start() {
        SwingUtilities.invokeLater(() -> new Board().setVisible(true));
    }

    public boolean isGoingFirst() {
        return goingFirst;
    }

    public Letter getLetter() {
        return playerLetter;
    }
}
