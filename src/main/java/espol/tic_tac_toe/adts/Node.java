package espol.tic_tac_toe.adts;

import java.util.LinkedList;
import java.util.List;

public class Node<E> {

    private E content;
    private List<Tree<E>> children;

    public Node(E content) {
        content = content;
        children = new LinkedList<>();
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        content = content;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }

    public void addChild(Tree<E> child) {
        children.add(child);
    }

    public void addChildren(List<Tree<E>> children) {
        children.addAll(children);
    }

}
