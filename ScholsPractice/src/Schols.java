import java.util.*;

public class Schols {
	
	public int maxDiameter;
	public Node root;
	
	Schols(String key) {
		root = new Node(key, null, null);
	}
	
	
	public void printByLevel (Node root) {

		Queue<Node> nodes = new LinkedList<Node>();
		
		nodes.add(root);
		printByLevel(nodes);
	}

	private void printByLevel(Queue<Node> nodes) {

		if (!nodes.isEmpty()) {		
			Node temp = nodes.remove();
			if (temp.left != null) nodes.add(temp.left);
			if (temp.right != null) nodes.add(temp.right);
			System.out.println(temp.key + " ");
			printByLevel (nodes);
		}
	}

	
	public int diameter(Node root) {

		if (root == null) return -1;
		else if (root.left == null && root.right ==null) return 0;
		else return diameter2(root);
	}

	private int diameter2(Node root) {

		int diamRight = 0;
		int diamLeft = 0;
		if (root.left == null && root.right == null) 
			return 0;
		else if (root.left == null) {
			diamRight = 1 + diameter2(root.right);
			maxDiameter = Integer.max(maxDiameter, 1 + diamRight);
			return maxDiameter;
		}
		else if (root.right == null) {
			diamLeft =  1 + diameter2(root.left);
			maxDiameter = Integer.max(maxDiameter, 1 + diamLeft);
			return maxDiameter;
		}
		else {
			diamLeft = 1 + diameter2(root.left); 
			diamRight = 1 + diameter2(root.right);
			maxDiameter = Integer.max(maxDiameter, (2 + diamLeft + diamRight));
			return maxDiameter;
		}
	}
	
	public static void main(String[] args) {
		
	}

}
