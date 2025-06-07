package shapes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
//		main1();
//		main2();
//		test1();
		main3();
	}

	private static void main1() {
		ShapeStorage<Shape> allShapes = new ShapeStorage<>();
		ShapeStorage<Circle> smallCircles = new ShapeStorage<>();
		allShapes.add(new Rectangle(2, 3)); // 6 area
		smallCircles.add(new Circle(1)); // ~3.14 area
		smallCircles.add(new Circle(3)); // ~28.27 area
		System.out.println("Display all Circles :");
		smallCircles.displayAllShapes();
		System.out.println("Display all Shapes :");
		allShapes.displayAllShapes();
		// Only circles with area >= 10 will be imported
		allShapes.importLargeShapes(smallCircles, 10.0);
		System.out.println("Display all Shapes after import of shapes with radius>=10 :");
		allShapes.displayAllShapes();
		System.out.printf("\n Total area: %.2f\n", allShapes.getTotalArea());
	}

	private static void main2() {
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle(2.0));
		shapes.add(new Rectangle(3.0, 4.0));
		shapes.add(new Circle(1.0));
		shapes.add(new Rectangle(5.0, 5.0));
		shapes.add(new Circle(3.5));
		System.out.println("All Shapes :");
		for (Shape shape : shapes) {
			System.out.println(shape);
		}
		// filter shapes with area >= 15
		System.out.println("\n Shapes with area >= 15:");
		List<Shape> filtered = ShapeAnalyzer.filterByMinArea(shapes, 15);
		for (Shape shape : filtered) {
			System.out.println(shape);
		}
		// find shape with max area
		Shape maxShape = ShapeAnalyzer.findShapeWithMaxArea(shapes);
		System.out.println("\n Shape with max area :");
		System.out.println(maxShape);
		// group by type
		Map<String, List<Shape>> grouped = ShapeAnalyzer.groupByType(shapes);
		// print
		System.out.println("\n Grouped by type :");
		for (Map.Entry<String, List<Shape>> entry : grouped.entrySet()) {
			System.out.println(entry.getKey() + ":");
			for (Shape shape : entry.getValue()) {
				System.out.println(" " + shape);
			}
		}
	}
	
	private static void main3() {
		String filename = "shapes.txt";
		// 1. Create shapes
		List <Shape > shapesToSave = new ArrayList <>();
		shapesToSave.add(new Circle (3.5));
		shapesToSave.add(new Rectangle (5.5, 3.3));
		// optional: Clear the file before saving to it
		PersistentShapeManager.clearFile(filename );
		// 2. Save to file
		PersistentShapeManager.saveShapesToFile(shapesToSave , filename );
		// 3. Load from file
		List <Shape > loadedShapes = PersistentShapeManager.loadShapesFromFile(filename );
		// 4. Display loaded shapes
		System.out.println (" Shapes loaded from file :");
		for (Shape shape : loadedShapes) {
		System.out.println(shape );
		}
		//Extension to test clearFile better
		List <Shape > shapesToSave2 = new ArrayList <>();
		shapesToSave.add(new Circle (4.5));
		PersistentShapeManager.clearFile(filename );
		PersistentShapeManager.saveShapesToFile(shapesToSave2 , filename );
		List <Shape > loadedShapes2 = PersistentShapeManager.loadShapesFromFile(filename );
		System.out.println (" Shapes loaded from file in second iteration :");
		for (Shape shape : loadedShapes2) {
		System.out.println(shape );
		}
	}
	
	/**
	 * Test for testing the ShapeFactory Class
	 * @author aabert
	 */
	private static void test1() {
		String str1 = "Rectangle: width=3.0, length=4.5";
		Shape shape1 = ShapeFactory.fromString(str1);
		String str2 = "Circle: radius=5.0";
		Shape shape2 = ShapeFactory.fromString(str2);
		System.out.println(shape1.toString());
		System.out.println(shape2.toString());
		String str3 = "Rectangle width=3.0, length=4.5";
		Shape shape3 = ShapeFactory.fromString(str3);
	}
}
