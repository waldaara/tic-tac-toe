/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espol.tic_tac_toe.adts;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class TreeNode<E> {
    
    private E content;
    private List<E_Tree<E>> children;

    public TreeNode(E content) {
        this.content = content;
        this.children = new LinkedList<>();
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public List<E_Tree<E>> getChildren() {
        return children;
    }

    public void setChildren(List<E_Tree<E>> children) {
        this.children = children;
    }
    
}
