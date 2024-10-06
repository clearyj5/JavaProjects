package eTest3;

public class LLTest {
	
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	
	public static void main(String args[])
	{

		LinkedList list = new LinkedList();
		list.add(ONE);
		list.add(TWO);
		list.add(THREE);
		list.add(FOUR);
		list.add(FIVE);
		
		System.out.print(list);
		
		list.insert(6);
		System.out.print(list);
		
		System.out.print(list.get(THREE));
		
		list.remove(FOUR);
		System.out.print(list);
		
		System.out.print(list.size());
	

	}
}
