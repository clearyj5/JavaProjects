import java.util.ArrayList;

public class Stack {
	
	static ArrayList<Integer> stack = new ArrayList<>();
	
	public static void push(int item) {
		stack.add(0, item);
	}
	
	public static void pop() {
		try {
			stack.remove(0);
		} catch(NullPointerException exception) {
			
		}
	}
	
	public static int peek() {
		try {
		int lastItem = stack.get(-1);
		return lastItem;
		} catch(NullPointerException exception) {
			return -1;
		}
	}
	
	public static int search(int itemSearch) {
		try {
		int itemLocation = stack.indexOf(itemSearch);
		return itemLocation;
		} catch(IndexOutOfBoundsException exception) {
			return -1;
		}
	}
	
	public static void move(int itemToMove) {
		if(search(itemToMove) != -1) {
			stack.set(0, itemToMove);
		}
	}

}
