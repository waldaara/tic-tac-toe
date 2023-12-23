package espol.tic_tac_toe.models;

public class Board {
    
    private Mark[][] matrix;
    private Player playerX;
    private Player playerY;

    public Board() {
        this.matrix = new Mark[3][3];
    }

    public Board(Mark[][] matrix) {
        this.matrix = matrix;
    }

    public Mark[][] getMatrix() {
        return matrix;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerY() {
        return playerY;
    }
    
    public int calculateUtility(Player player){
        int rowsPlayerX = countRows(playerX);
        int columsPlayerX = countColumns(playerX);
        int diagonalPlayerX = countDiagonals(playerX);
        
        int rowsPlayerY = countRows(playerY);
        int columsPlayerY = countColumns(playerY);
        int diagonalPlayerY = countDiagonals(playerY);

        int playerXPosibilities = rowsPlayerX + columsPlayerX + diagonalPlayerX;
        int playerYPosibilities = rowsPlayerY + columsPlayerY + diagonalPlayerY;
        
        if(player == playerX){
           return playerXPosibilities - playerYPosibilities;
        }
        return playerYPosibilities - playerXPosibilities ;
    }
   
    private int countColumns(Player player){
        int columns = 0;
        int row = 0;
        for(int j = 0; j < matrix.length; j++) {
            if(matrix[row][j] != player.getMark() && matrix[row][j] != null){
                columns--;
            }else if(matrix[row+1][j] != player.getMark() && matrix[row+1][j] != null){
                columns--;
            }else if(matrix[row+2][j] != player.getMark() && matrix[row+2][j] != null){
                columns--;
            }
            columns++;    
            }
        return columns;
    }
    
    private int countRows(Player player){
        int rows = 0;
        int column = 0;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][column] != player.getMark() && matrix[i][column] != null){
                rows--;
            }else if(matrix[i][column+1] != player.getMark() && matrix[i][column+1] != null){
                rows--;
            }else if(matrix[i][column+2] != player.getMark() && matrix[i][column+2] != null){
                rows--;
            }
            rows++;    
            }
        return rows;
    }
    
    private int countDiagonals(Player player) {
        int mainDiagonal = 0;
        int secundaryDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != player.getMark() && matrix[i][i] != null) {
                mainDiagonal--;
            }
            if (matrix[i][2 - i] != player.getMark() && matrix[i][i] != null) {
                secundaryDiagonal--;
            }
        }
        if (mainDiagonal == 3 && secundaryDiagonal == 3) {
            return 2;
        }else if (mainDiagonal == 3) {
            return 1;
        }else if(secundaryDiagonal == 3){
            return 1;
        }
        return 0;
    }
    
}
