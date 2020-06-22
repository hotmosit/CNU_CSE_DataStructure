package DS08_12;

public class Problem_1 {
    public static void main(String args[]) {
        AVLTree at = new AVLTree(14);
        at.add(17);
        at.add(11);
        at.add(7);
        at.add(53);
        at.add(4);
        at.add(13);
        at.add(12);
        at.add(8);

        System.out.println(at.toString());

        at.remove(53);
        System.out.println(at.toString());
        at.remove(11);
        System.out.println(at.toString());
        at.remove(7);
        System.out.println(at.toString());
        at.remove(12);
        System.out.println(at.toString());
        at.remove(14);
        System.out.println(at.toString());
        at.remove(13);
        System.out.println(at.toString());
    }
}

class AVLTree {
    private int key, height;
    private AVLTree left, right;
    public static final AVLTree NIL = new AVLTree();

    public AVLTree(int key) {
        this.key = key;
        left = right = NIL;
    }

    private AVLTree(int key, AVLTree left, AVLTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
        height = 1 + Math.max(left.height, right.height);
    }

    private AVLTree() {
        left = right = this;
        height = -1;
    }

    public boolean add(int key) {
        int oldSize = size();
        grow(key);
        return size() > oldSize;
    }

    public AVLTree grow(int key) {
        if (this == NIL) {
            return new AVLTree(key);
        }
        if (key == this.key) { // 값 중복
            return this;
        }
        if (key < this.key) {
            left = left.grow(key);
        } else {
            right = right.grow(key);
        }
        rebalance();
        height = 1 + Math.max(left.height, right.height);
        return this;
    }


    public AVLTree remove(int key) {
        // case 1 : 양쪽 노드가 없는 노드 삭제, 대체로 최소값 삭제
        // case 2 : 한쪽 노드만 있는 노드 삭제
        // case 3 : 한쪽 노드만 있는 노드 삭제

        // base
        if (this == NIL) {
            return NIL;
        }

        // case 1
        if(this.left.key == key && this.left.left == NIL && this.right.right == NIL){
            this.left = NIL;
            this.height = height();
            rebalance();
        }

        if(this.right.key == key && this.right.left == NIL && this.right.right == NIL){
            this.right = NIL;
            this.height = height();
            rebalance();
        }



        if (key < this.key) {
            this.left = left.remove(key);
        }
        if (key > this.key) {
            this.right = right.remove(key);
        }
        if (key == this.key) {

            int newKey = minimum(this.right).key;
            remove(newKey);
            this.key = newKey;

            this.height = height();

            rebalance();


        }


        return this;


    }

    public int height() {

        return 1 + Math.max(left.height, right.height);
    }

    public AVLTree minimum(AVLTree node) {

        if (node.left != NIL) {
            return minimum(node.left);
        }

        return node;
    }

    public int size() {
        if (this == NIL) return 0;
        return 1 + left.size() + right.size();
    }

    public String toString() {
        if (this == NIL) return "";
        return left + " " + key + " " + right;
    }

    private void rebalance() {
        if (right.height > left.height + 1) {
            if (right.left.height > right.right.height) {
                right.rotateRight();
            }
            rotateLeft();
        } else if (left.height > right.height + 1) {
            if (left.right.height > left.left.height) left.rotateLeft();
            rotateRight();
        }

    }

    private void rotateLeft() {
        left = new AVLTree(key, left, right.left);
        key = right.key;
        right = right.right;
    }

    private void rotateRight() {
        right = new AVLTree(key, right, right.right);
        key = left.key;
        left = left.left;
    }

}
