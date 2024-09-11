package BinarySearchTree;

public class Implementation {
    public static void main(String[] args) {

        Implementation bst = new Implementation();

        int[] arr = new int[]{13, 7, 4, 9, 29, 83, 26, 40, 19, 64};

        for(int num : arr){
            bst.add(num);
        }

        bst.preOrder(bst.root);
    }
    Node root, parent;

    public void add(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return;
        }
        Node currentNode = root;
        while(currentNode != null){
            if(data < currentNode.data){
                parent = currentNode;
                currentNode = currentNode.leftChild;
            }
            else{
                parent = currentNode;
                currentNode = currentNode.rightChild;
            }
        }
        if(data < parent.data){
            parent.leftChild = newNode;
        } else {
            parent.rightChild = newNode;
        }
    }

    public void search(int searchedNum){
        if(root == null){
            System.out.println("Nothing is in the tree");
            return;
        }
        Node current = root;
        while(searchedNum != current.data) {
            if (searchedNum < current.data){
                if(current.leftChild == null){
                    System.out.println("It is not in here");
                    return;
                }
                current = current.leftChild;
            } else {
                if(current.rightChild == null){
                    System.out.println("It is not in here");
                    return;
                }
                current = current.rightChild;
            }
        }
        System.out.println("Found");

    }

    public void inOrder(Node current){
        if(current != null){
            inOrder(current.leftChild);
            System.out.print(current.data + ", ");
            inOrder(current.rightChild);
        }
    }
    public void preOrder(Node current){
        if(current != null){
            System.out.print(current.data + ", ");
            preOrder(current.leftChild);
            preOrder(current.rightChild);
        }
    }
    public void postOrder(Node current){
        if(current != null){
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current.data + ", ");
        }
    }

    public Node delete(Node root, int data){
        if(root == null){
            return null;
        }

        if(data < root.data){
            root.leftChild = delete(root.leftChild, data);
        }
        else if(data > root.data){
            root.rightChild = delete(root.rightChild, data);
        }
        else {
            // Node found and no children
            if(root.leftChild == null && root.rightChild == null){
                return null;
            }
            //One child
            if(root.leftChild == null) {
                return root.rightChild;
            }
            else if(root.rightChild == null){
                return root.leftChild;
            }
            //Two Children - find the minimum node on the right sub tree
            Node successor = findMin(root.rightChild);
            root.data = successor.data;
            root.rightChild = delete(root.rightChild, successor.data);
        }
        return root;
    }

    public Node findMin(Node root){
        while(root.leftChild != null){
            root = root.leftChild;
        }
        return root;
    }

    static class Node{
        int data;
        Node leftChild;
        Node rightChild;

        public Node(int data) {
            this.data = data;
        }
    }
}

