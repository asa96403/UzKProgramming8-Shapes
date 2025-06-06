package shapes;

public class Circle extends Shape{
	private double radius;
	
	public Circle(double radius) {
		if(radius >=0) {
			this.radius=radius;
		} else {
			System.out.println("The radius has to be positive. Has been set to 1.");
			this.radius=1;
		}
	}

	@Override
	public double getArea() {
		return radius*radius*Math.PI;
	}

	@Override
	public String toString() {
		return "Circle with radius: " + radius;
	}

}
