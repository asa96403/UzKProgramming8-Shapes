package shapes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapeAnalyzer {
	/**
	 * Returns a list of shapes whose area is greater than or equal to the specified
	 * value
	 * 
	 * @param shapes  the Collection of Shapes to be filtered
	 * @param minArea the minimum area of the Shapes to return
	 * @return a List of Shapes from shapes that have an area >= minArea
	 * @author aabert
	 */
	static List<Shape> filterByMinArea(Collection<? extends Shape> shapes, double minArea) {
		List<Shape> largeShapes = new ArrayList<Shape>();
		for (Shape s : shapes) {
			if (s.getArea() >= minArea) {
				largeShapes.add(s);
			}
		}
		return largeShapes;
	}

	/**
	 * Returns the shape with the largest area.
	 * 
	 * @param shapes the Collection of shapes to find the Element with the maximum
	 *               area from
	 * @return the shape with the largest area
	 * @author aabert
	 */
	static Shape findShapeWithMaxArea(Collection<? extends Shape> shapes) {
		// Initialise Shape with Shape that has an area of 0
		Shape max = new Circle(0);
		for (Shape s : shapes) {
			if (s.getArea() >= max.getArea())
				max = s;
		}
		return max;
	}

	/**
	 * Groups the given shapes by their concrete type (e.g., ”Circle”, ”Rectangle”)
	 * in a Map as seen in the return type.
	 * 
	 * @param <T> The type (subtype of Shape) of the Collection passed in and the returned List
	 * @param shapes the Collection to be grouped
	 * @return the Map containing the grouped Lists (Key: Classname of the specific shape)
	 */
	static <T extends Shape> Map<String, List<T>> groupByType(Collection<T> shapes) {
		Map<String, List<T>> map = new HashMap<String, List<T>>();
		for (Shape s : shapes) {
			if (map.containsKey(s.getClass().getSimpleName())) {
				map.get(s.getClass().getSimpleName()).add((T) s);
			} else {
				map.put(s.getClass().getSimpleName(), new ArrayList<T>());
				map.get(s.getClass().getSimpleName()).add((T) s);
			}
		}
		return map;
	}
}
