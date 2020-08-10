package ds.trees;

public class BTLeftView {
    static int max_level = 0;

    void leftViewUtil(Node node, int level) {
        if (node == null)
            return;

        if (max_level < level) {
            System.out.print(node.data + "->");
            max_level = level;
        }

        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    public static void main(String args[]) {
        BTLeftView tree = new BTLeftView();
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);
        tree.leftViewUtil(root, 1);
    }
}

