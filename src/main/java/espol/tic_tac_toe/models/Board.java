package espol.tic_tac_toe.models;

import espol.tic_tac_toe.enums.Mark;
import java.io.Serializable;

public class Board implements Serializable{

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

    public void setMatrix(Mark[][] matrix) {
        this.matrix = matrix;
    }
}
