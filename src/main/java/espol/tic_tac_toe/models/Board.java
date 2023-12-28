package espol.tic_tac_toe.models;

import espol.tic_tac_toe.enums.Mark;

public class Board {
    
    Player currentTurn;
    
    private Mark[][] matrix;
    
    public Board() {
        this.matrix = new Mark[3][3];
    }

    public Board(Mark[][] matrix) {
        this.matrix = matrix;
    }

    public Mark[][] getMatrix() {
        return matrix;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }
    
    public Player getOponent(){
        if(currentTurn.getMark() == Mark.X){
            Player oponent = new CPU(Mark.O);
            return oponent;
        }
        Player oponent = new CPU(Mark.X);
        return oponent;
    }

}