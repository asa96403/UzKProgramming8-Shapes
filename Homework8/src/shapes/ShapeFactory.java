package shapes;

public class ShapeFactory {
	public static Shape fromString(String input) {
		Shape result;
		if(input.regionMatches(0, "Circle:", 0, 7) && input.regionMatches(8, "radius=", 0, 7)) {
			result= new Circle(Double.parseDouble(input.substring(15)));
		} else if(input.regionMatches(0, "Rectangle: width=", 0, 17) && input.regionMatches(20, ", length=", 0, 9)) {
			// Format: Rectangle: width=3.0, length=4.0
			result= new Rectangle(Double.parseDouble(input.substring(17, input.indexOf(","))), Double.parseDouble(input.substring(input.indexOf(",")+9)));
		} else  {
			result=null;
			throw new IllegalArgumentException("Invalid Input Format! Correct Format: Rectangle: width=x, length=y or Circle: radius=x");
		}
		return result;
	}
}
