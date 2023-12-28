package espol.tic_tac_toe.models;

import espol.tic_tac_toe.enums.Mark;

public class CPU extends Player {
    
    public CPU(Mark mark, int wins, int losses, int ties) {
        super(mark, wins, losses, ties);
    }

    public CPU(Mark mark) {
        super(mark);
    }
    
}
