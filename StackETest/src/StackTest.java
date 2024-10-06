
public class StackTest {
	
	int sizeOfStack;
	
	public StackTest(int size) {
		sizeOfStack = size;
	}

	public static void main(String[] args) {
		Stack testStack = new Stack();
		for (int i = 0; i <= 10; i++) {
			testStack.push(i);
		}

	}

}
