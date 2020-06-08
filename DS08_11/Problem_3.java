package DS08_11;


public class Problem_3 {
    public static void main(String args[]){
        BinaryTree bt1 = new BinaryTree();
        BinaryTree bt2 = new BinaryTree();

        bt1.insert(1);
        bt1.insert(3);
        bt1.insert(5);
        bt1.insert(7);
        bt1.insert(9);
        System.out.println("<< 후위 순회 시작 >>");
        bt1.postorder(bt1);
        System.out.println();
        System.out.println("트리의 높이 : "+ bt1.height(bt1));

        System.out.println();
        
        bt2.insert(77);
        bt2.insert(44);
        bt2.insert(55);
        bt2.insert(99);
        bt2.insert(33);
        bt2.insert(66);
        bt2.insert(88);
        bt2.insert(22);
        System.out.println("<< 후위 순회 시작 >>");
        bt2.postorder(bt2);
        System.out.println();
        System.out.println("트리의 높이 : " + bt2.height(bt2));
    }
}

class BinaryTree {
    private int key;
    private BinaryTree left, right;


    public BinaryTree() {
        // 디폴트 생성시 key 값에 -1을 넣는다.
        this.key = -1;
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

        if(key == -1){
            // 디폴트 생성일 시
            key = x;
            return;
        }

        if (x < key) {
            if(this.left == null) {
                // 왼쪽에 노드가 없는 경우 노드를 생성하여 key 값을 넣는다
                this.left = new BinaryTree(x);
            }else {
                // 왼쪽에 노드가 있는 경우 insert(x) 실행
                this.left.insert(x);
            }
        } else {
            if(this.right == null){
                // 오른쪽에 노드가 없는 경우 노드 생성하여 key 값 넣는다.
                this.right = new BinaryTree(x);
            }else {
                // 오른쪽 노드가 있는 경우 insert(x) 실행
                this.right.insert(x);
            }
        }

    }

    public void postorder(BinaryTree bt) {
        // 재귀 호출 이용하여 구현

        if( bt.right == null && bt.left == null){
            // 양쪽에 노드가 비어있는 경우 재귀 탈출 (base)
            System.out.print(bt.key+ " ");
            return;
        }


        if(bt.left != null) {
            // 왼쪽에 노드가 있는 경우 왼쪽을 먼저 탐색한다.
            postorder(bt.left);
        }
        if(bt.right!= null) {
            // 왼쪽 탐색을 마친 후 오른쪽을 탐색한다.
            postorder(bt.right);
        }

        System.out.print(bt.key + " ");
    }

    public int height(BinaryTree bt) {
        if(bt == null){
            // 노드가 null인 경우 높이가 0이므로 0반환
            return 0;
        } else {
            int leftS, rightS;

            if(bt.left != null) {
                // 왼쪽에 노드가 존재하는 경우 leftS에 재귀 호출
                leftS = height(bt.left);
            }  else {
                // 존재하지 않는 경우 -1로 설정한다.
                leftS = -1;
            }
            if(bt.right != null){
                // 오른쪽에 노드가 존재하는 경우 rightS에 재귀 호출
                rightS = height(bt.right);
            }else {
                // 존재하지 않는 경우 -1로 설정한다.
                rightS = -1;
            }

            if(leftS > rightS){
                // 왼쪽이 오른쪽보다 큰 경우
                return 1 + leftS;
            } else {
                // 오른쪽이 왼쪽보다 큰 경우
                return 1 + rightS;
            }
        }
    }
}
