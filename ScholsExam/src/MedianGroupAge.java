

public class MedianGroupAge { 

	public Node root;            	// root of BST

	class Node {
		public int age;          	// nodes to be sorted by t
		public Node left;			// left subtree
		public Node right; 			// right subtree
		public int N;            	// number of nodes in subtree


		public Node(int age, int N) {
			this.age = age;
			this.N = N;
		}
	}

	MedianGroupAge(int m){
		root.N = m;
	}

	public void addPerson(int age) {

		root = addPerson(root, age);
	}

	private Node addPerson(Node root, int age) {
		if (root == null) return new Node(age, 1);

		if (age < root.age) root.left  = addPerson(root.left,  age);
		else if (age > root.age) root.right = addPerson(root.right, age);

		root.N = 1 + root.left.N + root.right.N;

		return root;
	}

	public void removePerson(int age) { 

		if (root != null) root = removePerson(age, root);
	}

	private Node removeMaxLeft(Node x) {

		if (x.right == null) return x.left;

		x.right = removeMaxLeft(x.right);
		x.N = x.left.N + x.right.N + 1;
		return x;

	}

	private Node findMaxInLeftTree(Node x) {

		while (x.right != null) x = x.right;
		return x;

	}

	private Node removePerson(int age, Node x) {

		if (x == null) return null;

		if (age > x.age) x.right = removePerson(age, x.right);
		else if (age < x.age) x.left = removePerson(age, x.left);
		else
		{
			if (x.left == null) return x.right;
			else if (x.right == null) return x.left;

			Node temp = x;
			x = temp.left;
			x = findMaxInLeftTree(temp.left); 
			x.left = removeMaxLeft(temp.left);
			x.right = temp.right;

		}
		x.N = x.left.N + x.right.N + 1;
		return x;
	}

	public int getMedian() { 
		if (root == null) return -1;
		else return getMedian(root);
	}

	private int getMedian(Node x) {
		int median = (x.N - 1) / 2;	
		return select(median, root);
	}

	private int select(int n, Node x) {

		int a = x.left.N;
		if (a > n)
		{
			return select(n, x.left);
		}
		else if (a < n)
		{
			return select(n - a - 1, x.right);
		}
		else return x.age;
	}


}
