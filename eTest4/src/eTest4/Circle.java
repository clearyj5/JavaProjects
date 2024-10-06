package eTest4;

public class Circle implements GeometricObject {
	
	double radius = 1.0;

	public Circle(double radius) {
		
		this.radius = radius;
	}
	
	@Override
	public double getPerimeter() {
		
		double perimeter = 2 * Math.PI * radius;
		return perimeter;
		
	}

	@Override
	public double getArea() {
		
		double area = Math.PI * radius * radius;
		return area;
		
	}

}
