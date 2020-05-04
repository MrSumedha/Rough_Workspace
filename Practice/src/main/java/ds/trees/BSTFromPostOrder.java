package ds.trees;

import java.util.Stack;

public class BSTFromPostOrder {
  private class Node {
    int data;
    Node left, right;

    public Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  private Node constructTreeFromPostOrder(int post[], int n) {
    Node root = new Node(post[n - 1]);
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    // Traverse from second last node
    for (int i = n - 2; i >= 0; --i) {
      Node node = new Node(post[i]);
      // Keep popping nodes while top() of stack
      // is greater.
      Node temp = null;
      while (!stack.isEmpty() && stack.peek().data > post[i]) {
        temp = stack.pop();
      }
      // Make x as left child of temp
      if (temp != null) {
        temp.left = node;
      } else {
        stack.peek().right = node;
      }
      stack.push(node);
    }
    return root;
  }

  // A utility function to print inorder traversal
  // of a Binary Tree
  private void printInorder(Node node) {
    if (node == null) {
      return;
    }
    printInorder(node.left);
    System.out.print(node.data + " ");
    printInorder(node.right);
  }

  public static void main(String[] args) {
    BSTFromPostOrder postOrder = new BSTFromPostOrder();
    int post[] = {1, 7, 5, 50, 40, 10};
    Node root = postOrder.constructTreeFromPostOrder(post, post.length);
    System.out.println("Inorder traversal of the constructed tree:");
		postOrder.printInorder(root);
  }
}
