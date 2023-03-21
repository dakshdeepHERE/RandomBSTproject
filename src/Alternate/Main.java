package Alternate;

// importing necessary libraries
import java.util.Random;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    // constructor to initialize the node
    public Node(int item) {
        data = item;
        left = right = null;
    }
}
// Binary Search Tree class
class BST {
    Node root;
    // constructor to initialize the BST
    BST() {
        root = null;
    }
    // function to insert a new node in the BST
    void insert(int key) {
        root = insertRec(root, key);
    }
    // function to recursively insert a new node in the BST
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }
    // function to traverse and print the BST in inorder format
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int choice = 0;

        System.out.println("BST Test Program");
        //Taking input from the user and executing the choices as per user input.

        while (true) {
            System.out.println("1. Generate Random BST");
            System.out.println("2. Display BST (PreOrder)");
            System.out.println("3. Display BST (InOrder)");
            System.out.println("4. Display BST (PostOrder)");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < 10; i++) {
                        bst.insert(random.nextInt(100) + 1);
                    }
                    System.out.println("BST with 10 random integers has been generated");
                    break;
                case 2:
                    System.out.println("PreOrder Traversal of BST:");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("InOrder Traversal of BST:");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("PostOrder Traversal of BST:");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

