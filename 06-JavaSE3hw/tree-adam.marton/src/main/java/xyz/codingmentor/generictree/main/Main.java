package xyz.codingmentor.generictree.main;

import xyz.codingmentor.generictree.tree.Node;
import xyz.codingmentor.generictree.tree.Tree;

/**
 *
 * @author Ádám
 */
public class Main {
    
    private Main() {
        //default constructor
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.setRoot(new Node("0"));
        tree.addNodeAt(0, "1");
        tree.addNodeAt(1, "2");
        tree.addNodeAt(1, "3");
        tree.addNodeAt(2, "4");
        tree.visitTree();
    }
}
