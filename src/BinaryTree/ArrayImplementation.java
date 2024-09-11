//On the binary tree array implementation write the following methods:
//tree = [ 'D', 'A', 'F', 'E', 'B', 'R', 'T', 'G', 'Q', None, None, 'V', None, 'J', 'L']
//get_right_child(index)
//get_left_child(index)
//get_parent(index)
// preorder(index)
//inorder(index)
//postorder(index)

package BinaryTree;

public class ArrayImplementation {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        System.out.println(tree.getParent(3));
    }
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    static class BinaryTree{
        int[] tree = { 5, 4, 6, 8, 6, 92, 3, 1, 10, 13};
        Node root;
        int node_count;

        public int getLeftChild(int index) {
            int getLeftChildIndex = (2*index)+1;
            if(getLeftChildIndex < tree.length && tree[getLeftChildIndex] != '\0'){
                return tree[getLeftChildIndex];
            }else {
                return 0;
            }
        }

        public int getRightChild(int index) {
            int getRightChildIndex = (2*index)+2;
            if(getRightChildIndex < tree.length && tree[getRightChildIndex] != 0){
                return tree[getRightChildIndex];
            }else {
                return 0;
            }
        }

        public int getParent(int index) {
            int getParent = (index - 1)/2;
            if(getParent < tree.length && tree[getParent] != 0){
                return tree[getParent];
            }else {
                return 0;
            }
        }

        public void preOrder(int index) {
            if (index >= tree.length) {
                return;
            }
            System.out.print(tree[index] + ", ");
            preOrder(2 * index + 1);
            preOrder(2 * index + 2);
        }

        public void postOrder(int index){
            if(index >= tree.length){
                return;
            }
            postOrder(2 * index + 1);
            postOrder(2 * index + 2);
            System.out.print(tree[index] + ", ");
        }

        public void inOrder(int index){
            if(index >= tree.length){
                return;
            }
            inOrder(2 * index + 1);
            System.out.print(tree[index] + ", ");
            inOrder(2 * index + 2);
        }
    }
}

