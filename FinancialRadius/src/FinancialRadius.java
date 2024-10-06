import java.util.*;

public class FinancialRadius {

	public int[] distances;
	public PriorityQueue<Integer> minQ;
	
	FinancialRadius(){
		this.distances = new int[0];
		this.minQ = new PriorityQueue<Integer>();
	}
	
	public void addBusinessDistance(int d) {
		this.minQ.add(d);
		int[] tempArray = new int[this.minQ.size()];
		PriorityQueue<Integer> tempQ = new PriorityQueue<Integer>(this.minQ.size());
		int tempInt = 0;
		
		for (int i = 0; i < tempArray.length-1; i++) {
			tempInt = this.minQ.remove();
			tempArray[i] = tempInt;
			tempQ.add(tempInt);
		}
		
		this.minQ = tempQ;
		this.distances = tempArray;
	}
	
	public int getFRadius() {
		
		int twoThirds = (distances.length*2)/3;
		return distances[twoThirds];
	}
	
	public static void main(String[] args) {
		FinancialRadius fr = new FinancialRadius();
		
		fr.addBusinessDistance(1);
		fr.addBusinessDistance(4);
		fr.addBusinessDistance(2);
		fr.addBusinessDistance(3);
		fr.addBusinessDistance(6);
		fr.addBusinessDistance(7);
		fr.addBusinessDistance(5);
		fr.addBusinessDistance(9);
		fr.addBusinessDistance(8);
		
		System.out.println(fr.getFRadius());
	}
}





















