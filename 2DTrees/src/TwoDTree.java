import java.util.*;

public class TwoDTree {
	private Node root;
	
	private class Node {
		Point p; 
		Node left;
		Node right;
		int level; //root at level 1
		int N; //number of nodes in subtree with this Node as root
	}
	
	public class Point {
		public double x;
		public double y;
		
		Point(int x0, int y0){
			this.x = x0; this.y =y0;
		}
	}
	
	

	private Point findKthClosest(Point centre, double radius, int k) {
		
		if (root.N < k) return null;
		else return findKthClosest(centre, radius, k, root);
	}
	
	public Point findKthClosest(Point centre, double radius, int k, Node root) {
		
		Stack<Point> pointsInCircle = new Stack<Point>();
		double distSquared = 0;
		
		if (root.level % 2 == 1)
		{
			distSquared = (centre.x - root.p.x)*(centre.x - root.p.x) + (centre.y - root.p.y)*(centre.y - root.p.y);
			if (distSquared <= k) pointsInCircle.push(root.p);
			
			else 
		}
		else if (root.level % 2 == 0)
		{
			distSquared = (centre.x - root.p.x)*(centre.x - root.p.x) + (centre.y - root.p.y)*(centre.y - root.p.y);
			if (distSquared <= k) pointsInCircle.push(root.p);
		}
		
		return null;
	}
	
	public Point closest(Point target, Point a, Point b) {
		
		double squaredDistA = (target.x - a.x)*(target.x - a.x) + (target.y - a.y)*(target.y - a.y);
		double squaredDistB = (target.x - b.x)*(target.x - b.x) + (target.y - b.y)*(target.y - b.y);
		
		return Double.min(squaredDistA, squaredDistB) == squaredDistA? a: b;
		
		
	}
	/*
	 * if (root == null) return null;
		
		Node next = new Node();
		Node other  = new Node();
		
		if (root.level % 2 != 0) {
			next = root.right;
			other = root.left;
		}
		else {
			next = root.left;
			other = root.right;
		}
		
		Point temp = findKthClosest(centre, radius, k, next);
		Point best = closest(centre, root.p, temp);
		
		double squaredDist = (centre.x - best.x)*(centre.x - best.x) + (centre.y - best.y)*(centre.y - best.y);
		double dist = 0;
		
		return null;
		
	 */


}
