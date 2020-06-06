package DS08_11;

import java.util.*;

public class OrderedTree {
    private Object root;
    private List subtrees;
    private int size;

    public OrderedTree(){
        
    }

    public OrderedTree(Object root){
        this.root = root;
        subtrees = new LinkedList();
        size = 1;
    }

    public OrderedTree(Object root, List trees){

    }
}
