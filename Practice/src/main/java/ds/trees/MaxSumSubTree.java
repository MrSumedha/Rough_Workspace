package ds.trees;

public class MaxSumSubTree {
  private class Node {
    int val;
    Node right, left;

    public Node() {
      this.left = this.right = null;
    }

    public Node(int val) {
      this.val = val;
      this.left = this.right = null;
    }
  }

  private Node maxSumTree(Node root) {
    if (root.left == null && root.right == null) {
      return root;
    }
    Node node = new Node();
    if (root.right != null) {
      node.val += root.right.val;
    }
    if (root.left != null) {
      node.val += root.left.val;
    }
    return null;
  }
}
