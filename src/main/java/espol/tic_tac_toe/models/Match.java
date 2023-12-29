package espol.tic_tac_toe.models;

import espol.tic_tac_toe.adts.Tree;
import java.io.Serializable;
import java.util.UUID;
import espol.tic_tac_toe.services.PredictionsService;

public class Match implements Serializable {

    private final String id;
    private int winsX;
    private int winsO;
    private int ties;
    private Board matchsBoard;
    private Player playerX;
    private Player playerO;
    private Player currentTurn;
    private Tree<Board> predictionsTree;

    public Match(Player playerX, Player playerO, Player currentTurn) {
        this.id = UUID.randomUUID().toString();
        this.winsX = 0;
        this.winsO = 0;
        this.ties = 0;
        this.matchsBoard = new Board();
        this.playerX = playerX;
        this.playerO = playerO;
        this.currentTurn = currentTurn;
        this.predictionsTree = PredictionsService.generatePredictionsTree(matchsBoard, playerX, playerO, currentTurn);
    }

    public String getId() {
        return id;
    }

    public int getWinsX() {
        return winsX;
    }

    public void setWinsX(int winsX) {
        this.winsX = winsX;
    }

    public int getWinsO() {
        return winsO;
    }

    public void setWinsO(int winsO) {
        this.winsO = winsO;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public Board getMatchsBoard() {
        return matchsBoard;
    }

    public void setMatchsBoard(Board matchsBoard) {
        this.matchsBoard = matchsBoard;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public void setPlayerX(Player playerX) {
        this.playerX = playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public void setPlayerO(Player playerO) {
        this.playerO = playerO;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Player currentTurn) {
        this.currentTurn = currentTurn;
    }

    public Tree<Board> getPredictionsTree() {
        return predictionsTree;
    }

    public void setPredictionsTree(Tree<Board> predictionsTree) {
        this.predictionsTree = predictionsTree;
    }

}
