package espol.tic_tac_toe.models;

import espol.tic_tac_toe.enums.Mark;

public abstract class Player {
    
    private Mark mark;
    private int wins;
    private int losses;
    private int ties;

    public Player(Mark mark) {
        this.mark = mark;
    }

    public Player(Mark mark, int wins, int losses, int ties) {
        this.mark = mark;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }
    
}
