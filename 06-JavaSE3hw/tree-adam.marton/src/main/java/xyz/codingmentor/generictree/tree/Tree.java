package xyz.codingmentor.generictree.tree;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ádám
 * @param <T>
 */
public class Tree<T> {
    private static final Logger LOGGER = Logger.getLogger(Tree.class.getName());
    private Node root;

    public Tree() {
        root = new Node();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    public void addNode(T data) {
        root.addChild(new Node(data));
    }

    public void addNodeAt(int index, T data) {
        root.addChildAt(index, new Node(data));
    }
    
    public void visitTree() {
        root.visitChildren();
        LOGGER.log(Level.INFO, root.toString());
    }
}
