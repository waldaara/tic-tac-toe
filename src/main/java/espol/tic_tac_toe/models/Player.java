package espol.tic_tac_toe.models;

import java.io.Serializable;

public abstract class Player implements Serializable {

    private Mark mark;

    public Player(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
