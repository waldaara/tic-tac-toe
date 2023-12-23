/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.tic_tac_toe.models;

/**
 *
 * @author USUARIO
 */
public class Board {
    
    private int[][] matrix = new int[3][3];
    
    private final char player1 = 'X';
    private final char player2 = 'O';
    private int utility_X;
    private int utility_O;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public char getPlayer1() {
        return player1;
    }

    public char getPlayer2() {
        return player2;
    }
    public int getUtility_X() {
        return utility_X;
    }
    
    public int getUtility_O() {
        return utility_O;
    }
    
    public int calculateUtilityX() {
        int rowsPlayer1 = countLines(player1, true);
        int columsPlayer1 = countLines(player1, false);
        int diagonalPlayer1 = countDiagonals(player1);

        int rowsPlayer2 = countLines(player2, true);
        int columsPlayer2 = countLines(player2, false);
        int diagonalPlayer2 = countDiagonals(player2);

        int player1_Utility = rowsPlayer1 + columsPlayer1 + diagonalPlayer1;
        int player2_Utility = rowsPlayer2 + columsPlayer2 + diagonalPlayer2;

        return player1_Utility - player2_Utility;
    }

    private int countLines(char player, boolean rows) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            boolean isPossible = true;
            for (int j = 0; j < 3; j++) {
                if (rows) {
                    if (matrix[i][j] != player) {
                        isPossible = false;
                        break;
                    }
                } else {
                    if (matrix[j][i] != player) {
                        isPossible = false;
                        break;
                    }
                }
            }
            if (isPossible) {
                count++;
            }
        }
        return count;
    }
    
    private int countDiagonals(char player) {
        int count = 0;
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for (int i = 0; i < 3; i++) {
            if (matrix[i][i] != player) {
                diagonal1 = false;
            }
            if (matrix[i][2 - i] != player) {
                diagonal2 = false;
            }
        }
        if (diagonal1) {
            count++;
        }
        if (diagonal2) {
            count++;
        }
        return count;
    }
    
}
