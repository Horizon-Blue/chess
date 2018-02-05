package controller;

import model.Player;


public class Session {
    private final Player playerA;
    private final Player playerB;
    private int gameCount;
    private Game game;


    public Session(Player playerA, Player playerB) {
        if (playerA == null || playerB == null)
            throw new IllegalArgumentException("players cannot be null");

        // add player to session
        playerA.session = this;
        playerB.session = this;
        this.playerA = playerA;
        this.playerB = playerB;

        gameCount = 0;

        // randomly select the player for white piece
        if (Math.random() > 0.5)
            game = new Game(playerA, playerB);
        else
            game = new Game(playerB, playerA);
    }

    public void start() {
        ++gameCount;

    }

    public void restart() {
        // swap players with black & white piece
        if (isWhite(playerA))
            game = new Game(playerB, playerA);
        else
            game = new Game(playerA, playerB);
        // start a new game
        start();
    }

    public boolean isWhite(Player player) {
        return game.isWhite(player);
    }

    public boolean isWhiteRound() {
        return game.isWhiteRound;
    }

    @Override
    public String toString() {
        return playerA.name + playerB.name;
    }
}
