package espol.tic_tac_toe.adts;

import java.util.LinkedList;
import java.util.List;

public class Node<E> {
    
    private E content;
    private List<Tree<E>> children;

    public Node(E content) {
        this.content = content;
        this.children = new LinkedList<>();
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public List<Tree<E>> getChildren() {
        return children;
    }
    
    public boolean addChild(Tree<E> child) {
        return children.add(child);
    }

    public boolean removeChild(Tree<E> child) {
        return children.remove(child);
    }

    public void addAll(List<Tree<E>> nodes) {
        for (Tree<E> node : nodes) {
            children.add(node);
        }
    }
    
}