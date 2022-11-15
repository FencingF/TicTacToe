package org.fenci.tictactoe.game;

public enum Player implements Globals {
    BOT, PLAYER;

    public Letter getLetter() {
        Letter letter = null;
        if (getGame().getLetter() == Letter.X) {
            letter = this == PLAYER ? Letter.X : Letter.O;
        } else {
            letter = this == PLAYER ? Letter.O : Letter.X;
        }
        return letter;
    }
}
