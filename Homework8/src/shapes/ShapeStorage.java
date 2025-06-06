package shapes;

import java.util.ArrayList;

public class ShapeStorage<T extends Shape> extends ArrayList<T>{

	/**
	 * default version UID as suggested by IDE
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * calculates the sum of the areas of all stored shapes and returns it
	 * @return the sum of all stored shapes
	 * @author aabert
	 */
	public double getTotalArea() {
		double totalArea =0;
		for(Shape s: this) {
			totalArea+=s.getArea();
		}
		return totalArea;
	}
	
	/**
	 * prints all shapes using their toString()
	 * @author aabert
	 */
	public void displayAllShapes() {
		for(Shape s: this) {
			System.out.println(s.toString());
		}
	}
}
