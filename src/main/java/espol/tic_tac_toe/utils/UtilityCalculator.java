package espol.tic_tac_toe.utils;

import espol.tic_tac_toe.enums.Mark;
import espol.tic_tac_toe.models.Player;
import espol.tic_tac_toe.models.Board;

public class UtilityCalculator {

    public static int calculateUtility(Board board, Player player, Player oponent) {
        int playerPosibilities = calculateAvaliableLines(board, player);
        int oponentPosibilities = calculateAvaliableLines(board, oponent);

        return playerPosibilities - oponentPosibilities;
    }

    public static int calculateAvaliableLines(Board board, Player player) {
        int columns = calculateAvaliableColumns(board, player);
        int rows = calculateAvaliableRows(board, player);
        int diagonals = calculateAvaliableDiagonals(board, player);

        return columns + rows + diagonals;
    }

    private static int calculateAvaliableColumns(Board board, Player player) {
        int columns = 0;
        int row = 0;
        Mark[][] matrix = board.getMatrix();

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[row][j] != player.getMark() && matrix[row][j] != null) {
                columns--;
            } else if (matrix[row + 1][j] != player.getMark() && matrix[row + 1][j] != null) {
                columns--;
            } else if (matrix[row + 2][j] != player.getMark() && matrix[row + 2][j] != null) {
                columns--;
            }

            columns++;
        }

        return columns;
    }

    private static int calculateAvaliableRows(Board board, Player player) {
        int rows = 0;
        int column = 0;
        Mark[][] matrix = board.getMatrix();

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] != player.getMark() && matrix[i][column] != null) {
                rows--;
            } else if (matrix[i][column + 1] != player.getMark() && matrix[i][column + 1] != null) {
                rows--;
            } else if (matrix[i][column + 2] != player.getMark() && matrix[i][column + 2] != null) {
                rows--;
            }
            rows++;
        }

        return rows;
    }

    private static int calculateAvaliableDiagonals(Board board, Player player) {
        int mainDiagonal = 0;
        int secundaryDiagonal = 0;
        Mark[][] matrix = board.getMatrix();

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != player.getMark() && matrix[i][i] != null) {
                mainDiagonal--;
            }

            if (matrix[i][2 - i] != player.getMark() && matrix[i][i] != null) {
                secundaryDiagonal--;
            }

            mainDiagonal++;
            secundaryDiagonal++;
        }

        if (mainDiagonal == 3 && secundaryDiagonal == 3) {
            return 2;
        } else if (mainDiagonal == 3) {
            return 1;
        } else if (secundaryDiagonal == 3) {
            return 1;
        }

        return 0;
    }

}
