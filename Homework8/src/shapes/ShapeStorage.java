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
	
	/**
	 * adds shapes from another storage to this storage if their area is at least minArea
	 * @param <U> the TypeParameter of the ShapeStorage passed in, must be a subtype of the TypeParameter of this class
	 * @param other the ShapeStorage to import shapes from
	 * @param minArea the minimum area of the shapes to be added to this ShapeStorage
	 */
	public <U extends T> void importLargeShapes(ShapeStorage<U> other, double minArea) {
		for(Shape s: other) {
			if(s.getArea()>=minArea) {
				this.add((T) s);
			}
		}
	}
}
