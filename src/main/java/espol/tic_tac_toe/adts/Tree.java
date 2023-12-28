package espol.tic_tac_toe.adts;

import java.util.List;

public class Tree<E> {

    private Node<E> root;

    public Tree() {
        root = null;
    }

    public Tree(E rootContent) {
        root = new Node(rootContent);
    }

    public E getRoot() {
        return root.getContent();
    }

    public void setRoot(E content) {
        root.setContent(content);
    }

    public Node getRootNode() {
        return root;
    }

    public List<Tree<E>> getChildren() {
        return root.getChildren();
    }

    public void addChild(Tree<E> child) {
        root.addChild(child);
    }

    public void addChild(E childContent) {
        root.addChild(new Tree<E>(childContent));
    }

    public void addChildren(List<Tree<E>> children) {
        root.addChildren(children);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isLeaf() {
        return root.getChildren().isEmpty();
    }

}
