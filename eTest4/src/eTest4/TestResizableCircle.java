package eTest4;

public class TestResizableCircle {

	public static void main(String[] args) {
		
		double radius = 100.00;
		ResizableCircle circle2 = new ResizableCircle(radius);
		int percentageReduction = 10;
		circle2.resize(percentageReduction);
		System.out.println("Perimeter of the resized circle is " + String.format("%.2f", circle2.getPerimeter()) 
							+ "\nArea of the resized circle is " + String.format("%.1f", circle2.getArea()));
		
	}

}