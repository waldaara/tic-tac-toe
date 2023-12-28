package espol.tic_tac_toe.adts;

import java.util.List;

public class Tree<E> {
    
    private Node<E> root;
    
    public Tree () {
        this.root = null; 
    }

    public Tree(Node<E> root) {
        this.root = root;
    }
    
    public boolean isEmpty () {
        return this.root == null;
    }

    public E getRoot() {
        return root.getContent();
    }
    
    public Node getRootNode () {
        return this.root;
    }

    private void setRootNode(Node<E> root) {
        this.root = root;
    }
    
    public void setRoot (E content) {
        this.root.setContent(content);
    }
    
    public boolean isLeaf () {
        return this.root.getChildren().isEmpty();
    }
    
    public boolean showRecursiveTraversal(){
        if(this.isEmpty() || this.isLeaf()){
            return false;
        }
        List<Tree<E>> children = this.root.getChildren();
        for(Tree child : children){
//            implementar una funcion que muestre el tablero
//            System.out.println(child.root.getContent());
            child.showRecursiveTraversal();
        }
        return true;
    }
    
}