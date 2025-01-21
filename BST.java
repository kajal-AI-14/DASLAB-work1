/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignmnent0309
        
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BST {
    Node root;

    // Constructors
    BST(int key) {
        root = new Node(key);
    }

    BST() {
        root = null;
    }

    // A utility function to search a given key in BST
    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;

        // val is greater than root's key
        if (root.key > key)
            return search(root.left, key);

        // val is less than root's key
        return search(root.right, key);
    }

    // A utility function to insert a new key in BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // A utility function to delete a node with a given key in BST
    Node deleteRec(Node root, int key) {
        // Base Case: If the tree is empty
        if (root == null) return root;

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    // A utility function to find the minimum value node in a given subtree
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void printPostorder(Node node) {
        if (node == null)
            return;

        // First recur on left subtree
        printPostorder(node.left);

        // Then recur on right subtree
        printPostorder(node.right);

        // Now deal with the node
        System.out.print(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder */
    void printInorder(Node node) {
        if (node == null)
            return;

        // First recur on left child
        printInorder(node.left);

        // Then print the data of node
        System.out.print(node.key + " ");

        // Now recur on right child
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder */
    void printPreorder(Node node) {
        if (node == null)
            return;

        // First print data of node
        System.out.print(node.key + " ");

        // Then recur on left subtree
        printPreorder(node.left);

        // Now recur on right subtree
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Node(8); // create root
        Node a = new Node(3);
        tree.root.left = a;
        Node b = new Node(10);
        tree.root.right = b;
        a.left = new Node(1);
        a.right = new Node(6);
        b.left = new Node(9);
        b.right = new Node(14);

        System.out.println("Pre-Order");
        tree.printPreorder(tree.root);

        System.out.println("\nPost-Order");
        tree.printPostorder(tree.root);

        System.out.println("\nIn-Order");
        tree.printInorder(tree.root);

        // Example usage of search, insert, and delete
        System.out.println("\nSearch for 6: " + (tree.search(tree.root, 6) != null ? "Found" : "Not Found"));
        tree.insertRec(tree.root, 5);
        System.out.println("In-Order after inserting 5:");
        tree.printInorder(tree.root);

        tree.deleteRec(tree.root, 10);
        System.out.println("\nIn-Order after deleting 10:");
        tree.printInorder(tree.root);
    }
}


