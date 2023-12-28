package espol.tic_tac_toe.models;

import espol.tic_tac_toe.enums.Mark;

public class Human extends Player{
    
    public Human(Mark mark, int wins, int losses, int ties) {
        super(mark, wins, losses, ties);
    }

    public Human(Mark mark) {
        super(mark);
    }
    
}
