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
        if (predictionTree.isEmpty() || predictionTree.isLeaf()) {
            return null;
        }

        List<Integer> minUtilitySecondBoards = new LinkedList<>();
        List<Integer> utilityFirstBoards = new LinkedList<>();
        List<Tree<Board>> children = predictionTree.getRootNode().getChildren();

        for (Tree child : children) {
            List<Tree<Board>> boardsPosibilities = child.getRootNode().getChildren();
            List<Integer> utilitySecondBoards = new LinkedList<>();

            for (Tree leaf : boardsPosibilities) {
                int utility = calculateUtilityTreeNode(leaf);
                utilitySecondBoards.add(utility);
            }

            int min = Collections.min(utilitySecondBoards);
            minUtilitySecondBoards.add(min);

            int utilityFirstBoard = calculateUtilityTreeNode(child);
            utilityFirstBoards.add(utilityFirstBoard);
        }

        int minUtilSecondBoard = Collections.min(minUtilitySecondBoards);
        int maxUtilFirstBoard = findMaxUtility(minUtilitySecondBoards, utilityFirstBoards);

        return searchBestBoard(predictionTree, maxUtilFirstBoard, minUtilSecondBoard);
    }

    private static List<Tree<Board>> generateChildrensTree(Node<Board> rootNode) {
        List<Tree<Board>> childrenTree = new LinkedList<>();

        Board currentBoard = rootNode.getContent();
        List<Board> children = generatePossibleStates(currentBoard);

        for (Board boardChild : children) {
            List<Board> boardLeafs = generatePossibleStates(boardChild);
            Node<Board> boardChildNode = new Node<>(boardChild);

            for (Board board : boardLeafs) {
                Node<Board> predictionBoard = new Node<>(board);
                Tree<Board> predictionTreeBoard = new Tree<>(predictionBoard);
                boardChildNode.getChildren().add(predictionTreeBoard);
            }

            Tree<Board> node = new Tree<>(boardChildNode);
            childrenTree.add(node);
        }

        return childrenTree;
    }

    private static List<Board> generatePossibleStates(Board board) {
        List<Board> possiblesStates = new LinkedList<>();
        Mark[][] matrix = board.getMatrix();
        //el currunt no lo tiene el board
        Player currentPlayer = null;//board.getCurrentTurn();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == null) {
                    Mark[][] newPossibleMatrix = board.getMatrix();
                    newPossibleMatrix[i][j] = currentPlayer.getMark();
                    Board newBoard = new Board(newPossibleMatrix);
                    possiblesStates.add(newBoard);
                }
            }
        }

        return possiblesStates;
    }

    private static int calculateUtilityTreeNode(Tree<Board> tree) {
        Node<Board> Node = tree.getRootNode();
        Board board = Node.getContent();

        //el board no tiene que saber quien es el current ni el oponente, eso se saca del match
        //Player player = board.getCurrentTurn();
        //Player CPU = board.getOponent();
        return UtilityCalculator.calculateUtility(board, null, null);
    }

    private static int findMaxUtility(List<Integer> minUtilitys, List<Integer> maxUtilityBoards) {
        int min = Collections.min(minUtilitys);
        int pos = minUtilitys.indexOf(min);

        return maxUtilityBoards.get(pos);
    }

    private static Board searchBestBoard(Tree<Board> predictionTree, int maxUtilityFirstBoard, int minUtilitySecondBoard) {
        List<Tree<Board>> children = predictionTree.getRootNode().getChildren();

        for (Tree childTree : children) {
            List<Tree<Board>> leafs = childTree.getRootNode().getChildren();

            for (Tree leaf : leafs) {
                boolean firstCondition = calculateUtilityTreeNode(leaf) == minUtilitySecondBoard;
                boolean secondCondition = calculateUtilityTreeNode(childTree) == maxUtilityFirstBoard;

                if (firstCondition && secondCondition) {
                    Node<Board> nodeBoard = childTree.getRootNode();
                    Board board = nodeBoard.getContent();

                    return board;
                }
            }
        }

        return null;
    }

}
