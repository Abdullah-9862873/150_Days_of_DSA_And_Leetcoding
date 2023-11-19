
/*
Lets say you have the following tree input
                                    10
                                   /  \
                                  5    11
                                 / \     \
                                3   7     17
                                 \       /
                                  4     14

And the value of k = 3
That means 3rd smallest value that is 5 which is the answer
 */
import java.util.Scanner;

public class Part_09_Kth_Smallest_Element_in_BST {
    public Node root;

    public static void main(String[] args) {
        Part_09_Kth_Smallest_Element_in_BST tree = new Part_09_Kth_Smallest_Element_in_BST();
        Scanner input = new Scanner(System.in);
        tree.makeBinaryTree();
        tree.displayBinaryTree();
        tree.checkBalancing();
        System.out.println();

        System.out.println("Enter the value of k: ");
        int k = input.nextInt();
        input.close();

        int ans = tree.findKthSmallest(tree.root, k);
        System.out.println(k + " Smallest value is: " + ans);
    }

    public int count = 0;

    private int findKthSmallest(Node root, int k) {
        if (root == null) {
            return 0;
        }
        Node ans = findKthSmallestHelper(root, k);
        return ans.value;
    }

    private Node findKthSmallestHelper(Node root, int k) {
        if (root == null) {
            return null;
        }

        Node left = findKthSmallestHelper(root.left, k);
        if(left != null){
            return left;
        }
        count++;
        if(count == k){
            return root;
        }
        return findKthSmallestHelper(root.right, k);
    }

    public void makeBinaryTree() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the root Element: ");
        root = new Node(input.nextInt());
        populate(root, input);
    }

    public void populate(Node root, Scanner input) {
        System.out.println("Do you want to enter the left of " + root.value + " (yes/no)");
        String leftChoice = input.next();
        if (leftChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the left node of " + root.value);
            root.left = new Node(input.nextInt());
            root.height = Math.max(height(root.left), height(root.right)) + 1;
            populate(root.left, input);
        }
        System.out.println("Do you want to enter the right of " + root.value + " (yes/no)");
        String rightChoice = input.next();
        if (rightChoice.equalsIgnoreCase("yes")) {
            System.out.println("Enter the right node of " + root.value);
            root.right = new Node(input.nextInt());
            root.height = Math.max(height(root.left), height(root.right)) + 1;
            populate(root.right, input);
        }
    }

    public void checkBalancing() {
        boolean ans = isBalanced(root);
        if (ans == true) {
            System.out.println("The tree is balanced");
        } else {
            System.out.println("The tree is not balanced");
        }
    }

    public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        return (height(root.left) - height(root.right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public void displayBinaryTree() {
        display(root, "", false);
    }

    public static void display(Node root, String str, boolean isLeft) {
        if (root == null) {
            return;
        }
        System.out.println(str + (isLeft ? "├── " : "└── ") + root.value + " (" + height(root) + ")");
        display(root.left, str + (isLeft ? "|   " : "    "), true);
        display(root.right, str + (isLeft ? "|   " : "    "), false);
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        Node next;
        private int height;

        public Node(int val) {
            this.value = val;
        }
    }
}
