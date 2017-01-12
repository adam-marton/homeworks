package xyz.codingmentor.generictree.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ádám
 * @param <T>
 */
public class Node<T> {
    private static final Logger LOGGER = Logger.getLogger(Node.class.getName());
    private T data;
    private List<Node> children;
    private Node parent;
    
    public Node() {
        //default constructor
    }
    
    public Node(T data) {
        children = new ArrayList<>();
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        for(Node child : children) {
           child.parent = this;
        }
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public void addChild(Node child) {
        child.parent = this;
        children.add(child);
    }
    
    public void addChildAt(int index, Node child) {
        child.parent = this;
        children.add(index, child);
    }
    
    public Node getChild(int index) {
            return children.get(index);
    }
    
    public int getNumberOfChildren() {
        return children.size();
    }

    public boolean hasChildren() {
        return children.isEmpty();
    }
    
    public void visitChildren() {
        if(this.hasChildren()) {
            for(Node child : this.getChildren()) {
                LOGGER.log(Level.INFO, child.toString());
                child.visitChildren();
            }
        }
    }
    
    @Override
    public String toString() {
        return "Node: " + data.toString();
    }
}