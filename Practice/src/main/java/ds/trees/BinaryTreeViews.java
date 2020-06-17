package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node right, left;

    public Node(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}

public class BinaryTreeViews {

    private static void printRightView(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
                if (i == n) System.out.print(temp.data + "->");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);

        printRightView(root);
    }
}
