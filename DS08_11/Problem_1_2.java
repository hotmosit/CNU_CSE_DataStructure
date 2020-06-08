package DS08_11;

import java.util.*;

public class Problem_1_2{
    public static void main(String args[]){
        OrderedTree tree_D, tree_E, tree_B, tree_A, tree_C;


        OrderedTree tree_H = new OrderedTree(66);
        OrderedTree tree_G = new OrderedTree(22);
        OrderedTree tree_F = new OrderedTree(88);

        List<OrderedTree> subtreeOf_D = new LinkedList<>();
        subtreeOf_D.add(tree_G);
        tree_D = new OrderedTree(33, subtreeOf_D);

        List<OrderedTree> subtreeOf_E = new LinkedList<>();
        subtreeOf_E.add(tree_H);
        tree_E = new OrderedTree(55, subtreeOf_E);

        List<OrderedTree> subtreeOf_B = new LinkedList<>();
        subtreeOf_B.add(tree_D);
        subtreeOf_B.add(tree_E);
        tree_B = new OrderedTree(44, subtreeOf_B);

        List<OrderedTree> subtreeOf_C = new LinkedList<>();
        subtreeOf_C.add(tree_F);
        tree_C = new OrderedTree(99, subtreeOf_C);

        List<OrderedTree> subtreeOf_A = new LinkedList<>();
        subtreeOf_A.add(tree_B);
        subtreeOf_A.add(tree_C);
        tree_A = new OrderedTree(77, subtreeOf_A);

        tree_A.levelorder();



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
                subtrees.add(tree); // 연결 리스트에 순서대로 삽입됨
                size += tree.size();
            }
        }
    }

    public void levelorder(){
        Queue<OrderedTree> queue = new LinkedList<>();

        queue.add(this); // 루트 먼저 삽입

        while(!queue.isEmpty()){ // 큐에 아무것도 없을 때 까지 실행한다.
            OrderedTree node = queue.poll();
            System.out.print(node.root + " ");

            for(Object o : node.subtrees){
                // 노드 (루트)의 자식들을 큐에 삽입한다.
                queue.add((OrderedTree) o);
            }
        }

    }

    public int size(){
        return size;
    }
}
