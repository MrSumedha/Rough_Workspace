package ds.trees;

public class Node {
        int data;
        ds.trees.Node right, left;

        public Node(int val) {
            this.data = val;
            this.left = this.right = null;
        }
}
