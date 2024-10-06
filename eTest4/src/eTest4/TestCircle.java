package eTest4;

public class TestCircle {

	public static void main(String[] args) {
		
		double radius = 100.00;
		Circle circle1 = new Circle(radius);
		System.out.println("Perimeter of the circle is " + String.format("%.2f", circle1.getPerimeter()) 
							+ "\nArea of the circle is " + String.format("%.2f", circle1.getArea()));

	}

}
