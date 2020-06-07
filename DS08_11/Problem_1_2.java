package DS08_11;

import java.util.*;

public class Problem_1_2{
    public static void main(String args[]){
            OrderedTree treeA, treeB, treeD;
            OrderedTree treeC = new OrderedTree("C");
            OrderedTree treeE = new OrderedTree("E");
            OrderedTree treeF = new OrderedTree("F");
            OrderedTree treeG = new OrderedTree("G");

            List<Object> subtreesOfB = new LinkedList<>();
            subtreesOfB.add(treeE);
            subtreesOfB.add(treeF);
            treeB = new OrderedTree("B", subtreesOfB);

            List<Object> subtreeOfD = new LinkedList<>();
            subtreeOfD.add(treeG);
            treeD = new OrderedTree("D", subtreeOfD);

            List<Object> subtreesOfA = new LinkedList<>();
            subtreesOfA.add(treeB);
            subtreesOfA.add(treeC);
            subtreesOfA.add(treeD);
            treeA = new OrderedTree("A", subtreesOfA);

            treeA.levelorder();

    }
}


class OrderedTree {
    private Object root;
    private List<Object> subtrees;
    private int size;

    public OrderedTree() {
    }

    public OrderedTree(Object root){
        this.root = root;
        subtrees = new LinkedList<>();
        size = 1;
    }

    public OrderedTree(Object root, List trees){
        this(root);

        for(Iterator it = trees.iterator(); it.hasNext(); ){
            Object object = it.next();
            if(object instanceof OrderedTree){
                OrderedTree tree = (OrderedTree) object;
                subtrees.add(tree);
                size += tree.size();
            }
        }
    }

    public void levelorder(){
        Queue<OrderedTree> queue = new LinkedList<>();
        queue.add(this);

        while(!queue.isEmpty()){
            OrderedTree node = queue.poll();
            System.out.println(node.root + "");

            for(Object o : node.subtrees){
                queue.add((OrderedTree) o);
            }
        }

    }

    public int size(){
        return size;
    }
}
