package DS08_11;

public class Problem_3 {
    public static void main(String args[]){
        BinaryTree bt = new BinaryTree(33);
        bt.insert(11);
        bt.insert(55);
        bt.insert(6);
        bt.insert(22);
        bt.insert(44);

        bt.postorder(bt);
    }
}

class BinaryTree {
    private int key;
    private BinaryTree left, right;

    public BinaryTree() {
    }

    public BinaryTree(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(int key, BinaryTree left, BinaryTree right) {
        this(key);
        this.left = left;
        this.right = right;
    }

    public void insert(int x) {
        if (x < key) {
            if(this.left == null) {
                this.left = new BinaryTree(x);
            }else {
                this.left.insert(x);
            }
        } else {
            if(this.right == null){
                this.right = new BinaryTree(x);
            }else {
                this.right.insert(x);
            }
        }

    }

    public void postorder() {
        BinaryTree temp;

        temp = this;

        while(true){
            if(temp.right == null && temp.left == null){
                System.out.println(temp.key);
                break;
            }



        }

    }

    public int height() {
        return 0;
    }

}
