package org.fenci.tictactoe.game;

public enum Player implements Globals {
    BOT, PLAYER;

    public Letter getPlayerLetter() {
        Letter letter;
        if (getGame().getLetter() == Letter.X) {
            letter = this == PLAYER ? Letter.X : Letter.O;
        } else {
            letter = this == PLAYER ? Letter.O : Letter.X;
        }
        return letter;
    }

    public static Player getPlayerFromLetter(Letter letter) {
        if (Game.getINSTANCE().getLetter() == letter) {
            return Player.PLAYER;
        } else {
            return Player.BOT;
        }
    }
}
