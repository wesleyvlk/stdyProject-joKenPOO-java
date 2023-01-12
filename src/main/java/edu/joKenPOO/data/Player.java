package main.java.edu.joKenPOO.data;

public class Player {
    private String player;
    private int score;

    protected Player(String player, int score) {
        this.player = player;
        this.score = score;
    }

    protected String getPlayer() {
        return player;
    }

    protected void setPlayer(final String player) {
        this.player = player;
    }

    protected int getScore() {
        return score;
    }

    protected void setScore(final int score) {
        this.score = score;
    }

    protected void incrementScore() {
        setScore(getScore() + 1);
    }

}
