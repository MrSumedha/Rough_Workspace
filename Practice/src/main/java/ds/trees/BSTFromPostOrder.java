package ds.trees;

import java.util.*;

// Class Node has data and references to the left 
// and the right child. 
class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BSTFromPostOrder {

	Node constructTreeFromPostOrder(int post[], int n) {
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
	
	Node constructTreeFromInOrder(int inorder[], int n) {
		Node root = new Node(inorder[n/2]);
		
		return root;
	}

	// A utility function to print inorder traversal
	// of a Binary Tree
	void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) {
		BSTFromPostOrder tree = new BSTFromPostOrder();
		int post[] = new int[] { 1, 7, 5, 50, 40, 10 };
		int size = post.length;

		Node root = tree.constructTreeFromPostOrder(post, size);

		System.out.println("Inorder traversal of the constructed tree:");
		tree.printInorder(root);
	}
}
