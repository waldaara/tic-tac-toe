package espol.tic_tac_toe.utils;

import espol.tic_tac_toe.enums.Mark;
import espol.tic_tac_toe.models.Player;
import espol.tic_tac_toe.models.Board;

public class UtilityCalculator {

    public static int calculate(Board board, Player player, Player oponent) {
        int playerPosibilities = calculateAvaliableLines(board, player);
        int oponentPosibilities = calculateAvaliableLines(board, oponent);

        return playerPosibilities - oponentPosibilities;
    }

    private static int calculateAvaliableLines(Board board, Player player) {
        int columns = calculateAvaliableColumns(board, player);
        int rows = calculateAvaliableRows(board, player);
        int diagonals = calculateAvaliableDiagonals(board, player);

        return columns + rows + diagonals;
    }

    private static int calculateAvaliableColumns(Board board, Player player) {
        int columns = 0;

        Mark[][] matrix = board.getMatrix();

        Mark oponentsMark = (player.getMark() == Mark.X) ? Mark.O : Mark.X;

        for (int j = 0; j < matrix.length; j++) {
            boolean oponentHasMarkInColumn = false;

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == oponentsMark) {
                    oponentHasMarkInColumn = true;
                    break;
                }
            }

            if (!oponentHasMarkInColumn) {
                columns++;
            }
        }

        return columns;
    }

    private static int calculateAvaliableRows(Board board, Player player) {
        int rows = 0;

        Mark[][] matrix = board.getMatrix();

        Mark oponentsMark = (player.getMark() == Mark.X) ? Mark.O : Mark.X;

        for (int i = 0; i < matrix.length; i++) {
            boolean oponentHasMarkInRow = false;

            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == oponentsMark) {
                    oponentHasMarkInRow = true;
                    break;
                }
            }

            if (!oponentHasMarkInRow) {
                rows++;
            }
        }

        return rows;
    }

    private static int calculateAvaliableDiagonals(Board board, Player player) {
        int diagonals = 0;

        Mark[][] matrix = board.getMatrix();

        Mark oponentsMark = (player.getMark() == Mark.X) ? Mark.O : Mark.X;

        boolean oponentHasMarkInMainDiagonal = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == oponentsMark) {
                oponentHasMarkInMainDiagonal = true;
                break;
            }
        }

        if (!oponentHasMarkInMainDiagonal) {
            diagonals++;
        }

        boolean oponentHasMarkInSecundaryDiagonal = false;

        for (int i = matrix.length; i > 0; i--) {
            if (matrix[i][i] == oponentsMark) {
                oponentHasMarkInSecundaryDiagonal = true;
                break;
            }
        }

        if (!oponentHasMarkInSecundaryDiagonal) {
            diagonals++;
        }

        return diagonals;
    }

}
