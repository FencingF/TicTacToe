package org.fenci.tictactoe.game.rules;

import org.fenci.tictactoe.game.Player;

import java.util.Set;

public class Winner {

    private final Player player;
    private final Set<Integer> winningBoxes;

    public Winner(Player player, Set<Integer> winningBoxes) {
        this.player = player;
        this.winningBoxes = winningBoxes;
    }

    public Player getPlayer() {
        return player;
    }

    public Set<Integer> getWinningBoxes() {
        return winningBoxes;
    }
}
