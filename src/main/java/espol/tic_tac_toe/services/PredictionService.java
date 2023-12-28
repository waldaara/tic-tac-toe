package espol.tic_tac_toe.services;

import espol.tic_tac_toe.adts.Node;
import espol.tic_tac_toe.adts.Tree;
import espol.tic_tac_toe.enums.Mark;
import espol.tic_tac_toe.models.Board;
import espol.tic_tac_toe.models.Player;
import espol.tic_tac_toe.utils.UtilityCalculator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PredictionService {
    
    public static Tree<Board> generatePredictionTree(Board board) {
        Node<Board> rootNode = new Node<>(board);
        Tree<Board> predictionTree = new Tree<>(rootNode);
        List<Tree<Board>> posibilites = generateChildrensTree(rootNode); 

        predictionTree.getRootNode().addAll(posibilites);
        return predictionTree;
    }
    
    public static Board getBestMovement(Tree<Board> predictionTree) {
        if(predictionTree.isEmpty() || predictionTree.isLeaf()){
            return null;
        }
        List<Integer> minUtilitySecondBoards = new LinkedList<>();
        List<Integer> utilityFirstBoards = new LinkedList<>();
        List<Tree<Board>> children = predictionTree.getRootNode().getChildren();
        for(Tree child : children){
            List<Tree<Board>> boardsPosibilities = child.getRootNode().getChildren();
            List<Integer> utilitySecondBoards = new LinkedList<>();
            for(Tree leaf : boardsPosibilities){
                int utility = getUtilityNode(leaf);
                utilitySecondBoards.add(utility);
            }
            int min = Collections.min(utilitySecondBoards);
            minUtilitySecondBoards.add(min);
            
            int utilityFirstBoard = getUtilityNode(child);
            utilityFirstBoards.add(utilityFirstBoard);
        }
        int MaxUtil = findMaxUtility(minUtilitySecondBoards, utilityFirstBoards);
        return searchBoardByUtility(predictionTree, MaxUtil);
    }

    private static List<Tree<Board>> generateChildrensTree(Node<Board> rootNode) {
        List<Tree<Board>> childrenTree = new LinkedList<>();
        
        Board currentBoard = rootNode.getContent();
        List<Board> children = generatePossibleStates(currentBoard);
        for (Board boardChild: children){
            List<Board> boardLeafs = generatePossibleStates(boardChild);
            Node<Board> boardChildNode = new Node<>(boardChild);
            for(Board board: boardLeafs){
                Node<Board> predictionBoard = new Node<>(board);
                Tree<Board> predictionTreeBoard = new Tree<>(predictionBoard);
                boardChildNode.getChildren().add(predictionTreeBoard);
            }
            Tree<Board> node = new Tree<>(boardChildNode);
            childrenTree.add(node);
        }
        return childrenTree;
    }
    
    private static List<Board> generatePossibleStates(Board board){
        List<Board> possiblesStates = new LinkedList<>();
        Mark[][] matrix = board.getMatrix();
        Player currentPlayer = board.getCurrentTurn();
        for(int i = 0; i< matrix.length ; i++){
            for(int j = 0; j<matrix.length; j++){
                if(matrix[i][j] == null){
                    Mark[][] newPossibleMatrix = board.getMatrix();
                    newPossibleMatrix[i][j] = currentPlayer.getMark();
                    Board newBoard = new Board(newPossibleMatrix);
                    possiblesStates.add(newBoard);
                }
            }
        }
        return possiblesStates;
    }
    
    private static int getUtilityNode(Tree<Board> node){
        Node<Board> Node = node.getRootNode();
        Board board = Node.getContent();
                
        Player player = board.getCurrentTurn();
        Player CPU = board.getOponent();
        return UtilityCalculator.calculateUtility(board, player, CPU);
    }
    
    private static int findMaxUtility(List<Integer> minUtilitys, List<Integer> maxUtilityBoards){
        int min = Collections.min(minUtilitys);
        int pos = minUtilitys.indexOf(min);
        return maxUtilityBoards.get(pos);
    }
    
    //Still in work to tired to finish
    private static Board searchBoardByUtility(Tree<Board> predictionTree, int utility){
        return null;
    }
    
}