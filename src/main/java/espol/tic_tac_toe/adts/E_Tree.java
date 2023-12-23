/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.tic_tac_toe.adts;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public class E_Tree<E> {
    
    private TreeNode<E> root;
    
    public E_Tree () {
        this.root = null; 
    }
    
    public boolean isEmpty () {
        return this.root == null;
    }

    public E getRoot() {
        return root.getContent();
    }
    
    private TreeNode getRootNode () {
        return this.root;
    }

    private void setRootNode(TreeNode<E> root) {
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
        List<E_Tree<E>> children = this.root.getChildren();
        for(E_Tree child : children){
//            implementar una funcion que muestre el tablero
//            System.out.println(child.root.getContent());
            child.showRecursiveTraversal();
        }
        return true;
    }

}