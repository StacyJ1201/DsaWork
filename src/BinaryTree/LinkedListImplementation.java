package BinaryTree;

public class LinkedListImplementation {
    public static void main(String[] args) {

    }
    static class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree{
        Node root;
        int size;

        public void add(char data){
            root = addRecursively(root, data);
        }

        private Node addRecursively(Node current, char data) {
            if(current == null){
                return new Node(data);
            }
            if(size % 2 == 0){
                current.left = addRecursively(current.left, data);
            } else{
                current.right = addRecursively(current.right, data);
            }
            size++;
            return current;
        }

        public void preOrder(Node current){
            System.out.println(current.data);
            preOrder(current.left);
            preOrder(current.right);
        }
        public void inOrder(Node current){
            inOrder(current.left);
            System.out.println(current.data);
            inOrder(current.right);
        }
        public void postOrder(Node current){
            postOrder(current.left);
            postOrder(current.right);
            System.out.println(current.data);
        }
    }

}
